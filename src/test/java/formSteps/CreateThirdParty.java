//package formSteps;
//
//import com.github.javafaker.*;
//import com.github.javafaker.Number;
//import forms.*;
//import helpers.ScrollintoView;
//import helpers.SelectElements;
//import helpers.Wait;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.PageFactory;
//import pageobjects.SubjectCompanyFormPage;
//import pageobjects.ReviewAndConfirmThirdParty;
//import step_definitions.BaseClass;
//
//import java.util.Random;
//
///**
// * Created by tdatta on 6/1/17.
// */
//public class CreateThirdParty extends BaseClass {
//
//    private Random random = new Random();
//    private Faker faker = new Faker();
//    public WebElement element;
//
//    private Wait wait = new Wait();
//    private Actions actions = new Actions(driver);
//
//    private Internet internet = faker.internet();
//    private Address streetAddress = faker.address();
//    private Company company = faker.company();
//    private IdNumber idNumber = faker.idNumber();
//    private Number number = faker.number();
//    private DiligenceTabForm diligenceTabForm = new DiligenceTabForm(driver);
//
//    private JavascriptExecutor jse = (JavascriptExecutor) driver;
//
//
//    private ScrollintoView scrollintoView = new ScrollintoView();
//
//    private QuestionnaireRecipientForm qr = new QuestionnaireRecipientForm(driver);
//    private ThirdPartyCompanyDetailsForm thirdPartyCompanyDetailsForm = new ThirdPartyCompanyDetailsForm(driver);
//    private DiligenceOrderDetailsForm diligenceOrderDetailsForm = new DiligenceOrderDetailsForm(driver);
//    private SubjectCompanyFormPage subjectCompanyFormPage = new SubjectCompanyFormPage(driver);
//    private ReviewAndConfirmThirdParty reviewAndConfirmThirdParty = new ReviewAndConfirmThirdParty(driver);
//    private RiskAssessmentForm riskAssessmentForm = new RiskAssessmentForm(driver);
//    private SelectElements selectElements = new SelectElements();
//
//
//    public CreateThirdParty(WebDriver driver) {
//        PageFactory.initElements(driver, this);
//    }
//
//
//    public void thirdPartyCreationPageIsVisible() {
//
//        String text = wait.waitAndGetText(driver, By.xpath("//*[@id=\"title-info\"]/h2/span[1]"));
//        Assert.assertEquals(text, "Create New Third-Party");
//        new CreateThirdParty(driver);
//    }
//
//    public String fillThirdPartyDetails() throws InterruptedException {
//
//
//        String thirdPartyName = company.name();
//
//        thirdPartyCompanyDetailsForm.companyName.sendKeys(thirdPartyName);
//        thirdPartyCompanyDetailsForm.alternateComanyNames.sendKeys(company.name());
//        thirdPartyCompanyDetailsForm.address.sendKeys(streetAddress.streetAddress());
//        //chooses random country
////        new Select(driver.findElement(By.id("CountryId"))).selectByVisibleText("Afghanistan");
//        selectElements.selectRandomOption(By.id("CountryId"));
//        thirdPartyCompanyDetailsForm.state.sendKeys(streetAddress.state());
//        thirdPartyCompanyDetailsForm.city.sendKeys(streetAddress.city());
//        thirdPartyCompanyDetailsForm.zipCode.sendKeys(streetAddress.zipCode());
//        //chooses random country of incorporation
//        selectElements.selectRandomOption(By.id("CountryOfIncorporationId"));
//        thirdPartyCompanyDetailsForm.website.sendKeys(company.url());
//
//        return thirdPartyName;
//
//    }
//
//    public void fillDiligenceOrderDetails() {
//
//        wait.waitUntilPresent(diligenceOrderDetailsForm.diligencePageLoaded, );
//        diligenceOrderDetailsForm.orderName.sendKeys(company.buzzword());
//        diligenceOrderDetailsForm.clientReferenceId.sendKeys(number.digits(5));
//        diligenceOrderDetailsForm.notes.sendKeys(company.catchPhrase());
//    }
//
//
//    public void fillAffiliateCompanyDetails() throws InterruptedException {
//        scrollintoView.scrollToView(subjectCompanyFormPage.affiliateFormTypeCompany);
//
//        scrollintoView.scrollUp();
//        subjectCompanyFormPage.affiliateFormTypeCompany.click();
////        subjectCompanyFormPage.name.sendKeys(company.name());
//        subjectCompanyFormPage.taxID.sendKeys(idNumber.validSvSeSsn());
//    }
//
//    public void reviewAndConfirm() {
//        wait.waitUntilPresent(By.id("submitOrderButton"));
//        scrollintoView.scrollDown();
//        reviewAndConfirmThirdParty.submitButton.click();
//    }
//
//    public void submitThisForm() {
//        scrollintoView.scrollToViewAndClick(thirdPartyCompanyDetailsForm.continueButton);
//    }
//
//    public void fillRiskAssessmentForm() throws InterruptedException {
//
////        riskAssessmentForm.chooseCountry();
////        riskAssessmentForm.chooseIndustry();
//        scrollintoView.scrollToView(riskAssessmentForm.continueButton);
//        riskAssessmentForm.continueButton.click();
//    }
//
//    public void fillRecepientDetailsFormExternal() throws InterruptedException {
////        selectElements.selectRandombyElement(qr.chooseQuestionnaire);
//        selectElements.selectByIndexNumbert(By.id("SelectedSurveyId-0"), 1);
//        qr.firstName.sendKeys(streetAddress.firstName());
//        qr.lastName.sendKeys(streetAddress.lastName());
//        qr.email.sendKeys(internet.emailAddress());
//        selectElements.selectByIndexNumbert(By.id("SurveyRecipientLanguageId-0"), 1);
////        selectElements.selectRandombyElement(qr.languages);
//        submitThisForm();
//        Thread.sleep(5000);
//
//        //click continue if the email is not verified
//        if (driver.findElement(By.id("modalDialogConfirmButton")).isDisplayed()){
//            driver.findElement(By.id("modalDialogConfirmButton")).click();
//        }
//    }
//
//    public void fillRecepientDetailsFormInternal(String internalUserName) throws InterruptedException {
//        driver.findElement(By.id("internalUserRecipient-0")).click();
//        Thread.sleep(2000);
//        selectElements.selectByIndexNumbert(By.id("SelectedSurveyId-0"), 1);
//        selectElements.selectByIndexNumbert(By.id("SelectedUserId-0"), 1);
////        qr.firstName.sendKeys(streetAddress.firstName());
////        qr.lastName.sendKeys(streetAddress.lastName());
////        qr.email.sendKeys(internet.emailAddress());
//        submitThisForm();
//
//        Thread.sleep(5000);
//
//        //click continue if the email is not verified
//        if (driver.findElement(By.id("modalDialogConfirmButton")).isDisplayed()){
//            driver.findElement(By.id("modalDialogConfirmButton")).click();
//        }
//
//
//    }
//
//    public void chooseOrderType(String orderType) throws InterruptedException {
//        wait.waitUntilPresent(diligenceOrderDetailsForm.diligencePageLoaded, );
//
//        switch (orderType) {
//
//            case "CreditSafe":
//                diligenceTabForm.creditSafe.click();
//                break;
//            case "DDIQ":
////                actions.moveToElement(diligenceTabForm.DDIQ).click().perform();
//                diligenceTabForm.DDIQ.click();
//                break;
//            case "Level1":
//                diligenceTabForm.level1.click();
//                break;
//            case "Level1+Smartsource":
//                diligenceTabForm.level1PlusSmartSource.click();
//                break;
//            case "Questionnaire":
//                diligenceTabForm.questionnaire.click();
//                break;
//            case "Questionnaire+DDIQ":
//                diligenceTabForm.questtionnairePLusDDIQ.click();
//                break;
//            case "RedFlag":
//                diligenceTabForm.redFlag.click();
//                break;
//            case "Sanctions":
//                diligenceTabForm.sanctions.click();
//                break;
//            case "ScreenIQ":
//                diligenceTabForm.screenIQ.click();
//                break;
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
