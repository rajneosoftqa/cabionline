package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import step_definitions.BaseClass;

/**
 * Created by tdatta on 6/21/17.
 */
public class XPathHelpers extends BaseClass {

    private Wait wait = new Wait();
    private ScrollintoView scrollintoView = new ScrollintoView();
    private JavascriptExecutor jse = (JavascriptExecutor) driver;


    public WebElement valueXpathInTable(String id, String containsString) {

        WebElement element = driver.findElement(By.xpath(String.format
                (".//*[@id='%s']//td[contains(.,'%s')]", id, containsString)));
        return element;
    }

    public void clickTwoXpathConditionOnTable(String id, String firstString, String secondString) {


        driver.findElement(By.xpath(String.format
                (".//*[@id='%s']//td[contains(.,'%s')]// and td[contains(.,'%s')]",
                        id, firstString, secondString))).click();
    }

}
