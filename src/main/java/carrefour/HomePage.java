package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private final int TIMEOUT_COOKIE = 20;

    private By cssSelectorAccept = By.cssSelector("button#onetrust-accept-btn-handler");
    private By cssSelectorMaisonLoisires = By.cssSelector("[for='header-tab-non-food']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    //     /* //            - Fermer les cookies*/       //////////////////////////////////////////

    public HomePage acceptCookie() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement bouttonAccept = wait.until(ExpectedConditions.elementToBeClickable(cssSelectorAccept));
        bouttonAccept.click();
        return this;

    }

//- Ouvrir section Maisons & Loisirs


    public ShopingPage openMaisonsLoisirs() {
        WebElement bouttonMaisonLoisires = driver.findElement(cssSelectorMaisonLoisires);
        bouttonMaisonLoisires.click();
        return new ShopingPage(driver) ;

    }
    }