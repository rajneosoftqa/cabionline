package pageobjects;

import helpers.CssHelpers;
import helpers.SelectElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;

import java.util.List;

public class OMSDashboardPage extends BaseClass {
    Actions actions = new Actions(driver);

    private SelectElements selectElements = new SelectElements();
    CssHelpers cssHelpers = new CssHelpers();

    public OMSDashboardPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ExternalUserDashboardViewDropDown")
    public WebElement dashboardViewDropDown;

    @FindBy(id = "calendar")
    public WebElement calendar;

    @FindBy(className = "btn-create-dash")
    public WebElement createOrderButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div[1]/div/div[2]/div[1]/div[2]/div/ul/li[2]/select")
    public WebElement showPerPageSelect;
    
    @FindBy (id = "headerSearchBox")
    public WebElement searchBox;
    
    @FindBy (id = "userOptionsDropDown")
    public WebElement userOptionsDropDown;
    
    @FindBy (xpath = "//a[contains(text(),'Change Password')]")
    public WebElement changePassword;

    @FindBy (xpath = "//a[contains(text(),'Log Off')]")
    public WebElement logOff;
    
    @FindBy (id = "metricTilesContainer")
    public WebElement tableElements;

    @FindBy (id = "gbox_jqGrid")
    public WebElement tableGrid;

    @FindBy (className = "fc-left")
    public WebElement calMonth;

    @FindBy (id = "metricTilesContainer")
    public WebElement gridList;

    @FindBy (id = "gbox_jqGrid")
    public WebElement jqgridList;


    @FindBy (className = "metric-tile-title")
    public List <WebElement> tile;

    @FindBy (xpath = "//*[@id='metric-tile-1']/div[3]")
    public WebElement notSubmittedTile;

    @FindBy (id = "metric-tile-1")
    public WebElement notSubmittedTileDiv;

    @FindBy (xpath = "/html/body/nav[1]/div[2]/div[2]/ul/li[2]/div/span[1]/div")
    public WebElement suggestions;



//    @FindBy (xpath = "//*[@id=\"metric-tile-2\"]/div[3]")
//    public WebElement inProgress;
//
//    @FindBy (xpath = "//*[@id=\"metric-tile-4\"]/div[3]")
//    public WebElement unreadMessages;
//
//    @FindBy (xpath = "//*[@id=\"metric-tile-3\"]/div[3]")
//    public WebElement reportsDelivered;

    @FindBy(xpath = "//a[contains(text(),'Terms and Conditions')]")
    public WebElement termsandconditions;

    @FindBy(xpath = "//a[contains(text(),'Terms and Conditions')]")
    public WebElement tocverify;

    @FindBy(xpath = "//a[text()='Support']")
    public WebElement support;

    @FindBy(xpath = "//*[@id='body-content']/div[1]/ul/li/h2")
    public WebElement supportverify;

    @FindBy(id = "headerSearchBox")
    public WebElement quicksearch;

    @FindBy(id = "DownloadAudit")
    public WebElement downloadaudit;


    @FindBy(id = "DownloadResults")
    public WebElement downloadresults;

    @FindBy(xpath = "//a[contains(text(),'Forgot Password')]")
    public WebElement forgotpassword;

    @FindBy(linkText = "English (US)")
    public WebElement language;

    @FindBy(xpath = "//a[contains(text(),'Privacy Policy')]")
    public WebElement privacypolicy;

    @FindBy(xpath = "//a[contains(text(),'Privacy Policy')]")
    public WebElement privacypolicyverify;

    @FindBy(css = ".dropdown-menu")
    public WebElement userOptionsDropDowndiv;

    public void selectShowPerPage(String numberPerPage){
        selectElements.selectByVisibleText(showPerPageSelect, numberPerPage);
    }
    public void chooseDashBoardView(String textToChoose){
        dashboardViewDropDown.click();
        actions.moveToElement(driver.findElement(By.linkText(textToChoose))).click().build().perform();
    }

    public void statusTile(String text) throws InterruptedException{
        for(WebElement s : tile)
        {
            if(s.getText().equals(text)){
                s.click();
                Thread.sleep(2000);
                break;
            }
        }
    }

    public void expandUserOptions(){
        cssHelpers.unHideElement(userOptionsDropDowndiv);
    }

}
