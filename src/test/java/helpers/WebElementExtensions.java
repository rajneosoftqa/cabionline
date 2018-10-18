package helpers;

import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import pageobjects.LoginPage;
import step_definitions.BaseClass;

import java.util.Iterator;
import java.util.List;

/**
 * Created by tdatta on 7/14/17.
 */
public class WebElementExtensions extends BaseClass {
    private Wait wait = new Wait();
    private LoginPage loginPage = new LoginPage();


    public WebElement findElementByDataBind(String binding, String dataBindProperty) {
        WebElement element;
        element = driver.findElement(By.cssSelector(String.format("[data-bind='%s: %s']", binding, dataBindProperty)));
        wait.waitUntilPresent(element);
        return element;
    }

    public Boolean checkIfTextDisplayed(By by, String expected) {
        String actualText = driver.findElement(by).getText();
        assertEquals(actualText, expected);
        return null;
    }

    public WebElement findByCSS(String tagName, String attribute, String attributeName) {
        WebElement element = driver.findElement(By.cssSelector(String.format("%s[%s='%s']",
                tagName, attribute, attributeName)));
        return element;
    }

    public List <WebElement> multipleElementsByCSS(String tagName, String attribute, String attributeName) {
        List<WebElement> elements = driver.findElements(By.cssSelector(String.format("%s[%s='%s']",
                tagName, attribute, attributeName)));
        return elements;
    }

    public void loginWithGivenCredentials(DataTable userCredentials){
        List<List<String>> data = userCredentials.raw();
        //This is to get the first data of the set (First Row + First Column)
        loginPage.userName.sendKeys(data.get(0).get(0));
        //This is to get the first data of the set (First Row + Second Column)
        loginPage.password.sendKeys(data.get(0).get(1));
        loginPage.loginButton.click();
    }
    public void clearAndSendKeys(WebElement element, String keys){
        element.clear();
        element.sendKeys(keys);

    }

    public void clickLinkByHref(String href) {
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        Iterator<WebElement> i = anchors.iterator();

        while(i.hasNext()) {
            WebElement anchor = i.next();
            if(anchor.getAttribute("href").contains(href)) {
                anchor.click();
                break;
            }
        }
    }
}