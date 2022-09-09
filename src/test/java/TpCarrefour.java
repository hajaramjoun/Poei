import carrefour.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TpCarrefour {
    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void stUp() {
        driver.get("https://www.carrefour.fr/");
        driver.manage().window().maximize();
    }


    @Test
    public void test(){
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookie().openMaisonsLoisirs().openRayons();




    }


    @AfterMethod
    public void teardown() {
//        driver.quit();


    }
}
