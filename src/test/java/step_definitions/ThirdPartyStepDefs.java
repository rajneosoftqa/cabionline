//package step_definitions;
//
//import com.github.javafaker.Faker;
//import com.github.javafaker.Name;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import formSteps.CreateThirdParty;
//import forms.DiligenceTabForm;
//import forms.RiskAssessmentForm;
//import forms.ThirdPartyCompanyDetailsForm;
//import forms.UpdateAffiliateForm;
//import helpers.*;
//import org.hamcrest.CoreMatchers;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
//import pageobjects.*;
//
//import java.util.List;
//
//import static org.junit.Assert.assertThat;
//
//
///**
// * Created by tdatta on 5/9/17.
// */
//public class ThirdPartyStepDefs extends BaseClass {
//
//    private Wait wait = new Wait();
//    private HomePage homePage = new HomePage(driver);
//    private CreateThirdParty createThirdParty = new CreateThirdParty(driver);
//    private ThirdPartiesPage thirdPartiesPage = new ThirdPartiesPage(driver);
//    private ThirdPartyDetailsEditPage thirdPartyDetailsEditPage = new ThirdPartyDetailsEditPage(driver);
//    private PopupWindow popupWindow = new PopupWindow();
//    private WebElementExtensions webElementExtensions = new WebElementExtensions();
//    private String thirdPartyName;
//    private RegressionSteps regressionSteps = new RegressionSteps();
//    private TableElements tableElements = new TableElements();
//    private ScrollintoView scrollintoView = new ScrollintoView();
//    private SelectElements selectElements = new SelectElements();
//    private ThirdPartySummaryPage thirdPartySummaryPage = new ThirdPartySummaryPage(driver);
//    private Faker faker = new Faker();
//    private UpdateAffiliateForm updateAffiliateForm = new UpdateAffiliateForm(driver);
//    private Name name = faker.name();
//    private String fullName = name.fullName();
//    private ReviewThirdPartiesTabs reviewThirdPartiesTabs = new ReviewThirdPartiesTabs(driver);
//    private ThirdPartyCompanyDetailsForm thirdPartyCompanyDetailsForm = new ThirdPartyCompanyDetailsForm(driver);
//    private DiligenceTabForm diligenceTabForm = new DiligenceTabForm(driver);
//    private RiskAssessmentForm riskAssessmentForm = new RiskAssessmentForm(driver);
//
//
//
//    @And("^I navigate to third party creation page$")
//    public void iNavigateToThirdPartyCreationPage() throws Throwable {
//        homePage.navigateToCreateNewThirdPartyPage();
//    }
//
//    @And("^I fill up the details of a third party$")
//    public void iFillUpTheFormToCreateACompany() throws Throwable {
//
//        thirdPartyName = createThirdParty.fillThirdPartyDetails();
//        System.out.println("The third party name is " + thirdPartyName);
//        Thread.sleep(2000);
//        createThirdParty.submitThisForm();
//        Thread.sleep(3000);
//        //if third party name exists click continue
//        popupWindow.ifPopupClickContinue();
//
//    }
//
//    @And("^I fill up diligence order details$")
//    public void iFillUpDiligenceOrderDetailsForAOrder() throws Throwable {
//        createThirdParty.fillDiligenceOrderDetails();
//        createThirdParty.submitThisForm();
//        Thread.sleep(2000);
//        //click continue if pop up window opens
//        if (driver.findElement(By.id("modalDialog")).isDisplayed()) {
//            driver.switchTo().activeElement();
//            driver.findElement(By.id("modalDialogConfirmButton")).click();
//            Thread.sleep(2000);
//        } else Thread.sleep(2000);
//    }
//
//    @And("^I fill out the affiliate company details$")
//    public void iFillOutTheAffiliateCompanyDetails() throws Throwable {
//        createThirdParty.fillAffiliateCompanyDetails();
//        createThirdParty.submitThisForm();
//    }
//
//    @And("^I review and confirm the third party$")
//    public void iReviewAndConfirmTheThirdParty() throws Throwable {
//        createThirdParty.reviewAndConfirm();
//    }
//
//    @And("^I filter third parties by \"([^\"]*)\" status$")
//    public void iFilterThirdPartiesByStatus(String filter) throws Throwable {
//        thirdPartiesPage.chooseRelationShipStatus(filter);
//    }
//
//    @And("^I review the table as it updates by \"([^\"]*)\" status")
//    public void iReviewTheTableAsItUpdatesByStatus(String relatioinship) throws Throwable {
//        String status = wait.waitAndGetText(driver, By.cssSelector("td[title='Accepted']"));
//        assertThat(status, CoreMatchers.equalTo(relatioinship));
//    }
//
//    @And("^I filter third parties by \"([^\"]*)\" insight score$")
//    public void iFilterThirdPartiesByInsightScore(String insightScore) throws Throwable {
//        thirdPartiesPage.chooseInsightScore(insightScore);
//    }
//
//    @And("^I review the table as it updates by \"([^\"]*)\" insightscore$")
//    public void iReviewTheTableAsItUpdatesByInsightscore(String insightscore) throws Throwable {
//        wait.waitUntilPresent(By.cssSelector("td[title='L']"));
//    }
//
//    @And("^I filter third parties by available third party name$") // filtering by third party name
//    public String iFilterThirdPartiesByName() throws Throwable {
//        String thirdParty = wait.waitAndGetText(driver, By.cssSelector("td[aria-describedby='jqGrid_E']"));
//        thirdPartiesPage.filterTableByThirdPartyName(thirdParty);
//        return thirdParty;
//    }
//
//    @And("^I review the table as it updates by searched name$")
//    public void iReviewTheTableAsItUpdatesByName() throws Throwable {
//        String thirdName = iFilterThirdPartiesByName();
//        String status = wait.waitAndGetText(driver, By.cssSelector("td[aria-describedby='jqGrid_E']"));
//        assertThat(status, CoreMatchers.equalTo(thirdName));
//    }
//
//    @Then("^The geography, insight score, relationship status, Last Due Diligence Type are visible$")
//    public void theGeographyInsightScoreRelationshipStatusLastDueDiligenceTypeAreVisible() throws Throwable {
//        wait.waitUntilPresent(thirdPartiesPage.countryMap, );
//    }
//
//    @And("^I click on any third parties from the list$")
//    public void iClickOnAFromTheList() throws Throwable {
//        wait.waitUntilPresent(By.id("gview_jqGrid"));
//        Thread.sleep(5000);
//        List<WebElement> allProducts = driver.findElements(By.id("gview_jqGrid"));
//        Thread.sleep(200);
//        for (WebElement tableItem : allProducts) {
//            try {
//                Actions actions = new Actions(driver);
//                Thread.sleep(200);
//                actions.moveToElement(tableItem).click().perform();
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//            Thread.sleep(10000);
//        }
//    }
//
//    @And("^I ensure user can edit the this third-party details$")
//    public void iEnsureUserCanEditTheThirdPartyDetails() throws Throwable {
//        wait.waitUntilPresent(thirdPartyDetailsEditPage.pageHeader, );
//        thirdPartyDetailsEditPage.editThirdPartyDetailsButton.click();
//        thirdPartyDetailsEditPage.editCompanyName.isEnabled();
//        thirdPartyDetailsEditPage.addAffiliate.isDisplayed();
//    }
//
//    @And("^The third party confirmation page shows up$")
//    public void theThirdPartyConfirmationPageShowsUp() throws Throwable {
//        Thread.sleep(3000);
//        wait.waitUntilPresent
//                (By.xpath("//*[@id=\"monitoringDetailsLoadingContainer\"]/div/div/label"));
//        System.out.println("Third Party Creation was successful");
//    }
//
//    @And("^I fill out the risk assessment form$")
//    public void iFillOutTheRiskAssessmentForm() throws Throwable {
//        Thread.sleep(2000);
//        scrollintoView.scrollDown();
//        driver.findElement(By.id("nextStepButton")).click();
////        scrollintoView.scrollToViewAndClick(driver.findElement(By.id("nextStepButton")));
////        WebElement element = driver.findElement(By.id("nextStepButton"));
////        scrollintoView.scrollToView(element);
////        scrollintoView.scrollDown();
////        element.click();
//    }
//
//    @And("^I click on override$")
//    public void iClickOnOverride() throws Throwable {
//
//        wait.waitAndClickOnElement(driver, reviewThirdPartiesTabs.riskModelOverride);
//        WebElement element = webElementExtensions.findElementByDataBind
//                ("click", "ViewInsightScoreOverride");
//        element.click();
//    }
//
//    @And("^In the pop up window I change the risk to \"([^\"]*)\"$")
//    public void inThePopUpWindowIChangeTheRiskTo(String arg0) throws Throwable {
//        popupWindow.getTheHandleOf();
//        wait.waitUntilGridSpinnersNotPresent();
//        wait.waitUntilPresent(By.id(("overrideInsightScore")));
//        driver.findElement(By.id("modalContent")).findElement(By.xpath
//                ("//*[@id=\"overrideInsightScore\"]/div[2]/div[3]/label[4]")).click();
//        driver.findElement(By.id("modalDialogConfirmButton")).click();
//    }
//
//    @Then("^The the risk model should read \"([^\"]*)\"$")
//    public void theTheRiskModelShouldRead(String arg0) throws Throwable {
//        String actual = wait.waitAndGetText(driver, By.xpath
//                ("//*[@id=\"thirdPartyRiskFactorsTab\"]/div[1]/div[2]/div[3]/div[1]"));
//        Assert.assertEquals(arg0, actual);
//    }
//
//    @And("^I check the third party is queued in the third party tab$")
//    public void iCheckTheThirdPartyIsQueuedInTheThirdPartyTab() throws Throwable {
//        thirdPartiesPage.filterTableByThirdPartyName(thirdPartyName);
//        String text = wait.waitAndGetText(driver, By.cssSelector("td[aria-describedby='jqGrid_E']"));
//        System.out.println("This 3p name is " + text);
//        Assert.assertEquals(thirdPartyName, text);
//    }
//
//    @And("^I click on that newly created third-party$")
//    public void iClickOnThatNewlyCreatedThirdParty() throws Throwable {
//        driver.findElement(By.cssSelector
//                (String.format("td[title='%s']", thirdPartyName))).click();
//    }
//
//    @And("^I click on a third party that has \"([^\"]*)\" relationship Status$")
//    public void iLickOnAThirdPartyThatHasRelationshipStatus(String arg0) throws Throwable {
//        tableElements.clickAStringInTable(arg0);
//    }
//
//    @And("^I change the relationship status to \"([^\"]*)\"$")
//    public void iChangeTheRelationshipStatusTo(String arg0) throws Throwable {
//        Thread.sleep(2000);
//        driver.findElement(By.id("approvalActionsDropdown")).click();
//        driver.findElement(By.cssSelector(String.format("a[data-bind*=%s]", arg0))).click();
//    }
//
//    @And("^I confirm the pop up message$")
//    public void iConfirmThePopUpMessage() throws Throwable {
//        Thread.sleep(4000);
//        popupWindow.ifPopupClickContinue();
//        wait.waitUntilNotPresent(By.id("modalDialogConfirmButton"));
////        popupWindow.checkIfPopupWindowClosed();
//    }
//
//    @And("^I choose order type as \"([^\"]*)\"$") //only for Questionnaire and Questionnaire + DDIQ
//    public void iChooseOrderTypeAs() throws Throwable {
//        createThirdParty.fillDiligenceOrderDetails();
//        //Chooses the questionnaire
//        new Select(driver.findElement(By.id("SelectedSurveyId"))).selectByIndex(1);
//
//    }
//
//    @And("^I fill the recipient order details for an internal \"([^\"]*)\"$")
//    public void iFillTheRecipientOrderDetailsFor(String arg0) throws Throwable {
//        createThirdParty.fillRecepientDetailsFormInternal(arg0);
//    }
//
//    @And("^The status of the order should be \"([^\"]*)\"$")
//    public void theStatusOfTheOrderShouldBe(String arg0) throws Throwable {
//
//        String status = wait.waitAndGetText(driver, By.className("order-status-pre"));
//
//        while (true) {
//            if (!arg0.equals(status)) {
//                driver.navigate().refresh();
//            } else if (status.equals(arg0)) {
//                Assert.assertEquals(arg0, status);
//            }
//            break;
//        }
//    }
//
//    @And("^I can edit the recipient details$")
//    public void iCanEditTheRecipientOrderDetailsAndSaveTheChange() throws Throwable {
//        scrollintoView.scrollDown();
//        wait.waitAndClick(driver, By.id("editRecipientButton"));
//    }
//
//    @And("^I add a new available recipient$")
//    public void iAddANewRecipientAs() throws Throwable {
//        popupWindow.moveToNewWindow();
//        thirdPartyDetailsEditPage.addAndDeleteRecipient();
//        popupWindow.closeNewWindow();
//    }
//
//    @And("^I choose an available language and save the changes$")
//    public void iChooseAnAvailableLanguage() throws Throwable {
//        selectElements.selectRandomOption(By.id("LanguageId"));
//        thirdPartyDetailsEditPage.saveNewRecipientInfo.click();
//    }
//
//    @And("^I see affiliate subject card available$")
//    public void iSeeAffiliateSubjectCardAvailable() throws Throwable {
//        Thread.sleep(4000);
//        wait.waitUntilGridSpinnersNotPresent();
//        scrollintoView.scrollToView(thirdPartyDetailsEditPage.subjectCard);
//        wait.waitUntilPresent(By.className("subject-card"));
//        thirdPartySummaryPage.affiliateSubjectCard.isDisplayed();
//    }
//
//    @And("^I can edit the affiliate details$")
//    public void iCanEditTheAffiliateDetails() throws Throwable {
//        wait.waitAndClickOnElement(driver, thirdPartySummaryPage.editPencilButton);
//    }
//
//    @And("^I choose a recipient from the list$")
//    public void iChooseARecepientFromTheList() throws Throwable {
//        driver.findElement(By.id("checkbox1629")).click();
//    }
//
//    @And("^I click on resend$")
//    public void iClickOnResend() throws Throwable {
//        driver.findElement(By.id("addRecipient")).click();
//    }
//
//    @And("^I click on edit affiliate pencil button$")
//    public void iClickOnEditAffiliatePencilButton() throws Throwable {
//        scrollintoView.scrollToView(thirdPartyDetailsEditPage.subjectCard);
//        scrollintoView.scrollToMiddle();
//        driver.findElement(By.xpath
//                (".//*[@id='affiliates']/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/a/span")).click();
//        wait.waitUntilPresent(By.id("Name"));
//    }
//
//    @And("^I see a pop up window$")
//    public void iSeeAPopUpWindow() throws Throwable {
//        popupWindow.moveToNewFrame();
//    }
//
//    @And("^I edit the name of the affiliate and see the change")
//    public void iEditTheNameOfTheAffiliateAndSave() throws Throwable {
//        String actual = popupWindow.editAnAffiliate();
//        Thread.sleep(3000);
//        String expected = webElementExtensions.findElementByDataBind("text", "Name").getText();
//        Assert.assertEquals(expected, actual);
//    }
//
//    @And("^I navigate to the third party that just got created$")
//    public void iNavigateToTheThirdPartyThatJustGotCreated() throws Throwable {
//        webElementExtensions.findByCSS("td", "title", thirdPartyName).click();
//    }
//
//    @And("^I see an approval banner$")
//    public void iSeeAnApprovalBanner() throws Throwable {
//        wait.waitUntilPresent(By.id("approvals-banner"));
//    }
//
//    @And("^I click on \"([^\"]*)\" to approve or reject the third party$")
//    public void iClickOnToApproveOrRejectTheThirdParty(String arg0) throws Throwable {
//        if (arg0.equalsIgnoreCase("Approve")) {
//            arg0 = String.valueOf(2);
//        } else if (arg0.equalsIgnoreCase("Reject")) {
//            arg0 = String.valueOf(1);
//        }
//        driver.findElement(By.xpath(String.format
//                ("//*[@id=\"approvals-banner\"]/div[%s]", arg0))).click();
//    }
//
//    @And("^I write a note and confirm the review$")
//    public void iWriteANoteAndConfirmTheReview() throws Throwable {
//        wait.waitUntilPresent(By.id("setApprovalTaskStatus"));
//        webElementExtensions.findElementByDataBind("textInput", "Notes").
//                sendKeys("Automation of 3p review verified");
//        driver.findElement(By.id("modalDialogConfirmButton")).click();
//    }
//
//    @And("^The approval banner should be closed$")
//    public void theApprovalBannerShouldBeClosed() throws Throwable {
//        wait.waitUntilNotPresent(By.id("approvals-banner"));
//
//    }
//
//
//    @And("^I change the master affiliate name$")
//    public void iChangeTheMasterAffiliateNameTo() throws Throwable {
//        wait.waitUntilPresent(updateAffiliateForm.name, );
//        webElementExtensions.clearAndSendKeys(updateAffiliateForm.name, fullName);
//        updateAffiliateForm.saveAffiliates.click();
//        Thread.sleep(5000);
//    }
//
//    @And("^The change shows in the third-party summary$")
//    public void theChangeShowsInTheThirdPartySummary() throws Throwable {
//        scrollintoView.scrollUp();
//        WebElement element = driver.findElement(By.cssSelector("#coreDetailsEditForm > div:nth-child(5) > div:nth-child(1) > p:nth-child(3)"));
//        String thirdPartCOmpanyName = element.getText();
//        Assert.assertEquals(fullName, thirdPartCOmpanyName);
//    }
//
//    @And("^I change the third-party name to \"([^\"]*)\"$")
//    public void iChangeTheThirdPartyNameTo(String arg0) throws Throwable {
//        thirdPartyDetailsEditPage.editThirdPartyDetailsButton.click();
//        driver.findElement(By.id("CompanyName")).clear();
//        driver.findElement(By.id("CompanyName")).sendKeys(arg0);
//
////        webElementExtensions.clearAndSendKeys(thirdPartyDetailsEditPage.editCompanyName, arg0);
//        System.out.println("Wait here after creating the name");
//        Thread.sleep(5000);
//    }
//
//    @And("^I see master affiliate name changed to \"([^\"]*)\"$")
//    public void iSeeMasterAffiliateNameChangedTo(String arg0) throws Throwable {
//        scrollintoView.scrollToView(thirdPartyDetailsEditPage.subjectCard);
//        String affliateActualName = webElementExtensions.
//                findElementByDataBind("text", "Name").getText();
//        Assert.assertEquals(arg0, affliateActualName);
//    }
//
//    @And("^I edit master affiliate$")
//    public void iEditMasterAffiliate() throws Throwable {
//        Thread.sleep(5000);
//        scrollintoView.scrollToView(thirdPartyDetailsEditPage.subjectCard);
//        wait.waitAndClick(driver, By.cssSelector(".col-sm-2 > a:nth-child(1) > span:nth-child(1)"));
//        Thread.sleep(4000);
//    }
//
//    @And("^I save the change made to third party$")
//    public void iSaveTheChangeMadeToThirdParty() throws Throwable {
//        System.out.println("Wait here to save the details");
////        thirdPartyDetailsEditPage.editDetailsSaveButton.click();
//        WebElement element = driver.findElement(By.id("editCoreDetailsActionLinks")).
//                findElement(By.id("editCoreDetailsActionLink"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).click().perform();
////        driver.findElement(By.xpath(".//*[@id='editCoreDetailsActionLink']")).click();
//        Thread.sleep(5000);
//    }
//
//    @And("^I click on initiate diligence$")
//    public void iClickOnInitiateDiligence() throws Throwable {
//        wait.waitAndClick(driver, By.xpath(".//*[@id='headerActionButtons']/ul/li[2]/button"));
//        Thread.sleep(4000);
//    }
//
//    @And("^I continue next steps until the diligence tab$")
//    public void iContinueNextStepsUntilTheDiligenceTab() throws Throwable {
//        wait.waitUntilPresent(thirdPartyCompanyDetailsForm.companyName, );
//        createThirdParty.submitThisForm();
//        createThirdParty.submitThisForm();
//    }
//
//    @Then("^I should see the tiles that represents diligence products$")
//    public void iShouldSeeTheTilesThatRepresentsDiligenceProducts() throws Throwable {
//        driver.findElement(By.className("product-types-container")).isDisplayed();
//    }
//
//    @Then("^I should be on the diligence tab$")
//    public void iShouldBeOnTheDiligenceTab() throws Throwable {
//        wait.waitUntilPresent(By.className("perform-diligence-container"));
//    }
//
//    @Then("^I should see third party type selection panel$")
//    public void iShouldSeeThirdPartyTypeSelectionPanel() throws Throwable {
//        wait.waitUntilPresent(By.id("thirdPartyDetailsForm"));
//    }
//
//    @And("^I choose a third-party type \"([^\"]*)\"$")
//    public void iChooseAThirdPartyType(String arg0) throws Throwable {
//        wait.waitAndClick(driver, By.xpath(".//*[@id='thirdPartyDetailsForm']/div[2]/div/div[1]/label/span/div"));
//    }
//
//    @And("^I see a cancel option in the bottom of the tiles that are selected$")
//    public void iSeeACancelOptionInTheBottomOfTheTilesThatAreSelected() throws Throwable {
//        wait.waitAndClick(driver, By.id("product-type-3"));
//        driver.findElement(By.className("product-type-cancel")).isDisplayed();
//
//    }
//
//    @And("^The cancel option deselect the tile$")
//    public void theCancelOptionDeselectTheTile() throws Throwable {
//        driver.findElement(By.xpath(".//*[@id='thirdPartyDiligenceForm']/div[1]/div[2]/div[2]/div[3]/div[2]/span")).click();
//        wait.waitUntilNotPresent(By.className("selected"));
//    }
//
//    @And("^I add a refresh a event$")
//    public void iAddARefreshAEvent() throws Throwable {
//        Thread.sleep(5000);
//        scrollintoView.scrollDown();
//        wait.waitAndClick(driver, By.id("editRefreshEventActionLinks"));
//    }
//
//    @And("^A new dialog box opens up$")
//    public void aNewDialogBoxOpensUp() throws Throwable {
//        wait.waitAndSwitchToNewWindow(driver, By.id("modalDialog"));
//    }
//
//    @And("^I choose a next refresh activity as \"([^\"]*)\"$")
//    public void iChooseANextRefreshActivityAs(String arg0) throws Throwable {
//        selectElements.selectByVisibleText(By.id("NextDueDiligenceActivityId"), arg0);
//    }
//
//    @And("^I choose a next run date \"([^\"]*)\"$")
//    public void iChooseANextRunDate(String date) throws Throwable {
//        driver.findElement(By.id("nextrundate")).sendKeys(String.valueOf(date));
//    }
//
//    @And("^I choose a Refresh Frequency as \"([^\"]*)\"$")
//    public void iChooseARefreshFrequencyAs(String arg0) throws Throwable {
//        selectElements.selectByVisibleText(By.id("FrequencyId"), arg0);
//    }
//
//    @And("^I save the form$")
//    public void iSaveTheForm() throws Throwable {
//        driver.findElement(By.id("modalDialogConfirmButton")).click();
//    }
//
//    @And("^I see the refresh event is shown under REFRESH option$")
//    public void iSeeTheRefreshEventIsShownUnderREFRESHOption() throws Throwable {
//        wait.waitUntilPresent(By.id("refreshEventOverviewContainer"));
//    }
//
//    @And("^I see options for edit and delete a refresh event$")
//    public void iSeeOptionsForEditAndDeleteARefreshEvent() throws Throwable {
//        wait.waitUntilPresent(By.cssSelector(".button-capital"));
//    }
//
//    @Then("^I should be able to choose multiple product type$")
//    public void iShouldBeAbleToChooseMultipleProductType() throws Throwable {
//        wait.waitUntilPresent(diligenceTabForm.creditSafe, );
//        diligenceTabForm.creditSafe.click();
//        diligenceTabForm.DDIQ.click();
//
//    }
//
//    @When("^I click on \"([^\"]*)\" table elements$")
//    public void iClickOnTableElements(String arg0) throws Throwable {
//        wait.waitAndClick(driver, By.linkText(arg0));
//    }
//
//    @Then("^A new tab opens up for this \"([^\"]*)\" element$")
//    public void aNewTabOpensUpForThisElement(String arg0) throws Throwable {
//        wait.waitAndSwitchToNewTab();
//
//    }
//
//    @And("^I get the count of Due diligence completed from the dashboard$")
//    public void iGetTheCountOfDueDiligenceCompletedFromTheDashboard() throws Throwable {
//        wait.waitAndClick(driver, By.className("c3-arc-Due-Diligence-Completed"));
//        Thread.sleep(4000);
//        String countOfDiligence = driver.findElement
//                (By.cssSelector(".ui-paging-info")).getText();
//        System.out.println("Count of diligence compeleted " + countOfDiligence);
//    }
//
//    @And("^I choose an available client$")
//    public void iChooseAClientAccount() throws Throwable {
//        wait.waitUntilPresent(By.id("ClientAccountId"));
//        selectElements.selectByIndexNumbert(By.id("ClientAccountId"), 0);
//    }
//
//    @And("^I choose a product type \"([^\"]*)\"$")
//    public void iChooseAProductType(String arg0) throws Throwable {
//        scrollintoView.scrollUp();
//        createThirdParty.chooseOrderType(arg0);
//    }
//
//    @And("^I fill out recipient details$")
//    public void iFillOutRecepientDetails() throws Throwable {
//        createThirdParty.fillRecepientDetailsFormExternal();
//    }
//
//    @And("^I move to new window$")
//    public void iMoveToNewWindow() throws Throwable {
//        popupWindow.moveToNewWindow();
//    }
//
//    @And("^I choose \"([^\"]*)\" for country$")
//    public void iChooseForCountry(String arg0) throws Throwable {
//        selectElements.selectByVisibleText(By.id("CountryId"), arg0);
//    }
//
//    @And("^I type \"([^\"]*)\" in the name field for available thirdparty suggestion$")
//    public void iTypeInTheNameFieldForAvailablePSuggestion(String arg0) throws Throwable {
//        driver.findElement(By.id("CompanyName")).sendKeys(arg0);
//    }
//
//    @And("^I click on search for third party bar$")
//    public void iClickOnSearchForThirdPartyBar() throws Throwable {
//        driver.findElement(By.id("identityVerificationSearch")).click();
//    }
//
//    @And("^I choose the third party from the list$")
//    public void iChooseTheThirdPartyFromTheList() throws Throwable {
//        wait.waitAndClick(driver, By.xpath(".//*[@id='resultsListPanel']/div[2]/div/i"));
//    }
//
//    @And("^I click on import third party data bar$")
//    public void iClickOnImportThirdPartyDataBar() throws Throwable {
//        scrollintoView.scrollToViewAndClick(driver.findElement(By.xpath(".//*[@id='identityVerification']/div/button")));
//    }
//
//    @And("^I confirm the data to be imported$")
//    public void iConfirmTheDataToBeImported() throws Throwable {
//        Thread.sleep(3000);
//        popupWindow.ifPopupClickContinue();
//    }
//
//    @And("^I click on continue button for the next page$")
//    public void iClickOnContinueButtonForTheNextPage() throws Throwable {
//        scrollintoView.scrollToViewAndClick(driver.findElement(By.id("nextStepButton")));
//    }
//
//    @And("^I insert an order name as \"([^\"]*)\"$")
//    public void iInsertAnOrderNameAs(String arg0) throws Throwable {
//        driver.findElement(By.id("OrderName-0")).sendKeys(arg0);
//    }
//
//    @And("^I see a report available msg shows up$")
//    public void iSeeAReportAvailableMsgShowsUp() throws Throwable {
//        String msg = wait.waitAndGetText(driver, By.id("creditReportAvailability"));
//        if (msg.contains("Report Available")) {
//            System.out.println("Report is available");
//        }
//        System.out.println("Report is NOT available");
//    }
//
//    @Then("^I should be able to proceed without selecting diligence order$")
//    public void iShouldBeAbleToProceedWithoutSelectingDiligenceOrder() throws Throwable {
//        Thread.sleep(2000);
//        scrollintoView.scrollToViewAndClick(driver.findElement(By.id("nextStepButton")));
//    }
//
//    @And("^Third party details confirmation page shows up$")
//    public void thirdPartyDetailsConfirmationPageShowsUp() throws Throwable {
//        wait.waitUntilPresent(By.className("col-sm-10"));
//    }
//
//    @And("^I click on ShowHide button to .*$")
//    public void iClickOnShowHideButtonToHideTheSideBar() throws Throwable {
//        thirdPartiesPage.showHideButton.click();
//    }
//
//    @And("^I see side bar is not shown$")
//    public void iSeeSideBarIsNotShown() throws Throwable {
//        wait.waitUntilNotPresent(By.xpath(".//*[@id='aggregatecontainer']/div[2]/h3"));
//    }
//
//    @And("^I see side bar is displayed$")
//    public void iSeeSideBarIsDisplayed() throws Throwable {
//        wait.waitUntilPresent(By.xpath(".//*[@id='aggregatecontainer']/div[2]/h3"));
//    }
//
//    @And("^I write override notes$")
//    public void iWriteOverrideNotes() throws Throwable {
//        webElementExtensions.findElementByDataBind("textInput", "Notes")
//                .sendKeys("Override Test");
//        driver.findElement(By.id("modalDialogConfirmButton")).click();
//    }
//
//    @And("^I see the override highlight$")
//    public void iSeeTheOverrideHighlight() throws Throwable {
//       String actual = wait.waitAndGetText(driver, By.cssSelector("div.task-group-container:nth-child(6) > div:nth-child(1) > div:nth-child(1) > span:nth-child(5)"));
//        Assert.assertEquals("Override", actual);
//    }
//
//    @And("^I see a warning message in the dialogue box$")
//    public void iSeeAWarningMessageInTheDialogueBox() throws Throwable {
//        popupWindow.moveToNewFrame();
//        popupWindow.moveToNewWindow();
//        String actual = driver.findElement(By.id("modalBody")).getText();
//        Assert.assertEquals("A form is open in edit mode. Any unsaved changes will be lost. Do you wish to continue?", actual);
//    }
//}
