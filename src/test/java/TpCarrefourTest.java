import carrefour.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TpCarrefourTest {
//    WebDriver driver = new ChromeDriver();
    ChromeOptions options= new ChromeOptions();
    public TpCarrefourTest() throws MalformedURLException {
    }

//    RemoteWebDriver driver = new RemoteWebDriver(new URL(" http://192.168.121.12:4444"), options);
    RemoteWebDriver driver = new RemoteWebDriver(new URL(" http://admin:admin@192.168.121.12:4444"), options);
//    RemoteWebDriver driver = new RemoteWebDriver(new URL(" http://192.168.121.16:4444"), options);//remote hub and node




    @BeforeMethod
    public void stUp() {
        driver.get("https://www.carrefour.fr/");
        driver.manage().window().maximize();
//        System.out.println(System.getProperty("user.dir"));
//        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\chromedriver.exe");// mettre webdriver dans le systeme win 32
    }


    @Test
    public void test() {
        //Arrange



        //Act
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookie().openMaisonsLoisirs().openRayons().openFirstElement();


        // Asserts


    }


    @AfterMethod
    public void teardown() {
        driver.quit();


    }
}
