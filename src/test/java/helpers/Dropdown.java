package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import step_definitions.BaseClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titudatta on 8/19/15.
 */
public class Dropdown extends BaseClass {

    public void selectValueFromUnorderedList(WebElement driver, final String value) {
        List<WebElement> options = driver.findElements(By.tagName("li"));
        for (WebElement option : options) {
//           System.out.println(option.getText());
            if (value.equalsIgnoreCase(option.getText())) {
                option.click();
                break;
            }
        }
    }

    public void selectValueFromUnorderedListWithCheckbox(WebDriver driver, WebElement optionlistdiv, WebElement button, final String value) {
        button.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElement> inputs = optionlistdiv.findElements(By.tagName("input"));
        for (WebElement input : inputs) {
            js.executeScript("arguments[0].setAttribute('style', 'display:none;')",input);
        }
        List<WebElement> options = optionlistdiv.findElements(By.tagName("label"));
        for (WebElement option : options) {
            if (value.equalsIgnoreCase(option.getText())) {
                option.click();
                break;
            }
        }
        button.click();
    }

    public List<String> getAllValuesFromUnorderedListWithCheckbox(WebDriver driver, WebElement optionlistdiv, WebElement button) {
        button.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<String> optionList = new ArrayList <>();
        List<WebElement> inputs = optionlistdiv.findElements(By.tagName("input"));
        for (WebElement input : inputs) {
            js.executeScript("arguments[0].setAttribute('style', 'display:none;')",input);
        }
        List<WebElement> options = optionlistdiv.findElements(By.tagName("label"));
        for (WebElement option : options) {
           optionList.add(option.getText().replace(",", "-"));
        }
        button.click();
        return optionList;

    }


    public void assertDefaultValueFromUnorderedListWithCheckbox (WebDriver driver, final String value, WebElement form) {
        List<WebElement> options = form.findElements(By.xpath("//button/span[not(contains(@class, 'caret')) and not(contains(@aria-hidden, 'true'))]"));
        for (WebElement option : options){
            assertEquals(option.getText(), value);
        }
    }

    public void assertCheckedFromUnorderedListWithCheckbox (WebElement form, WebElement button) {
        button.click();
        List<WebElement> options = form.findElements(By.tagName("input"));
        for (WebElement option : options){
            assertFalse(option.isSelected());
        }
        button.click();
    }

    public void selectValueFromInput(WebElement optionlistdiv, WebElement button, final String value) {
        button.click();
        List<WebElement> options = optionlistdiv.findElements(By.tagName("input"));
        for (WebElement option : options) {
//            System.out.println(value + " ==--==  " + option.getAttribute("value"));
            if (value.replace(" ","").equalsIgnoreCase(option.getAttribute("value"))) {
                option.click();
                break;
            }
        }
        button.click();
    }
}
