import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private final int TIMEOUT_COOKIE = 10;
    private By cssSelectorAccept = By.cssSelector("[data-cel-widget=sp-cc-accept]");
    private By cssSelectorInput = By.cssSelector("input[value='Go']");
    private By cssSelectorBareSearch = By.cssSelector("input[aria-label='Rechercher']");
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /*      o    acceptCookie(): click accept cookie button
      o    SearchWithButton(String keyword): enter keyword in search bar and click in button
      o    SearchWithEnter(String keyword): enter keyword in search bar and press enter
  -    SearchResultPage
      o    openSearchResult(int index): click the search result with index n
  */
    public HomePage acceptCookie() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement bouttonAccept = wait.until(ExpectedConditions.elementToBeClickable(cssSelectorAccept));
        bouttonAccept.click();
        return this;
    }

    ;

    public SearchResultPage SearchWithButton(String keyword) {
        WebElement searchGo = driver.findElement(cssSelectorInput);
        WebElement searchBar = driver.findElement(cssSelectorBareSearch);
        searchBar.sendKeys(keyword);
        searchGo.click();
        return new SearchResultPage(this.driver);
    }

    ;

    //
//    public void SearchWithEnter(String keyword) {
//
//    }
//
//    ;
//
    public ProductPage openSearchResult(int index) {
        List<WebElement> resulstElement = driver.findElements(By.cssSelector("img.s-image"));
        resulstElement.get(index).click();
    return new ProductPage(driver);
    }


}
