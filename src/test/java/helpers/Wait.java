package helpers;

import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.BaseClass;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by tdatta on 6/2/17.
 */
public class Wait extends BaseClass {

    private int waitTime = 30;
    private static WebElement element;
    private WebDriverWait webDriverWait = new WebDriverWait(driver, waitTime);


    @And("^I wait (\\d+) seconds for .*$")
    public void iWaitSecondsForPageToLoad(int seconds) throws Throwable {
        Thread.sleep(seconds*1000);
    }


    public void waitAndClick(WebDriver driver, By by) {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public WebElement waitAndClick(WebElement element)
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return element;
    }

    public void waitUntilPresent(By by) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitUntilPresent(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitUntilNotPresent(WebElement element) {
        webDriverWait.until(ExpectedConditions.invisibilityOf(element));
        return element;
    }

    public WebElement waitUntilClickable(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public String waitUntilTextIs(By by, String text){
        webDriverWait.until(ExpectedConditions.textToBe(by, text));
        return text;
    }

    public String waitUntilTextIs(WebElement element, String text){
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(element, text));
        return text;
    }

    public void waitAndClickOnElement(WebDriver driver, WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitUntilNotPresent(By by) {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public String waitAndGetText(WebDriver driver, By by) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        String text = driver.findElement(by).getText();
        return text;
    }
    public String waitAndGetText(WebDriver driver, WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
         return element.getText();
    }
    public WebElement waitAndReturnElement(WebDriver driver, By by) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        WebElement element = driver.findElement(by);
        return element;
    }
    public void waitToGetTitle(WebDriver driver, String title) {
        webDriverWait.until(ExpectedConditions.titleIs(title));

    }
    public List<WebElement> waitAndReturnListElements(WebDriver driver, By by) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        List<WebElement> elements = driver.findElements(by);
        return elements;
    }
    public void waitAndSendKeys(WebDriver driver, By by, String keys) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(keys);
    }

    public void waitAndSendKeysByElement(WebElement element, String keys) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(keys);
    }
    public void waitAndSwitchToNewWindow(WebDriver driver, By by) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        if (driver.findElement(by).isDisplayed()) {
            driver.switchTo().activeElement();
        }
    }
    public void waitAndSwitchToNewTab(){

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }
    public void waitAndSwitchToMainTab(){

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }
    public void waitUntilGridSpinnersNotPresent(){
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){}
        if (driver.findElements(By.id("gridSpinner")).size() != 0) {
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("gridSpinner")));
        } else if (driver.findElements(By.cssSelector("div.loading:nth-child(1) > img:nth-child(1)")).size() != 0) {

            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated
                    (By.cssSelector("div.loading:nth-child(1) > img:nth-child(1)")));
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("load_jqGrid")));
        }
        else if (driver.findElements(By.cssSelector("div.loading")).size() != 0) {

            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated
                    (By.cssSelector("div.loading")));
//            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("load_jqGrid")));
        }
        else if (driver.findElements(By.id("load_jqGrid")).size() != 0) {
            System.out.println("grid spinner present");
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("load_jqGrid")));
        }

    }
    public void waitUntilSubjectLoadingNotPresent() {
        if (driver.findElements(By.cssSelector("[data-bind='visible: SubjectLoading']")).size() != 0) {
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated
                    (By.cssSelector("[data-bind='visible: SubjectLoading']")));
        }
    }
    public void untilNumberOfWindows(int numberOfWindows){
        webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));

    }


    public Boolean waitUntilIsPresentAndClickable(By by) throws Throwable {
        waitUntilGridSpinnersNotPresent();
//        webDriverWait = new WebDriverWait(driver,3000);
        checkPageIsReady();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
//        Thread.sleep(1000);
        waitUntilGridSpinnersNotPresent();
        return null;
    }
    public Boolean waitUntilIsPresentAndClickable(WebElement element) throws Throwable {
        waitUntilGridSpinnersNotPresent();
        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
//        Thread.sleep(3000);
        return null;
    }

    public void checkPageIsReady() {
        waitUntilGridSpinnersNotPresent();
        JavascriptExecutor js = (JavascriptExecutor)driver;


        //Initially bellow given if condition will check ready state of page.
        if (js.executeScript("return document.readyState").toString().equals("complete")){
//            System.out.println("Page Is loaded.");
            return;
        }

        //This loop will rotate for 25 times to check If page Is ready after every 1 second.
        //You can replace your value with 25 If you wants to Increase or decrease wait time.
        for (int i=0; i<25; i++){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {}
            //To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete")){
                break;
            }
        }
    }

    public static void waitUntilExpectedCss(WebDriver driver, WebElement element, String cssProperty, String cssValue) {
        WebDriverWait wait = new WebDriverWait(driver,20);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String enabled = element.getCssValue(cssProperty);
//                System.out.println(enabled);
                if(enabled.contains(cssValue))
                    return true;
                else
                    return false;
            }
        });
    }


    public static void waitUntilTextVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,20);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String enabled = element.getText();
//                System.out.println(enabled);
                if(!enabled.isEmpty())
                    return true;
                else
                    return false;
            }
        });
    }

    public void waitForanElement(WebElement element) {

        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitForElementToBeVisible(WebElement element) throws Throwable {
        System.out.println("in");
        while (!element.isDisplayed()){
            System.out.println("double in");
            Thread.sleep(5000);
            if (element.isDisplayed()) {
                break;
            }
        }
    }

}