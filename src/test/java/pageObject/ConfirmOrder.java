package pageObject;

import abstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmOrder extends AbstractComponents {
    WebDriver driver;
    public ConfirmOrder(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".hero-primary")
    WebElement confirmTitle;

    public String getConfirmTitle(){
        return confirmTitle.getText();
    }
}
