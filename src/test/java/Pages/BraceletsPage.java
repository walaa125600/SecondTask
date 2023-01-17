package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class BraceletsPage extends PageBase{
    WebDriver driver;
    WebDriverWait wait;
    Extractor ext;

    public BraceletsPage(WebDriver driver) {
        this.driver = driver;
        jSExecutor = (JavascriptExecutor) driver;
    }

    public String GetCurrentURL(){
        String URL2=driver.getCurrentUrl();
        return URL2;
    }

    public void SearchForItem() throws Exception {
        ext=new Extractor();
        String SearchTxtBoxLocator= ext.Locaters(0,4);
        WebElement SearchTxtBox=this.driver.findElement(By.xpath(SearchTxtBoxLocator));
        String SearchValue= ext.Locaters(1,1);
        SetTextElementTxt(SearchTxtBox,SearchValue);
        String GoBtnLocator= ext.Locaters(0,5);
        WebElement GoBtn=this.driver.findElement(By.xpath(GoBtnLocator));
        ClickBtn(GoBtn);

    }

}
