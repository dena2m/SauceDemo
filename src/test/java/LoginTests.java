import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.Callable;

public class LoginTests extends BaseTest {

    @Test
    public void loginWithValidCredentials() {
        ChromeDriver driver = openChromeDriver();
        try {
         LoginPage loginPage = new LoginPage(driver);

         //kada je metoda void onda ovako nizemo:
          /*  loginPage.enterTextIntoUsernameField(Strings.VALID_USER);
            loginPage.enterTextIntoPasswordField(Strings.INVALID_PASSWORD);
            loginPage.clickLoginButtonSuccess(); */

            //kada metoda vraca loginPage i radimo return this, mozemo ovako:
            loginPage.enterTextIntoUsernameField(Strings.VALID_USER)
                     .enterTextIntoPasswordField(Strings.VALID_PASSWORD)
                     .clickLoginButtonSuccess();

           // assert driver.getCurrentUrl().equals(Strings.INVENTORY_URL) : "Wrong URL";
            //koristimo metodu za uporedjivanje trenutnog i ocekivanog url
            assertUrl(driver.getCurrentUrl(), Strings.INVENTORY_URL);
        }finally {
         driver.quit();
        }
    }
    @Test
    public void loginWithInvalidUserNameAndValidPass() {
         ChromeDriver driver = openChromeDriver();
         try {
             LoginPage loginPage = new LoginPage(driver);

             print("Entering invalid username");
             loginPage.enterTextIntoUsernameField(Strings.INVALID_USER);

             print("Entering valid password");
             loginPage.enterTextIntoPasswordField(Strings.VALID_PASSWORD);

             print("Clicking on login button");
             loginPage.clickingLoginButtonFailure();

             assertUrl(driver.getCurrentUrl() ,Strings.LOGIN_URL);
         }finally {
             driver.quit();
         }

    }

}
