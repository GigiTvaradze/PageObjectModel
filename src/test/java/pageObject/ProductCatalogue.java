package pageObject;

import abstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AbstractComponents {

    WebDriver driver;
    public ProductCatalogue(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".mb-3")
    By productCatalogue;

    @FindBy(css = ".ng-animating")
    By loadingIcon;

    @FindBy(css = ".card-body button:last-of-type")
    By addToCardButton;

    @FindBy(css = "b")
    By productTitle;

    @FindBy(css = "#toast-container")
    By productIsAddedOnCartAlert;

    @FindBy(xpath = "(//button[@class='btn btn-custom'])[3]")
    WebElement cartButton;

    public void waitForProductCatalogueToBeLoaded(){
        waitForElementToBeVisible(productCatalogue);
    }

    public void waitForLoadingIconToBeInvisible(){
        waitForElementToBeInvisible(loadingIcon);
    }

    public void waitForProductIsAddedOnCartAlertToBeVisible(){
        waitForElementToBeInvisible(productIsAddedOnCartAlert);
    }

    public void clickOnProductFromCatalogue(String productName){
        List<WebElement> products = driver.findElements(productCatalogue);
        WebElement prodElements = products.stream().filter(product -> product.findElement(productTitle).getText().equals(productName)).findFirst().orElse(null);
        assert prodElements != null;
        prodElements.findElement(addToCardButton).click();
    }

    public void clickOnCartButton(){
        clickOnByWebElement(cartButton);
    }
}