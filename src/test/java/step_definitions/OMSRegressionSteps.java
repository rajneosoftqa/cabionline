package step_definitions;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import formSteps.CreateOrder;

import formSteps.SearchOrder;
import helpers.*;

import helpers.Wait;
import helpers.WebElementExtensions;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageobjects.*;
import util.Credentials;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import static junit.framework.TestCase.assertTrue;


public class OMSRegressionSteps extends BaseClass {
    LoginPage loginPage = new LoginPage();
    Wait wait = new Wait();
    WebElementExtensions webElementExtensions = new WebElementExtensions();
    OMSDashboardPage omsDashboardPage = new OMSDashboardPage();
    CreateOrder createOrder = new CreateOrder();
    OrderPage orderPage = new OrderPage();
    Misc misc = new Misc();
    HomePage  homePage = new HomePage(driver);
    SearchOrder searchorderpage = new SearchOrder();
    OrderSearchPage orderSearchPage = new OrderSearchPage();
    CasePage casePage = new CasePage(driver);
//    String companyName = null;
    SubjectCompanyFormPage subjectCompanyFormPage = new SubjectCompanyFormPage(driver);
    private ReviewAndConfirmOrderPage rco = new ReviewAndConfirmOrderPage(driver);
    PopupWindow popupWindow = new PopupWindow();

    PageHelpers pageHelpers = new PageHelpers();
    Credentials credentials = new Credentials();
    SelectElements selectElements = new SelectElements();
    Dropdown dropdown = new Dropdown();
    ScrollintoView scrollintoView = new ScrollintoView();

    Faker faker = new Faker();
    private Name name = faker.name();
    String firstname = name.firstName().replace("'","");
    String lastname = name.lastName().replace("'","");
    String orderName = name.firstName().replace("'","").toLowerCase();
    String message = name.firstName().replace("'","");

    String companyName = name.lastName().replace("'","");
    String[] orders = null;
    String driverDirectory = System.getProperty("user.dir") + "/testData";
    public static String casename = "";


    @When("^I navigate to \"([^\"]*)\" page from the main nav panel$")
    public void iNavigateToPageFromTheMainNavPanel(String NavName) throws Throwable {
        wait.waitAndClick(driver, By.xpath("//a[contains(text(),'Advanced Search')]"));
        wait.waitUntilGridSpinnersNotPresent();
    }

    @Given("^User navigates to \"([^\"]*)\" site$")
    public void userNavigatesToSite(String arg0) throws Throwable {
        driver.navigate().to(String.format("https://%s", arg0));
    }

    @And("^The login page functionality should be available$")
    public void theLoginPageFunctionalitiesShouldBeAvailable() throws Throwable {
        loginPage.check_loginPageFunctionalities();
    }

    @Given("^I login to OMS site$")
    public void iLoginToOMSSite() throws Throwable {
        loginPage.loginToOMSPage();
        loginPage.navigateToDiligenceLoginPage();
        credentials.getCredentials();
//        wait.waitUntilPresent(By.id("gbox_jqGrid"));
//    pageHelpers.checkPageIsReady(driver);
//        homePage.checkForHomePageVisibility();
    }
//
//    @Given("^I login to OMS site$")
//    public void iLoginToOMSSite() throws Throwable {
//        loginPage.loginToOMSPage();
//        wait.waitUntilPresent(By.id("gbox_jqGrid"));
//    }

    @And("^I am in dashboard page$")
    public void iAmInDashboardPage() throws Throwable {
        wait.waitUntilTextIs(By.xpath("/html/body/div[1]/div[2]/div/div[1]/ul[1]/li[1]/h2"), "Dashboard");
    }


    @And("^I see in progress tile is active$")
    public void iSeeInProgressTileIsActive() throws Throwable {
        wait.waitUntilPresent(omsDashboardPage.jqgridList);
        WebElement element = webElementExtensions.findElementByDataBind("text", "Title");
        if (element.getText().equals("In Progress")) {
            assertTrue(element.getAttribute("class").contains("active"));
        }
    }

    @And("^I click on dashboard viewing options and choose \"([^\"]*)\"$")
    public void iClickOnDashboardViewingOptionsAndChoose(String arg0) throws Throwable {
        omsDashboardPage.chooseDashBoardView(arg0);
    }

