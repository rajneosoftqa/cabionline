package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import formSteps.CreateOrder;
import forms.OrderDetailsForm;
import forms.UpdateDDIQSubjectForm;
import helpers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import pageobjects.*;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by tdatta on 6/14/17.
 */
public class RegressionSteps extends BaseClass {

    private LoginPage login = new LoginPage();
    private Wait wait = new Wait();
    private CreateOrder createOrder = new CreateOrder();
    private OrderDetailsForm orderDetailsForm = new OrderDetailsForm(driver);
    private ReviewAndConfirmOrderPage rco = new ReviewAndConfirmOrderPage(driver);
    private ScrollintoView scrollintoView = new ScrollintoView();
    private XPathHelpers xPathHelpers = new XPathHelpers();
    private PageHelpers pageHelpers = new PageHelpers();
    private ThirdPartyDetailsEditPage thirdPartyDetailsEditPage = new ThirdPartyDetailsEditPage(driver);
    private TableElements tableElements = new TableElements();
    private UpdateDDIQSubjectForm DDIQSubjectForm = new UpdateDDIQSubjectForm(driver);
    private WebElementExtensions webElementExtensions = new WebElementExtensions();
    private PopupWindow popupWindow = new PopupWindow();
    private OMSDashboardPage omsDashboardPage = new OMSDashboardPage();
    private OrderPage orderPage = new OrderPage();

    @And("^I click on create order button$")
    public void iCLickOnCreateOrderButton() throws Throwable {
        wait.waitAndClick(driver, By.id("btnCreateOrder"));
    }

//    @And("^I fill out the order details for \"([^\"]*)\"$")
//    public void iFillOutTheOrderDetails(String account) throws Throwable {
//        createOrder.fillOrderDetails(account);
//        createOrder.fillIndividualSubjectForm();
//    }



    @And("^I click on a third-party that has \"([^\"]*)\"$")
    public void iClickOnAThirdPartyThatHas(String LastDDType) throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        driver.findElement(By.linkText(LastDDType)).click();
//        tableElements.clickAStringInTable(LastDDType);
    }

    @And("^I click on Due diligence activity for \"([^\"]*)\"$")
    public void iClickOnDueDiligenceActivityFor(String LastDDType) throws Throwable {
        Thread.sleep(2000);
        scrollintoView.scrollDown();
        wait.waitAndClick(driver, By.xpath(String.format(".//*[@id='jqGrid']//td[contains(.,'%s')]", LastDDType)));
    }

    @And("^I edit the recipient details \"([^\"]*)\", \"([^\"]*)\"$")
    public void iEditTheRecipientDetails(String FirstName, String Emails) throws Throwable {
        scrollintoView.scrollToMiddle();
        thirdPartyDetailsEditPage.editRecipientDetails(FirstName, Emails);
        Thread.sleep(5000);
        wait.waitUntilGridSpinnersNotPresent();
    }

    @Then("^I see the edited field saved successfully with the \"([^\"]*)\", \"([^\"]*)\"$")
    public void iSeeTheEditedFieldSavedSuccessfullyWithThe(String FirstName, String Email) throws Throwable {

        popupWindow.ifPopupClickContinue();
        wait.waitUntilPresent(By.cssSelector("[data-bind='text: FirstName']"));
        String actualFirstName = webElementExtensions.findElementByDataBind
                ("text", "FirstName").getText();
        String actualEmail = webElementExtensions.findElementByDataBind
                ("text", "EmailAddress").getText();
        assertEquals(actualFirstName, FirstName);
        assertEquals(actualEmail, Email);
    }

    @And("^I wait till the popup verification window closes$")
    public void iWaitTillThePopupVerificationWindowCloses() throws Throwable {
        popupWindow.ifPopupClickContinue();
        wait.waitUntilNotPresent(By.id("modalBody"));
        popupWindow.checkIfPopupWindowClosed();
    }

    @And("^I click on a third-party that has \"([^\"]*)\" and \"([^\"]*)\" .*$")
    public void iClickOnAThirdPartyThatHasAnd(String relatioshipStatus, String LastDDType) throws Throwable {
        wait.waitUntilPresent(By.id("gview_jqGrid"));
        tableElements.clickTwoConditionMet("gview_jqGrid", relatioshipStatus, LastDDType);
//        WebElement element = driver.findElement(By.cssSelector
//                (".//*[@id='gview_jqGrid']//td[contains(.,'jqGrid_J')]"));
//        if (element.getText().equals("Pending")){
//            element.click();
//        }
    }

    @And("^I click on \"([^\"]*)\" tab$")
    public void iClickOnTab(String tabString) throws Throwable {
        wait.waitAndClick(driver, By.linkText(tabString));
        wait.waitUntilGridSpinnersNotPresent();
    }

    @And("^I update and submit the subject$")
    public void iUpdateAndSubmitTheSubject() throws Throwable {
        DDIQSubjectForm.fillUpdateDDIQSubjectForm();
        Thread.sleep(5000);
    }

    @And("^I go to DDIQ details page$")
    public void iGoToDDIQDetailsPage() throws Throwable {
        driver.get("https://insightqa.exiger.com/Order/Details/6009");
    }

    @And("^I see the change for DDIQ tab$")
    public void iSeeTheChangeForDDIQTab() throws Throwable {
        WebElement element = wait.waitAndReturnElement
                (driver, By.xpath("//*[@id=\"subjectsContainer\"]/div[2]/div[1]/div/div/div[1]/div/div[1]/span[2]"));
        element.isDisplayed();
    }

    @Then("^The iframe loads with details information$")
    public void iFrameLoads() throws Throwable {
        Thread.sleep(5000);
        driver.findElement(By.id("ddiqFrame")).isDisplayed();
    }



    @And("^I sort the order by \"([^\"]*)\" (\\d+) times$")
    public void iSortTheOrderByTimes(String arg0, int arg1) throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitUntilPresent(By.id("jqGrid"));
        wait.waitUntilGridSpinnersNotPresent();
        orderPage.sortOrderByColumnHeader(arg0, arg1);
    }


    @And("^I see (\\d+) item listed in the table$")
    public void iSeeItemListedInTheTable(int arg0) throws Throwable {
        List<WebElement> rows = driver.findElements(By.cssSelector
                ("[id='jqGrid'] tr"));
        int count = rows.size() - 1;
        System.out.println("ROW COUNT : "+count);
        assertEquals(count, arg0);
    }
}



