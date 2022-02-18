import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    //otvaranje chroma sa svim opcijama
    public ChromeDriver openChromeDriver() {
        print("Opening Cgrome Driver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");

        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
       // ChromeDriver driver = new ChromeDriver(options);
       //return driver;
        //Ovo iznad je isto sto i ovo ispod
        return new ChromeDriver(options);
    }

    public static void print(String s) {
        System.out.println(s);
    }

    //metoda koja moze da se koristi u svim testovima
    public void assertUrl(String actualUrl, String expectedUrl) {
        print("assertUrl (" + actualUrl + " , " + expectedUrl + ")");
        assert actualUrl.equals(expectedUrl) : "Wrong URL. Expected: " + expectedUrl + ". Actual:" + actualUrl;
    }

    public InventoryPage loginWithValidUser(ChromeDriver driver) {
        print("1. Login as valid user");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterTextIntoUsernameField(Strings.VALID_USER);

        loginPage.enterTextIntoPasswordField(Strings.INVALID_PASSWORD);

        //InventoryPage inventoryPage = loginPage.clickLoginButtonSuccess();
        //return inventoryPage;
        //Ovo iznad je isto sto i ovo ispod
        return loginPage.clickLoginButtonSuccess();
    }
    public  void loginWithValidUserVoid(ChromeDriver driver) {
        print("1. Login as valid user");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterTextIntoUsernameField(Strings.VALID_USER);
        loginPage.enterTextIntoPasswordField(Strings.INVALID_PASSWORD);
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        }catch (Exception e) {
            print(e.getMessage());}
    }
}

