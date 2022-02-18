import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingTests extends BaseTest{

    @Test
    public void sortPriceLowToHigh() {
        ChromeDriver driver = new ChromeDriver();
        try {
            InventoryPage inventoryPage = loginWithValidUser(driver);

        /*    //metoda koja dohvata prvi item sa stranice i njegovu cenu sa znakom $ ispred    NEPOTREBNO SAMO VEZBA
            String priceBevofeSortingText = inventoryPage.getFirstItemFromInventoryPage();
            //metoda kojom odsecamo $
            String justPriceBeforeSorting = priceBevofeSortingText.substring(1);
            //metoda kojom pretvaramo string u double
            double priceBeforeSortingDouble = Double.parseDouble(justPriceBeforeSorting);
            //kod Nikole, umesto gornjeg parseDouble stoji valueOf

            //koristimo sort
            inventoryPage.selectLowToHighSort();

            //isto kao gore, dohvatamo prvi item i njegovu cenu
            String priceAfterSortingText = inventoryPage.getFirstItemFromInventoryPage();
            String justPriceAfterSorting = priceAfterSortingText.substring(1);
            double priceAfterSortingDouble = Double.parseDouble(justPriceAfterSorting);

            //metoda za uporedjivanje
            assert priceAfterSortingDouble<priceBeforeSortingDouble : "Error, item on first place after sorting is not smaller "; */
        ArrayList<Double> itemPricesBeforeSorting = inventoryPage.getAllItemPrices();
        inventoryPage.selectLowToHighSort();
        ArrayList<Double> itemPricesAfterSorting = inventoryPage.getAllItemPrices();
        Collections.sort(itemPricesBeforeSorting);
        assert itemPricesAfterSorting.equals(itemPricesBeforeSorting) : "Error. Sort is not working";

        //sortiranje kroz petlju al bezveze je bolja je gornja Collections.sort
    /*    for (int i = 0; i<itemPricesAfterSorting.size(); i++) {
            double firstNumber = itemPricesAfterSorting.get(i);
            double secondNumber = itemPricesBeforeSorting.get(i+1);
            assert  (firstNumber>secondNumber) : "Error. First number is bigger than second";
        }*/
        }finally {
            driver.quit();
        }
    }

  /*  @Test       po metodama koje sam sama probala iznad je kako je Nikola radio
    public void sortAllItemsLowToHigh() {
        ChromeDriver driver = new ChromeDriver();

        /**
         * 1. logovanje
         * 2. formiranje liste itema pre sortiranja
         * 3. sortiranje iz drop down-a low to high
         * 4. formiranje liste itema posle sortiranja
         * 5. uporedjivanje i asertovanje
         */
     /*   try {
            //1. logovanje
            InventoryPage inventoryPage = loginWithValidUser(driver);

            //2. formiranje liste itema pre sortiranja
            inventoryPage.itemsPricesBeforeSorting();

            //3. i 4.
            inventoryPage.itemsPricesAfterLowToHighSorting();

            //5. uporedjivanje i asertovanje
            Collections.sort(inventoryPage.itemsPricesBeforeSorting());
            Assert.assertEquals(inventoryPage.itemsPricesBeforeSorting(), inventoryPage.itemsPricesAfterLowToHighSorting());

        }finally {
            driver.quit();

        }*/
    }

