package formSteps;

import com.github.javafaker.Faker;
import forms.QuestionnaireForm;
import helpers.SelectElements;
import org.openqa.selenium.By;
import step_definitions.BaseClass;

public class FillUpQuestions extends BaseClass {
    private Faker faker = new Faker();
    private SelectElements selectElements = new SelectElements();

    private QuestionnaireForm questionnaireForm = new QuestionnaireForm(driver);

    public void fillQuestionnaireDetails() throws InterruptedException {
        questionnaireForm.address1.sendKeys(faker.address().streetAddress());
        questionnaireForm.address2.sendKeys(faker.address().streetName());
        questionnaireForm.city.sendKeys(faker.address().city());
        questionnaireForm.state.sendKeys(faker.address().state());
        questionnaireForm.zipcode.sendKeys(faker.address().zipCode());
        selectElements.selectByIndexNumbert(By.id("QR~QID97"), 0);
        questionnaireForm.nameOfThePersonCompleting.sendKeys(faker.name().fullName());
        questionnaireForm.titleOfPersonCompleting.sendKeys(faker.name().title());
        questionnaireForm.email.sendKeys(faker.internet().emailAddress());
        questionnaireForm.alternateEmail.sendKeys(faker.internet().emailAddress());
        questionnaireForm.oneTwoYearsinBusiness.click();
        questionnaireForm.annualIncome.click();
        questionnaireForm.politicalExposedNO.click();
        questionnaireForm.govInvolvedNO.click();
        questionnaireForm.publicCompanyYES.click();
        questionnaireForm.vendorBackgroundCheck.click();
        questionnaireForm.howManyIndividualInvolveExiger1.click();
        questionnaireForm.continueButton.click();
        Thread.sleep(2000);
    }
}
