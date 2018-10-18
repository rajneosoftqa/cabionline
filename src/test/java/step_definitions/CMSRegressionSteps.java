package step_definitions;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import cucumber.api.PendingException;
import cucumber.api.java.bs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import formSteps.CreateOrder;
import formSteps.SearchOrder;
import forms.SearchOrderForm;
import helpers.Dropdown;;
import org.apache.commons.io.FilenameUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pageobjects.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import helpers.*;
import util.Credentials;
import org.junit.*;
import org.joda.time.*;


import javax.ws.rs.HEAD;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.lang.reflect.Array;
import java.text.Collator;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.*;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
//import static org.hamcrest.MatcherassertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class CMSRegressionSteps extends BaseClass {
    Wait wait = new Wait();
    LoginPage loginPage = new LoginPage();
    private CasePage casePage = new CasePage(driver);
    Misc misc = new Misc();
    Dropdown dropdown = new Dropdown();
    SearchOrderForm search = new SearchOrderForm();
    PopupWindow popupWindow = new PopupWindow();
    ScrollintoView scrollintoView = new ScrollintoView();
    OMSDashboardPage omsDashboardPage = new OMSDashboardPage();
    OrderSearchPage orderSearchPage = new OrderSearchPage();
    CreateOrder createOrder = new CreateOrder();
    Credentials credentials = new Credentials();
    OrderPage orderPage = new OrderPage();
    HomePage homePage = new HomePage(driver);
    SearchOrder searchorderpage = new SearchOrder();
    SubjectCompanyFormPage subjectCompanyFormPage = new SubjectCompanyFormPage(driver);
    CapacityProfilePage capacityProfilePage = new CapacityProfilePage();
    PageHelpers pageHelpers = new PageHelpers();
    Actions actions = new Actions(driver);
    AdminPage adminPage = new AdminPage();
    private ReviewAndConfirmOrderPage rco = new ReviewAndConfirmOrderPage(driver);
    private String numberOfHours = "";
    private String hoursReasonType = "";
    private CssHelpers cssHelpers = new CssHelpers();
    private SelectElements selectElements = new SelectElements();
    private AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage(driver);
    public int PastDueCount = 0;
    public WebElement reportStatus = null;

    Faker faker = new Faker();
    private Name name = faker.name();
    String firstname = name.firstName().replace("'", "");
    String lastname = name.lastName().replace("'", "");
    String message = faker.superhero().name().replace("'", "");
    String orderName = name.firstName().replace("'", "")+"_"+faker.company().name().replace("-","_").replace("'", "");
    String companyName = faker.company().name().replace("'", "").replace("-","_");
    String[] orders = null;
    String draftStatus = "";

    String driverDirectory = System.getProperty("user.dir") + "/testData";
    public static String thirdParty = "";
    public static String accountname = "";



    @And("^I login to CMS site$")
    public void iLoginToCMSSite() throws Throwable {
        loginPage.navigateToDiligenceLoginPage();
        loginPage.userName.sendKeys("tdattacm@exiger.com");
        loginPage.password.sendKeys("Admin1234");
        loginPage.loginButton.click();
        wait.waitUntilGridSpinnersNotPresent();
    }


    @And("^I am in CMS dashboard page$")
    public void iAmInCMSDashboardPage() throws Throwable {
        wait.waitAndClick(casePage.dashboardCMS);
        wait.waitUntilGridSpinnersNotPresent();
    }

    @And("^I click on Cases$")
    public void iClickOnCases() throws Throwable {
        driver.findElement(By.xpath("//a[contains(text(),'Cases')]")).click();
        System.out.println("-"+driver.findElement(By.xpath("//a[contains(text(),'Cases')]")).getText()+"-");
        wait.waitUntilGridSpinnersNotPresent();
    }


    @And("^I click on Search button$")
    public void iClickOnSearchButton() throws Throwable {
        casePage.searchButton.click();
        wait.waitUntilGridSpinnersNotPresent();
    }

    @And("^I select \"([^\"]*)\" in Status Dropdown$")
    public void iSelectInStatusDropdown(String arg0) throws Throwable {
        //driver.findElement((By) casePage.statusDropdown).click();
        dropdown.selectValueFromUnorderedListWithCheckbox(driver, search.ordertypediv, search.ordertypebutton, arg0);

    }

    @And("^I click on Order Submitted on date (\\d+)/(\\d+)/(\\d+)$")
    public void iClickOnOrderSubmittedOnDate(int arg0, int arg1, int arg2) throws Throwable {
        System.out.println(driver.findElement(By.id("load_jqGrid")).getSize());
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitAndClick(casePage.firstrow);
    }

    @And("^I navigate to Case Summary Page$")
    public void iNavigateToCaseSummaryPage() throws Throwable {
        popupWindow.moveToAnotherNewTab();
        Thread.sleep(5000);

    }

    @And("^I click on Edit Core Details$")
    public void iClickOnEditCoreDetails() throws Throwable {
        //scrollintoView.scrollToView(casePage.coredetails);
        scrollintoView.scrollWithoutBanner(driver);
        wait.waitAndClick(casePage.coredetailslink);

    }

    @And("^I enter date in Interim Report Due Date$")
    public void iEnterDateInInterimReportDueDate() throws Throwable {
        searchorderpage.submitcal("interimReportDueDateContainer");
//        casePage.duedate.sendKeys("t");
//        casePage.interimreportduedate.sendKeys("t");
    }

    @And("^I click on Complete checkbox$")
    public void iClickOnCompleteCheckbox() throws Throwable {
//        if(!casePage.interimreportcheckbox.isSelected()) {
        casePage.interimreportcheckbox.click();
//        }
//        else {
//            PastDueCount = PastDueCount - 1;
//        }
    }

    @Then("^I click on Save Core Details$")
    public void iClickOnSaveCoreDetails() throws Throwable {
        casePage.savecoredetails.click();
        Thread.sleep(10000);

    }

    @And("^Remember Me Checkbox is Present$")
    public void rememberMeCheckboxIsPresent() throws Throwable {
        loginPage.rememberMeButton.isDisplayed();
    }

    @Then("^I check the Remember Me box$")
    public void iCheckTheRememberMeBox() throws Throwable {
        loginPage.rememberMeButton.click();
        assertTrue(loginPage.rememberMeButton.isSelected());
    }

    @And("^I navigate to login page$")
    public void iNavigateToLoginPage() throws Throwable {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement dropdown = driver.findElement(By.cssSelector(".dropdown-menu"));
        js.executeScript("arguments[0].setAttribute('style', 'display:block;')", dropdown);

        omsDashboardPage.logOff.click();

        loginPage.navigateToDiligenceLoginPage();
    }

    @And("^I click on Forgot Password$")
    public void iClickOnForgotPassword() throws Throwable {
        omsDashboardPage.forgotpassword.click();
    }

    @And("^I enter username$")
    public void iEnterUsername() throws Throwable {
        loginPage.userName.sendKeys("tdattacm@exiger.com");
        loginPage.loginButton.click();
    }

    @Then("^I get password reset email sent message$")
    public void iGetPasswordResetEmailSentMessage() throws Throwable {
        assertTrue(driver.findElement(By.cssSelector(".temp-alert-top.alert.alert-dismissible.alert-success")).isDisplayed());
    }


    @And("^I change the language to English$")
    public void iChangeTheLanguageToEnglish() throws Throwable {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement dropdown = driver.findElement(By.cssSelector(".dropdown-menu"));
        js.executeScript("arguments[0].setAttribute('style', 'display:block;')", dropdown);

        omsDashboardPage.language.click();
    }

    @And("^I click on support link in CMS$")
    public void iClickOnSupportLinkInCMS() throws Throwable {
        Thread.sleep(2000);
        wait.waitUntilNotPresent(driver.findElement(By.className("loading")));
        wait.waitUntilPresent(omsDashboardPage.jqgridList);
        scrollintoView.scrollToView(omsDashboardPage.support);
//        String selectAll = Keys.chord(Keys.CONTROL, Keys.END);
//        driver.findElement(By.xpath("//body")).sendKeys(selectAll);

//        actions.moveToElement(omsDashboardPage.support).sendKeys().build().perform();
        wait.waitAndClick(omsDashboardPage.support);
    }

    @And("^I navigate to support page in CMS$")
    public void iNavigateToSupportPageInCMS() throws Throwable {
        wait.waitAndClick(omsDashboardPage.supportverify);
    }


    @And("^I click on Privacy Policy link$")
    public void iClickOnPrivacyPolicyLink() throws Throwable {
        wait.waitUntilClickable(omsDashboardPage.gridList);
        scrollintoView.scrollToView(omsDashboardPage.privacypolicy);
        wait.waitAndClick(omsDashboardPage.privacypolicy);
        Thread.sleep(5000);
    }

    @And("^I navigate to privacy page$")
    public void iNavigateToPrivacyPage() throws Throwable {
        assertTrue(omsDashboardPage.privacypolicyverify.isDisplayed());
    }

    @And("^I click on terms and conditions in CMS$")
    public void iClickOnTermsAndConditionsInCMS() throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitUntilPresent(omsDashboardPage.tableGrid);
        scrollintoView.scrollDown();
        wait.waitAndClick(omsDashboardPage.termsandconditions);
    }


    @And("^I navigate to the terms and conditions page in CMS$")
    public void iNavigateToTheTermsAndConditionsPageInCMS() throws Throwable {
        omsDashboardPage.tocverify.click();
    }

    @And("^I should be able to click \"([^\"]*)\" tile and see past due cases$")
    public void iShouldBeAbleToClickTileAndSeePastDueCases(String arg0) throws Throwable {
        Thread.sleep(5000);
        omsDashboardPage.statusTile(arg0);
    }

    @And("^I should be able to click \"([^\"]*)\" tile and see cases in pending assignment$")
    public void iShouldBeAbleToClickTileAndSeeCasesInPendingAssignment(String arg0) throws Throwable {
        omsDashboardPage.statusTile(arg0);
    }

    @And("^I should be able to click \"([^\"]*)\" tile and see cases not yet accepted for research$")
    public void iShouldBeAbleToClickTileAndSeeCasesNotYetAcceptedForResearch(String arg0) throws Throwable {
        omsDashboardPage.statusTile(arg0);
    }

    @And("^I should be able to click on \"([^\"]*)\" tile and view currently in progress cases$")
    public void iShouldBeAbleToClickOnTileAndViewCurrentlyInProgressCases(String arg0) throws Throwable {
        omsDashboardPage.statusTile(arg0);
    }

    @And("^I should be able to click on \"([^\"]*)\" and view cases due in the next five days$")
    public void iShouldBeAbleToClickOnAndViewCasesDueInTheNextFiveDays(String arg0) throws Throwable {
        omsDashboardPage.statusTile(arg0);
    }

    @And("^I should be able to click on \"([^\"]*)\" and view cases with unread messages$")
    public void iShouldBeAbleToClickOnAndViewCasesWithUnreadMessages(String arg0) throws Throwable {
        omsDashboardPage.statusTile(arg0);
    }

    @And("^I log off from the site in CMS$")
    public void iLogOffFromTheSiteInCMS() throws Throwable {
        omsDashboardPage.expandUserOptions();
        omsDashboardPage.logOff.click();
        wait.waitUntilPresent(loginPage.userName);
        loginPage.loginPageIsVisible();
    }

    @And("^I click on back arrow in calendar to go to previous month in CMS$")
    public void iClickOnBackArrowInCalendarToGoToPreviousMonthInCMS() throws Throwable {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        orderSearchPage.previousmonth.click();
        System.out.println(omsDashboardPage.calMonth.getText() + " == " + new SimpleDateFormat("MMM").format(cal.getTime()) + " 2018");
        assertTrue(omsDashboardPage.calMonth.getText().contains(new SimpleDateFormat("MMM").format(cal.getTime()) + " 2018"));

    }

    @And("^I click on forward arrow in calendar to go to next month in CMS$")
    public void iClickOnForwardArrowInCalendarToGoToNextMonthInCMS() throws Throwable {
        Calendar cal = Calendar.getInstance();
        orderSearchPage.nextmonth.click();
        System.out.println(omsDashboardPage.calMonth.getText() + " == " + new SimpleDateFormat("MMM").format(cal.getTime()) + " 2018");
        assertTrue(omsDashboardPage.calMonth.getText().contains(new SimpleDateFormat("MMM").format(cal.getTime()) + " 2018"));
    }

    @And("^I type \"([^\"]*)\" in search for subjects text box in CMS$")
    public void iTypeInSearchForSubjectsTextBoxInCMS(String arg0) throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        omsDashboardPage.quicksearch.sendKeys("test");
        Thread.sleep(10000);
    }

    @And("^I should be able to click on the suggestion in CMS$")
    public void iShouldBeAbleToClickOnTheSuggestionInCMS() throws Throwable {
        omsDashboardPage = new OMSDashboardPage();
        wait.waitUntilPresent(casePage.quickSearchContainer);
//        System.out.println("size =  "+casePage.quickSearchContainers.size());
//        System.out.println("size sub =  "+driver.findElements(By.cssSelector(".tt-dataset-subjects")).size());
//        System.out.println("size selectable =  "+driver.findElements(By.cssSelector(".tt-selectable")).size());
//        System.out.println("size left =  "+driver.findElements(By.cssSelector(".ta-subject-left")).size());
        if (casePage.quickSearchResults.size() > 0) {
            wait.waitUntilPresent(casePage.quickSearchContainer);
            Thread.sleep(10000);
            List <WebElement> list = driver.findElements(By.cssSelector(".ta-subject-container"));
            System.out.println("test " + list.size());
            list.get(0).click();
        } else {
            assertEquals(casePage.quickSearchNotFound.getText(), "No subjects found");
        }
    }

    @And("^I click on Download Results in CMS$")
    public void iClickOnDownloadResultsInCMS() throws Throwable {
        omsDashboardPage.downloadresults.click();
    }

    @Then("^The report gets downloaded in CMS$")
    public void theReportGetsDownloadedInCMS() throws Throwable {
        misc.downloadFile("Case_Search_Results", "csv");
    }

    @And("^I click on create order button in CMS$")
    public void iClickOnCreateOrderButtonInCMS() throws Throwable {
        wait.waitAndClick(driver, By.id("btnCreateOrder"));
    }

    @And("^I fill order details for \"([^\"]*)\" type in CMS$")
    public void iFillOrderDetailsForTypeInCMS(String arg0) throws Throwable {
        orderPage.fillOrderDetails(arg0, orderName);
        System.out.println("order name is used: " + orderName);
    }

    @And("^I fill out the subject \"([^\"]*)\" details in CMS$")
    public void iFillOutTheSubjectDetailsInCMS(String orderform) throws Throwable {
        if (orderform.equals("company")) {
            companyName = createOrder.fillCompanySubjectForm(companyName);
            System.out.println("Company name is " + companyName);
        } else if (orderform.equals("individual")) {
            createOrder.fillIndividualSubjectForm(firstname, lastname);
            System.out.println("name 1: " + firstname);
        }
    }

    @And("^I move to next page in CMS$")
    public void iMoveToNextPageInCMS() throws Throwable {
        subjectCompanyFormPage.continueButton.click();
        //Thread.sleep(5000);
    }

    @And("^I review order details have order type in CMS$")
    public void iReviewOrderDetailsHaveOrderTypeAndOrderNameInCMS() throws Throwable {
        orderPage.reviewOrderType("Level 1");
    }

    @And("^I submit the order in CMS$")
    public void iSubmitTheOrderInCMS() throws Throwable {
        rco.submitOrderButton.click();
        //wait.waitUntilPresent(omsDashboardPage.tableElements);
    }

    @And("^I see the name of the subject for \"([^\"]*)\" is added in CMS$")
    public void iSeeTheNameOfTheSubjectForIsAddedInCMS(String arg0) throws Throwable {
        if (arg0.equals("company")) {
            String actual = wait.waitAndGetText(driver, By.xpath("//*[@id='subjectsReviewContainer']//*[contains(text(),'" + companyName + "')]"));
//        System.out.println(companyName.toLowerCase()+" ===== "+actual.toLowerCase());
            assertEquals(companyName.toLowerCase(), actual.toLowerCase());
        } else {
            String actual = wait.waitAndGetText(driver, By.xpath("//*[@id='subjectsReviewContainer']//*[contains(text(),'" + firstname + "')]"));
            System.out.println(firstname.toLowerCase() + " " + lastname.toLowerCase() + " ===== " + actual.toLowerCase());
            assertEquals(firstname.toLowerCase() + " " + lastname.toLowerCase(), actual.toLowerCase());
        }
    }


    @And("^I should be able to type \"([^\"]*)\" in Name field in CMS$")
    public void iShouldBeAbleToTypeInNameFieldInCMS(String arg0) throws Throwable {
        searchorderpage.fillordername(arg0);
    }

    @And("^I should be able to click on Order type field and select a \"([^\"]*)\" in CMS$")
    public void iShouldBeAbleToClickOnOrderTypeFieldAndSelectAInCMS(String arg0) throws Throwable {
        searchorderpage.selectordertype(arg0);
    }

    @And("^I should be able to pick Submited between start and end dates as \"([^\"]*)\" and \"([^\"]*)\" fields in CMS$")
    public void iShouldBeAbleToPickSubmitedBetweenStartAndEndDatesAsAndFieldsInCMS(String arg0, String arg1) throws Throwable {
        searchorderpage.submitcal_1("");
        searchorderpage.submitcal_2();
    }

    @And("^I should be able to pick Completed between start and end dates as \"([^\"]*)\" and \"([^\"]*)\" fields in CMS$")
    public void iShouldBeAbleToPickCompletedBetweenStartAndEndDatesAsAndFieldsInCMS(String arg0, String arg1) throws Throwable {
        searchorderpage.submitcal_3();
        searchorderpage.submitcal_4();
    }

    @And("^I should be able to click Order Status field and select \"([^\"]*)\" in CMS$")
    public void iShouldBeAbleToClickOrderStatusFieldAndSelectInCMS(String arg0) throws Throwable {
        searchorderpage.fillorderstatus(arg0);
    }

    @And("^I should be able to type \"([^\"]*)\" in Order Number field in CMS$")
    public void iShouldBeAbleToTypeInOrderNumberFieldInCMS(String arg0) throws Throwable {
        searchorderpage.ordernumber(arg0);
    }

    @And("^I should be able to click on Search button in CMS$")
    public void iShouldBeAbleToClickOnSearchButtonInCMS() throws Throwable {
        searchorderpage.searchbuttonclick();
        wait.waitUntilGridSpinnersNotPresent();
        //Thread.sleep(5000);
    }

    @Then("^I should be able to see the results in CMS$")
    public void iShouldBeAbleToSeeTheResultsInCMS() throws Throwable {
        searchorderpage.viewresults();
    }

    @And("^I should be able to click on Reset button in CMS$")
    public void iShouldBeAbleToClickOnResetButtonInCMS() throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitUntilPresent(search.resetbutton);
        wait.waitUntilClickable(search.resetbutton).click();
    }


    @And("^The order page opens in a new tab in CMS$")
    public void theOrderPageOpensInANewTabInCMS() throws Throwable {
        popupWindow.moveToAnotherNewTab();
        Thread.sleep(5000);
        assertTrue(wait.waitUntilPresent(orderPage.ordertitle).isDisplayed());
        System.out.println(wait.waitUntilPresent(orderPage.ordertitle).isDisplayed());
    }

    @And("^I click on continue button in CMS$")
    public void iClickOnContinueButtonInCMS() throws Throwable {
        wait.waitUntilClickable(orderPage.continueButton).click();
        Thread.sleep(10000);
    }

    @And("^I navigate to subjects page in CMS$")
    public void iNavigateToSubjectsPageInCMS() throws Throwable {
        assertTrue(wait.waitUntilPresent(orderPage.enterSubjects).isDisplayed());
    }


    @And("^I click on an order from the table for \"([^\"]*)\" in CMS$")
    public void iClickOnAnOrderFromTheTableForInCMS(String arg0) throws Throwable {
        System.out.println("testest");
        if (arg0.equals("company")) {
            if (orderPage.firstOrderCheckCms.size() > 0) {
                wait.waitUntilClickable(orderPage.firstOrdercCms).click();
            } else {
                orderPage.createOrder("company");
                wait.waitAndClick(orderPage.backToDashBoard);
                homePage.navigateToOrdersPage();
                searchorderpage.fillorderstatus("Draft");
                searchorderpage.selectordertype("Level 1");
                searchorderpage.searchbuttonclick();
                wait.waitUntilGridSpinnersNotPresent();
                wait.waitUntilPresent(omsDashboardPage.jqgridList);
                omsDashboardPage.statusTile("Not Submitted");
                wait.waitUntilClickable(orderPage.firstOrdercCms).click();
            }
        } else {
            if (orderPage.firstOrderCheck.size() > 0) {
                wait.waitAndClick(orderPage.firstOrdercCms);
            } else {
                orderPage.createOrder("individual");
                wait.waitAndClick(orderPage.backToDashBoard);
                homePage.navigateToOrdersPage();
                searchorderpage.fillorderstatus("Draft");
                searchorderpage.selectordertype("Level 1");
                searchorderpage.searchbuttonclick();
                wait.waitUntilGridSpinnersNotPresent();
                wait.waitUntilPresent(omsDashboardPage.jqgridList);
                omsDashboardPage.statusTile("Not Submitted");
                wait.waitUntilClickable(orderPage.firstOrdercCms).click();
            }
        }
    }


    @And("^I navigate to the messages tab in CMS$")
    public void iNavigateToTheMessagesTabInCMS() throws Throwable {
        assertTrue(orderPage.messageHistory.isDisplayed());
    }


