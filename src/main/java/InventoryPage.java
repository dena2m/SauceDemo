import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder;
import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends BasePage{

        //webelelmenti
        @FindBy(id = "add-to-cart-sauce-labs-backpack")
        WebElement addToCartBackpackButton;

        @FindBy(id = "add-to-cart-sauce-labs-bike-light")
        WebElement addToCartBikeLightButton;

        @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
        WebElement addToCartBoltTshirtButton;

        @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
        WebElement addToCartFleeceJacketButton;

        @FindBy(id = "add-to-cart-sauce-labs-onesie")
        WebElement addToCartOnesieButton;

        @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
        WebElement addToCartTshirtButton;

        @FindBy(id = "remove-sauce-labs-backpack")
        WebElement removeBackpackButton;

        @FindBy(className = "product_sort_container")
        WebElement sortDropDown;


        //konstruktor nasledjen od nadklase
        public InventoryPage(ChromeDriver driver) {
            super(driver);
        }

    //metoda koja klikce na add to cart za backpack
    public InventoryPage clickAddToCartBackpack() {
            addToCartBackpackButton.click();
            return this;
    }

    //isto za ranac
    public InventoryPage clickAddToCartBikeLight() {
            addToCartBikeLightButton.click();
            return this;
    }

    //metoda za klik na remove batton za ranac
    public InventoryPage clickRemoveBackpack() {
            removeBackpackButton.click();
            return this;
    }

    //metoda za biranje opcija za sortiranje itema
    public InventoryPage selectLowToHighSort() {
            Select dropdown = new Select(sortDropDown);
            //Select je klasa za upravljanje dropdownovima
        //biranje opcija iz dropdowna po tekstu koji pise
        dropdown.selectByVisibleText("Price (low to high)");
        return this;
    }

    //univerzalna metoda za trazenje cene bilo kojeg itema po njegovom nazivu
    public String getItemPrice(String itemName) {
            String price = null;
            //ovako dohvatamo sve divove sa itemima
        List<WebElement> allItems = driver.findElements(By.className("inventory_item"));
        for (WebElement element : allItems) {
            if(element.getText().contains(itemName)) {
                WebElement priceWebElement = element.findElement(By.className("inventory_item_price"));
                price = priceWebElement.getText();
                break;
            }
        }
        return price;
    }

    //ova metoda dohvata cenu prvog itema u nizu
    public String getFirstItemFromInventoryPage() {
            String price = null;
            //sve elemente stavljamo u niz
            List<WebElement> allItems = driver.findElements(By.className("inventory_item"));
            //pa dohvatamo prvi element
            WebElement firstElementPrice = allItems.get(0).findElement(By.className("inventory_item_price"));
            return firstElementPrice.getText();
         }

         public void addToCartItemByName(String name) {
             //List<WebElement> allItems = driver.findElements(By.className("inventory_item"));
            //napravljen je dole metod za ovo iznad zato je zameljeno ispod
             List<WebElement> allItems = getAllItems();
             for (WebElement element : allItems) {
                 WebElement elementName = element.findElement(By.className("inventory_item_name"));
                 String actualName = elementName.getText();
                 if(actualName.equals(name)) {
                     WebElement elementAddToCartButton = element.findElement(By.xpath(".//button"));
                     elementAddToCartButton.click();
                     break;
                 }
             }
         }
//ovo je isto kao sto sam sama radila ispod u itemsPricesBeforeSorting(
        public ArrayList<Double> getAllItemPrices() {
            List<WebElement> allItems = getAllItems();
            ArrayList<Double> itemPrices = new ArrayList<>();
            for ( WebElement element : allItems) {
               String itemPriceWithDollar = element.findElement(By.className("inventory_item_price")).getText();
               String itemPriceWithoutDollar = itemPriceWithDollar.substring(1);
               Double itemPrice = Double.valueOf(itemPriceWithoutDollar);
              print("Item price is:" + itemPrice);
               itemPrices.add(itemPrice);
            }
            return itemPrices;
        }

         //metoda koja pravi listu itema pre sortiranja, uklara znak $ i pretvara iz stringa u double
 /*   public List<Double> itemsPricesBeforeSorting() {

            List<WebElement> priceBeforeSortingString = driver.findElements(By.className("inventory_item_price"));
            List<Double> finalPriceBeforeSorting = new ArrayList<>();
            for (WebElement item : priceBeforeSortingString) {
                finalPriceBeforeSorting.add(Double.valueOf(item.getText().replace("$", "")));
            }
            return finalPriceBeforeSorting;
        }


        //metoda koja pravi listu itema posle sortiranja, uklanja znak $ i pretvara iz stringa u double
    public List<Double> itemsPricesAfterLowToHighSorting() {

            selectLowToHighSort();

            List<WebElement> priceAfterSortingString = driver.findElements(By.className("inventory_item_price"));
            List<Double> finalPriceAfterSorting = new ArrayList<>();
            for (WebElement item : priceAfterSortingString) {
                finalPriceAfterSorting.add(Double.valueOf(item.getText().replace("$", "")));
            }
            return finalPriceAfterSorting;
        }*/

        public List<WebElement> getAllItems() {
            List<WebElement> allItems = driver.findElements(By.className("inventory_item"));
            return allItems;
        }

    }


