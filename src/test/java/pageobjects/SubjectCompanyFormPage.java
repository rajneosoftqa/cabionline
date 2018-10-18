package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by tdatta on 6/2/17.
 */
public class SubjectCompanyFormPage {

    private WebDriver driver;

    // Affiliates company details

    @FindBy(xpath = "//*[@id=\"2\"]/ul/li[1]/h3")
    public WebElement affiliatePageLoaded;

    @FindBy(id = "affiliateFormTypeCompany")
    public WebElement affiliateFormTypeCompany;

    @FindBy(id = "Name")
    public WebElement name;

    @FindBy(id = "DBA")
    public WebElement alternateCompanyName;

    @FindBy(id = "TaxId.Anonymized")
    public WebElement taxID;

    @FindBy(name = "Address1")
    public WebElement address;

    @FindBy(id = "CountryId")
    public WebElement country;

    @FindBy(id = "RegionName")
    public WebElement regionOrState;

    @FindBy(id = "City")
    public WebElement city;

    @FindBy(id = "ZipCode")
    public WebElement zipCode;

    @FindBy(id = "CountryOfIncorporationId")
    public WebElement countryOfIncorporation;

    @FindBy(id = "Website")
    public WebElement website;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[13]/ul/li[1]/a")
    public WebElement cancelButton;

    @FindBy(xpath = "//*[@id=\"affiliateCompanyForm\"]/div[12]/ul/li[4]/a")
    public WebElement addAffilatesToThirdParty;

    @FindBy(id = "previousStepButton")
    public WebElement backButton;

    @FindBy (css = "#\\31  > div:nth-child(1) > h3:nth-child(1)")
    public WebElement enterSubjectVisible;

    @FindBy(id = "subjectFormTypeCompany")
    public WebElement subjectFormTypeCompany;

    @FindBy(id = "Notes")
    public WebElement notes;

    @FindBy(id = "nextStepButton")
    public WebElement continueButton;

    @FindBy (id = "Address")
    public WebElement addresSubjectCompany;

    @FindBy (id = "modalDailogCancelButton")
    public WebElement modalDailogCancelButton;

    @FindBy (xpath = "//*[@id='companySubjectForm']/div[13]/ul/li[4]/a")
    public WebElement addSubjectToOrder;

    @FindBy (linkText = "Add Subject To Order")
    public WebElement addSubjectToOrderlink;

    public SubjectCompanyFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
