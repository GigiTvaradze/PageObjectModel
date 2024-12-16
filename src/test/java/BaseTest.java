import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
   public WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void beforeMethod() throws IOException {
        Properties prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/GlobalData.properties");
        prop.load(fileInputStream);
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/gtv/Desktop/chromedriver");
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            //FireFox
        }
        else if (browserName.equalsIgnoreCase("safari")) {
            //Safari
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        driver.get(prop.getProperty("url"));
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}