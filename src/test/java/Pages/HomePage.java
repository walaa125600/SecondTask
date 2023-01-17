package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase{
    WebDriver driver;
    WebDriverWait wait;
    Extractor ext;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        jSExecutor = (JavascriptExecutor) driver;
    }

    public void ClickOnBracelets() throws Exception {
        ext = new Extractor();
        String CategoryString = ext.Locaters(0, 2);
        WebElement CategoryLink = this.driver.findElement(By.xpath(CategoryString));
        ActionBuilder( CategoryLink,driver);
        String  BraceletsString = ext.Locaters(0, 3);
        WebElement BraceletsLink= this.driver.findElement(By.xpath(BraceletsString));
        //ClickBtn(BraceletsLink);
        jSExecutor.executeScript("arguments[0].click();", BraceletsLink);

    }
}
