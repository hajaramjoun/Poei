import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TpPageObject {


    WebDriver driver = new ChromeDriver();
    @BeforeMethod
    public void stUp() {
        driver.get("https://www.amazon.fr/");
        driver.manage().window().maximize();
    }

@Test
public void testHomepage() {
    //Arrange
    String expectedtitleElement = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";

    //Act
    int index =1;
   String homePage = new HomePage(driver).acceptCookie().SearchWithButton(expectedtitleElement);
    homePage.openSearchResult(1);
    ProductPage productPage = new ProductPage(driver);
    productPage.addToCart();
    /*productPage.openCart();
    productPage.refuseAppleCare();*/


    // Asserts
    /*  Assert.assertEquals(expectedtitleElement, titleElementActuel);*/

}
@AfterMethod
public void teardown() {
    driver.quit();


}


}
//    @Test
//    public void testPO() {
//        final String keyword = "iPhone 13";
//
//        HomePage homePage = new HomePage(driver);
//        CartPage cartPage = homePage.acceptCookie()
//                .searchWithButton(keyword)
//                .openSearchResult(0)
//                .addToCart()
//                .refuseAppleCare()
//                .openCartPage();
//
//        Assert.assertEquals(cartPage.getSubTotal(), "1000");
//    }