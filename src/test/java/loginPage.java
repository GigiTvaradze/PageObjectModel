import com.google.common.eventbus.SubscriberExceptionContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class loginPage extends BaseTest{
    @Test
    public void test() throws InterruptedException {
        By userEmail = By.id("userEmail");
        By userPassword = By.id("userPassword");
        By loginButton = By.id("login");

        By productTitle = By.cssSelector("b");
        By addToCardButton = By.cssSelector(".card-body button:last-of-type");

        By loadingAlert = By.cssSelector(".ng-animating");
        By productIsAddedOnCartAlert = By.cssSelector("#toast-container");

        By cartButton = By.xpath("(//button[@class='btn btn-custom'])[3]");

        By myCartTitle = By.cssSelector("div[class='heading cf'] h1");

        String email = "ggtv@ggtv.ge";
        String password = "Gg123!!ggtv";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(userEmail).sendKeys(email);
        driver.findElement(userPassword).sendKeys(password);
        driver.findElement(loginButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingAlert));
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        WebElement prodElements =  products.stream().filter(product -> product.findElement(productTitle).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
        prodElements.findElement(addToCardButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(productIsAddedOnCartAlert));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingAlert));

        driver.findElement(cartButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(myCartTitle));
        String cartTitle = driver.findElement(myCartTitle).getText();
        Assert.assertEquals(cartTitle,"My Cart");


        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean itemMatch = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase("ZARA COAT 3"));
        Assert.assertTrue(itemMatch);

        driver.findElement(By.cssSelector(".totalRow button")).click();
    }
}