package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by tdatta on 6/19/17.
 */
public class SubjectIndividualFormPage {

    WebDriver driver;

    @FindBy (id = "FirstName")
    public WebElement firstName;

    @FindBy(id = "MiddleName")
    public WebElement middleName;

    @FindBy (id = "LastName")
    public WebElement lastName;
    
    @FindBy (id = "Aliases")
    public WebElement aliases;
    
    @FindBy (id = "GenderId")
    public WebElement gender;
    
    @FindBy (id = "Title")
    public WebElement title;

    @FindBy (id = "SocialSecurityNumber.Anonymized")
    public WebElement socialSecurityNumber;

    @FindBy (id = "Employer")
    public WebElement employer;

    @FindBy (id = "CountryId")
    public WebElement country;

    @FindBy (id = "NationalityId")
    public WebElement nationality;

    @FindBy (id = "Address")
    public WebElement address;

    @FindBy (id = "RegionId")
    public WebElement state;

    @FindBy (id = "City")
    public WebElement city;

    @FindBy (id = "ZipCode")
    public WebElement zipCode;

    @FindBy (id = "Notes")
    public WebElement notes;

    @FindBy (xpath = "//*[@id=\"individualSubjectForm\"]/div[21]/ul/li[4]/a")
    public WebElement addSubjectToOrder;

    @FindBy (xpath = "//*[@id=\"individualSubjectForm\"]/div[21]/ul/li[1]/a")
    public WebElement cancel;

    @FindBy (id = "cancelOrderButton")
    public WebElement cancelOrderButton;

    @FindBy (id = "previousStepButton")
    public WebElement backButton;

    @FindBy (id = "nextStepButton")
    public WebElement continueButton;

    @FindBy (className = "name-container")
    public WebElement addedSubject;

    @FindBy (linkText = "Add Subject To Order")
    public WebElement addSubjectToOrderlink;

    public SubjectIndividualFormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}
