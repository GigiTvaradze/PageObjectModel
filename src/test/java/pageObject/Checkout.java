package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Checkout {
    WebDriver driver;
    public Checkout(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
}
