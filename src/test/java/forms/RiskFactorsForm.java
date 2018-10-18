package forms;

import org.openqa.selenium.By;

/**
 * Created by tdatta on 6/2/17.
 */
public class RiskFactorsForm {

    //Risk Factor

    private final By showAllRiskFactors = By.className("fade-gradient");
    private final By companyNameRiskFactor = By.xpath("//*[@id=\"selectedClientAccountRiskFactors\"]/div[1]/select");
    private final By industryRiskFactor = By.xpath("//*[@id=\"selectedClientAccountRiskFactors\"]/div[2]/select");
    private final By yearsInBusiness = By.xpath("//*[@id=\"selectedClientAccountRiskFactors\"]/div[3]/select");
    private final By companySize = By.xpath("//*[@id=\"selectedClientAccountRiskFactors\"]/div[4]/select");
    private final By associatedWithPEP = By.xpath("//*[@id=\"selectedClientAccountRiskFactors\"]/div[5]/select");
    private final By relationshipType = By.xpath("//*[@id=\"selectedClientAccountRiskFactors\"]/div[6]/select");
    private final By sizeOfRelationShip = By.xpath("//*[@id=\"selectedClientAccountRiskFactors\"]/div[7]/select");
    private final By criticalityOfRelationShip = By.xpath("//*[@id=\"selectedClientAccountRiskFactors\"]/div[8]/select");
    private final By DDIQScore = By.xpath("//*[@id=\"selectedClientAccountRiskFactors\"]/div[9]/select");
    private final By degreeOfGovInvolvement = By.xpath("//*[@id=\"selectedClientAccountRiskFactors\"]/div[10]/select");
    private final By publicCompany = By.xpath("//*[@id=\"selectedClientAccountRiskFactors\"]/div[11]/select");
    private final By numOfEmployees = By.xpath("//*[@id=\"selectedClientAccountRiskFactors\"]/div[12]/select");
}
