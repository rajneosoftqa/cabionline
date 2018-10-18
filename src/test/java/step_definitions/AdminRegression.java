package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.ScrollintoView;
import helpers.Wait;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.AdminPage;
import pageobjects.CapacityProfilePage;
import pageobjects.CasePage;
import pageobjects.LoginPage;

import java.util.Arrays;
import java.util.List;


public class AdminRegression extends BaseClass {
    private Wait wait = new Wait();
    private LoginPage loginPage = new LoginPage();
    private AdminPage adminPage = new AdminPage();
    private CapacityProfilePage capacityProfilePage = new CapacityProfilePage();
    private ScrollintoView scrollintoView = new ScrollintoView();
    private CasePage casePage = new CasePage(driver);


    @And("^I login to Insight Admin$")
    public void iLoginToInsightAdmin() throws Throwable {
        driver.get("https://insightqaadmin.exiger.com/");
        loginPage.userName.sendKeys("automation@exiger.com");
        loginPage.password.sendKeys("Exiger1!");
        loginPage.loginButton.click();
    }

    @And("^I click on Internal Users tab$")
    public void iClickOnInternalUsersTab() throws Throwable {
        wait.waitAndClick(adminPage.internalUsersDiligenceSkills);
    }

    @And("^I click on add Internal User$")
    public void iClickOnAddInternalUser() throws Throwable {
        wait.waitAndClick(adminPage.addInternalUser);
    }

    @And("^I navigate to add Internal User Page$")
    public void iNavigateToAddInternalUserPage() throws Throwable {
        assertTrue(wait.waitUntilPresent(adminPage.verifyAddinternalUser).isDisplayed());

    }

    @And("^I check Case Creator role is not present in Roles$")
    public void iCheckCaseCreatorRoleIsNotPresentInRoles() throws Throwable {
        assertFalse(driver.getPageSource().contains("Case Creator"));
    }

    @And("^I select the Diligence Skills role$")
    public void iSelectTheDiligenceSkillsRole() throws Throwable {
        System.out.println(!adminPage.checkDiligenceSkillsRole.isSelected());
        if (!adminPage.checkDiligenceSkillsRole.isSelected()) {
            wait.waitAndClick(adminPage.checkDiligenceSkillsRole);
        }
    }

    @And("^I click the submit button$")
    public void iClickTheSubmitButton() throws Throwable {
        wait.waitAndClick(adminPage.updateUserButtonDiligenceSkills);
//        wait.waitAndClick(adminPage.updateUserLinkDiligenceSkills);
//        wait.waitAndClick(adminPage.updateUserButtonDiligenceSkills);
    }

    @Then("^I see Diligence Skills role is checked$")
    public void iSeeDiligenceSkillsRoleIsChecked() throws Throwable {
        assertTrue(adminPage.checkDiligenceSkillsRole.isSelected());
    }

    @And("^I log off from Diligence Admin$")
    public void iLogOffFromDiligenceAdmin() throws Throwable {
        wait.waitAndClick(adminPage.logOffDiligenceAdmin);
    }


    @Then("^I see Diligence Skills role is not checked$")
    public void iSeeDiligenceSkillsRoleIsNotChecked() throws Throwable {
        assertFalse(adminPage.checkDiligenceSkillsRole.isSelected());
    }

    @And("^I see Capacity Profile Tab is not present$")
    public void iSeeCapacityProfileTabIsNotPresent() throws Throwable {
        assertEquals(capacityProfilePage.capacityProfile.size(), 0);

    }

