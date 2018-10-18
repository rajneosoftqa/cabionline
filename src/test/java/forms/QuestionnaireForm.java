package forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuestionnaireForm {
    WebDriver driver;

    @FindBy(id = "QR~QID3~1")
    public WebElement address1;
    
    @FindBy (id = "QR~QID3~2")
    public WebElement address2;
    
    @FindBy (id = "QR~QID3~3")
    public WebElement city;

    @FindBy(id = "QR~QID3~4")
    public WebElement state;

    @FindBy (id = "QR~QID3~5")
    public WebElement zipcode;

    @FindBy (id = "QR~QID97")
    public WebElement country;

    @FindBy (id = "QR~QID2~2")
    public WebElement nameOfThePersonCompleting;
    
    @FindBy (id = "QR~QID2~3")
    public WebElement titleOfPersonCompleting;

    @FindBy (id = "QR~QID2~4")
    public WebElement email;

    @FindBy (id = "QR~QID2~5")
    public WebElement alternateEmail;

    @FindBy (id = "QID99-1-label")
    public WebElement oneTwoYearsinBusiness;
    
    @FindBy (id = "QID99-2-label")
    public WebElement threeToFiveYearsBusiness;

    @FindBy (id = "QID101-1-label")
    public WebElement annualIncome;

    @FindBy (id = "QID100-3-label")
    public WebElement politicalExposedNO;

    @FindBy (id = "QID102-1-label")
    public WebElement govInvolvedNO;

    @FindBy (id = "QID103-1-label")
    public WebElement publicCompanyYES;

    @FindBy (id = "QID13-1-label")
    public WebElement vendorBackgroundCheck;
    
    @FindBy (id = "QID86-1-label")
    public WebElement howManyIndividualInvolveExiger1;

    @FindBy (id = "NextButton")
    public WebElement continueButton;

//    @FindBy (id = "QID83-1-label")
//    public WebElement ;

    public QuestionnaireForm(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
