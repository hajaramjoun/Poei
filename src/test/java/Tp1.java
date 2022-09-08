import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class Tp1 {
    WebDriver driver;
    @BeforeMethod
    public void stUp() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();
    }



    @Test
    public void test() {
        System.out.println("hellow hajar");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }

    @Test
    public void testAmazon() {

        WebElement searchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBar.sendKeys("gtghjhjyh");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    @Test
    public void tp1XpathAmazon() {

        WebElement bouttonAccept = driver.findElement(By.xpath("(//span[@class='a-button-inner']/input[@type='submit'])[1]"));
        bouttonAccept.click();
        WebElement searchBar = driver.findElement(By.xpath("//input[@aria-label='Rechercher']"));
        searchBar.sendKeys("coque iphone");
        WebElement searchGo = driver.findElement(By.xpath("//input[@value='Go']"));
        searchGo.click();
        WebElement firstElement = driver.findElement(By.xpath("(//span/a/div/img)[1]"));
        firstElement.click();
        WebElement ajoutPanier = driver.findElement(By.xpath("//input[@title='Ajouter au panier']"));
        ajoutPanier.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    @Test
    public void tp1CsshAmazon() {


        /*A ne pas utiliser */
//        final  int IMPLICIT_TiMOUT = 10;
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_TiMOUT));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement bouttonAccept = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        bouttonAccept.click();
        WebElement searchGo = driver.findElement(By.cssSelector("input[value='Go']"));
        WebElement searchBar = driver.findElement(By.cssSelector("input[aria-label='Rechercher']"));
        searchBar.sendKeys("coque iphone");
        searchGo.click();
        WebElement firstElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-csa-c-pos='1']")));
        firstElement.click();
        WebElement ajoutPanier = driver.findElement(By.cssSelector("[aria-labelledby='submit.add-to-cart-announce']"));
        ajoutPanier.click();

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
    @AfterMethod
    public void  teardown(){
        driver.quit();

    }
}

