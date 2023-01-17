package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends PageBase{
    WebDriver driver;
    WebDriverWait wait;
    Extractor ext;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        jSExecutor = (JavascriptExecutor) driver;
    }
    public void OpenTheCart() throws Exception {
        ext = new Extractor();
        String CartLocator=ext.Locaters(0, 9);
        WebElement Cart=this.driver.findElement(By.xpath(CartLocator));
        ClickBtn(Cart);
    }
    public Double GetTotalPrice() throws Exception {
        ext=new Extractor();
        String totalPriceInCartPage=ext.Locaters(0,10);
        WebElement PriceInCartPage=this.driver.findElement(By.xpath(totalPriceInCartPage));
        String totalPrice=PriceInCartPage.getText();
        totalPrice=totalPrice.substring(1, totalPrice.length());
        String finalprice=totalPrice.replaceAll("$", "");
        Double totDouble=Double.parseDouble(finalprice);
        System.out.println("Total Price in cart Page  is  "+totDouble);
        return totDouble;


    }




}
