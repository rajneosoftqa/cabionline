package pageobjects;

import helpers.ScrollintoView;
import helpers.Wait;
import helpers.Wrapers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.*;
import step_definitions.BaseClass;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by tdatta on 5/25/17.
 */
public class HomePage extends BaseClass {

    private Wait wait = new Wait();
    private Wrapers wrapers = new Wrapers();
    private ScrollintoView scrollintoView = new ScrollintoView();
    private WebElement element;


    // All the options in the home page at header
    private final By dashboard = By.linkText("Dashboard");
    private final By thirdParties = By.linkText("Third-Parties");
    private final By reporting = By.linkText("Reporting");
    private final By monitoring = By.linkText("Monitoring");
    private final By viewMyThirdParties = By.id("dLabel"); //third party search icon
    private final By searchByNameforThirdParties = By.id("headerSearchBox");
    private final By userOptionDropDown = By.id("userOptionsDropDown");
    private final By changePassWord = By.linkText("Change Password");
    private final By selectLanguage = By.id("languageSelection");
    private final By logOff = By.id("logout-form");
    private final By order = By.xpath("//a[contains(text(),'Orders')]");
    private Actions actions;

    //Third party creation
    private final By createThirdPartyButton = By.cssSelector(".btn-create-dash");

    // Right pane navigation on home page

    public void preDueDiligenceReviewRequired() {
        By.xpath("//*[@id=\"thirdPartyTilesContainer\"]/div/ul/li[position()>=1 and position()<=6]/div[1]/div[2]");
    }

    private final By questionnairesOutstanding = By.xpath("//*[@id=\"thirdPartyTilesContainer\"]/div/ul/li[2]/div[1]/div[2]");
    private final By dueDiligenceReadyforReview = By.xpath("//*[@id=\"thirdPartyTilesContainer\"]/div/ul/li[3]/div[1]/div[2]");
    private final By escalatedforFurtherReview = By.xpath("//*[@id=\"thirdPartyTilesContainer\"]/div/ul/li[4]/div[1]/div[2]");
    private final By refreshDateApproaching = By.xpath("//*[@id=\"thirdPartyTilesContainer\"]/div/ul/li[5]/div[1]/div[2]");
    private final By unreadMonitoringAlerts = By.xpath("//*[@id=\"thirdPartyTilesContainer\"]/div/ul/li[6]/div[1]/div[2]");


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void checkForHomePageVisibility() {
        String text = wait.waitAndGetText(driver, dashboard);
        assertEquals(text, "Dashboard");
    }

    public void logOffFromCurrentSession(WebDriver driver) throws InterruptedException {

        wait.waitAndClick(driver, userOptionDropDown);
        wait.waitAndClick(driver, logOff);
    }

    public void callRightPane(String rightPane) {

        if (rightPane.equalsIgnoreCase("QUESTIONNAIRES OUTSTANDING")) {
            wait.waitAndClick(driver, questionnairesOutstanding);
        } else if (rightPane.equalsIgnoreCase("Due Diligence Ready for Review")) {
            wait.waitAndClick(driver, dueDiligenceReadyforReview);
        } else if (rightPane.equalsIgnoreCase("Escalated for Further Review")) {
            wait.waitAndClick(driver, escalatedforFurtherReview);
        } else if (rightPane.equalsIgnoreCase("Unread Monitoring Alerts")) {
            wait.waitAndClick(driver, unreadMonitoringAlerts);
        }
        new HomePage(driver);
    }

    public void navigateToCreateNewThirdPartyPage() {
        wait.waitAndClick(driver, createThirdPartyButton);
    }

    public void navigateToMonitoringPage() {
        wait.waitAndClick(driver, By.linkText("Monitoring"));
    }

    public int countForThirdParties() {
        String count;
        element = wait.waitAndReturnElement
                (driver, By.xpath("//*[@id=\"insightThirdPartiesActiveContainer\"]/div/div/div/div/div[1]/div[1]"));
        Boolean isPresent = driver.findElements(By.className("active-count")).size() > 0;
        assertTrue(isPresent);
        count = element.getText();
        int countNumber = Integer.parseInt(count);
        try {
            if (countNumber <= 0) {
                Thread.sleep(10000);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        count = element.getText();
        System.out.println("The count is on dashboard page " + count);
        return Integer.parseInt(count);
    }
    public void navigateToOrdersPage() {
        wait.waitAndClick(driver, order);
    }
}














