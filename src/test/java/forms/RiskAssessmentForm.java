package forms;

import helpers.SelectElements;
import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import step_definitions.BaseClass;

/**
 * Created by tdatta on 6/28/17.
 */
public class RiskAssessmentForm extends BaseClass{
    private SelectElements selectElements = new SelectElements();
    private Wait wait = new Wait();
    
    @FindBy(id = "nextStepButton")
    public WebElement continueButton;

    @FindBy (id = "previousStepButton")
    public WebElement backButton;

    public RiskAssessmentForm(WebDriver driver){
        super();
        PageFactory.initElements(driver, this);
    }

    public void chooseCountry(){
        wait.waitUntilPresent(By.id("SelectedClientAccountRiskFactors_0__ValueId"));
        selectElements.selectRandomOption(By.id("SelectedClientAccountRiskFactors_0__ValueId"));
    }
    public void chooseIndustry(){
        selectElements.selectRandomOption(By.id("SelectedClientAccountRiskFactors_1__ValueId"));
    }
    public void chosseYearofBusiness(String yearOfBusiness){
        new Select(driver.findElement(By.id("SelectedClientAccountRiskFactors_2__ValueId")))
                .selectByVisibleText(yearOfBusiness);
    }
    public void chooseCompanySize(String companySize){
        new Select(driver.findElement(By.id("SelectedClientAccountRiskFactors_3__ValueId")))
                .selectByVisibleText(companySize);
    }
    public void chooseAssociatedWithPEP(String associatedPEP){
        new Select(driver.findElement(By.id("SelectedClientAccountRiskFactors_4__ValueId")))
                .selectByVisibleText(associatedPEP);
    }
    public void chooseRelationshipType(String relationshipType){
        new Select(driver.findElement(By.id("SelectedClientAccountRiskFactors_5__ValueId")))
                .selectByVisibleText(relationshipType);
    }
    public void chooseSizeofRelationship(String sizeOfRelationship){
        new Select(driver.findElement(By.id("SelectedClientAccountRiskFactors_6__ValueId")))
                .selectByVisibleText(sizeOfRelationship);
    }
    public void chooseofCriticalityOfRelatioship(String criticalityRelationship){
        new Select(driver.findElement(By.id("SelectedClientAccountRiskFactors_7__ValueId")))
                .selectByVisibleText(criticalityRelationship);
    }
    public void chooseDDIQScore(String DDIQScore){
        new Select(driver.findElement(By.id("SelectedClientAccountRiskFactors_8__ValueId")))
                .selectByVisibleText(DDIQScore);
    }
    public void chooseDegreeofGovInvolvement(String govInvolvement){
        new Select(driver.findElement(By.id("SelectedClientAccountRiskFactors_9__ValueId")))
                .selectByVisibleText(govInvolvement);
    }
    public void choosePublicCompany(String publicCompany){
        new Select(driver.findElement(By.id("SelectedClientAccountRiskFactors_10__ValueId")))
                .selectByVisibleText(publicCompany);
    }
    public void chooseNumberOfEmployees(String numberofEmployees){
        new Select(driver.findElement(By.id("SelectedClientAccountRiskFactors_11__ValueId")))
                .selectByVisibleText(numberofEmployees);
    }
}
