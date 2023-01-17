package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

    public class PageBase {

        public JavascriptExecutor jSExecutor;

        protected static void ClickBtn(WebElement Button) {
            Button.click();
        }

        protected static void SetTextElementTxt(WebElement TextElement, String Value) {
            TextElement.sendKeys(Value);
        }

        public void ScrollDown() {
            jSExecutor.executeScript("scrollBy(0,1000)");
        }

        public static void ActionBuilder(WebElement Button, WebDriver driver) {
            Actions actions = new Actions(driver);
            actions.moveToElement(Button);
            Action action = actions.build();
            action.perform();
        }


    }


