package forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by tdatta on 6/2/17.
 */
public class ThirdPartyCompanyDetailsForm {

    WebDriver driver;

    // Third-Party Details elements

    @FindBy(id = "CompanyName")
    public WebElement companyName;

    @FindBy(id = "DBA")
    public WebElement alternateComanyNames;

    @FindBy(id = "Address1")
    public WebElement address;

    @FindBy(id = "CountryId")
    public WebElement country;

    @FindBy(id = "RegionName")
    public WebElement state;

    @FindBy(id = "City")
    public WebElement city;

    @FindBy(id = "ZipCode")
    public WebElement zipCode;

    @FindBy(id = "SelectedRequestor")
    public WebElement requestor;

    @FindBy(id = "CountryOfIncorporationId")
    public WebElement countryOfIncorporation;

    @FindBy(id = "Website")
    public WebElement website;

    @FindBy(id = "ProjectName")
    public WebElement projectName;

    @FindBy(id = "TypeOfOrganization")
    public WebElement typeOfOrg;

    @FindBy(id = "CorporateRegistrationNumber")
    public WebElement corpRegNum;

    @FindBy(id = "Cost Center")
    public WebElement costCenter;

    @FindBy(id = "nextStepButton")
    public WebElement continueButton;


    public ThirdPartyCompanyDetailsForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
