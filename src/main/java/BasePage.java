import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    ChromeDriver driver = null;

    //webelementi zajednicki za sve strane
    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCartLink;

    @FindBy(className = "shopping_cart_badge")
    WebElement shoppingCartBadgeNumber;

    //konstruktor nadklase
    public BasePage(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //metoda za kliktanje na shopping cart ikonu i navigaciju ka shopping cart strani
    public CartPage clickOnShoppingCartIcon() {
        shoppingCartLink.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    //metoda za dohvatanje broja iz shopping cart ikone
    public String getNumberFromShoppingCartIcon() {
        assert isShoppingCartBadgeNumberPresent();
        String number = shoppingCartBadgeNumber.getText();
        return number;
    }

    public boolean isShoppingCartBadgeNumberPresent() {
        return isElementPresent(shoppingCartBadgeNumber);
    }


    //kad element mozda postoji, mozda ne postoji, ako je element prisutan vratice element, ako nije vratice da nije
    public boolean isElementPresent(WebElement element) {
        try {
            Boolean present = element.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static void print(String s) {
        System.out.println(s);
    }
}