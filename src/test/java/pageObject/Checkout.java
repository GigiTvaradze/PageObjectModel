package pageObject;

import abstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout extends AbstractComponents {
    WebDriver driver;
    public Checkout(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    By countryResultList = By.cssSelector(".ta-results");

    @FindBy(css = ".form-group input")
    private WebElement selectCountry;

    @FindBy(css = ".ta-item:nth-of-type(3)")
    private WebElement countryGeorgia;

    @FindBy(css = ".actions")
    private WebElement placeOrderButton;

    public void selectCountry(String country){
        Actions actions = new Actions(driver);
        actions.sendKeys(selectCountry,country).build().perform();
    }

    public void waitForCountryResultListToBeLoaded(){
        waitForElementToBeVisible(countryResultList);
    }

    public void clickOnCountry(){
        countryGeorgia.click();
    }

    public void  clickOnPlaceOrderButton(){
        clickOnByWebElement(placeOrderButton);
    }
}
