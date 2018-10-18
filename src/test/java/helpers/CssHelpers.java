package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import step_definitions.BaseClass;

public class CssHelpers extends BaseClass {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void unWrapText(WebElement webElement){
        js.executeScript("arguments[0].setAttribute('style', 'overflow:none;')",webElement);
    }

    public void unHideElement(WebElement webElement){
        js.executeScript("arguments[0].setAttribute('style', 'display:block;')",webElement);
    }

    public void HideElement(WebElement webElement){
        js.executeScript("arguments[0].setAttribute('style', 'display:none;')",webElement);
    }

    public void addCssProperty(WebElement webElement,String propertyName,String propertyValue){
        js.executeScript("arguments[0].setAttribute('style', '"+propertyName+":"+propertyValue+";')",webElement);
    }
}
