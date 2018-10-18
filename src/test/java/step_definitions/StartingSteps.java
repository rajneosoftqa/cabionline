package step_definitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import helpers.Wait;
import helpers.WebElementExtensions;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import util.Credentials;


public class StartingSteps extends BaseClass {


    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage(driver);
    Wait wait = new Wait();
    WebElementExtensions webElementExtensions = new WebElementExtensions();


    @When("^Home page is available$")
    public void homePageIsAvailable() throws Throwable {
//        loginPage.navigateToDiligenceLoginPage();
        homePage.checkForHomePageVisibility();
    }

    @Given("^I login to Threepm home page as \"([^\"]*)\" of \"([^\"]*)\"$")
    public void iLoginToThreepmHomePageAsOf(String arg0, String arg1) throws Throwable {
        loginPage.navigateToDiligenceLoginPage();
        loginPage.loginAs(arg0, arg1);
    }

    @Given("^User logs in with following credentials$")
    public void userLogsInWithFollowingCredentials(DataTable usercredentials) throws Throwable {
        loginPage.navigateToDiligenceLoginPage();
        webElementExtensions.loginWithGivenCredentials(usercredentials);
    }

    @Given("I login with correct credentials$")
    public void userLogsInWithCorrectCredentials() throws Throwable {
        loginPage.navigateToDiligenceLoginPage();
        Credentials credentials = new Credentials();
    }

    @Given("^I login as a supervisor$")
    public void iLoginAsASupervisor() throws Throwable {
        loginPage.navigateToDiligenceLoginPage();
        Credentials credentials = new Credentials();
    }
}




























