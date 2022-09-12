package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
 /*   amazon.ProductPage
        o    addToCart(): click ajouter au panier button
        o    refuseAppleCare() : click non merci
        o    openCart() : click cart button
        -    amazon.CartPage
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
    private By cssSelectorNonMerci = By.cssSelector("[aria-labelledby='attachSiNoCoverage-announce']");
    private By cssSelectorOpenPanier = By.cssSelector("[aria-labelledby='attach-sidesheet-view-cart-button-announce']");
    private WebDriver driver;
    private final int TIMEOUT_COOKIE = 10;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage addToCart() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement addElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#add-to-cart-button")));
        addElement.click();
        return this;
    }
    public ProductPage refuseAppleCare() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement nonMerciElement = wait.until(ExpectedConditions.elementToBeClickable(cssSelectorNonMerci));
        nonMerciElement.click();
        return this;
    }
    public CartPage openCart() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement addElement = wait.until(ExpectedConditions.elementToBeClickable(cssSelectorOpenPanier));
        addElement.click();
    return new CartPage(driver);
    }


}