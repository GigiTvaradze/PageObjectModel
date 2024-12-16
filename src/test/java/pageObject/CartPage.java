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

    @FindBy(css = "div[class='heading cf'] h1")
    By myCartTitle;

    @FindBy(css = ".cartSection h3")
    By productTitle;

    @FindBy(css = ".totalRow button")
    WebElement checkoutButton;

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
