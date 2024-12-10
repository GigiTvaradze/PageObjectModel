package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ConfirmOrder {
    WebDriver driver;
    public ConfirmOrder(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
}
