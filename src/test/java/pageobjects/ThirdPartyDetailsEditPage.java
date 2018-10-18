package pageobjects;

import helpers.ScrollintoView;
import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import step_definitions.BaseClass;

/**
 * Created by tdatta on 6/19/17.
 */
public class ThirdPartyDetailsEditPage extends BaseClass{

    private Wait wait = new Wait();
    private ScrollintoView scrollintoView = new ScrollintoView();

    @FindBy(id = "pageHeader")
    public WebElement pageHeader;

    @FindBy(linkText = "Summary")
    public WebElement summary;

    @FindBy(linkText = "Risk Model")
    public WebElement riskModel;

    @FindBy(linkText = "Monitoring")
    public WebElement monitoring;

    @FindBy(id = "approvalActionsDropdown")
    public WebElement setRelationStatus;

    @FindBy(id = "editCoreDetailsActionLinks")
    public WebElement editThirdPartyDetailsButton;

    @FindBy(id = "cancelEditCoreDetailsActionLink")
    public WebElement cancelEditButton;

    @FindBy(xpath = "//*[@id=\"editCoreDetailsActionLink\"]")
    public WebElement editDetailsSaveButton;

    @FindBy(id = "CompanyName")
    public WebElement editCompanyName;

    @FindBy(id = "editMonitoringDetailsActionLinks")
    public WebElement editRefreshingButton;

    @FindBy(xpath = "//*[@id=\"editCoreDetailsActionLinks\"]/li/a")
    public WebElement addAffiliate;

    @FindBy (id = "addRecipient")
    public WebElement addNewRecipient;

    @FindBy (id = "addRecipientButton")
    public WebElement saveNewRecipientInfo;

    @FindBy (css = "span[class='glyphicon-pencil']")
    public WebElement pencilEdit;

    @FindBy (className = "subject-card")
    public WebElement subjectCard;

//    @FindBy (css = ".col-sm-2 > a:nth-child(1) > span:nth-child(1)")
//    public WebElement editMasterAffiliate;
    


    public ThirdPartyDetailsEditPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void editRecipientDetails(String FirstName, String Emails) {
        wait.waitAndClick(driver, By.id("editRecipientButton"));
        WebElement firstNameElement = driver.findElement(By.id("FirstName"));
        firstNameElement.clear();
        firstNameElement.sendKeys(FirstName);
        WebElement emailElement = driver.findElement(By.id("recipientemail"));
        emailElement.clear();
        emailElement.sendKeys(Emails);
        driver.findElement(By.id("updateRecipientButton")).click();
        wait.waitUntilGridSpinnersNotPresent();
    }

    public void addAndDeleteRecipient() throws InterruptedException {
        String title = wait.waitAndGetText(driver, By.xpath(".//*[@id='order-title']"));
        System.out.println("The third party chosen "+ title);
        wait.waitUntilGridSpinnersNotPresent();
        scrollintoView.scrollDown();
        wait.waitAndClick(driver, By.id("addRecipient"));
        new Select(driver.findElement(By.id("addRecipientForm"))
                .findElement(By.xpath(".//*[@id='InsightUserId']"))).selectByIndex(1);
        new Select(driver.findElement(By.id("addRecipientForm"))
                .findElement(By.xpath(".//*[@id='LanguageId']"))).selectByIndex(1);
        driver.findElement(By.xpath(".//*[@id='addRecipientButton']")).click();
        Thread.sleep(8000);
//        wait.waitAndClick(driver, By.id("deleteRecipientButton"));
//        wait.waitAndClick(driver, By.xpath(".//*[@id='modalDialogConfirmButton']"));
        Thread.sleep(2000);
    }

}