    @And("^I unselect all roles$")
    public void iUnselectAllRoles() throws Throwable {
        for (WebElement checkbox : adminPage.rolesList) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    @And("^I see Diligence Skills role is disabled$")
    public void iSeeDiligenceSkillsRoleIsDisabled() throws Throwable {
        assertFalse(adminPage.checkDiligenceSkillsRole.isEnabled());
    }

    @And("^I select \"([^\"]*)\" role$")
    public void iSelectRole(String arg0) throws Throwable {
        wait.waitAndClick(adminPage.diligenceAdministratorRole);
    }

    @And("^I see Diligence skill role is enabled$")
    public void iSeeDiligenceSkillRoleIsEnabled() throws Throwable {
        assertTrue(adminPage.checkDiligenceSkillsRole.isEnabled());
    }

    @And("^I click on client accounts tab$")
    public void iClickOnClientAccountsTab() throws Throwable {
        wait.waitAndClick(adminPage.clientAccountTab);
    }


    @And("^I enter legal name as \"([^\"]*)\" and click search$")
    public void iEnterLegalNameAsAndClickSearch(String arg0) throws Throwable {
        wait.waitAndSendKeysByElement(capacityProfilePage.legalName, arg0);
        wait.waitAndClick(new CapacityProfilePage().filterButtonDiligenceSkills);
        Thread.sleep(5000);
        assertTrue(capacityProfilePage.userSearchDiligence.isDisplayed());
    }

    @And("^I clicked on details for the searched client$")
    public void iClickedOnDetailsForTheSearchedClient() throws Throwable {
        wait.waitAndClick(capacityProfilePage.detailsLinkFirstUser);
    }

    @And("^I click on Update Account link$")
    public void iClickOnUpdateAccountLink() throws Throwable {
        wait.waitAndClick(capacityProfilePage.updateAccountLink);
        assertTrue(wait.waitUntilPresent(capacityProfilePage.verifyUpdateUserPageDiligenceSkills).isDisplayed());

    }

    @And("^I check ICV - Residency Refresher is available in products$")
    public void iCheckICVResidencyRefresherIsAvailableInProducts() throws Throwable {
        assertTrue(wait.waitUntilPresent(capacityProfilePage.icvResidencyRefresher).isDisplayed());
    }

    @And("^I verify ICV - Residency Refresher is listed between ICV - Residency and Investigative Project$")
    public void iVerifyICVResidencyRefresherIsListedBetweenICVResidencyAndInvestigativeProject() throws Throwable {
        assertEquals(capacityProfilePage.icvResidency.getText(), "ICV - Residency");
        assertEquals(capacityProfilePage.icvResidencyRefresherPath.getText(), "ICV - Residency Refresher");
        assertEquals(capacityProfilePage.investigativeProject.getText(), "Investigative Project");

    }

    @And("^I verify that the client type is Diligence$")
    public void iVerifyThatTheClientTypeIsDiligence() throws Throwable {
        assertTrue(adminPage.accountType.getText().contains("Diligence"));
    }

    @And("^I verify that the client type is Third Party$")
    public void iVerifyThatTheClientTypeIsThirdParty() throws Throwable {
        assertTrue(adminPage.accountType.getText().contains("Third-Party"));
    }

    @When("^I check ICV - Residency Refresher as a product$")
    public void iCheckICVResidencyRefresherAsAProduct() throws Throwable {
        scrollintoView.scrollToView(capacityProfilePage.icvResidencyRefresher);
        Thread.sleep(5000);
        if (!adminPage.icvResidencyRefresherProduct.isSelected())
            wait.waitAndClick(capacityProfilePage.icvResidencyRefresherPath);
        wait.waitAndClick(capacityProfilePage.updateAccount);
    }

    @Then("^I verify Expedite option is not available$")
    public void iVerifyExpediteOptionIsNotAvailable() throws Throwable {
        Thread.sleep(5000);
        assertTrue(adminPage.expediteOption.size() == 0);
    }

    @And("^I check A la Carte Research is available in products$")
    public void iCheckALaCarteResearchIsAvailableInProducts() throws Throwable {
        assertTrue(wait.waitUntilPresent(capacityProfilePage.aLaCarteResearch).isDisplayed());
    }

    @And("^I verify A la Carte Research listed above Asset Tracing$")
    public void iVerifyALaCarteResearchListedAboveAssetTracing() throws Throwable {
        assertEquals(capacityProfilePage.aLaCarteResearchPath.getText(), "A La Carte Research");
        assertEquals(capacityProfilePage.assetTracingPath.getText(), "Asset Tracing");
    }

    @When("^I check A la Carte Research as a product$")
    public void iCheckALaCarteResearchAsAProduct() throws Throwable {
        scrollintoView.scrollToView(capacityProfilePage.aLaCarteResearch);
        Thread.sleep(5000);
        if (!adminPage.aLaCarteResearchProduct.isSelected())
            wait.waitAndClick(capacityProfilePage.aLaCarteResearchPath);
        wait.waitAndClick(capacityProfilePage.updateAccount);
    }

    @And("^I verify all product types are selectable$")
    public void iVerifyAllProductTypesAreSelectable() throws Throwable {
        List <WebElement> element = driver.findElements(By.xpath("/html/body/div[2]/div/div/form/div[43]/div[1]/div/label"));
        List <String>  list = Arrays.asList("A La Carte Research", "Asset Tracing", "CQM Questionnaire", "CQM Questionnaire + DDIQ", "CreditSafe", "DDIQ", "Exiger Express", "ICV - Citizenship", "ICV - Residency", "ICV - Residency Refresher", "Investigative Project", "Investment Advisor Review", "Investment Manager Review", "IPO", "IPO + SmartSource", "Level 1", "Level 1 + SmartSource (™)", "M&A", "M&A + SmartSource", "Questionnaire", "Questionnaire + DDIQ", "Red Flag", "Sanctions", "ScreenIQ");
        System.out.println(element.size());
        if (element.size() > 0) {
            for (WebElement label : element) {
                System.out.println(label.getText());
                System.out.println(list.contains(label.getText()));
                assertTrue(list.contains(label.getText()));
                if(list.contains(label.getText())){
                   assertTrue(label.findElement(By.xpath("//input")).isEnabled());
                }
            }

        }
    }

    @And("^I verify only diligence product types are selectable$")
    public void iVerifyOnlyDiligenceProductTypesAreSelectable() throws Throwable {
        List <WebElement> element = driver.findElements(By.xpath("/html/body/div[2]/div/div/form/div[42]/div[1]/div/label"));
        List <String>  list = Arrays.asList("CQM Questionnaire", "CQM Questionnaire + DDIQ", "CreditSafe", "Questionnaire", "Questionnaire + DDIQ", "Sanctions", "ScreenIQ");
        System.out.println(element.size());
        int i = 0;
        if (element.size() > 0) {
            for (WebElement label : element) {
                //System.out.println(list.contains(label.getText()));
                if(list.contains(label.getText())){
//                    System.out.println(label.getAttribute("innerHTML"));
//                    System.out.println(label.getText());
//                    System.out.println(label.findElement(By.xpath("//input")).getAttribute("disabled"));
//                    System.out.println(label.findElement(By.xpath("//input")).isEnabled());
//                    Thread.sleep(10000);
                    assertTrue(label.getAttribute("innerHTML").contains("disabled"));
                }
                i++;
            }

        }
        System.out.println(i);
    }

    @And("^I verify Enable Advanced Search checkbox is available$")
    public void iVerifyEnableAdvancedSearchCheckboxIsAvailable() throws Throwable {
       assertTrue(adminPage.enableAdvancedSearchCheckbox.isDisplayed());
    }

    @And("^I check Enable Advanced Search checkbox and save$")
    public void iCheckEnableAdvancedSearchCheckboxAndSave() throws Throwable {
       wait.waitAndClick(adminPage.enableAdvancedSearchCheckbox);
        wait.waitAndClick(capacityProfilePage.updateAccount);
        Thread.sleep(5000);
    }

    @And("^I uncheck Enable Advanced Search checkbox and save$")
    public void iUncheckEnableAdvancedSearchCheckboxAndSave() throws Throwable {
        wait.waitAndClick(adminPage.enableAdvancedSearchCheckbox);
        wait.waitAndClick(capacityProfilePage.updateAccount);
        Thread.sleep(5000);
        wait.waitAndClick(adminPage.logOffDiligenceAdmin);
    }

    @And("^I verify advanced search tab is not visible$")
    public void iVerifyAdvancedSearchTabIsNotVisible() throws Throwable {
        assertFalse(casePage.advancedSearchList.size()<0);
    }
}