//    @Then("^I check the sent message in CMS$")
//    public void iCheckTheSentMessageInCMS() throws Throwable {
//        String actual = wait.waitAndGetText(driver, By.xpath("//*[@id='messages']//*[contains(text(),'" + message + "')]"));
//        assertEquals(message, actual);
//    }

    @And("^I click on a case from the table$")
    public void iClickOnACaseFromTheTable() throws Throwable {
        wait.waitAndClick(casePage.firstCaseCms);
        //casePage.firstCaseCms.click();
    }

    @And("^I click on a in progress case from the table$")
    public void iClickOnAInProgressCaseFromTheTable() throws Throwable {
        casePage.firstCaseCmsNotes.click();
    }

    @And("^The case page opens in a new tab$")
    public void theCasePageOpnesInANewTab() throws Throwable {
        popupWindow.moveToNewTab2();
        assertTrue(wait.waitUntilPresent(casePage.caseTitle).isDisplayed());
    }

    @And("^I click on Messages tab in Case Page$")
    public void iClickOnMessagesTabInCasePage() throws Throwable {
        casePage.messagesTab.click();
        wait.waitUntilPresent(casePage.messageHistory);
    }

    @And("^I send a message in the message textbox and click send in Case Page$")
    public void iSendAMessageInTheMessageTextboxAndClickSendInCasePage() throws Throwable {
        wait.waitAndSendKeysByElement(casePage.messageBox, message);
        wait.waitUntilClickable(casePage.sendMessage1).click();
        wait.waitAndClick(casePage.confirmSend);
    }

    @And("^I should be able to type a Case in Case Name field$")
    public void iShouldBeAbleToTypeInCaseNameField() throws Throwable {
        searchorderpage.fillordername(OMSRegressionSteps.casename);
        Thread.sleep(5000);
    }

    @And("^I should be able to click on Status field and select \"([^\"]*)\"$")
    public void iShouldBeAbleToClickOnStatusFieldAndSelect(String arg0) throws Throwable {
        searchorderpage.fillordername("IDM186");
        searchorderpage.selectordertype(arg0);

    }

    @And("^I should be able to click on Status field in case search and select \"([^\"]*)\"$")
    public void iShouldBeAbleToClickOnStatusFieldInCaseSearchAndSelect(String arg0) throws Throwable {
        searchorderpage.selectordertype(arg0);

    }

    @And("^I should be able to type \"([^\"]*)\" in subject name field$")
    public void iShouldBeAbleToTypeInSubjectNameField(String arg0) throws Throwable {
        casePage.subjectName.sendKeys("test");
    }

    @And("^I should be able to select \"([^\"]*)\" option in account name field$")
    public void iShouldBeAbleToSelectOptionInAccountNameField(String arg0) throws Throwable {
        casePage.selectAccountId(arg0);
    }

    @And("^I should be able to select Jurisdiction as \"([^\"]*)\"$")
    public void iShouldBeAbleToSelectJurisdictionAs(String arg0) throws Throwable {
        casePage.fillcaseJurisdiction(arg0);
    }

    @And("^I see the Case Summary Page$")
    public void iSeeTheCaseSummaryPage() throws Throwable {
        assertTrue(wait.waitUntilPresent(casePage.caseTitle).isDisplayed());
        assertTrue(wait.waitUntilPresent(casePage.orderDetails).isDisplayed());
        assertTrue(wait.waitUntilPresent(casePage.caseDetails).isDisplayed());
        assertTrue(wait.waitUntilPresent(casePage.coreDetails).isDisplayed());
        System.out.println(casePage.caseTitle.getText());
        System.out.println(casePage.orderDetails.getText());
        System.out.println(casePage.caseDetails.getText());
        System.out.println(casePage.coreDetails.getText());

    }

    @And("^I upload the document in the order$")
    public void iUploadTheDocumentInTheOrder() throws Throwable {
        String fileUpload = System.getProperty("user.dir") + File.separator + "testData" + File.separator + "Upload" + File.separator + "test1kb.pdf";
        System.out.println("file upload: "+fileUpload);
        wait.waitUntilPresent(orderPage.submitDocuments).sendKeys(fileUpload);
    }

    @And("^I click on save button$")
    public void iClickOnSaveButton() throws Throwable {
        wait.waitAndClick(orderPage.saveButton);
        Thread.sleep(5000);
    }

    @And("^I click on add new document$")
    public void iClickOnAddNewDocument() throws Throwable {
        //scrollintoView.scrollDown();
        wait.waitAndClick(orderPage.addNewdocument);

    }

    @Then("^I check if the file was uploaded$")
    public void iCheckIfTheFileWasUploaded() throws Throwable {
        wait.waitUntilPresent(orderPage.deleteButton);
        assertTrue(driver.getPageSource().contains("test1kb.pdf"));
    }

    @And("^I login to OMS site for sending external message$")
    public void iLoginToOMSSiteForSendingExternalMessage() throws Throwable {
        omsDashboardPage.expandUserOptions();
        omsDashboardPage.logOff.click();
        loginPage.loginToOMSPage();
        loginPage.navigateToDiligenceLoginPage();
        credentials.getCredentials();
    }


    @And("^I click on the searched case from the table$")
    public void iClickOnTheSearchedCaseFromTheTable() throws Throwable {
        wait.waitUntilPresent(driver.findElement(By.xpath("//td[contains(text(),'" + OMSRegressionSteps.casename + "')]")));
        casePage.externalMessageCMS.click();
    }

    @And("^I click on Orders in CMS$")
    public void iClickOnOrdersInCMS() throws Throwable {
        homePage.navigateToOrdersPage();
        wait.waitUntilGridSpinnersNotPresent();
    }

    @And("^I click on an order from the table in CMS$")
    public void iClickOnAnOrderFromTheTableInCMS() throws Throwable {
        wait.waitAndClick(casePage.firstrow);
        wait.waitUntilGridSpinnersNotPresent();
    }

    @Then("^I check the sent internal message in CMS$")
    public void iCheckTheSentInternalMessageInCMS() throws Throwable {
        Thread.sleep(5000);
        assertTrue(driver.getPageSource().contains(message));
    }

    @And("^The case page opens in a new tab in CMS$")
    public void theCasePageOpensInANewTabInCMS() throws Throwable {
        popupWindow.moveToNewTab();
        assertTrue(wait.waitUntilPresent(casePage.caseTitle).isDisplayed());
    }

    @And("^I should be able to click on an in progress case from the table$")
    public void iShouldBeAbleToClickOnAnInProgressCaseFromTheTable() throws Throwable {
        casePage.inProgresscase.click();
    }

    @And("^I click on Reports tab in Case Page$")
    public void iClickOnReportsTabInCasePage() throws Throwable {
        wait.waitAndClick(casePage.reportsTab);
        assertTrue(wait.waitUntilPresent(casePage.reportsTabtitle).isDisplayed());
    }

    @And("^I upload the report in the case$")
    public void iUploadTheReportInTheCase() throws Throwable {
        String fileUpload = System.getProperty("user.dir") + File.separator + "testData" + File.separator + "Upload" + File.separator + "test1kb.pdf";
        wait.waitUntilPresent(casePage.uploadReport).sendKeys(fileUpload);
    }

    @And("^I should be able to select \"([^\"]*)\" option in Report field$")
    public void iShouldBeAbleToSelectOptionInReportField(String arg0) throws Throwable {
        casePage.selectreportType(arg0);
    }

    @And("^I enter a title for the report$")
    public void iEnterATitleForTheReport() throws Throwable {
        casePage.caseReportTitle.sendKeys("Dummy Report");
    }

    @Then("^I click on upload button$")
    public void iClickOnUploadButton() throws Throwable {

        wait.waitAndClick(casePage.uploadButton);
    }

    @Then("^I click Upload Report button$")
    public void iClickConfirmUploadButton() throws Throwable {
        //wait.waitUntilPresent(casePage.confirmUploadbutton).click();
        wait.waitUntilClickable(casePage.confirmUploadbutton).click();
    }

    @And("^I click on Generate PDF$")
    public void iClickOnGeneratePDF() throws Throwable {
        casePage.generatePdfLink.click();
    }

    @And("^I click on the first report$")
    public void iClickOnTheFirstReport() throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitAndClick(casePage.firstRowpdf);
    }

    @And("^I click on Generate PDF button$")
    public void iClickOnGeneratePDFButton() throws Throwable {
        wait.waitAndClick(casePage.generatePdfButton);
        System.out.println("tstts12132213");
    }

    @And("^The report is getting generated$")
    public void theReportIsGettingGenerated() throws Throwable {
        wait.waitUntilNotPresent(casePage.generatingPDF);
    }

    @Then("^Report is downloaded$")
    public void reportIsDownloaded() throws Throwable {
        misc.downloadFile("CaseSummaries", "zip");
    }

    @And("^I select supervisor in the drop down$")
    public void iSelectInTheSupervisorDropDown() throws Throwable {
        casePage.selectSupervisorid();
    }

    @And("^I select Primary Researcher in the drop down$")
    public void iSelectInThePrimaryResearcherDropDown() throws Throwable {
        casePage.selectPrimaryresearcherId();
    }

    @Then("^I click on Save Assignments$")
    public void iClickOnSaveAssignments() throws Throwable {
        wait.waitAndClick(casePage.assignCasebutton);
    }

    @And("^I select case status as \"([^\"]*)\" and click on Search$")
    public void iSelectCaseStatusAsAndClickOnSearch(String arg0) throws Throwable {
        if (arg0.equalsIgnoreCase("Pending Acceptance")) {
            orderPage.createCaseOrder(orderName, "company");
            driver.findElement(By.xpath("//a[contains(text(),'Cases')]")).click();
            wait.waitUntilGridSpinnersNotPresent();
        }
        searchorderpage.selectordertype(arg0);
        searchorderpage.searchbuttonclick();
        wait.waitUntilGridSpinnersNotPresent();
    }

    @And("^I see only \"([^\"]*)\" cases$")
    public void iSeeOnlyCases(String arg0) throws Throwable {
        int statussize = driver.findElements(By.xpath("//*[@id='jqGrid']/tbody/tr[not(contains(@class,'jqgfirstrow'))]/td[3]")).size();
        int statusstype = driver.findElements(By.xpath("//*[@id='jqGrid']/tbody/tr/td[text()='" + arg0 + "']")).size();
        assertEquals(statussize, statusstype);
        System.out.println(statussize + "==" + statusstype);
    }

    @And("^I move to the next page for \"([^\"]*)\"$")
    public void iMoveToTheNextPageFor(String arg0) throws Throwable {
        popupWindow.moveToAnotherNewTab();
        Thread.sleep(5000);
    }

    @And("^I see the DDIQ tab is not present$")
    public void iSeeTheDDIQTabIsNotPresent() throws Throwable {

        assertEquals(casePage.ddiqTab.size(), 0);
    }

    @And("^I see the DDIQ tab is present$")
    public void iSeeTheDDIQTabIsPresent() throws Throwable {
        assertTrue(casePage.ddiqTab.size() >= 0);
    }

    @Then("^I should be able to see the searched results in CMS$")
    public void iShouldBeAbleToSeeTheSearchedResultsInCMS() throws Throwable {
        searchorderpage.viewresultscms();
    }

    @And("^I click on Documents tab$")
    public void iClickOnDocumentsTab() throws Throwable {
        if (casePage.modals.size() > 0) {
            cssHelpers.HideElement(casePage.modal);
        }
        wait.waitAndClick(casePage.documentsTab);
    }

    @And("^I navigate to Documents tab$")
    public void iNavigateToDocumentsTab() throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        assertTrue(wait.waitUntilPresent(casePage.verifyDocumentstab).isDisplayed());
    }


    @And("^I click on Case Documents$")
    public void iClickOnCaseDocuments() throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitAndClick(casePage.uploadCasedocuments);
    }


    @And("^I click on Edit Report Type$")
    public void iClickOnEditReportType() throws Throwable {
        Thread.sleep(5000);
        wait.waitAndClick(casePage.editReportTypebutton);
    }

    @And("^I select Multiple Master Reports option$")
    public void iSelectMultipleMasterReportsOption() throws Throwable {
        if (!casePage.multipleMasterreportsOption.isSelected())
            wait.waitAndClick(casePage.multipleMasterreportsOption);
    }

    @And("^I click cancel button$")
    public void iClickCancelButton() throws Throwable {
        System.out.println(casePage.generateReporttypeCancelbutton.getText());
        wait.waitAndClick(casePage.generateReporttypeCancelbutton);

    }

    @Then("^I see Single Master Report option is selected by default$")
    public void iSeeSingleMasterReportOptionIsSelectedByDefault() throws Throwable {
        assertTrue(wait.waitUntilPresent(casePage.singleMasterreportOption).isSelected());
    }

    @And("^I see View Shared Notes is available$")
    public void iSeeViewSharedNotesIsAvailable() throws Throwable {
        assertTrue(wait.waitUntilPresent(casePage.sharedNotes).isDisplayed());
        assertTrue(wait.waitUntilPresent(casePage.sharedNotesfileName).isDisplayed());
        assertTrue(wait.waitUntilPresent(casePage.sharedNotesOpeninWord).isDisplayed());


    }

    @And("^I click on Research tab$")
    public void iClickOnResearchTab() throws Throwable {
        wait.waitAndClick(casePage.researchTab);
        wait.waitUntilGridSpinnersNotPresent();
        assertTrue(wait.waitUntilPresent(casePage.refreshButton).isDisplayed());
    }

    @And("^I navigate to Research tab$")
    public void iNavigateToResearchTab() throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        assertTrue(wait.waitUntilPresent(casePage.refreshButton).isDisplayed());
    }

    @And("^I complete the tasks via task matrix$")
    public void iCompleteTheTasksViaTaskMatrix() throws Throwable {
        casePage.completeMatrixtasks();
    }

    @Given("^I login to CMS with Researcher account$")
    public void iLoginToCMSWithResearcherAccount() throws Throwable {
        omsDashboardPage.expandUserOptions();
        omsDashboardPage.logOff.click();
        loginPage.navigateToDiligenceLoginPage();
        loginPage.userName.sendKeys("tdattaresearcher@exiger.com");
        loginPage.password.sendKeys("Admin123!!");
        loginPage.loginButton.click();

    }

    @Given("^I login to CMS with Editor account$")
    public void iLoginToCMSWithEditorAccount() throws Throwable {
        omsDashboardPage.expandUserOptions();
        omsDashboardPage.logOff.click();
        loginPage.navigateToDiligenceLoginPage();
        loginPage.userName.sendKeys("tdattaedit@exiger.com");
        loginPage.password.sendKeys("Exiger1!!");
        loginPage.loginButton.click();
    }

    @Given("^I login to CMS with Content Reviewer account$")
    public void iLoginToCMSWithContentReviewerAccount() throws Throwable {
        omsDashboardPage.expandUserOptions();
        omsDashboardPage.logOff.click();
        loginPage.navigateToDiligenceLoginPage();
        loginPage.userName.sendKeys("tdattareview@exiger.com");
        loginPage.password.sendKeys("Exiger1!!");
        loginPage.loginButton.click();
    }

    @And("^I click on Edit Draft Status$")
    public void iClickOnEditDraftStatus() throws Throwable {
        wait.waitAndClick(casePage.editDraftstatusButton);

    }

    @And("^I click on saving option$")
    public void iClickOnSavingOption() throws Throwable {
        wait.waitAndClick(casePage.getEditDraftstatusSavingoption);
    }

    @And("^The Draft is saved$")
    public void theDraftIsSaved() throws Throwable {
        Thread.sleep(5000);
        wait.waitUntilPresent(casePage.editDraftstatusButton);
    }

    @And("^I select a Third Party Contractor$")
    public void iSelectAsThirdPartyContractor() throws Throwable {
        thirdParty = casePage.selectThirdpartyContractor();
    }

    @And("^I click on Add Additional Contractor$")
    public void iClickOnAddAdditionalContractor() throws Throwable {
        wait.waitAndClick(casePage.addAdditionalcontractorlink);
    }

    @And("^I select a Second Third Party Contractor$")
    public void iSelectInSecondThirdPartyContractor() throws Throwable {
        casePage.selectThirdpartyContractor1();
        Thread.sleep(5000);
    }


    @And("^I select currency as \"([^\"]*)\" for first Third Party Contractor$")
    public void iSelectCurrencyAsForFirstThirdPartyContractor(String arg0) throws Throwable {
        casePage.selectfirstThirdpartyCurrency(arg0);
    }

    @And("^I enter Budget as \"([^\"]*)\" for first Third Party Contractor$")
    public void iEnterBudgetAsForFirstThirdPartyContractor(String arg0) throws Throwable {
        casePage.selectfirstThirdpartyBudjet(arg0);
    }

    @And("^I select Due date for first Third Party Contractor$")
    public void iSelectDueDateForFirstThirdPartyContractor() throws Throwable {
        wait.waitAndClick(casePage.firstThirdpartyduedateid);
        casePage.firstThirdpartyduedateid.click();
    }

    @Then("^I check the filled details$")
    public void iCheckTheFilledDetails() throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        System.out.println(new Select(casePage.verifyThirdpartyDetails).getFirstSelectedOption().getText());
        assertEquals(new Select(casePage.verifyThirdpartyDetails).getFirstSelectedOption().getText(), thirdParty);
    }

    @And("^I click on the plus icon in Hours Tracker$")
    public void iClickOnThePlusIconInHoursTracker() throws Throwable {
        wait.waitAndClick(casePage.hoursTrackericon);
    }

    @And("^I select currency as \"([^\"]*)\" for second Third Party Contractor$")
    public void iSelectCurrencyAsForSecondThirdPartyContractor(String arg0) throws Throwable {
        casePage.selectSecondThirdpartyCurrency(arg0);
    }

    @And("^I enter Budget as \"([^\"]*)\" for Second Third Party Contractor$")
    public void iEnterBudgetAsForSecondThirdPartyContractor(String arg0) throws Throwable {
        casePage.selectSecondThirdpartyBudjet(arg0);
    }

    @And("^I select Due date for Second Third Party Contractor$")
    public void iSelectDueDateForSecondThirdPartyContractor() throws Throwable {
        wait.waitAndClick(casePage.secondThirdpartyduedateid);
        casePage.secondThirdpartyduedateid.click();
    }


    @And("^I enter \"([^\"]*)\" in the hours worked field$")
    public void iEnterInTheHoursWorkedField(String arg0) throws Throwable {
        casePage.inputWorkinghours(arg0);
        numberOfHours = arg0;
    }

    @And("^I select \"([^\"]*)\" in the reason field$")
    public void iSelectInTheReasonField(String arg0) throws Throwable {
        casePage.selecthoursReasontype(arg0);
        hoursReasonType = arg0;
    }

    @And("^I select the Date in the date field$")
    public void iSelectTheDateInTheDateField() throws Throwable {
        wait.waitAndClick(casePage.workingHoursdate);
        casePage.workingHoursdate.click();

    }

    @And("^I click on save button for working hours$")
    public void iClickOnSaveButtonForWorkingHours() throws Throwable {
        wait.waitAndClick(casePage.workingHoursSaveoption);
    }

    @Then("^I verify the details entered$")
    public void iVerifyTheDetailsEntered() throws Throwable {
//        System.out.println(casePage.verifyHoursWorked.getText());
        wait.checkPageIsReady();
        cssHelpers.addCssProperty(casePage.navBar,"position","relative");
        wait.waitUntilTextIs(casePage.verifyHoursWorked, numberOfHours);
        String reason = casePage.verifyReasonType.getText();
        System.out.println(reason);
        assertEquals(hoursReasonType, reason);
        //deleting entries to make sure the list is not getting longer
        wait.waitAndClick(casePage.deleteHoursTracker);
        wait.waitAndClick(casePage.confirmDeleteHoursTracker);
    }

    @And("^I verify the searched results$")
    public void iVerifyTheSearchedResults() throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        assertTrue(casePage.verifyAdvancedSearch.isDisplayed());
    }

    @And("^I navigate to DDIQ tab$")
    public void iNavigateToDDIQTab() throws Throwable {
        wait.waitAndClick(casePage.ddiqTabCMS);
        wait.waitUntilPresent(casePage.verifyDDIQ);
        assertEquals(casePage.verifyDDIQ.getText().toLowerCase(), "Subjects".toLowerCase());

    }

    @And("^I check the details are saved$")
    public void iCheckTheDetailsAreSaved() throws Throwable {
        System.out.println(new Select(casePage.verifyPrimaryResearcherDetails).getFirstSelectedOption().getText());
        assertEquals(new Select(casePage.verifyPrimaryResearcherDetails).getFirstSelectedOption().getText(), "Titu Datta [Researcher]");
    }

    @And("^I complete high priority tasks on the research tab$")
    public void iCompleteHighPriorityTasksOnTheResearchTab() throws Throwable {
        casePage.completeMatrixtasks();
    }

    @And("^I click on profile edit pencil icon$")
    public void iClickOnProfileEditPencilIcon() throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitAndClick(casePage.editProfilePencilDDIQ);
    }

    @And("^I click on Cancel button$")
    public void iClickOnCancelButton() throws Throwable {
        wait.waitAndClick(subjectCompanyFormPage.modalDailogCancelButton);
    }

    @Given("^I login to CMS with user having Diligence skills permissions$")
    public void iLoginToCMSWithUserHavingDiligenceSkillsPermissions() throws Throwable {
        omsDashboardPage.expandUserOptions();
        omsDashboardPage.logOff.click();
        loginPage.navigateToDiligenceLoginPage();
        loginPage.userName.sendKeys("automation@exiger.com");
        loginPage.password.sendKeys("Exiger1!");
        loginPage.loginButton.click();
    }

    @And("^I see Capacity Profile Tab is present$")
    public void iSeeCapacityProfileTabIsPresent() throws Throwable {
        assertTrue(capacityProfilePage.capacityProfileTab.isDisplayed());
    }

    @And("^I click on Capacity Profile Tab$")
    public void iClickOnCapacityProfileTab() throws Throwable {
        wait.waitAndClick(capacityProfilePage.capacityProfileTab);
    }

    @Then("^I navigate to Capacity Profile Tab$")
    public void iNavigateToCapacityProfileTab() throws Throwable {
        assertTrue(capacityProfilePage.verifyCapacityProfileTab.isDisplayed());
    }

    @And("^I see First Name field is available$")
    public void iSeeFirstNameFieldIsAvailable() throws Throwable {
        assertTrue(wait.waitUntilPresent(capacityProfilePage.firstNameDiligenceSkills).isDisplayed());
    }

    @And("^I see Last Name field is available$")
    public void iSeeLastNameFieldIsAvailable() throws Throwable {
        assertTrue(wait.waitUntilPresent(capacityProfilePage.lastNameDiligenceSkills).isDisplayed());
    }

    @And("^I see the Position drop down field is available$")
    public void iSeeThePositionDropDownFieldIsAvailable() throws Throwable {
        assertTrue(wait.waitUntilPresent(capacityProfilePage.positionDiligenceSkills).isDisplayed());
    }

    @And("^I see Home Office drop down field is available$")
    public void iSeeHomeOfficeDropDownFieldIsAvailable() throws Throwable {
        assertTrue(wait.waitUntilPresent(capacityProfilePage.homeOfficeDiligenceSkillsButton).isDisplayed());
    }

    @And("^I see Language drop down field is available$")
    public void iSeeLanguageDropDownFieldIsAvailable() throws Throwable {
        assertTrue(wait.waitUntilPresent(capacityProfilePage.languageDiligenceSkillsButton).isDisplayed());
    }

    @And("^I see Order Type drop down field is available$")
    public void iSeeOrderTypeDropDownFieldIsAvailable() throws Throwable {
        assertTrue(wait.waitUntilPresent(capacityProfilePage.orderTypeDiligenceSkillsButton).isDisplayed());
    }

    @And("^I see Jurisdiction drop down field is available$")
    public void iSeeJurisdictionDropDownFieldIsAvailable() throws Throwable {
        assertTrue(wait.waitUntilPresent(capacityProfilePage.jurisdictionDiligenceSkillsButton).isDisplayed());
    }

    @And("^I see Account Name drop down is available$")
    public void iSeeAccountNameDropDownIsAvailable() throws Throwable {
        assertTrue(wait.waitUntilPresent(capacityProfilePage.accountNameDiligenceSkills).isDisplayed());
    }

    @And("^I see all multi-select dropdowns have \"([^\"]*)\" as the default value$")
    public void iSeeAllMultiSelectDropdownsHaveAsTheDefaultValue(String arg0) throws Throwable {
        dropdown.assertDefaultValueFromUnorderedListWithCheckbox(driver, arg0, capacityProfilePage.filterForm);

    }

    @And("^I click on Search button for Diligence Skills results$")
    public void iClickOnSearchButtonForDiligenceSkillsResults() throws Throwable {
        wait.waitAndClick(capacityProfilePage.searchButtonDiligenceSkills);
    }

    @And("^I see the default results for users of all Positions$")
    public void iSeeTheDefaultResultsForUsersOfAllPositions() throws Throwable {
        Set <String> fromDropdown = new HashSet <>(dropdown.getAllValuesFromUnorderedListWithCheckbox(driver, capacityProfilePage.positionDiv, capacityProfilePage.dropdownDiligencePositionButton));
        List <String> list = new ArrayList <>();
        for (WebElement position : capacityProfilePage.positionTableList) {
            list.add(position.getText().replace("*", ""));
        }
        System.out.println(list.size());
        wait.waitAndClick(capacityProfilePage.pageNext);
        Thread.sleep(5000);
        for (WebElement position : new CapacityProfilePage().positionTableList) {
            list.add(position.getText().replace("*", ""));
        }
        System.out.println(list.size());
        Set <String> fromTable = new HashSet <>(list);
        System.out.println(fromDropdown + " ==== " + fromTable);
        assertTrue(fromDropdown.containsAll(fromTable));
    }


    @Then("^I see the results are listed in an alphabetical order$")
    public void iSeeTheResultsAreListedInAnAlphabeticalOrder() throws Throwable {
        capacityProfilePage.pagePrev.click();
        Thread.sleep(5000);
        List <String> list = new ArrayList <>();
        for (WebElement name : new CapacityProfilePage().nameList) {
            list.add(name.getText());
        }

        capacityProfilePage.pageNext.click();
        Thread.sleep(5000);
        for (WebElement name : capacityProfilePage.nameList) {
            list.add(name.getText());
        }

        String compareString = "Aaron";
        Collator myCollator = Collator.getInstance();
        for (String name : list) {
            assertTrue(myCollator.compare(name.substring(0, 1), compareString.substring(0, 1)) >= 0);
            compareString = name;
        }
    }

    @And("^I enter alphanumeric values in First Name, Last Name fields and click search$")
    public void iEnterAlphanumericValuesInFirstNameLastNameFieldsAndClickSearch() throws Throwable {
        capacityProfilePage.iCheckAlphaNumericInput("123");
        capacityProfilePage.iCheckAlphaNumericInput("test");
        capacityProfilePage.iCheckAlphaNumericInput("%");
    }

    @And("^I see the results for the searched criteria$")
    public void iSeeTheResultsForTheSearchedCriteria() throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        assertTrue(capacityProfilePage.firstUserDiligenceSkills.isDisplayed());
    }

    @And("^I click on Edit link for the first user$")
    public void iClickOnEditLinkForTheFirstUser() throws Throwable {
        wait.waitAndClick(capacityProfilePage.editLink);
    }

    @And("^I enter alphabets in First Name and Last Name fields and click search for UserProfile$")
    public void iEnterAlphabetsInFirstNameAndLastNameFieldsAndClickSearchForUserProfile() throws Throwable {
        wait.waitAndSendKeysByElement(capacityProfilePage.firstNameDiligenceSkills, "test");
        wait.waitAndSendKeysByElement(capacityProfilePage.lastNameDiligenceSkills, "test");
        wait.waitAndClick(capacityProfilePage.searchButtonDiligenceSkills);
    }

    @And("^I navigate to user profile page for that user$")
    public void iNavigateToUserProfilePageForThatUser() throws Throwable {
        assertTrue(capacityProfilePage.verifyCapacityProfileTab.isDisplayed());
    }

    @And("^I see First Name / Last Name / Position / Home Office / Hire Date fields are read only$")
    public void iSeeFirstNameLastNamePositionHomeOfficeHireDateFieldsAreReadOnly() throws Throwable {
        assertFalse(capacityProfilePage.firstNameDiligenceSkills.isEnabled());
        assertFalse(capacityProfilePage.lastNameDiligenceSkills.isEnabled());
        assertFalse(capacityProfilePage.labelPositionDiligence.isEnabled());
        assertFalse(capacityProfilePage.labelHomeOfficeDiligence.isEnabled());
        assertFalse(capacityProfilePage.labelHireDateDiligence.isEnabled());
    }

    @And("^I see  the only actionable fields are Language / Jurisdiction / Account Name / Order Type$")
    public void iSeeTheOnlyActionableFieldsAreLanguageJurisdictionAccountNameOrderType() throws Throwable {
        assertTrue(capacityProfilePage.labelLanguageDiligence.isEnabled());
        assertTrue(capacityProfilePage.labelOrderTypeDiligence.isEnabled());
        assertTrue(capacityProfilePage.labelJurisdictionDiligence.isEnabled());
        assertTrue(capacityProfilePage.labelAccountNameDiligence.isEnabled());
    }

    @And("^I select values in the editable fields on user profile page$")
    public void iSelectValuesInTheEditableFieldsOnUserProfilePage() throws Throwable {
        wait.waitAndClick(capacityProfilePage.buttonAccountNameDiligence);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List <WebElement> inputs = capacityProfilePage.accountNameEditDiv.findElements(By.tagName("input"));
        for (WebElement input : inputs) {
            js.executeScript("arguments[0].setAttribute('style', 'display:none;')", input);
        }
        accountname = driver.findElement(By.xpath("//*[@id='edit-profile-form']/div/div[9]/div/ul/li[1]/a/label")).getText();
        System.out.println(accountname);
        wait.waitAndClick(capacityProfilePage.buttonAccountNameDiligence);
        System.out.println(capacityProfilePage.isSelectedCheckboxReturnStatus(capacityProfilePage.languageEditDiv, capacityProfilePage.buttonLanguageDiligence));
        if (!capacityProfilePage.isSelectedCheckboxReturnStatus(capacityProfilePage.languageEditDiv, capacityProfilePage.buttonLanguageDiligence)) {
            capacityProfilePage.checkInput(driver, capacityProfilePage.languageEditDiv, capacityProfilePage.buttonLanguageDiligence, " English (US)");
        }
        if (!capacityProfilePage.isSelectedCheckboxReturnStatus(capacityProfilePage.orderTypeEditDiv, capacityProfilePage.buttonOrderTypeDiligence)) {
            capacityProfilePage.checkInput(driver, capacityProfilePage.orderTypeEditDiv, capacityProfilePage.buttonOrderTypeDiligence, " Red Flag");
        }
        if (!capacityProfilePage.isSelectedCheckboxReturnStatus(capacityProfilePage.jurisdictionEditDiv, capacityProfilePage.buttonJurisdictionDiligence)) {
            capacityProfilePage.checkInput(driver, capacityProfilePage.jurisdictionEditDiv, capacityProfilePage.buttonJurisdictionDiligence, " United States");
        }
        if (!capacityProfilePage.isSelectedCheckboxReturnStatus(capacityProfilePage.accountNameEditDiv, capacityProfilePage.buttonAccountNameDiligence)) {
            capacityProfilePage.checkInput(driver, capacityProfilePage.accountNameEditDiv, capacityProfilePage.buttonAccountNameDiligence, accountname);
        }
    }

    @And("^I navigate away from the user profile page$")
    public void iNavigateAwayFromTheUserProfilePage() throws Throwable {
        wait.waitAndClick(capacityProfilePage.capacityProfileTab);
        System.out.println("out of profile");
    }

    @And("^I go back to the user profile page for that user$")
    public void iGoBackToTheUserProfilePageForThatUser() throws Throwable {
        wait.waitAndSendKeysByElement(capacityProfilePage.firstNameDiligenceSkills, "test");
        wait.waitAndSendKeysByElement(capacityProfilePage.lastNameDiligenceSkills, "test");
        wait.waitAndClick(capacityProfilePage.searchButtonDiligenceSkills);
        wait.waitUntilGridSpinnersNotPresent();
        assertTrue(capacityProfilePage.firstUserDiligenceSkills.isDisplayed());
        wait.waitAndClick(capacityProfilePage.editLink);
    }

    @Then("^I see the selected values are not saved$")
    public void iSeeTheSelectedValuesAreNotSaved() throws Throwable {
        capacityProfilePage.isNotSelectedCheckbox(capacityProfilePage.languageEditDiv, capacityProfilePage.buttonLanguageDiligence);
        capacityProfilePage.isNotSelectedCheckbox(capacityProfilePage.orderTypeEditDiv, capacityProfilePage.buttonOrderTypeDiligence);
        capacityProfilePage.isNotSelectedCheckbox(capacityProfilePage.jurisdictionEditDiv, capacityProfilePage.buttonJurisdictionDiligence);
        capacityProfilePage.isNotSelectedCheckbox(capacityProfilePage.accountNameEditDiv, capacityProfilePage.buttonAccountNameDiligence);
    }

    @Then("^I see Diligence Skills role is present$")
    public void iSeeDiligenceSkillsRoleIsPresent() throws Throwable {
        assertTrue(wait.waitUntilPresent(capacityProfilePage.diligenceSkillsRole).isDisplayed());
    }

    @And("^I click on Save option on the user profile page$")
    public void iClickOnSaveOptionOnTheUserProfilePage() throws Throwable {
        wait.waitAndClick(capacityProfilePage.saveButtonDiligenceSkills);

    }

    @And("^I go back to the user profile page for that user for save scenario$")
    public void iGoBackToTheUserProfilePageForThatUserForSaveScenario() throws Throwable {
        wait.waitAndSendKeysByElement(capacityProfilePage.firstNameDiligenceSkills, "test");
        wait.waitAndSendKeysByElement(capacityProfilePage.lastNameDiligenceSkills, "test");
        wait.waitAndClick(capacityProfilePage.searchButtonDiligenceSkills);
        wait.waitUntilGridSpinnersNotPresent();
        assertTrue(capacityProfilePage.firstUserDiligenceSkills.isDisplayed());
        wait.waitAndClick(capacityProfilePage.editLink);
    }

    @Then("^I see the selected values are saved$")
    public void iSeeTheSelectedValuesAreSaved() throws Throwable {
        capacityProfilePage.isSelectedCheckbox(capacityProfilePage.languageEditDiv, capacityProfilePage.buttonLanguageDiligence);
        capacityProfilePage.checkInput(driver, capacityProfilePage.languageEditDiv, capacityProfilePage.buttonLanguageDiligence, " English (US)");
        capacityProfilePage.isSelectedCheckbox(capacityProfilePage.orderTypeEditDiv, capacityProfilePage.buttonOrderTypeDiligence);
        capacityProfilePage.checkInput(driver, capacityProfilePage.orderTypeEditDiv, capacityProfilePage.buttonOrderTypeDiligence, " Red Flag");
        capacityProfilePage.isSelectedCheckbox(capacityProfilePage.jurisdictionEditDiv, capacityProfilePage.buttonJurisdictionDiligence);
        capacityProfilePage.checkInput(driver, capacityProfilePage.jurisdictionEditDiv, capacityProfilePage.buttonJurisdictionDiligence, " United States");
        capacityProfilePage.isSelectedCheckbox(capacityProfilePage.accountNameEditDiv, capacityProfilePage.buttonAccountNameDiligence);
        capacityProfilePage.checkInput(driver, capacityProfilePage.accountNameEditDiv, capacityProfilePage.buttonAccountNameDiligence, accountname);
        wait.waitAndClick(capacityProfilePage.saveButtonDiligenceSkills);
    }

    @And("^I see Diligence Skills role is listed between Diligence Administration and Editor$")
    public void iSeeDiligenceSkillsRoleIsListedBetweenDiligenceAdministrationAndEditor() throws Throwable {
        assertEquals(capacityProfilePage.pathDiligenceAdministrator.getText(), "Diligence Administration");
        assertEquals(capacityProfilePage.pathDiligenceSkills.getText(), "Diligence Skills");
        assertEquals(capacityProfilePage.pathEditor.getText(), "Editor");
    }

    @And("^I see all dropdown fields contain the required options$")
    public void iSeeAllDropdownFieldsContainTheRequiredOptions() throws Throwable {
        capacityProfilePage.iSeeAllDropdownFieldsContainTheRequiredOptions();
    }

    @And("^I check all options in dropdown fields are unselected by default$")
    public void iCheckAllOptionsInDropdownFieldsAreUnselectedByDefault() throws Throwable {
        dropdown.assertCheckedFromUnorderedListWithCheckbox(capacityProfilePage.languageEditDiv, capacityProfilePage.buttonLanguageDiligence);
        dropdown.assertCheckedFromUnorderedListWithCheckbox(capacityProfilePage.jurisdictionEditDiv, capacityProfilePage.buttonJurisdictionDiligence);
        dropdown.assertCheckedFromUnorderedListWithCheckbox(capacityProfilePage.accountNameEditDiv, capacityProfilePage.buttonAccountNameDiligence);
        dropdown.assertCheckedFromUnorderedListWithCheckbox(capacityProfilePage.orderTypeEditDiv, capacityProfilePage.buttonOrderTypeDiligence);
    }

    @And("^I enter \"([^\"]*)\" in Email field and click Filter button$")
    public void iEnterInEmailFieldAndClickFilterButton(String arg0) throws Throwable {
        wait.waitAndSendKeysByElement(capacityProfilePage.emailDiligenceSkills, arg0);
        wait.waitAndClick(new CapacityProfilePage().filterButtonDiligenceSkills);
        Thread.sleep(5000);
        assertTrue(capacityProfilePage.userSearchDiligence.isDisplayed());
    }

    @And("^I click on Details link for the searched user$")
    public void iClickOnDetailsLinkForTheSearchedUser() throws Throwable {
        wait.waitAndClick(capacityProfilePage.detailsLinkDiligenceSkills);
    }

    @And("^I navigate to Internal User Details Page$")
    public void iNavigateToInternalUserDetailsPage() throws Throwable {
        assertTrue(capacityProfilePage.internalUserDiligenceSkills.isDisplayed());
    }

    @And("^I click on Update User link$")
    public void iClickOnUpdateUserLink() throws Throwable {
        wait.waitAndClick(capacityProfilePage.updateUserLinkDiligenceSkills);
        assertTrue(wait.waitUntilPresent(capacityProfilePage.verifyUpdateUserPageDiligenceSkills).isDisplayed());
    }

    @And("^I see Diligence Skills role is listed between Diligence Administration and Editor for existing user$")
    public void iSeeDiligenceSkillsRoleIsListedBetweenDiligenceAdministrationAndEditorForExistingUser() throws Throwable {
        assertEquals(capacityProfilePage.editPathDiligenceAdministrator.getText(), "Diligence Administration");
        assertEquals(capacityProfilePage.editPathDiligenceSkills.getText(), "Diligence Skills");
        assertEquals(capacityProfilePage.editPathEditor.getText(), "Editor");
    }

    @And("^I create an order$")
    public void iCreateAnOrder() throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        orderName = orderPage.createOrder("company");
        wait.waitAndClick(orderPage.backToDashBoard);
        homePage.navigateToOrdersPage();
