package pageObject;

import abstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponents {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    By myCartTitle = By.cssSelector("div[class='heading cf'] h1");
    By productTitle = By.cssSelector(".cartSection h3");

    @FindBy(css = ".totalRow button")
    private WebElement checkoutButton;

    public void waitForCartTitleToBeLoaded(){
        waitForElementToBeVisible(myCartTitle);
    }

    public String getCartTitle(){
        return driver.findElement(myCartTitle).getText();
    }

    public List<WebElement> getProductTitles(){
        return driver.findElements(productTitle);
    }

    public void clickOnCheckoutButton(){
        clickOnByWebElement(checkoutButton);
    }
}
