import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShoppingTests extends BaseTest{

    /**
     * Add an item from Inventory Page
     *
     * Steps:
     * 1. Login as valid user
     * 2. From Inventory page click on 'Add to cart' button for one item
     *
     * Expected results
     * 2. Verify that shopping cart icon has number 1 on it
     */
    @Test
    public void addOneItemInShoppingCart() {
        ChromeDriver driver = openChromeDriver();
        try {
    //koristimo metodu iz BaseTest koja nas uvek uloguje sa validnim userom
    InventoryPage inventoryPage = loginWithValidUser(driver);

    print("2. From Inventory page click on 'Add to cart' button for one item");
    inventoryPage.clickAddToCartBackpack();

    print("2. Verify that shopping cart icon has number 1 on it");
    String currentNumber = inventoryPage.getNumberFromShoppingCartIcon();

    assert currentNumber.equals("1") : "Wrong number of items. Expected: 1. Actual: " + currentNumber;
        }finally {
            driver.quit();
        }
    }

    /**
     * Add and remove item from inventory page
     *
     * Steps:
     * 1. Login as valid user
     * 2. From inventory page click on 'Add to cart' button for one item
     * 3. Click on 'Remove' button
     *
     * Expected results:
     * 2. Verify that shopping cart icon has number 1 on it
     * 3. Verify that shopping cart icon does not have any number on it
     */
    @Test
    public void addAndRemoveOneItemFromInventoryPage() {
        ChromeDriver driver = openChromeDriver();
        try {
            InventoryPage inventoryPage = loginWithValidUser(driver);
          //umesto gornje metode mozemo da koristicemo void metodu za logovanje i pravicemo objekat InventoryPage
         // loginWithValidUser(driver);
         // InventoryPage inventoryPage = new InventoryPage(driver);

          print("2. From inventory page click on 'Add to cart' button for one item");
         // inventoryPage.clickAddToCartBackpack();
            inventoryPage.addToCartItemByName(Strings.FLEECE_JACKET);

          print("2. Verify that shopping cart icon has number 1 on it");
          String currentNumber = inventoryPage.getNumberFromShoppingCartIcon();
          assert currentNumber.equals("1") : "Wrong number of items. Expected: 1. Actual: " + currentNumber;

          print("Click on 'Remove' button");
          inventoryPage.clickRemoveBackpack();

          print("3. Verify that shopping cart icon does not have any number on it");
        assert !inventoryPage.isShoppingCartBadgeNumberPresent();

        } finally {
            driver.quit();

        }
    }
}

