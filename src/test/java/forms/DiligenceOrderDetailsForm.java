package forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;

/**
 * Created by tdatta on 6/2/17.
 */
public class DiligenceOrderDetailsForm extends BaseClass {

    // Order details elements

    @FindBy (xpath = "//*[@id=\"thirdPartyDiligenceForm\"]/div[1]/ul/li[1]/h3")
    public WebElement diligencePageLoaded;

    @FindBy(id = "Q1Yes")
    public WebElement thirdPartyInvestigatedYes;

    @FindBy(id = "Q1No")
    public WebElement thirdPartyInvestigatedNo;

    @FindBy(id = "OrderTypeId")
    public WebElement orderType;

    @FindBy(id = "OrderName-0")
    public WebElement orderName;

    @FindBy(id = "ClientReferenceId-0")
    public WebElement clientReferenceId;

    @FindBy(id = "SelectedDiligenceRequestor-0")
    public WebElement SelectedDiligenceRequestor;

    @FindBy(id = "DiligenceProjectName")
    public WebElement diligenceProjectName;

    @FindBy(id = "Notes-0")
    public WebElement notes;

    @FindBy(id = "PerformDiligence")
    public WebElement performDiligenceRadioButton;

    @FindBy(id = "previousStepButton")
    public WebElement backButton;


    public DiligenceOrderDetailsForm(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
