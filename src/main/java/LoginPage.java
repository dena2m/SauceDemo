import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

ChromeDriver driver = null;

//webelementi
    @FindBy(id = "user-name")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    //konstruktor
    public LoginPage(ChromeDriver driver) {
        driver.get(Strings.LOGIN_URL);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //metoda za upisivanje username-a
    public LoginPage enterTextIntoUsernameField(String username) {
        userNameField.sendKeys(username);
        return this;
    }

    //metoda za upisivanje passworda
    public LoginPage enterTextIntoPasswordField(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    //metoda za kliktanje login buttona i prebacivanje na inventory page
    public InventoryPage clickLoginButtonSuccess() {
        loginButton.click();
        InventoryPage inventoryPage = new InventoryPage(driver);
        return inventoryPage;
    }

    //metoda na kliktanje login buttona ako su pogresni kredencijali
    public LoginPage clickingLoginButtonFailure() {
        loginButton.click();
        return this;
    }


}