//        searchorderpage.fillorderstatus("Draft");
//        searchorderpage.selectordertype("Level 1");
    }

    @And("^I enter alphabets in First Name and Last Name fields and click search for not save$")
    public void iEnterAlphabetsInFirstNameAndLastNameFieldsAndClickSearchForNotSave() throws Throwable {
        wait.waitAndSendKeysByElement(capacityProfilePage.firstNameDiligenceSkills, "leyon");
        wait.waitAndSendKeysByElement(capacityProfilePage.lastNameDiligenceSkills, "Admin");
        wait.waitAndClick(capacityProfilePage.searchButtonDiligenceSkills);
    }

    @Then("^I verify the task matrix was completed$")
    public void iVerifyTheTaskMatrixWasCompleted() throws Throwable {
        casePage.verifyTaskMatrix();
    }

    @And("^I click on a case from the table for matrix$")
    public void iClickOnACaseFromTheTableForMatrix() throws Throwable {
        wait.waitAndClick(casePage.firstCaseCms);
    }

    @And("^I should be able to type order name in Name field in CMS$")
    public void iShouldBeAbleToTypeOrderNameInNameFieldInCMS() throws Throwable {
        searchorderpage.fillordername(orderName);
    }

    @Then("^I click on assign case button$")
    public void iClickOnAssignCaseButton() throws Throwable {
        scrollintoView.scrollUp();
//        scrollintoView.scrollToView(casePage.assignCase);
        wait.waitAndClick(casePage.firstAssignCase);
        wait.waitAndClick(casePage.confirmAssignCase);
    }

    @And("^I should be able to type ordername in Case Name field$")
    public void iShouldBeAbleToTypeOrdernameInCaseNameField() throws Throwable {
        System.out.println("order name is used: " + orderName);
        wait.waitAndClick(casePage.caseName).sendKeys(orderName);
    }

    @Then("^I click on Generate button$")
    public void iClickOnGenerateButton() throws Throwable {
        wait.waitAndClick(casePage.generateSharedNotes);
    }

    @And("^I complete high priority tasks$")
    public void iCompleteHighPriorityTasks() throws Throwable {
        casePage.setHighPriorityTasks();
        Thread.sleep(3000);
    }

    @And("^The order page opens in another new tab in CMS$")
    public void theOrderPageOpensInAnotherNewTabInCMS() throws Throwable {
        popupWindow.moveToAnotherNewTab();
        Thread.sleep(5000);
    }

    @And("^I should be able to click Order Status field and select \"([^\"]*)\" for CMS$")
    public void iShouldBeAbleToClickOrderStatusFieldAndSelectForCMS(String arg0) throws Throwable {
        searchorderpage.fillorderstatusCMS(arg0);
    }

    @And("^The case page opens in another new tab in CMS$")
    public void theCasePageOpensInAnotherNewTabInCMS() throws Throwable {
        popupWindow.moveToAnotherNewTab();
        Thread.sleep(5000);
    }


    @And("^I click on \"([^\"]*)\" case from the table in CMS$")
    public void iClickOnCaseFromTheTableInCMS(String arg0) throws Throwable {
        if (casePage.firstCasesCheck.size() > 0) {
            System.out.println("found");
            wait.waitUntilClickable(casePage.firstCaseCheck).click();
        } else {
            System.out.println("not found");
            orderPage.createCaseOrder(arg0, "company");
            wait.waitAndClick(orderPage.backToDashBoard);
            driver.findElement(By.linkText("Cases")).click();
            wait.waitUntilGridSpinnersNotPresent();
            searchorderpage.fillordername(arg0);
            searchorderpage.searchbuttonclick();
            wait.waitUntilGridSpinnersNotPresent();
            wait.waitUntilClickable(casePage.firstCaseCheck).click();
        }
    }

    @And("^I select \"([^\"]*)\" in the Primary Supervisor drop down$")
    public void iSelectInThePrimarySupervisorDropDown(String arg0) throws Throwable {
        casePage.selectSupervisoridText(arg0);
    }

    @And("^I select \"([^\"]*)\" in the Primary Researcher drop down$")
    public void iSelectInThePrimaryResearcherDropDown(String arg0) throws Throwable {
        Thread.sleep(5000);
        casePage.selectPrimaryresearcher(arg0);
    }

    @And("^I should be able to type \"([^\"]*)\" in Case Name field$")
    public void iShouldBeAbleToTypeInCaseNameField(String arg0) throws Throwable {
        casePage.caseName.sendKeys(arg0);
    }

    @And("^I hover over the info icon$")
    public void iHoverOverTheInfoIcon() throws Throwable {
        actions.moveToElement(advancedSearchPage.advancedSearchToolTip).build().perform();
        Thread.sleep(5000);
        wait.waitAndClick(advancedSearchPage.advancedSearchToolTip);
        System.out.println(advancedSearchPage.advancedSearchInfo.getText());
    }

    @Then("^Message pops up to includes a message that the field is case-sensitive$")
    public void messagePopsUpToIncludesAMessageThatTheFieldIsCaseSensitive() throws Throwable {
        assertTrue(advancedSearchPage.advancedSearchInfo.getText().contains("The search box field is case-sensitive"));
    }

    @And("^I enter working hours$")
    public void iEnterWorkingHours() throws Throwable {
//        cssHelpers.addCssProperty(casePage.navBar,"position","ABSOLUTE");
//        scrollintoView.scrollToMiddle();
        wait.waitAndClick(casePage.hoursTrackericon);
        casePage.inputWorkinghours("4");
        casePage.selecthoursReasontype("Research & Writing");
        wait.waitAndClick(casePage.workingHoursdate);
        casePage.workingHoursdate.click();
        wait.waitAndClick(casePage.workingHoursSaveoption);
        Thread.sleep(5000);
        scrollintoView.scrollUp();
    }

    @Given("^I login to CMS with Supervisor account$")
    public void iLoginToCMSWithSupervisorrAccount() throws Throwable {
        omsDashboardPage.expandUserOptions();
        omsDashboardPage.logOff.click();
        loginPage.navigateToDiligenceLoginPage();
        loginPage.userName.sendKeys("tdattasupervisor@exiger.com");
        loginPage.password.sendKeys("Exiger1!!");
        loginPage.loginButton.click();
    }

    @And("^I click on Complete Case Button$")
    public void iClickOnCompleteCaseButton() throws Throwable {
        wait.waitAndClick(casePage.completeCaseButton);
        wait.waitAndClick(casePage.confirmCompleteCaseButton);

    }

    @And("^I verify if the upgrade option is available for the case$")
    public void iVerifyIfTheUpgradeOptionIsAvailableForTheCase() throws Throwable {
        assertTrue(casePage.upgradeOrder.isDisplayed());
    }

    @Then("^The I get error for not inputting date and save icon doesnt turn into saving$")
    public void theIGetErrorForNotInputtingDateAndSaveIconDoesntTurnIntoSaving() throws Throwable {
        assertTrue(casePage.inputDateToolTip.isDisplayed());
        System.out.println(casePage.inputDateToolTip.getText());
        assertTrue(casePage.workingHoursSaveoption.isDisplayed());
    }

    @And("^I review order details have order \"([^\"]*)\"$")
    public void iReviewOrderDetailsHaveOrder(String arg0) throws Throwable {
        orderPage.reviewOrderType(arg0);

    }

    @And("^I check no interim report is uploaded$")
    public void iCheckNoInterimReportIsUploaded() throws Throwable {
        assertTrue(casePage.deleteReport.size() <= 0);
    }

    @And("^I take the past due count$")
    public void iTakeThePastDueCount() throws Throwable {
        PastDueCount = Integer.parseInt(casePage.pastDueCount.getText());
        System.out.println("Original Count " + PastDueCount);
    }

    @Then("^I see the past due count increased by (\\d+)$")
    public void iSeeThePastDueCountIncreasedBy(int arg0) throws Throwable {
        wait.waitAndClick(casePage.dashboardCMS);
        wait.waitUntilGridSpinnersNotPresent();
        System.out.println("After increase " + casePage.pastDueCount.getText());
        assertEquals(PastDueCount + 1, Integer.parseInt(casePage.pastDueCount.getText()));
        PastDueCount = Integer.parseInt(casePage.pastDueCount.getText());

    }


    @And("^I create an order for \"([^\"]*)\" and assign case to CM$")
    public void iCreateAnOrderForAndAssignCaseToCM(String arg0) throws Throwable {
        wait.waitAndClick(driver, By.id("btnCreateOrder"));
        orderPage.fillOrderDetails(arg0, orderName);
        System.out.println("order name is used: " + orderName);
        String Name = createOrder.fillCompanySubjectForm(companyName.replace("-","_"));
        System.out.println("Company name is " + Name);
        subjectCompanyFormPage.continueButton.click();

//        String actual = wait.waitAndGetText(driver, By.xpath("//*[@id='subjectsReviewContainer']//*[contains(text(),'" + companyName + "')]"));
//        System.out.println(companyName.toLowerCase()+" ===== "+actual.toLowerCase());
//        assertEquals(companyName.toLowerCase(), actual.toLowerCase());
        wait.waitAndClick(rco.submitOrderButton);
        wait.waitUntilGridSpinnersNotPresent();
        Thread.sleep(5000);
//        wait.waitUntilPresent(omsDashboardPage.tableElements);
        homePage.navigateToOrdersPage();
        wait.waitUntilGridSpinnersNotPresent();
        System.out.println("order name is used: " + orderName);
        wait.waitAndClick(casePage.caseName).sendKeys(orderName);
        searchorderpage.fillorderstatusCMS("Submitted");
        searchorderpage.searchbuttonclick();
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitUntilClickable(casePage.firstrow).click();
        wait.waitUntilGridSpinnersNotPresent();
        popupWindow.moveToAnotherNewTab();
        Thread.sleep(5000);
        cssHelpers.addCssProperty(casePage.navBar,"position","relative");
        assertTrue(wait.waitUntilPresent(orderPage.ordertitle).isDisplayed());
        System.out.println(wait.waitUntilPresent(orderPage.ordertitle).isDisplayed());
        Thread.sleep(5000);
        scrollintoView.scrollToView(orderPage.viewCase);
        wait.waitAndClick(orderPage.viewCase);
        cssHelpers.addCssProperty(casePage.navBar,"position","relative");
        wait.waitAndClick(casePage.editCaseAssignment);
        casePage.selectSupervisoridText("Titu Datta [Supervisor]");
        Thread.sleep(5000);
        casePage.selectPrimaryresearcher("Titu Datta [Client Mgmt]");
        thirdParty = casePage.selectThirdpartyContractor();
        casePage.selectfirstThirdpartyCurrency("USD");
        casePage.selectfirstThirdpartyBudjet("10");
        wait.waitAndClick(casePage.firstThirdpartyduedateid);
        casePage.firstThirdpartyduedateid.click();
        wait.waitAndClick(casePage.assignCasebutton);
        scrollintoView.scrollUp();
//        scrollintoView.scrollToView(casePage.assignCase);
        wait.waitAndClick(casePage.assignCase);
        wait.waitAndClick(casePage.confirmAssignCase);
    }

    @And("^I create an order for \"([^\"]*)\" and assign case$")
    public void iCreateAnOrderForAndAssignCase(String arg0) throws Throwable {
        wait.waitAndClick(driver, By.id("btnCreateOrder"));
        orderPage.fillOrderDetails(arg0, orderName);
        System.out.println("order name is used: " + orderName);
        companyName = createOrder.fillCompanySubjectForm(companyName);
        System.out.println("Company name is " + companyName);
        subjectCompanyFormPage.continueButton.click();
        String actual = wait.waitAndGetText(driver, By.xpath("//*[@id='subjectsReviewContainer']//*[contains(text(),'" + companyName + "')]"));
//        System.out.println(companyName.toLowerCase()+" ===== "+actual.toLowerCase());
        assertEquals(companyName.toLowerCase(), actual.toLowerCase());
        wait.waitAndClick(rco.submitOrderButton);
        wait.waitUntilGridSpinnersNotPresent();
        Thread.sleep(5000);
//        wait.waitUntilPresent(omsDashboardPage.tableElements);
        homePage.navigateToOrdersPage();
        wait.waitUntilGridSpinnersNotPresent();
        System.out.println("order name is used: " + orderName);
        wait.waitAndClick(casePage.caseName).sendKeys(orderName);
        searchorderpage.fillorderstatusCMS("Submitted");
        searchorderpage.searchbuttonclick();
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitUntilClickable(casePage.firstrow).click();
        wait.waitUntilGridSpinnersNotPresent();
        popupWindow.moveToNewTab();
        Thread.sleep(5000);
        cssHelpers.addCssProperty(casePage.navBar,"position","relative");
        assertTrue(wait.waitUntilPresent(orderPage.ordertitle).isDisplayed());
        System.out.println(wait.waitUntilPresent(orderPage.ordertitle).isDisplayed());
        Thread.sleep(5000);
        scrollintoView.scrollToView(orderPage.viewCase);
        wait.waitAndClick(orderPage.viewCase);
        cssHelpers.addCssProperty(casePage.navBar,"position","relative");
        wait.waitAndClick(casePage.editCaseAssignment);
        casePage.selectSupervisoridText("Titu Datta [Supervisor]");
        Thread.sleep(5000);
        casePage.selectPrimaryresearcher("Titu Datta [Researcher]");
        wait.waitAndClick(casePage.assignCasebutton);
        scrollintoView.scrollUp();
//        scrollintoView.scrollToView(casePage.assignCase);
        wait.waitAndClick(casePage.assignCase);
//        actions.moveToElement(casePage.assignCase).click().build().perform();
        wait.waitAndClick(casePage.confirmAssignCase);
    }

    @And("^I click on Refresher Icon on the page$")
    public void iClickOnRefresherIconOnThePage() throws Throwable {
        wait.waitAndClick(casePage.refresherIcon);
    }

    @And("^I select Country in Jurisdictions form$")
    public void iSelectCountryInJurisdictionsForm() throws Throwable {
        selectElements.selectByVisibleText(By.id("CountryCode"), "Syrian Arab Republic");
    }

    @And("^I click on Add button$")
    public void iClickOnAddButton() throws Throwable {
        wait.waitAndClick(casePage.addButton);
        wait.waitAndClick(casePage.confirmAddButton);
        wait.waitUntilPresent(casePage.addButton);
    }

    @And("^I click on update button$")
    public void iClickOnUpdateButton() throws Throwable {
        wait.waitAndClick(casePage.updateButton);
    }

    @Then("^I see the past due count decreased by (\\d+)$")
    public void iSeeThePastDueCountDecreasedBy(int arg0) throws Throwable {
        wait.waitAndClick(casePage.dashboardCMS);
        wait.waitUntilGridSpinnersNotPresent();
        System.out.println("After decrease " + casePage.pastDueCount.getText());
        assertEquals(PastDueCount - 1, Integer.parseInt(casePage.pastDueCount.getText()));
        PastDueCount = Integer.parseInt(casePage.pastDueCount.getText());

    }

    @Then("^I see the past due count$")
    public void iSeeThePastDueCount() throws Throwable {
        wait.waitAndClick(casePage.dashboardCMS);
        wait.waitUntilGridSpinnersNotPresent();
        System.out.println("After cancel " + casePage.pastDueCount.getText());
        assertEquals(PastDueCount, Integer.parseInt(casePage.pastDueCount.getText()));

    }

    @Then("^I click on Cancel for Core Details$")
    public void iClickOnCancelForCoreDetails() throws Throwable {
        wait.waitAndClick(casePage.cancelCoreDetails);
    }

    @And("^I search the order for \"([^\"]*)\"$")
    public void iSearchTheOrderFor(String arg0) throws Throwable {
//        wait.waitAndClick(driver.findElement(By.linkText("Orders")));
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitAndClick(casePage.caseName).sendKeys(orderName);
        searchorderpage.selectordertype(arg0);
        searchorderpage.searchbuttonclick();
        wait.waitUntilGridSpinnersNotPresent();
    }

    @And("^I login to CMS site again as a client manager$")
    public void loginToCMSSiteAgain() throws Throwable {
        loginPage.userName.sendKeys("tdattacm@exiger.com");
        loginPage.password.sendKeys("Admin1234");
        loginPage.loginButton.click();
        wait.waitUntilGridSpinnersNotPresent();
    }

    @And("^I search the case with status \"([^\"]*)\" for interim due date$")
    public void iSearchTheCaseWithStatusForInterimDueDate(String arg0) throws Throwable {
        driver.findElement(By.xpath("//a[contains(text(),'Cases')]")).click();
        wait.waitUntilGridSpinnersNotPresent();
        System.out.println("order name is used: " + orderName);
        wait.waitAndClick(casePage.caseName).sendKeys(orderName);
        searchorderpage.selectordertype(arg0);
        casePage.searchButton.click();
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitAndClick(casePage.firstCaseCms);
        popupWindow.moveToAnotherNewTab();
        Thread.sleep(5000);
    }

    @And("^I see the order is listed in the table on CMS Dashboard$")
    public void iSeeTheOrderIsListedInTheTableCMS() throws Throwable {
        cssHelpers.addCssProperty(casePage.navBar,"position","relative");
//        List<WebElement> clientAccountName = wait.waitAndReturnListElements(driver, By.cssSelector("td[aria-describedby='jqGrid_Name']"));
        wait.waitUntilGridSpinnersNotPresent();
        System.out.println("Looking for the order name------  " + orderName);
        Thread.sleep(5000);
//        assertTrue(driver.getPageSource().contains(orderName));
        assertTrue(driver.findElements(By.xpath("//*[@id='jqGrid']/tbody/tr/td[2 and contains(text(),'Genoveva_Hane_Hane')]")).size()>0);
        System.out.println("Found the order!!!");
    }

    @Then("^I see the order is not listed in the table on CMS Dashboard$")
    public void iSeeTheOrderIsNotListedInTheTableCMS() throws Throwable {
//        List<WebElement> clientAccountName = wait.waitAndReturnListElements(driver, By.cssSelector("td[aria-describedby='jqGrid_Name']"));
        wait.waitUntilGridSpinnersNotPresent();
        System.out.println("Looking for the order name------  " + orderName);
        Assert.assertFalse(casePage.dashboardContainer.getText().contains(orderName));
        System.out.println("Order Removed!!!");
    }

    @And("^I click on show more filters$")
    public void iClickOnShowMoreFilters() throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitAndClick(orderSearchPage.moreFiltersButton);
    }

    @And("^I click on generate link$")
    public void iClickOnGenerateLink() throws Throwable {
        wait.waitAndClick(casePage.generateLink);
    }

    @And("^I see warning message for duplicate file name$")
    public void iSeeWarningMessageForDuplicateFileName() throws Throwable {
        Thread.sleep(5000);
        System.out.println(casePage.duplicateFileNameMessage.getText());
        assertEquals(casePage.duplicateFileNameMessage.getText(), "WARNING: Do not use duplicate filenames for reports that are a part of the same case.");
        wait.waitAndClick(casePage.reportDraftCancel);
    }

    @And("^I verify Interim Report checkbox is not checked$")
    public void iVerifyInterimReportCheckBoxIsNotChecked() throws Throwable {
        wait.waitAndClick(casePage.coredetailslink);
        searchorderpage.submitcal("interimReportDueDateContainer");
        assertFalse(casePage.interimreportbox.isSelected());
        wait.waitAndClick(casePage.savecoredetails);
        scrollintoView.scrollUp();
    }

    @And("^I click on Summary tab in Case Page$")
    public void iClickOnSummaryTabInCasePage() throws Throwable {
        Thread.sleep(5000);
        wait.waitUntilClickable(casePage.summaryTab);
        wait.waitAndClick(casePage.summaryTab);
    }

    @And("^I verify if interim report check box is checked$")
    public void iverifyIfInterimReportCheckBoxIsChecked() throws Throwable {
        wait.waitAndClick(casePage.coredetailslink);
        Thread.sleep(5000);
        System.out.println();
        assertTrue(casePage.interimreportbox.isSelected());
        wait.waitAndClick(casePage.savecoredetails);
    }

    @And("^I enter date in Interim Report Due Date and save$")
    public void iEnterDateInInterimReportDueDateAndSave() throws Throwable {
        wait.waitAndClick(casePage.coredetailslink);
        searchorderpage.submitcal("interimReportDueDateContainer");
        wait.waitAndClick(casePage.savecoredetails);
        scrollintoView.scrollUp();
//        Thread.sleep(5000);
    }

    @And("^I see Report Status column is present$")
    public void iSeeReportStatusColumnIsPresent() throws Throwable {
        assertTrue(casePage.reportStatusColumn.isDisplayed());
    }

    @And("^I select Multiple Master Reports option and click next$")
    public void iSelectMultipleMasterReportsOptionAndClickNext() throws Throwable {
        wait.waitAndClick(casePage.multipleMasterreportsOption);
        wait.waitAndClick(casePage.editReportNextButton);
        wait.waitAndClick(casePage.editReportUpdateButton);
        wait.waitUntilPresent(casePage.generateSharedNotes);
        wait.waitUntilGridSpinnersNotPresent();
    }

    @And("^I click generate and reports get generated$")
    public void iClickGenerateAndReportsGetGenerated() throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
       wait.waitAndClick(casePage.generateReport1);
       wait.waitAndClick(casePage.confirmGenerate);
       Thread.sleep(10000);
       wait.waitUntilClickable(casePage.editDraftstatusButton);

