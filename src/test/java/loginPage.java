import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class loginPage extends BaseTest{
    @Test
    public void test() {

        By userEmail = By.id("userEmail");
        By userPassword = By.id("userPassword");
        By loginButton = By.id("login");

        String email = "ggtv@ggtv.ge";
        String password = "Gg123!!ggtv";

        driver.findElement(userEmail).sendKeys(email);
        driver.findElement(userPassword).sendKeys(password);
        driver.findElement(loginButton).click();


        List<WebElement> products = driver.findElements(By.cssSelector("h5 b"));
        for (WebElement product : products) {
            String productName = product.getText();
            if (productName == "ADIDAS ORIGINAL"){
                driver.findElement(By.cssSelector("i[class='fa fa-shopping-cart']")).click();
            }
        }

    }
}