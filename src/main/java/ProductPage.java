import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
- /*   ProductPage
        o    addToCart(): click ajouter au panier button
        o    refuseAppleCare() : click non merci
        o    openCart() : click cart button
        -    CartPage
        o    selectQuantity(int quantity): select quantity in quantity dropdown
        o    getFirstProductName(): return text of first product name
        o    getFirstProductCapacity(): return text of first product capacity
        o    getFirstProductColor(): return text of color
        o    getFirstProductConfiguration(): return text of configuration
        o    getSubtotalCart(): return subtotal text at the bottom of the cart
        o    getSubtotalBuybox(): return subtotal text in the buybox
*/
public class ProductPage {

    private By cssSelectorAddCart = By.cssSelector("input#add-to-cart-button");
//    private By cssSelectorInput = By.cssSelector("input[value='Go']");
//    private By cssSelectorBareSearch = By.cssSelector("input[aria-label='Rechercher']");
    private WebDriver driver;
    public void addToCart() {
        WebElement addElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#add-to-cart-button")));
        addElement.click();
//    }public void addToCart() {
//        WebElement addElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#add-to-cart-button")));
//        addElement.click();
//    }

}