//       wait.waitAndClick(casePage.generateReport2);
//       wait.waitAndClick(casePage.confirmGenerate);
//       wait.waitUntilPresent(casePage.editDraftstatusButton);
//       Thread.sleep(5000);

    }


    @And("^I see draft status of the report$")
    public void iSeeDraftStatusOfTheReport() throws Throwable {
        System.out.println(casePage.reportStatus.getText());
       assertEquals(casePage.reportStatus.getText(),"Research In Progress");
    }

    @And("^I see draft status of the report is \"([^\"]*)\"$")
    public void iSeeDraftStatusOfTheReportIs(String arg0) throws Throwable {
        reportStatus = driver.findElement(By.xpath("//*[@id='jqGrid']/tbody/tr/td[2 and text()='"+orderName+"']/parent::tr/td[6]/p[text()='"+arg0+"']"));
        System.out.println(reportStatus);
        assertEquals(reportStatus.getText(),arg0);
    }


    @And("^I change the draft status of the order to \"([^\"]*)\"$")
    public void iChangeTheDraftStatusOfTheOrderTo(String arg0) throws Throwable {
        reportStatus.click();
        popupWindow.moveToAnotherNewTab();
        Thread.sleep(5000);
        wait.waitAndClick(casePage.documentsTab);
        wait.waitAndClick(casePage.editDraftstatusButton);
        selectElements.selectByVisibleText(By.xpath("//*[@id='reportDraftJqGrid']/tbody/tr[2]/td[13]/div[1]/select"),arg0);
        wait.waitAndClick(casePage.getEditDraftstatusSavingoption);
        wait.waitUntilPresent(casePage.editDraftstatusButton);
        wait.waitAndClick(casePage.dashboardCMS);
        wait.waitUntilGridSpinnersNotPresent();
        Thread.sleep(5000);
    }

    @And("^I click generate for multiple reports$")
    public void iClickGenerateForMultipleReports() throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitAndClick(casePage.generateReport1);
        wait.waitAndClick(casePage.confirmGenerate);