    @And("^I click on show per page to \"([^\"]*)\" number$")
    public void iClickOnShowPerPageToNumber(String arg0) throws Throwable {
        omsDashboardPage.selectShowPerPage(arg0);
    }

    @And("^I see calendar is available$")
    public void iSeeCalendarIsAvailable() throws Throwable {
        omsDashboardPage.calendar.isDisplayed();
    }

    @And("^If a order is available it should show in calendar$")
    public void ifAOrderIsAvailableItShouldShowInCalendar() throws Throwable {
        String text = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[1]/div/div[2]/div[3]/div/div[3]/div[3]/div/table/tbody/tr[2]/td[4]")).getText();
        System.out.println(text);

        WebElement dateWidget = driver.findElement(By.id("calendarContainer"));
        List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

        for (WebElement cell : columns) {
            String alldates = cell.getAttribute("data-date");
            System.out.println("All the data-dates " + alldates);
//            if (alldates.equals("2018-04-10")) {
//                cell.click();
//                Thread.sleep(4000);
//            }

        }
    }

    @And("^I see a search box is available$")
    public void iSeeASearchBoxIsAvailable() throws Throwable {
        omsDashboardPage.searchBox.isDisplayed();
    }

    @And("^I see create order option is available$")
    public void iSeeCreateOrderOptionIsAvailable() throws Throwable {
        omsDashboardPage.createOrderButton.isDisplayed();
    }

    @And("^I see change password and log off option$")
    public void iSeeChangePasswordOption() throws Throwable {
//        omsDashboardPage.userOptionsDropDown.click();
        new Actions(driver).moveToElement(omsDashboardPage.userOptionsDropDown).build().perform();
        omsDashboardPage.changePassword.isDisplayed();
        omsDashboardPage.logOff.isDisplayed();
    }

    @And("^I see page changes for \"([^\"]*)\"$")
    public void iSeePageChangesForTeamDashboard(String dashboard) throws Throwable {
        String actual = omsDashboardPage.dashboardViewDropDown.getText();
//        assertEquals("Viewing " + dashboard, actual);
        wait.waitUntilPresent(omsDashboardPage.gridList);
    }

    @And("^I choose \"([^\"]*)\" item per page$")
    public void iChooseItemPerPage(String arg0) throws Throwable {
//        wait.waitUntilClickable(omsDashboardPage.jqgridList);
        wait.waitUntilPresent(omsDashboardPage.tableGrid);
        omsDashboardPage.selectShowPerPage(arg0);
        wait.waitUntilPresent(omsDashboardPage.tableGrid);
    }

    @And("^I fill out the subject \"([^\"]*)\" details$")
    public void iFillOutTheSubjectDetails(String orderform) throws Throwable {
        if (orderform.equals("company")) {
            companyName = createOrder.fillCompanySubjectForm(companyName);
            System.out.println("Company name is " + companyName);
        } else if (orderform.equals("individual")) {
            createOrder.fillIndividualSubjectForm(firstname, lastname);
        }
    }

    @And("^I see the name of the subject is added$")
    public void iSeeTheNameOfTheSubjectIsAdded() throws Throwable {
        String actual = wait.waitAndGetText(driver, By.xpath("//*[@id='subjectsReviewContainer']/div[2]/div[1]//*[contains(text(),'"+companyName+"')]"));
//        System.out.println(companyName.toLowerCase()+" ===== "+actual.toLowerCase());
        assertEquals(companyName.toLowerCase(), actual.toLowerCase());

    }

    @And("^I move to next page$")
    public void iMoveToNextPage() throws Throwable {
        subjectCompanyFormPage.continueButton.click();
//        Thread.sleep(5000);
    }

    @And("^I fill order details for \"([^\"]*)\" type$")
    public void iFillOrderDetailsForType(String arg0) throws Throwable {
        orderPage.fillOrderDetails(arg0, orderName);
        System.out.println("order name is used: " + orderName);
    }

    @And("^I review order details have order type$")
    public void iReviewOrderDetails() throws Throwable {
        orderPage.reviewOrderType("Level 1");
    }

