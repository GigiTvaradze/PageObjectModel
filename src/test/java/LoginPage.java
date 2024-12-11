import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import pageObject.ProductCatalogue;

import java.util.List;

public class LoginPage extends BaseTest {
    @Test
    public void endToEndTest() {

        String email = "ggtv@ggtv.ge";
        String password = "Gg123!!ggtv";

        //Step1 - Login
        LandingPage landingPage = new LandingPage(driver);
        landingPage.login(email,password);

        //Step2 - Choose product from product catalog
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        productCatalogue.waitForProductCatalogueToBeLoaded();
        productCatalogue.waitForLoadingIconToBeInvisible();
        productCatalogue.clickOnProductFromCatalogue("ZARA COAT 3");
        productCatalogue.waitForProductIsAddedOnCartAlertToBeVisible();
        productCatalogue.waitForLoadingIconToBeInvisible();
        productCatalogue.clickOnCart();

        //3 -
        By myCartTitle = By.cssSelector("div[class='heading cf'] h1");

        wait.until(ExpectedConditions.visibilityOfElementLocated(myCartTitle));
        String cartTitle = driver.findElement(myCartTitle).getText();
        Assert.assertEquals(cartTitle, "My Cart");


        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean itemMatch = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase("ZARA COAT 3"));
        Assert.assertTrue(itemMatch);

        driver.findElement(By.cssSelector(".totalRow button")).click();


        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(By.cssSelector(".form-group input")),"Ge").build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.cssSelector(".ta-item:nth-of-type(3)")).click();

        //.action_submit doesn't work
        driver.findElement(By.cssSelector(".actions"));

        String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }
}