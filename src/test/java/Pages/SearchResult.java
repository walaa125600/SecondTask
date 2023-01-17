package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchResult extends PageBase{
    WebDriver driver;
    WebDriverWait wait;
    Extractor ext;
    public SearchResult(WebDriver driver) {
        this.driver = driver;
        jSExecutor = (JavascriptExecutor) driver;
    }

    public String GetAllList() throws Exception {
        ext = new Extractor();
        String RandomListLocator = ext.Locaters(0, 6);
        List<WebElement> allProducts = driver.findElements(By.xpath(RandomListLocator));
        String Name = null;
        for (int i = 0; i < allProducts.size(); i++) {
            Name = allProducts.get(i).getText();
            System.out.println(Name);


        }
        return Name;
    }

    public void AddFirstElementToCart() throws Exception {
        ext = new Extractor();
        String AddToCartLocator=ext.Locaters(0, 7);
        WebElement AddToCart=this.driver.findElement(By.xpath(AddToCartLocator));
        ClickBtn(AddToCart);
    }

    public Double GetElementPriceInSearchResult() throws Exception {
        ext=new Extractor();
        String totalPriceInSearchResult=ext.Locaters(0,8);
        WebElement PriceInSearchResult=this.driver.findElement(By.xpath(totalPriceInSearchResult));
        String totalPrice=PriceInSearchResult.getText();
        totalPrice=totalPrice.substring(1, totalPrice.length());
        String finalprice=totalPrice.replaceAll("$", "");
        Double totDouble=Double.parseDouble(finalprice);
        System.out.println("Actual Total Price is:  "+totDouble);
        return totDouble;



    }






}
