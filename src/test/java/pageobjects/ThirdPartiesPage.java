package pageobjects;

import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;

/**
 * Created by tdatta on 5/31/17.
 */
public class ThirdPartiesPage extends BaseClass {

    private Wait wait = new Wait();
    private WebElement element;


    private final By filterByThirdPartyName = By.id("ThirdPartyName");

    @FindBy(id = "ProjectName")
    public WebElement projectName;

    @FindBy(id = "ShowInactiveThirdParties")
    public WebElement showInactiveThirdPartiesRadioButon;

    @FindBy(id = "ResetButton")
    public WebElement resetButton;

    @FindBy(className = "form-control")
    public WebElement showPerPageSelectDropDown;

    @FindBy(id = "jqgh_jqGrid_DateCreated")
    public WebElement dateCreatedFilter;

    @FindBy(id = "jqgh_jqGrid_ThirdPartyName")
    public WebElement thirdPartyFilter;

    @FindBy(id = "jqgh_jqGrid_OrderDiligenceType")
    public WebElement orderDiligenceTypeFilter;

    @FindBy(id = "jqgh_jqGrid_OrderStatus")
    public WebElement orderStatusFilter;

    @FindBy(id = "jqgh_jqGrid_DateDueDiligenceCompleted")
    public WebElement dateDuDiligenceCompletedFilter;

    @FindBy(className = "jqgh_jqGrid_RelationshipStatus")
    public WebElement relationshipStatusFilter;


    @FindBy(id = "jqgh_jqGrid_InsightScore")
    public WebElement insightScoreFilter;


    @FindBy(id = "jqgh_jqGrid_NextMonitorDate")
    public WebElement nextMonitorDateFilter;

    @FindBy(className = "jqgh_jqGrid_Last 4 SSN")
    public WebElement lastFourSSNFilter;

    @FindBy(id = "countryheatmap")
    public WebElement countryMap;

    @FindBy(className = "aggregate-bar-container")
    public WebElement insightScrorePercentage;

    @FindBy(xpath = "//*[@id=\"aggregatecontainer\"]/div[2]/div[2]/div[2]/div[2]/div/div[1]")
    public WebElement relationShipStatus;

    @FindBy(xpath = "//*[@id=\"aggregatecontainer\"]/div[2]/div[2]/div[2]/div[3]/div/div[1]")
    public WebElement lastDueDiligenceType;


    @FindBy(id = "DownloadResults")
    public WebElement downloadResultsToCSV;

    @FindBy(id = "jqPager_right")
    public WebElement viewingPagination;

    @FindBy(id = "jqPager_center")
    public WebElement paginationCenter;

    @FindBy(id = "first_jqPager")
    public WebElement firstPager;

    @FindBy(id = "prev_jqPager")
    public WebElement previousPager;

    @FindBy(id = "next_jqPager")
    public WebElement nextPager;

    @FindBy(id = "last_jqPager")
    public WebElement lastPager;

    @FindBy (id = "showHideButton")
    public WebElement showHideButton;

    public ThirdPartiesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    public void chooseRelationShipStatus(String relationStatus) throws Exception {

        wait.waitAndClick(driver, By.xpath("//*[@id=\"filterForm\"]/div[1]/div[2]/div/button"));
        driver.findElement(By.xpath(String.format("//input[@value='%s']", relationStatus))).click();

    }


    public void chooseInsightScore(String insightScore) throws Exception {

        wait.waitAndClick(driver, By.xpath("//*[@id=\"filterForm\"]/div[1]/div[3]/div/button"));
        driver.findElement(By.xpath(String.format("//input[@value='%s']", insightScore))).click();

    }

    public void filterTableByThirdPartyName(String thirdPartyName){
        wait.waitAndSendKeys(driver, filterByThirdPartyName, thirdPartyName);
        wait.waitUntilPresent(By.cssSelector("td[aria-describedby='jqGrid_E']"));
    }

    public void chooseThirdPartyForDetails(String thirdPartyName){
        driver.findElement(By.xpath(String.format
                (".//*[@id='jqGrid']//td[contains(.,'%s')]", thirdPartyName))).click();
    }

    public int thirdPartiesCount(){

        String count=null;
        element = wait.waitAndReturnElement
                (driver, By.xpath("//*[@id=\"aggregatecontainer\"]/div[2]/div[1]"));
        count = element.getText();
        try {
            if (count.matches("0")) {
                Thread.sleep(5000);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        count = element.getText();
        int countNumber = Integer.parseInt(count.replaceAll("\\D", ""));
        System.out.println("The count is on third-parties page  " + countNumber);
        return countNumber;
    }
}
