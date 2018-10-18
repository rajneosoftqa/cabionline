package pageobjects;

import helpers.Wait;
import org.hamcrest.CoreMatchers;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

/**
 * Created by tdatta on 6/27/17.
 */
public class ReportingPage extends ThirdPartiesPage {

    private Wait wait = new Wait();

    @FindBy(css = "div.col-sm-6:nth-child(1) > div:nth-child(1)")
    public WebElement thirdPartyReportType;

    @FindBy(css = ".selected > div:nth-child(1)")
    public WebElement dueDiligenceReportType;

    @FindBy(id = "OrderName")
    public WebElement orderName;

    @FindBy(id = "ThirdPartyName")
    public WebElement thirdPartyName;

    @FindBy(id = "SearchButton")
    public WebElement filterButton;

    @FindBy(id = "ResetButton")
    public WebElement resetButton;

    @FindBy(id = "StartRelationshipStatusSetDate")
    public WebElement statustSetStartDate;

    @FindBy(id = "EndRelationshipStatusSetDate")
    public WebElement statustSetEndDate;

    @FindBy(id = "StartCreateDate")
    public WebElement createdStartDate;

    @FindBy(id = "EndCreateDate")
    public WebElement createdEndDate;

    @FindBy(id = "jqgh_jqGrid_RelationshipStatusSetDate")
    public WebElement statusSetDate;

    @FindBy(id = "jqgh_jqGrid_Country")
    public WebElement sortByCountry;

    @FindBy(id = "jqgh_jqGrid_Project")
    public WebElement sortByProject;

    @FindBy(id = "approvalActionsDropdown")
    public WebElement setRelationshipStatus;

    @FindBy(css = "ul.text-right:nth-child(1) > li:nth-child(2) > button:nth-child(1)")
    public WebElement initiateDiligence;


    public ReportingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void chooseRelationStatus(String status) throws InterruptedException {

        wait.waitAndClick(driver, By.cssSelector
                (".search > div:nth-child(2) > div:nth-child(3) > button:nth-child(1)"));
        driver.findElement(By.xpath(String.format("//input[@value='%s']", status))).click();
        driver.findElement(By.cssSelector
                (".search > div:nth-child(2) > div:nth-child(3) > button:nth-child(1)")).click();
        filterButton.click();
        Thread.sleep(3000);
    }

    public void chooseInsightScore(String insightScore) {
        driver.findElement(By.xpath(String.format("//input[@value='%s']", insightScore))).click();
    }

    public void summaryTab() {

        List<String> expectedStrings = Arrays.asList("At a Glance", "Monitoring", "Refresh", "Affiliates",
                "Due Diligence Activity", "Notes", "Documents");

        List<String> expectedStringsUpper = expectedStrings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Lets test this string " + expectedStringsUpper);


//        List<WebElement> allElements = driver.findElements(By.xpath("//div[@id='thirdparty']/ul/li"));
//        WebElement industries = driver.findElement(By.id("thirdparty"));
        List<WebElement> allElements = driver.findElements(By.tagName("li"));
        for (WebElement element : allElements) {
            System.out.println("The element actual texts are " + element.getText());
            assertThat(expectedStringsUpper, contains(element.getText()));
        }
    }
}