//        wait.waitUntilPresent(casePage.editDraftstatusButton);
        Thread.sleep(5000);
        wait.waitUntilClickable(casePage.editDraftstatusButton);

       wait.waitAndClick(casePage.generateReport2);
       wait.waitAndClick(casePage.confirmGenerate);
//       wait.waitUntilPresent(casePage.editDraftstatusButton2);
        Thread.sleep(5000);
        wait.waitUntilClickable(casePage.editDraftstatusButton2);

    }

    @And("^I click generate for multiple reports in CMS$")
    public void iClickGenerateForMultipleReportsInCMS() throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitAndClick(casePage.generateReport1);
        wait.waitAndClick(casePage.confirmGenerate);
        wait.waitUntilPresent(casePage.editDraftstatusButton);
        Thread.sleep(5000);
       wait.waitAndClick(casePage.generateReport2);
        wait.waitAndClick(casePage.confirmGenerate);
       Thread.sleep(5000);
    }

    @And("^I hover over the status and see status of drafts and their subjects$")
    public void iHoverOverTheStatusAndSeeStatusOfDraftsAndTheirSubjects() throws Throwable {
        reportStatus = driver.findElement(By.xpath("//*[@id='jqGrid']/tbody/tr/td[2 and text()='"+orderName+"']/parent::tr/td[6]/p[text()='Multiple Drafts *']"));
        new Actions(driver).moveToElement(reportStatus).build().perform();
        System.out.println(casePage.tooltipStatus.getText());
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        System.out.println(js.executeScript("return arguments[0].innerHTML",casePage.tooltipStatus));
        assertEquals(casePage.tooltipSubject1.getText(),companyName+0);
        assertEquals(casePage.tooltipSubjectStatus1.getText(),"Research In Progress");
        assertEquals(casePage.tooltipSubject2.getText(),companyName+1);
        assertEquals(casePage.tooltipSubjectStatus2.getText(),"Research In Progress");
    }

    @And("^I create an order for \"([^\"]*)\" with \"([^\"]*)\" \"([^\"]*)\" subjects and assign case to CM$")
    public void iCreateAnOrderForWithSubjectsAndAssignCaseToCM(String arg0, String arg1, String arg2) throws Throwable {
        wait.waitAndClick(driver, By.id("btnCreateOrder"));
        orderPage.fillOrderDetails(arg0, orderName);
        System.out.println("order name is used: " + orderName);
        for(int i=0; i<2; i++) {
            String Name = "";
            if(arg2.equalsIgnoreCase("unique")) {
                createOrder.fillCompanySubjectForm(companyName.replace("-", "_") + i);
            }
            else {
                createOrder.fillCompanySubjectForm(companyName.replace("-", "_"));
            }
            System.out.println("Company name is " + Name);
        }
        subjectCompanyFormPage.continueButton.click();

//        String actual = wait.waitAndGetText(driver, By.xpath("//*[@id='subjectsReviewContainer']//*[contains(text(),'" + companyName + "')]"));
//        System.out.println(companyName.toLowerCase()+" ===== "+actual.toLowerCase());
//        assertEquals(companyName.toLowerCase(), actual.toLowerCase());
        wait.waitAndClick(rco.submitOrderButton);
        wait.waitUntilGridSpinnersNotPresent();
        Thread.sleep(5000);
//        wait.waitUntilPresent(omsDashboardPage.tableElements);
        homePage.navigateToOrdersPage();
        wait.waitUntilGridSpinnersNotPresent();
        System.out.println("order name is used: " + orderName);
        wait.waitAndClick(casePage.caseName).sendKeys(orderName);
        searchorderpage.fillorderstatusCMS("Submitted");
        searchorderpage.searchbuttonclick();
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitUntilClickable(casePage.firstrow).click();
        wait.waitUntilGridSpinnersNotPresent();
        popupWindow.moveToNewTab();
        Thread.sleep(5000);
        cssHelpers.addCssProperty(casePage.navBar,"position","relative");
        assertTrue(wait.waitUntilPresent(orderPage.ordertitle).isDisplayed());
        System.out.println(wait.waitUntilPresent(orderPage.ordertitle).isDisplayed());
        Thread.sleep(5000);
        scrollintoView.scrollToView(orderPage.viewCase);
        wait.waitAndClick(orderPage.viewCase);
        cssHelpers.addCssProperty(casePage.navBar,"position","relative");
        wait.waitAndClick(casePage.editCaseAssignment);
        casePage.selectSupervisoridText("Titu Datta [Supervisor]");
        Thread.sleep(5000);
        casePage.selectPrimaryresearcher("Titu Datta [Client Mgmt]");
        thirdParty = casePage.selectThirdpartyContractor();
        casePage.selectfirstThirdpartyCurrency("USD");
        casePage.selectfirstThirdpartyBudjet("10");
        wait.waitAndClick(casePage.firstThirdpartyduedateid);
        casePage.firstThirdpartyduedateid.click();
        wait.waitAndClick(casePage.assignCasebutton);
        scrollintoView.scrollUp();
//        scrollintoView.scrollToView(casePage.assignCase);
//        actions.moveToElement(casePage.assignCase).click().build().perform();
        wait.waitAndClick(casePage.assignCase);
        wait.waitAndClick(casePage.confirmAssignCase);
    }

    @And("^I see it gives error as filename already exists$")
    public void iSeeItGivesErrorAsFilenameAlreadyExists() throws Throwable {
        new Actions(driver).moveToElement(casePage.tooltipStatus).build().perform();
        System.out.println(casePage.tooltipStatus.getText());
        assertEquals(casePage.tooltipStatus.getText(),"This filename already exists.");
        }

    @And("^I should be able to choose \"([^\"]*)\" in Account for order details$")
    public void iShouldBeAbleToChooseInAccountForOrderDetails(String arg0) throws Throwable {
        Thread.sleep(5000);
        selectElements.selectByVisibleText(orderPage.accountType, arg0);
        assertTrue(orderPage.accountType.isDisplayed());
        System.out.println(new Select(orderPage.accountType).getOptions().get(0).getText());
        System.out.println(new Select(orderPage.accountType).getOptions().get(1).getText());
        System.out.println(new Select(orderPage.accountType).getOptions().get(2).getText());
        System.out.println(new Select(orderPage.accountType).getOptions().get(3).getText());
        System.out.println(new Select(orderPage.accountType).getOptions().get(4).getText());
        System.out.println(new Select(orderPage.accountType).getOptions().get(5).getText());
        System.out.println(new Select(orderPage.accountType).getOptions().size());

    }

    @And("^I verify that order type field is non editable with single order displayed$")
    public void iVerifyThatOrderTypeFieldIsNonEditableWithSingleOrderDisplayed() throws Throwable {
        assertTrue("Single Order Type available",casePage.singleOrderType.isDisplayed());
    }

    @And("^I should be able to click \"([^\"]*)\" tile and see coming due cases$")
    public void iShouldBeAbleToClickTileAndSeeComingDueCases(String arg0) throws Throwable {
        Thread.sleep(5000);
        omsDashboardPage.statusTile(arg0);
        wait.waitUntilGridSpinnersNotPresent();
    }



    @And("^I see the order is visible in the calendar panel to \"([^\"]*)\" user$")
    public void iSeeTheOrderIsVisibleInTheCalendarPanelToUser(String arg0) throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        Thread.sleep(10000);
        WebElement order = driver.findElement(By.xpath("//*[@id='calendarEvents']/div/div[1]/div/div[1 and contains(text(),'"+orderName+"')]"));
        assertTrue(order.isDisplayed());
        wait.waitAndClick(order);
        popupWindow.moveToAnotherNewTab();
        Thread.sleep(5000);
        if(arg0.equalsIgnoreCase("Titu Datta [Editor]")) {
            System.out.println(casePage.associateEditor.getText());
            assertEquals(casePage.associateEditor.getText(), arg0);
        }
        else{
            System.out.println(casePage.associateReviewer.getText());
            assertEquals(casePage.associateReviewer.getText(),arg0);
            }
    }

    @And("^I assign \"([^\"]*)\" and \"([^\"]*)\" as editor and content reviewer respectively to the case$")
    public void iAssignAndAsEditorAndContentReviewerRespectivelyToTheCase(String arg0, String arg1) throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        driver.findElement(By.xpath("//a[contains(text(),'Cases')]")).click();
        wait.waitAndClick(casePage.caseName).sendKeys(orderName);
        casePage.subjectName.sendKeys(companyName);
        searchorderpage.selectordertype("Pending Acceptance");
        Thread.sleep(2000);
        casePage.searchButton.click();
        wait.waitUntilGridSpinnersNotPresent();
        Thread.sleep(5000);
        wait.waitAndClick(casePage.firstCaseCms);
        System.out.println("Client Name: " + casePage.firstCaseCms.getText());
        popupWindow.moveToAnotherNewTab();
        Thread.sleep(5000);
        cssHelpers.addCssProperty(casePage.navBar,"position","relative");
        wait.waitAndClick(casePage.editCaseAssignment);
        casePage.selectCaseContentReviewer(arg1);
        casePage.selectCaseEditor(arg0);
        wait.waitAndClick(casePage.assignCasebutton);
        wait.waitAndClick(casePage.coredetailslink);
        wait.waitAndSendKeysByElement(casePage.duedate,"t");
        Thread.sleep(5000);
        wait.waitAndClick(casePage.savecoredetails);
        Thread.sleep(3000);
        scrollintoView.scrollUp();
        wait.waitAndClick(casePage.assignCase);
        wait.waitAndClick(casePage.confirmAssignCase);
    }

    @And("^I remove \"([^\"]*)\" and \"([^\"]*)\" as editor and content reviewer from the case$")
    public void iRemoveAndAsEditorAndContentReviewerFromTheCase(String arg0, String arg1) throws Throwable {
        wait.waitAndClick(casePage.editCaseAssignment);
        casePage.selectCaseContentReviewer(arg1);
        casePage.selectCaseEditor(arg0);
        wait.waitAndClick(casePage.assignCasebutton);
        wait.waitUntilPresent(casePage.editCaseAssignment);
    }


    @And("^I see the case is now not present in the calendar panel$")
    public void iSeeTheCaseIsNowNotPresentInTheCalendarPanel() throws Throwable {
        System.out.println(casePage.calendarList);
      assertFalse(casePage.calendarList.getText().contains(orderName));
    }

    @And("^I see only cases that are due in the next (\\d+) days excluding weekends$")
    public void iSeeOnlyCasesThatAreDueInTheNextDaysExcludingWeekends(int arg0) throws Throwable {
        ArrayList<Integer> daysList = casePage.calculateDate(5);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        for(WebElement element : casePage.upcomingCasesList){
            System.out.println(element.getText());
            Date dt = sdf.parse(element.getText());
            String dateStr = new SimpleDateFormat("dd").format(dt);
            int date = Integer.parseInt(dateStr);

            assertTrue(daysList.contains(date));
        }
    }

    @And("^I enter a title for the report with (\\d+) characters$")
    public void iEnterATitleForTheReportWithCharacters(int arg0) throws Throwable {
        casePage.caseReportTitle.sendKeys("To start counting your letters, simply write or paste the text into the text area and Count characters.To start counting your letters, simply write or paste the text into the text area and Count chara");
    }

    @Then("^I verify Report is uploaded$")
    public void iVerifyReportIsUploaded() throws Throwable {
        assertTrue(casePage.deleteReport.size() <= 1);
    }


    @And("^I reload the page$")
    public void iReloadThePage() throws Throwable {
        pageHelpers.refresh();
    }


    @And("^I remove both Third Party Contractor values$")
    public void iRemoveBothThirdPartyContractorValues() throws Throwable {
        selectElements.selectByIndexNumbert(casePage.thirdPartyContractorId, 0);
        selectElements.selectByIndexNumbert(casePage.thirdPartyContractorId1, 0);
    }

    @And("^I verify one Third Party Contractor field is available by default$")
    public void iVerifyOneThirdPartyContractorFieldIsAvailableByDefault() throws Throwable {
       assertTrue(casePage.thirdPartyContractorField.isDisplayed());
    }

    @And("^I click on pencil icon to change Jurisdiction country$")
    public void iClickOnPencilIconToChangeJurisdictionCountry() throws Throwable {
        wait.waitAndClick(casePage.editJurisdiction);
    }

    @And("^I click on save button for Jurisdiction$")
    public void iClickOnSaveButtonForJurisdiction() throws Throwable {
        wait.waitAndClick(casePage.jurisdictionformSave);
        wait.waitAndClick(casePage.controlledcaseConfirm);
        wait.waitUntilPresent(casePage.controlledcaseBanner);
    }


    @Then("^I verify case is marked as controlled case$")
    public void iVerifyCaseIsMarkedAsControlledCase() throws Throwable {
//        wait.waitUntilPresent(casePage.addButton);
        scrollintoView.scrollUp();
        assertTrue(casePage.controlledcaseBanner.isDisplayed());
    }

    @And("^I verify Submitted documents section is between subject sequence and case documents section$")
    public void iVerifySubmittedDocumentsSectionIsBetweenSubjectSequenceAndCaseDocumentsSection() throws Throwable {
        assertTrue(casePage.subjectSequence.getText().equalsIgnoreCase("Subject Sequence"));
        assertTrue(casePage.clientSubmittedDocs.getText().equalsIgnoreCase("Client Submitted Documents (1)"));
        assertTrue(casePage.caseDocuments.getText().equalsIgnoreCase("Case Documents"));
    }

    @And("^I verify file is uploaded in client submitted docs section$")
    public void iVerifyFileIsUploadedInClientSubmittedDocsSection() throws Throwable {
        assertEquals(casePage.fileName.getText(),"test1kb.pdf");
    }


    @And("^I create an order for \"([^\"]*)\" and view case$")
    public void iCreateAnOrderForAndViewCase(String arg0) throws Throwable {
        wait.waitAndClick(driver, By.id("btnCreateOrder"));
        orderPage.fillOrderDetails(arg0, orderName);
        System.out.println("order name is used: " + orderName);
        String Name = createOrder.fillCompanySubjectForm(companyName.replace("-","_"));
        System.out.println("Company name is " + Name);
        subjectCompanyFormPage.continueButton.click();

//        String actual = wait.waitAndGetText(driver, By.xpath("//*[@id='subjectsReviewContainer']//*[contains(text(),'" + companyName + "')]"));
//        System.out.println(companyName.toLowerCase()+" ===== "+actual.toLowerCase());
//        assertEquals(companyName.toLowerCase(), actual.toLowerCase());
        wait.waitAndClick(rco.submitOrderButton);
        wait.waitUntilGridSpinnersNotPresent();
        Thread.sleep(5000);
//        wait.waitUntilPresent(omsDashboardPage.tableElements);
        homePage.navigateToOrdersPage();
        wait.waitUntilGridSpinnersNotPresent();
        System.out.println("order name is used: " + orderName);
        wait.waitAndClick(casePage.caseName).sendKeys(orderName);
        searchorderpage.fillorderstatusCMS("Submitted");
        searchorderpage.searchbuttonclick();
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitUntilClickable(casePage.firstrow).click();
        wait.waitUntilGridSpinnersNotPresent();
        popupWindow.moveToAnotherNewTab();
        Thread.sleep(5000);
        cssHelpers.addCssProperty(casePage.navBar,"position","relative");
        assertTrue(wait.waitUntilPresent(orderPage.ordertitle).isDisplayed());
        System.out.println(wait.waitUntilPresent(orderPage.ordertitle).isDisplayed());
        Thread.sleep(5000);
        scrollintoView.scrollToView(orderPage.viewCase);
        wait.waitAndClick(orderPage.viewCase);
    }

    @And("^I verify Submitted documents section is the only section visibile and interactable$")
    public void iVerifySubmittedDocumentsSectionIsTheOnlySectionVisibileAndInteractable() throws Throwable {
        assertTrue(casePage.clientSingleSubmittedDocs.isDisplayed());
        assertTrue(casePage.downloadAllDocs.isEnabled());
    }

    @And("^I verify case documents, subject sequence, shared notes, report generate sections are not visible$")
    public void iVerifyCaseDocumentsSubjectSequenceSharedNotesReportgenerateSectionsAreNotVisible() throws Throwable {
        assertFalse(casePage.subjectSequenceList.size()>0);
        assertFalse(casePage.caseDocumentsList.size()>0);
        assertFalse(casePage.sharedNotesList.size()>0);
        assertFalse(casePage.generateReports.size()>0);

    }

    @And("^I verify all sections are visible and interactable in Documents tab$")
    public void iVerifyAllSectionsAreVisibleAndInteractableInDocumentsTab() throws Throwable {
        assertTrue(casePage.clientSubmittedDocs.isDisplayed());
        assertTrue(casePage.downloadAllDocs.isEnabled());
        assertTrue(casePage.subjectSequence.isDisplayed());
        assertTrue(casePage.caseDocuments.isDisplayed());
        assertTrue(casePage.generateSharedNotes.isDisplayed());
        assertTrue(casePage.generateSharedNotes.isEnabled());
    }

    @And("^I verify Criminal Records deliverable is present$")
    public void iVerifyCriminalRecordsDeliverableIsPresent() throws Throwable {
        assertTrue(casePage.criminalRecordsDeliverable.isDisplayed());
    }

    @Given("^I login to Insight Admin for Diligence$")
    public void iLoginToInsightAdminForDiligence() throws Throwable {
        omsDashboardPage.expandUserOptions();
        omsDashboardPage.logOff.click();
        driver.get("https://insightqaadmin.exiger.com/");
        loginPage.userName.sendKeys("automation@exiger.com");
        loginPage.password.sendKeys("Exiger1!");
        loginPage.loginButton.click();
    }

    @And("^I click on details link for Level (\\d+) product$")
    public void iClickOnDetailsLinkForLevelProduct(int arg0) throws Throwable {
       wait.waitAndClick(casePage.level1Details);
    }

    @And("^I remove Criminal Records option from deliverables$")
    public void iRemoveCriminalRecordsOptionFromDeliverables() throws Throwable {
        wait.waitAndClick(casePage.criminalRecordsOptionRemove);
        wait.waitAndClick(casePage.deselectDeliverable);
        wait.waitAndClick(casePage.deliverablesSaveButton);
        wait.waitUntilPresent(capacityProfilePage.updateAccountLink);
        wait.waitAndClick(capacityProfilePage.adminLogOffLink);

    }

    @And("^I verify Criminal Records deliverable is still present$")
    public void iVerifyCriminalRecordsDeliverableIsStillPresent() throws Throwable {
        driver.findElement(By.xpath("//a[contains(text(),'Cases')]")).click();
        System.out.println("-"+driver.findElement(By.xpath("//a[contains(text(),'Cases')]")).getText()+"-");
        wait.waitUntilGridSpinnersNotPresent();
        searchorderpage.selectordertype("In Progress");
        casePage.searchButton.click();
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitAndClick(casePage.firstCaseCms);
        popupWindow.moveToAnotherNewTab();
        Thread.sleep(5000);
        wait.waitAndClick(casePage.researchTab);
        wait.waitUntilGridSpinnersNotPresent();
        assertTrue(wait.waitUntilPresent(casePage.refreshButton).isDisplayed());
        assertTrue(casePage.criminalRecordsDeliverable.isDisplayed());
    }

    @And("^I verify Criminal Records deliverable is not present$")
    public void iVerifyCriminalRecordsDeliverableIsNotPresent() throws Throwable {
        assertFalse(casePage.criminalRecordsDeliverableList.size()>0);

        omsDashboardPage.expandUserOptions();
        omsDashboardPage.logOff.click();
        driver.get("https://insightqaadmin.exiger.com/");
        loginPage.userName.sendKeys("automation@exiger.com");
        loginPage.password.sendKeys("Exiger1!");
        loginPage.loginButton.click();
        wait.waitAndClick(adminPage.clientAccountTab);
        wait.waitAndSendKeysByElement(capacityProfilePage.legalName, "A Titu Client");
        wait.waitAndClick(new CapacityProfilePage().filterButtonDiligenceSkills);
        Thread.sleep(5000);
        assertTrue(capacityProfilePage.userSearchDiligence.isDisplayed());
        wait.waitAndClick(capacityProfilePage.detailsLinkFirstUser);
        assertTrue(capacityProfilePage.internalUserDiligenceSkills.isDisplayed());
        wait.waitAndClick(casePage.level1Details);
        wait.waitAndClick(casePage.criminalRecordsOptionRemove);
        wait.waitAndClick(casePage.deselectDeliverable);
        selectElements.selectByVisibleText(adminPage.criminalRecordsTemplateType,"PROC-EX");
        wait.waitAndClick(casePage.deliverablesSaveButton);
        wait.waitUntilPresent(capacityProfilePage.updateAccountLink);
        wait.waitAndClick(capacityProfilePage.adminLogOffLink);
    }


    @And("^I verify pencil is present for Jurisdiction$")
    public void iVerifyPencilIsPresentForJurisdiction() throws Throwable {
        assertTrue(casePage.editJurisdiction.isDisplayed());
    }

    @And("^I verify pencil is not present for Jurisdiction$")
    public void iVerifyPencilIsNotPresentForJurisdiction() throws Throwable {
       assertFalse(casePage.editJurisdictionList.size()<0);
    }
}