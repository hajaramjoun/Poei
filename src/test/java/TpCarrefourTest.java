import carrefour.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TpCarrefourTest {
    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void stUp() {
        driver.get("https://www.carrefour.fr/");
        driver.manage().window().maximize();
    }


    @Test
    public void test() {
        //Arrange

        //Act
        HomePage homePage = new HomePage(driver);
        homePage./*acceptCookie().*/openMaisonsLoisirs().openRayons();


        // Asserts


    }


    @AfterMethod
    public void teardown() {
//        driver.quit();


    }
}
