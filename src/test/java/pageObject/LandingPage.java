package pageObject;

import abstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * The LandingPage class represents a specific web page in a web application.
 * It follows the Page Object Model (POM) design pattern, encapsulating the web
 * elements and interactions related to the page.
 */
public class LandingPage extends AbstractComponents {

    /**
     * WebDriver instance used to interact with the browser.
     */
    WebDriver driver;

    /**
     * Constructor to initialize the LandingPage class with a WebDriver instance.
     * It also uses the PageFactory to initialize web elements defined in this class.
     *
     * The `super(driver)` call ensures that the constructor of the parent class is invoked,
     * allowing it to perform its initialization tasks, such as setting up the WebDriver instance
     * in the base class.
     *
     * @param driver The WebDriver instance used for interacting with the web page.
     */
    public LandingPage(WebDriver driver){
        super(driver); // Calls the parent class's constructor to initialize shared WebDriver functionality.
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initializes the web elements defined in this class.
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