import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private By cssSelectorAccept = By.cssSelector("[data-cel-widget=sp-cc-accept]");
    private int TIME_OUT = 10;
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    //    o    acceptCookie(): click accept cookie button
//    o    SearchWithButton(String keyword): enter keyword in search bar and click in button
//    o    SearchWithEnter(String keyword): enter keyword in search bar and press enter
//-    SearchResultPage
//    o    openSearchResult(int index): click the search result with index n

    public void acceptCookie() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(TIME_OUT));
        WebElement bouttonAccept = wait.until(ExpectedConditions.elementToBeClickable(cssSelectorAccept));
        bouttonAccept.click();
    }

    ;

//    public String SearchWithButton(String keyword) {
//
//        return "ff";
//    }
//
//    ;
//
//    public void SearchWithEnter(String keyword) {
//
//    }
//
//    ;
//
//    public void openSearchResult(int index) {
//
//    }
//
//    ;


}
