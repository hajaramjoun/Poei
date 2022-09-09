import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TpCarrefour {
    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void stUp() {
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();
    }


    @Test
    public void test(){

    }


    @AfterMethod
    public void teardown() {
        driver.quit();


    }
}
