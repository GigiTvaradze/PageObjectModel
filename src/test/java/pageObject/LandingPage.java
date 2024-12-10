package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * The LandingPage class represents a specific web page in a web application.
 * It follows the Page Object Model (POM) design pattern, encapsulating the web
 * elements and interactions related to the page.
 */
public class LandingPage{

    /**
     * WebDriver instance used to interact with the browser.
     */
    WebDriver driver;

    /**
     * Constructor to initialize the LandingPage class with a WebDriver instance.
     * It also uses the PageFactory to initialize web elements defined in this class.
     *
     * @param driver The WebDriver instance used for interacting with the web page.
     */
    public LandingPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "login")
    WebElement loginButton;

    public void fillUserEmail(String email){
        userEmail.sendKeys(email);
    }

    public void fillUserPassword(String password){
        userPassword.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void login(String email, String password){
        fillUserEmail(email);
        fillUserPassword(password);
        clickLoginButton();
    }
}