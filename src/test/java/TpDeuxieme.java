import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TpDeuxieme {
    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void stUp() {
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();
    }

    @Test
    public void tp3() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement bouttonAccept = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        bouttonAccept.click();
        WebElement bouttonMenu = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-label='Ouvrir le menu']")));
        bouttonMenu.click();
//        WebElement bouttonMeilleureVente = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='hmenu hmenu-visible']/li[2]")));//.hmenu-visible>li>a:first-child /*****///.hmenu-visible>li:nth-child(2)
//        bouttonMeilleureVente .click();

        ///*************  prof corection/////////////////////////////////
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.hmenu-visible > li > a.hmenu-item")));
        List<WebElement> bouttonMeilleureVente = driver.findElements(By.cssSelector("ul.hmenu-visible > li > a.hmenu-item"));//.hmenu-visible>li>a:first-child /*****///.hmenu-visible>li:nth-child(2)
        bouttonMeilleureVente.get(0).click();
//        WebElement troisElement = driver.findElement(By.xpath("//ol[@role='list']/li[3]"));
//        troisElement.click();

        //////////////****  prof corection *////////////////////

        List<WebElement> troisElement = driver.findElements(By.cssSelector("[role=list]>li"));//
        troisElement.get(2).click();

    }

    public void testInssert() {
        // Arrange
        final String expectedToutes = "Toutes";
        final String expectedMeilleuresVentes = "Meilleures ventes";
        final String expectedAmazonBasics = "Amazon Basics";
        final String expectedVentesLivres = "Meilleures ventes dans Livres";

        // Act
        WebElement logo = driver.findElement(By.cssSelector("#nav-logo"));
        WebElement barreRecherche = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        WebElement toutesMenu = driver.findElement(By.cssSelector("#nav-hamburger-menu"));
        WebElement meilleuresVentes = driver.findElement(By.cssSelector("[data-csa-c-content-id=nav_cs_bestsellers]"));
        WebElement amazonBasics = driver.findElement(By.cssSelector("[data-csa-c-content-id=nav_cs_amazonbasics]"));
        WebElement meilleuresVenteLivres = driver.findElement(By.cssSelector("[data-csa-c-slot-id=desktop-5] h2.as-title-block-left"));

        // Asserts
        Assert.assertTrue(logo.isDisplayed(), "The Amazon Logo is not displayed");
        Assert.assertTrue(barreRecherche.isDisplayed());
        Assert.assertEquals(toutesMenu.getText(), expectedToutes);

        Assert.assertTrue(meilleuresVentes.isDisplayed());
        Assert.assertEquals(meilleuresVentes.getText(), expectedMeilleuresVentes, "The button Meilleures Ventes is not correct");

        Assert.assertTrue(amazonBasics.isDisplayed());
        Assert.assertEquals(amazonBasics.getText(), expectedAmazonBasics);

        Assert.assertTrue(meilleuresVenteLivres.isDisplayed());
        Assert.assertEquals(meilleuresVenteLivres.getText(), expectedVentesLivres);
    }

    @Test
    public void testSelect() {
        WebElement dropdown = driver.findElement(By.cssSelector("#searchDropdownBox"));
        Select categoriesSelect = new Select(dropdown);
        categoriesSelect.selectByIndex(4);
        categoriesSelect.selectByValue("search-alias=baby");
        categoriesSelect.selectByVisibleText("Informatique");
    }

    @Test
    public void testFirstSenario() {

        //Arrange
        String expectedtitleElement = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";


        //Act
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement bouttonAccept = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget=sp-cc-accept]")));
        bouttonAccept.click();
        WebElement searchGo = driver.findElement(By.cssSelector("input[value='Go']"));
        WebElement searchBar = driver.findElement(By.cssSelector("input[aria-label='Rechercher']"));
        searchBar.sendKeys("Apple iPhone 13 Pro Max (256 Go) - Vert Alpin");
        searchGo.click();
        WebElement firstElement = driver.findElement(By.cssSelector("[data-csa-c-pos='1']"));
        firstElement.click();
        WebElement addElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#add-to-cart-button")));
        addElement.click();
        WebElement nonMerciElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-labelledby='attachSiNoCoverage-announce']")));
        nonMerciElement.click();
        WebElement panierElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-labelledby='attach-sidesheet-view-cart-button-announce']")));
        panierElement.click();
        WebElement dropdown = driver.findElement(By.cssSelector("#quantity"));
        Select categoriesSelect = new Select(dropdown);
        categoriesSelect.selectByVisibleText("2");
        String titleElementActuel = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".a-truncate-full"))).getText();
        System.out.print(titleElementActuel);

        // Asserts
        /*  Assert.assertEquals(expectedtitleElement, titleElementActuel);*/


    }

    @AfterMethod
    public void teardown() {
        driver.quit();


    }
}
