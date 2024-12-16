
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.*;

import java.util.List;

public class LoginPage extends BaseTest {
    @Test()
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
        productCatalogue.clickOnCartButton();

        //3 - Cart Page Validation
        CartPage cartPage = new CartPage(driver);
        cartPage.waitForCartTitleToBeLoaded();
        String cartTitle = cartPage.getCartTitle();
        Assert.assertEquals(cartTitle, "My Cart");
        List<WebElement> cartProducts = cartPage.getProductTitles();
        boolean itemMatch = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase("ZARA COAT 3"));
        Assert.assertTrue(itemMatch);
        cartPage.clickOnCheckoutButton();

        //4 - Fill Checkout Page
        Checkout checkout = new Checkout(driver);
        checkout.selectCountry("Ge");
        checkout.waitForCountryResultListToBeLoaded();
        checkout.clickOnCountry();
        //.action_submit doesn't work
        checkout.clickOnPlaceOrderButton();

        //5 - Confirm Order
        ConfirmOrder confirmOrder = new ConfirmOrder(driver);
        String confirmMessage = confirmOrder.getConfirmTitle();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }
}