    @And("^I submit the order$")
    public void submitOrder() throws Throwable {
        wait.waitAndClick(rco.submitOrderButton);
        wait.waitUntilGridSpinnersNotPresent();
        Thread.sleep(5000);
//        wait.waitUntilPresent(omsDashboardPage.tableElements);
    }

    @And("^I click on Orders$")
    public void iClickOnOrders() throws Throwable {
        homePage.navigateToOrdersPage();
        wait.waitUntilGridSpinnersNotPresent();
    }

    @And("^I should be able to type \"([^\"]*)\" in Name field$")
    public void iShouldBeAbleToTypeInNameField(String arg0) throws Throwable {
        searchorderpage.fillordername(arg0);
    }

    @And("^I should be able to click on Order type field and select a \"([^\"]*)\"$")
    public void iShouldBeAbleToClickOnOrderTypeFieldAndSelectA(String arg0) throws Throwable {
//        searchorderpage.selectordertype(arg0);
//       selectElements.selectJavaScriptItems("SelectedProductTypeIds", arg0);
          searchorderpage.selectordertype(arg0);

    }

    @And("^I should be able to click Order Status field and select \"([^\"]*)\"$")
    public void iShouldBeAbleToClickOrderStatusFieldAndSelect(String arg0) throws Throwable {
        searchorderpage.fillorderstatus(arg0);
    }

    @And("^I should be able to type \"([^\"]*)\" in Order Number field$")
    public void iShouldBeAbleToTypeInOrderNumberField(String arg0) throws Throwable {
        searchorderpage.ordernumber(arg0);
    }

    @And("^I should be able to click on Search button$")
    public void iShouldBeAbleToClickOnSearchButton() throws Throwable {
       searchorderpage.searchbuttonclick();
    }

