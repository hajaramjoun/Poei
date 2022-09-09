package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BestSellerPage {
    WebDriver driver;
    private final int TIMEOUT_COOKIE = 10;
    ///*           *****************  - Cliquer sur "Voir" dans le premier resultat de Sports & Loisir (Draisienne pliable) ****************               */  //////////////////////////
   By cssSelectorElement= By.cssSelector("input[value='Go']");;
    public ProductPage openFirstElement(int index) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(TIMEOUT_COOKIE));

        WebElement bouttonMaisonLoisires = wait.until(ExpectedConditions.elementToBeClickable(cssSelectorElement));
        bouttonMaisonLoisires.click();
        return new ProductPage();
    }
}
