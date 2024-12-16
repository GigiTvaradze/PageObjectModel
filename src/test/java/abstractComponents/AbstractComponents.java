package abstractComponents;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponents{

    protected WebDriver driver; // Made protected for subclasses
    private WebDriverWait wait; // Ensure encapsulation

    public AbstractComponents(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance cannot be null");
        }
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Selenium 4-style constructor
        PageFactory.initElements(driver, this); // Initialize web elements if any
    }

    public void waitForElementToBeVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            throw new RuntimeException("Element not visible within timeout: " + locator, e);
        }
    }

    public void waitForElementToBeInvisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void clickOnByWebElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the element to be clickable
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click(); // Attempt to click
        } catch (ElementClickInterceptedException e) {
            // Fallback to JavaScript click if intercepted
            System.out.println("ElementClickInterceptedException encountered. Attempting JavaScript click.");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }
}