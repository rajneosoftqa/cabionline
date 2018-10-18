package pageobjects;

import helpers.WebElementExtensions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;

import java.util.List;

public class AdminPage extends BaseClass {

    LoginPage loginPage = new LoginPage();
    WebElementExtensions webElementExtensions = new WebElementExtensions();

    public AdminPage() { PageFactory.initElements(driver, this); }

    @FindBy(linkText = "Add Internal User")
    public WebElement addInternalUser;

    @FindBy(xpath = "/html/body/div[2]/div/h2")
    public WebElement verifyAddinternalUser;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/div[8]/div/div/label/input[contains(@name,'SelectedRoleIds')]")
    public List<WebElement> rolesList;

    @FindBy(linkText = "Internal Users")
    public WebElement internalUsersDiligenceSkills;

    @FindBy(linkText = "Client Accounts")
    public WebElement clientAccountTab;

    @FindBy(id = "SelectedRoleIds_DiligenceSkills")
    public WebElement checkDiligenceSkillsRole;

    @FindBy(id = "submit-button")
    public WebElement updateUserButtonDiligenceSkills;

    @FindBy(linkText = "Log Off")
    public WebElement logOffDiligenceAdmin;

    @FindBy(linkText = "Update User")
    public WebElement updateUserLinkDiligenceSkills;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/div[8]/div/div/label[10]/input")
    public WebElement diligenceAdministratorRole;

    @FindBy(xpath = "//*[@id='SelectedProductTypeIds_ICVResidencyRefresher']")
    public WebElement icvResidencyRefresherProduct;

    @FindBy(xpath = "//*[@id='SelectedProductTypeIds_ALaCarteResearch']")
    public WebElement aLaCarteResearchProduct;

    @FindBy(id = "AdvancedSearchEnabled")
    public WebElement enableAdvancedSearchCheckbox;

    @FindBy(xpath = "//*[contains(text(),'Account Type')]/parent::label/parent::div//p")
    public WebElement accountType;

    @FindBy(id = "ProductNames_7__IsExpedited")
    public List<WebElement> expediteOption;

    @FindBy(id = "DeliverablesConfiguration_DeliverablesSelectedTemplateTypes___TemplateTypeId")
    public WebElement criminalRecordsTemplateType;

}