    @And("^I should be able to click on Reset button$")
    public void iShouldBeAbleToClickOnResetButton() throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        searchorderpage.resetbuttonclick();
    }

    @Then("^I should be able to see the results$")
    public void iShouldBeAbleToSeeTheResults() throws Throwable {
        searchorderpage.viewresults();
    }

    @And("^I should be able to pick Submited between start and end dates as \"([^\"]*)\" and \"([^\"]*)\" fields$")
    public void iShouldBeAbleToPickSubmitedBetweenStartAndEndDatesAsAndFields(String arg0, String arg1) throws Throwable {
        searchorderpage.submitcal_1("");
        searchorderpage.submitcal_2();

    }

    @And("^I should be able to pick Completed between start and end dates as \"([^\"]*)\" and \"([^\"]*)\" fields$")
    public void iShouldBeAbleToPickCompletedBetweenStartAndEndDatesAsAndFields(String arg0, String arg1) throws Throwable {
        searchorderpage.submitcal_3();
        searchorderpage.submitcal_4();

    }



    @And("^I see the order is listed in the table$")
    public void iSeeTheOrderIsListedInTheTable() throws Throwable{
//        List<WebElement> clientAccountName = wait.waitAndReturnListElements(driver, By.cssSelector("td[aria-describedby='jqGrid_Name']"));
        wait.waitUntilGridSpinnersNotPresent();
        System.out.println("Looking for the order name------  " + orderName);

        assertTrue(driver.getPageSource().contains(orderName));
        System.out.println("Found the order!!!");
        }

    @Then("^I see the order is not listed in the table$")
    public void iSeeTheOrderIsNotListedInTheTable() throws Throwable {
//        List<WebElement> clientAccountName = wait.waitAndReturnListElements(driver, By.cssSelector("td[aria-describedby='jqGrid_Name']"));
        wait.waitUntilGridSpinnersNotPresent();
        System.out.println("Looking for the order name------  " + orderName);
        assertFalse(driver.getPageSource().contains(orderName));
        System.out.println("Order Removed!!!");
    }


    @And("^I see name field is available$")
    public void iSeeNameFieldIsAvailable() throws Throwable {
       assertTrue(orderSearchPage.orderName.isDisplayed());
    }

    @And("^I see order type dropdown is available$")
    public void iSeeOrderTypeDropdownIsAvailable() throws Throwable {
        assertTrue(orderSearchPage.ordertypebutton.isDisplayed());
    }


    @And("^I see Submitted 'Between Start date and End date' dropdowns are available$")
    public void iSeeSubmittedBetweenStartDateAndEndDateDropdownsAreAvailable() throws Throwable {
        assertTrue(orderSearchPage.submitstart.isDisplayed());
        assertTrue(orderSearchPage.calbtn1.isDisplayed());
        assertTrue(orderSearchPage.submitend.isDisplayed());
        assertTrue(orderSearchPage.calbtn2.isDisplayed());
    }

    @And("^I see Completed 'Between Start date and End date' dropdowns are available$")
    public void iSeeCompletedBetweenStartDateAndEndDateDropdownsAreAvailable() throws Throwable {
        assertTrue(orderSearchPage.completestart.isDisplayed());
        assertTrue(orderSearchPage.calbtn3.isDisplayed());
        assertTrue(orderSearchPage.completeend.isDisplayed());
        assertTrue(orderSearchPage.calbtn4.isDisplayed());
    }

    @And("^I see Order Status dropdown is available$")
    public void iSeeOrderStatusDropdownIsAvailable() throws Throwable {
        assertTrue(orderSearchPage.orderstatusbutton.isDisplayed());
    }

    @And("^I see Order Number field is available$")
    public void iSeeOrderNumberFieldIsAvailable() throws Throwable {
        assertTrue(orderSearchPage.ordernumber.isDisplayed());
    }

    @And("^I see show more filters link is available$")
    public void iSeeShowMoreFiltersLinkIsAvailable() throws Throwable {
        assertTrue(orderSearchPage.moreFiltersButton.isDisplayed());
    }

    @And("^I see search and reset buttons are available$")
    public void iSeeSearchAndResetButtonsAreAvailable() throws Throwable {
        assertTrue(orderSearchPage.resetbutton.isDisplayed());
        assertTrue(orderSearchPage.searchbutton.isDisplayed());
    }

    @And("^I see Order Name, Order Type, Submitted Start and End date fields are aligned horizontally$")
    public void iSeeOrderNameOrderTypeSubmittedStartAndEndDateFieldsAreAlignedHorizontally() throws Throwable {
      int position = orderSearchPage.orderName.getLocation().y;
        assertTrue(position == orderSearchPage.ordertypebutton.getLocation().y
                && position == orderSearchPage.submitstart.getLocation().y
                && position == orderSearchPage.calbtn1.getLocation().y
                && position == orderSearchPage.submitend.getLocation().y
                && position == orderSearchPage.calbtn2.getLocation().y);
    }

    @And("^I see Completed Start and End date, Order Status, Order Number fields are aligned horizontally$")
    public void iSeeCompletedStartAndEndDateOrderStatusOrderNumberFieldsAreAlignedHorizontally() throws Throwable {
        int position = orderSearchPage.completestart.getLocation().y;
        assertTrue(position == orderSearchPage.completestart.getLocation().y
                && position == orderSearchPage.calbtn3.getLocation().y
                && position == orderSearchPage.completeend.getLocation().y
                && position == orderSearchPage.calbtn4.getLocation().y
                && position == orderSearchPage.orderstatusbutton.getLocation().y
                && position == orderSearchPage.ordernumber.getLocation().y);

    }

    @And("^I click on back arrow in calendar to go to previous month$")
    public void iClickOnBackArrowInCalendarToGoToPreviousMonth() throws Throwable {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        orderSearchPage.previousmonth.click();
        System.out.println(omsDashboardPage.calMonth.getText()+" == "+ new SimpleDateFormat("MMM").format(cal.getTime()) + " 2018");
        assertTrue(omsDashboardPage.calMonth.getText().contains(new SimpleDateFormat("MMM").format(cal.getTime()) + " 2018"));
    }

    @And("^I click on forward arrow in calendar to go to next month$")
    public void iClickOnForwardArrowInCalendarToGoToNextMonth() throws Throwable {
        Calendar cal = Calendar.getInstance();
        orderSearchPage.nextmonth.click();
        System.out.println(omsDashboardPage.calMonth.getText()+" == "+new SimpleDateFormat("MMM").format(cal.getTime()) + " 2018");
        assertTrue(omsDashboardPage.calMonth.getText().contains(new SimpleDateFormat("MMM").format(cal.getTime()) + " 2018"));
    }


    @And("^I click on Order Status dropdown$")
    public void iClickOnOrderStatusDropdown() throws Throwable {
       orderSearchPage.orderstatusbutton.click();
    }


    @Then("^I should not see \"([^\"]*)\" status$")
    public void iShouldNotSeeStatus(String arg0) throws Throwable {
        orderSearchPage.verifyAbsenceOfStatus(arg0);
    }


    @Then("^I get unexpected error on the page$")
    public void iGetUnexpectedErrorOnThePage() throws Throwable {
        driver.findElement(By.className("error-layout-body-content"));
    }


    @And("^I go to a page which is not accesible$")
    public void iGoToAPageWhichIsNotAccesible() throws Throwable {
        driver.get("https://diligenceqa.exiger.com/Content/Fonts/Montserrat/");
    }

    @And("^I go to a page which doesnt exist$")
    public void iGoToAPageWhichDoesntExist() throws Throwable {
        driver.get("https://diligenceqa.exiger.com/Content/Fonts/MontserratTest/");
    }


    @And("^I click on terms and conditions$")
    public void iClickOnTermsAndConditions() throws Throwable {
        wait.waitUntilPresent(omsDashboardPage.jqgridList);
        wait.waitUntilClickable(omsDashboardPage.gridList);
        scrollintoView.scrollToView(omsDashboardPage.termsandconditions);
        wait.waitAndClick(omsDashboardPage.termsandconditions);
    }

    @And("^I navigate to the terms and conditions page$")
    public void iNavigateToTheTermsAndConditionsPage() throws Throwable {
        omsDashboardPage.tocverify.click();
    }

    @And("^I click on support link$")
    public void iClickOnSupportLink() throws Throwable {
        wait.waitUntilPresent(omsDashboardPage.jqgridList);
        wait.waitUntilClickable(omsDashboardPage.gridList);
        scrollintoView.scrollToView(omsDashboardPage.support);
        wait.waitAndClick(omsDashboardPage.support);
    }

    @And("^I navigate to support page$")
    public void iNavigateToSupportPage() throws Throwable {
        scrollintoView.scrollDown();
      assertTrue(omsDashboardPage.supportverify.isDisplayed());
    }

    @And("^I log off from the site$")
    public void iLogOffFromTheSite() throws Throwable {
        omsDashboardPage.expandUserOptions();
        omsDashboardPage.logOff.click();
    }

    @And("^I type \"([^\"]*)\" in search for subjects text box$")
    public void iTypeInSearchForSubjectsTextBox(String arg0) throws Throwable {
        omsDashboardPage.quicksearch.sendKeys("test");
        Thread.sleep(5000);
    }

    @And("^I should be able to see suggestions$")
    public void iShouldBeAbleToSeeSuggestions() throws Throwable {
        assertTrue(omsDashboardPage.suggestions.isDisplayed());

    }

    @And("^I should be able to click on the suggestion$")
    public void iShouldBeAbleToClickOnTheSuggestion() throws Throwable {
        List <WebElement> list = driver.findElements(By.cssSelector(".ta-subject-container"));
        list.get(0).click();
    }

    @And("^I click on Download Audit$")
    public void iClickOnDownloadAudit() throws Throwable {
        omsDashboardPage.downloadaudit.click();
    }

    @And("^I click on Download Results$")
    public void iClickOnDownloadResults() throws Throwable {
        omsDashboardPage.downloadresults.click();
    }

    @And("^The report gets downloaded$")
    public void theReportGetsDownloaded() throws Throwable {
        misc.downloadFile("Order_Search_Results","csv");
    }

    @And("^I should be able to click \"([^\"]*)\" tile$")
    public void iShouldBeAbleToClickTileAndSeeNotSubmittedOrders(String arg0) throws Throwable {
        wait.waitUntilPresent(omsDashboardPage.jqgridList);
        omsDashboardPage.statusTile(arg0);
    }

    @And("^I should be able to click \"([^\"]*)\" tile and see in progress orders$")
    public void iShouldBeAbleToClickTileAndSeeInProgressOrders(String arg0) throws Throwable {
        wait.waitUntilClickable(omsDashboardPage.gridList);
        omsDashboardPage.statusTile(arg0);
    }

    @And("^I should be able to click \"([^\"]*)\" tile and see my unread messages$")
    public void iShouldBeAbleToClickTileAndSeeMyUnreadMessages(String arg0) throws Throwable {
        omsDashboardPage.statusTile(arg0);
    }

    @And("^I should be able to click on \"([^\"]*)\" tile view orders with delivered reports$")
    public void iShouldBeAbleToClickOnTileViewOrdersWithDeliveredReports(String arg0) throws Throwable {
        omsDashboardPage.statusTile(arg0);

    }

    @And("^The audit report is downloaded$")
    public void theAuditReportIsDownloaded() throws Throwable {
        misc.downloadFile("Audit_Trail","csv");
   }

    @And("^I see \"([^\"]*)\" item listed in the table$")
    public void iSeeItemListedInTheTable(String arg0) throws Throwable {
        List<WebElement> rows = driver.findElements(By.cssSelector
                ("[id='jqGrid'] tr"));
        int count = rows.size() - 1;
        System.out.println("ROW COUNT : "+count);
        assertEquals(count, Integer.parseInt(arg0));
    }

    @Then("^The order page opens in a new tab$")
    public void theOrderPageOpensInANewTab() throws Throwable {
        popupWindow.moveToNewTab();
        assertTrue(wait.waitUntilPresent(orderPage.ordertitle).isDisplayed());
        System.out.println(wait.waitUntilPresent(orderPage.ordertitle).isDisplayed());
    }

    @And("^I see the order details page$")
    public void iSeeTheOrderDetailsPage() throws Throwable {
        assertTrue(wait.waitUntilPresent(orderPage.ordertitle).isDisplayed());
        System.out.println(orderPage.ordertitle.getText());
    }

    @And("^I click on an in progress order from the table$")
    public void iClickOnAnInProgressOrderFromTheTable() throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitUntilPresent(driver.findElement(By.id("gbox_jqGrid")));
        casename = orderPage.inProgressCase.getText();
        wait.waitUntilClickable(orderPage.inProgressOrder).click();
    }

    @And("^I click on continue button$")
    public void iClickOnContinueButton() throws Throwable {
        wait.waitUntilClickable(orderPage.continueButton).click();
        Thread.sleep(10000);
    }

    @And("^I navigate to subjects page$")
    public void iNavigateToSubjectsPage() throws Throwable {
         assertTrue(wait.waitUntilPresent(orderPage.enterSubjects).isDisplayed());


    }


    @And("^I see the name of the subject for \"([^\"]*)\" is added$")
    public void iSeeTheNameOfTheSubjectForIsAdded(String arg0) throws Throwable {
        if(arg0.equals("company")){
            String actual = wait.waitAndGetText(driver, By.xpath("//*[@id='subjectsReviewContainer']//*[contains(text(),'"+companyName+"')]"));
            System.out.println(companyName.toLowerCase()+" ===== "+actual.toLowerCase());
            assertEquals(companyName.toLowerCase(), actual.toLowerCase());
        }
        else{
            String actual = wait.waitAndGetText(driver, By.xpath("//*[@id='subjectsReviewContainer']//*[contains(text(),'"+firstname+"')]"));
            System.out.println(firstname.toLowerCase() + " " + lastname.toLowerCase()+" ===== "+actual.toLowerCase());
            assertEquals(firstname.toLowerCase() + " " + lastname.toLowerCase(), actual.toLowerCase());
        }
    }

    @And("^I click on an order from the table$")
    public void iClickOnAnOrderFromTheTable() throws Throwable {

    }

    @And("^I click on an order from the table for \"([^\"]*)\"$")
    public void iClickOnAnOrderFromTheTableFor(String arg0) throws Throwable {
        System.out.println("testest");
        if(arg0.equals("company")) {
            if(orderPage.firstOrderCheck.size()>0){
                wait.waitUntilClickable(orderPage.firstOrder).click();
            }
            else{
                orderPage.createOrder(arg0);
                wait.waitAndClick(orderPage.backToDashBoard);
                wait.waitUntilPresent(omsDashboardPage.jqgridList);
                omsDashboardPage.statusTile("Not Submitted");
                wait.waitUntilClickable(orderPage.firstOrder).click();
            }
        }
        else{
            if(orderPage.firstOrderCheck.size()>0){
                wait.waitUntilClickable(orderPage.firstOrder).click();
            }
            else{
                orderPage.createOrder("individual");
                wait.waitAndClick(orderPage.backToDashBoard);
                wait.waitUntilPresent(omsDashboardPage.jqgridList);
                omsDashboardPage.statusTile("Not Submitted");
                wait.waitUntilClickable(orderPage.firstOrder).click();
            }
        }
    }

    @And("^I click on Messages tab$")
    public void iClickOnMessagesTab() throws Throwable {
        orderPage.messagesTab.click();
        wait.waitUntilPresent(orderPage.messageHistory);
    }

    @And("^I navigate to the messages tab$")
    public void iNavigateToTheMessagesTab() throws Throwable {
        assertTrue(orderPage.messageHistory.isDisplayed());
    }

    @And("^I type \"([^\"]*)\" in the message textbox and click send$")
    public void iTypeInTheMessageTextboxAndClickSend(String arg0) throws Throwable {
        //orderPage.comment.click();
        wait.waitAndSendKeysByElement(orderPage.comment,"testing9");
        orderPage.addMessage.click();
//        System.out.println(arg0+" ===== "+orderPage.sentMessage.getText());
        String actual = wait.waitAndGetText(driver, By.xpath("//*[@id='messages']*[contains(text(),'"+arg0+"')]"));
        assertEquals(arg0,actual);

    }

    @Then("^I check the sent message$")
    public void iCheckTheSentMessage() throws Throwable {
        assertTrue(driver.getPageSource().contains(message));
    }


    @And("^I send a message in the message textbox and click send$")
    public void iSendAMessageInTheMessageTextboxAndClickSend() throws Throwable {
        wait.waitAndSendKeysByElement(orderPage.comment,message);
        orderPage.addMessage.click();
        String actual = wait.waitAndGetText(driver, By.xpath("//*[@id='messages']//*[text()='"+message+"']"));
        assertEquals(message,actual);
    }


    @And("^I login as child account$")
    public void iLoginAsChildAccount() throws Throwable {
        omsDashboardPage.expandUserOptions();
        omsDashboardPage.logOff.click();
        loginPage.navigateToDiligenceLoginPage();
        loginPage.userName.sendKeys("tdattachild2@exiger.com");
        loginPage.password.sendKeys("Exiger1!!");
        loginPage.loginButton.click();
    }



    @And("^I fill order details for \"([^\"]*)\" type for child account$")
    public void iFillOrderDetailsForTypeForChildAccount(String arg0) throws Throwable {
        orderPage.fillOrderDetailsicv(arg0, orderName);
        System.out.println("order name is used: " + orderName);
    }

    @Then("^I check the sent message in CMS$")
    public void iCheckTheSentMessageInCMS() throws Throwable {
        String actual = wait.waitAndGetText(driver, By.xpath("//*[@id='messages']//*[contains(text(),'" + message + "')]"));
        assertEquals(message, actual);
    }


    @And("^I click on Edit Case Assignment$")
    public void iClickOnEditCaseAssignment() throws Throwable {
        //scrollintoView.scrollToView(casePage.editCaseAssignment);
        wait.waitAndClick(casePage.editCaseAssignment);
    }

    @And("^I should be able to type ordername in Name field$")
    public void iShouldBeAbleToTypeOrdernameInNameField() throws Throwable {
        searchorderpage.fillordername(orderName);
    }

    @And("^I click on view case button$")
    public void iClickOnViewCaseButton() throws Throwable {
//        wait.waitAndClick(orderPage.viewCase);
        Thread.sleep(5000);
        scrollintoView.scrollToView(orderPage.viewCase);
        wait.waitAndClick(orderPage.viewCase);
    }

    @And("^I click on the searched order from the table$")
    public void iClickOnTheSearchedOrderFromTheTable() throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitAndClick(orderPage.clickSearchedOrder(orderName));
    }

    @And("^I review order details \"([^\"]*)\" type$")
    public void iReviewOrderDetailsType(String arg0) throws Throwable {
        orderPage.reviewOrderType(arg0);
    }


    @And("^I should be able to type ordername$")
    public void iShouldBeAbleToTypeOrdername() throws Throwable {
     orderPage.fillOrderName();
    }
}








































