import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class beginTest extends BaseTest{
    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();

        String email = "ggtv@ggtv.ge";
        String password = "Gg123!!ggtv";

    }
}
