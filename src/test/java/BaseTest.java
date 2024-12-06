import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "/Users/gtv/Desktop/chromedriver");

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client/");
    }

    /*
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
     */
}