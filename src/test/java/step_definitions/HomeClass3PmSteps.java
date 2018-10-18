//package step_definitions;
//
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Then;
//import helpers.*;
//import org.hamcrest.CoreMatchers;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import pageobjects.HomePage;
//import pageobjects.LoginPage;
//import pageobjects.MonitoringPage;
//import pageobjects.ThirdPartiesPage;
//
//import static org.junit.Assert.assertThat;
//
//
///**
// * Created by tdatta on 5/8/17.
// */
//public class HomeClass3PmSteps extends BaseClass {
//
//    private HomePage homePage = new HomePage(driver);
//    private LoginPage loginPage = new LoginPage();
//    private AllLinks allLinks = new AllLinks();
//    private Wait wait = new Wait();
//    private WebElement element;
//    private PopupWindow popupWindow = new PopupWindow();
//    private MonitoringPage monitoringPage = new MonitoringPage(driver);
//    private ScrollintoView scrollintoView = new ScrollintoView();
//    private ThirdPartiesPage thirdPartiesPage = new ThirdPartiesPage(driver);
//    private Wrapers wrapers = new Wrapers();
//
//
//    @Then("^I get the title of the page$")
//    public void iGetTheTitleOfThePage() throws Throwable {
//        String title = driver.getTitle();
//        System.out.println(title);
//    }
//
//
//    @And("^I click on third party title \"([^\"]*)\"$")
//    public void iClickOnThirdPartyTitle(String Label) throws Throwable {
//        homePage.callRightPane(Label);
//
//    }
//
//    @And("^I see more info about the \"([^\"]*)\"$")
//    public void iSeeMoreInfoAboutThe(String Label) throws Throwable {
//
//        wait.waitUntilPresent(By.className("drawer-inner"));
//        WebElement element1 = wait.waitAndReturnElement(driver, By.className("section-header-list"));
//        assertThat(element1.getText(), CoreMatchers.containsString(Label.toUpperCase()));
//    }
//
//    @And("^I see how many links are in the page$")
//    public void iSeeHowManyLinksAreInThePage() throws Throwable {
//        allLinks.getCountAllLinks();
//
//
//    }
//
//    @And("^I get all the links in the page$")
//    public void iGetAllTheLinksInThePage() throws Throwable {
//        allLinks.getAllLinks();
//        allLinks.getAllLinksName();
//
//    }
//
//    @And("^I navigate to each of the links in the page and I get the titles of the pages$")
//    public void iNavigateToEachOfTheLinksInThePage() throws Throwable {
//        allLinks.navigateToAllLinks();
//
//    }
//
//    @And("^I see all the third party activity on right nav$")
//    public void iSeeAllTheThirdPartyTitleVisible() throws Throwable {
//        element = wait.waitAndReturnElement(driver, By.className("dashboard-right")).findElement(By.className("list-group"));
//        System.out.println("All the links are: " + element.getText());
//    }
//
//    @And("^I get the metadata of the page$")
//    public void iGetTheMetadataOfThePage() throws Throwable {
//        Title_URL_Meta.getMetaData(driver);
//    }
//
//    @And("^I see a search box with a placeholder stating \"([^\"]*)\"$")
//    public void iSeeASearchBoxWithAPlaceholderStating(String Placeholder) throws Throwable {
//
//        element = wait.waitAndReturnElement(driver, By.id("header-searchbox-input"));
//        Assert.assertEquals(element.getAttribute("placeholder"), Placeholder);
//
//    }
//
//    @And("^I search for a third party in the search bar$")
//    public void iSearchForAsAThirdPartyByName() throws Throwable {
//        String thirdPartyName = wrapers.getThirdPartyNameFromList();
//        wait.waitAndSendKeys(driver, By.id("header-searchbox-input"), thirdPartyName);
//    }
//
//    @And("^I see the search menu dropdown$")
//    public void iSeeTheSearchMenuDropdown() throws Throwable {
//        WebElement element = wait.waitAndReturnElement(driver, By.className("tt-menu"));
//        System.out.println(element);
//    }
//
//    @And("^I close that review box$")
//    public void iCloseThatReviewBox() throws Throwable {
//        wait.waitAndClick(driver, By.cssSelector(".form-action"));
//
//    }
//
//    @Then("^User logs off from the current session$")
//    public void userShouldBeAbleToLogOffFromTheCurrentSession() throws Throwable {
//        homePage.logOffFromCurrentSession(driver);
//    }
//
//    @And("^User is navigated back to the login page$")
//    public void navigatedToTheLoginPage() throws Throwable {
//        loginPage.loginPageIsVisible();
//    }
//    @And("^I see a new page opens with the \"([^\"]*)\" title$")
//    public void iSeeANewPageOpensWithTheTitle(String Title) throws Throwable {
//        popupWindow.moveToNewWindow();
//        popupWindow.getTitleOfNewPage(driver, Title);
//    }
//    @And("^I see count for dashboard and third parties page and assert the number is same$")
//    public void theCountOfBothOfThesePagesShouldBeSame() throws Throwable {
//        int countHomePage = homePage.countForThirdParties();
//        driver.findElement(By.linkText("THIRD-PARTIES")).click();
//        wait.waitUntilPresent(thirdPartiesPage.countryMap, );
//        int countThirdPartyPage = thirdPartiesPage.thirdPartiesCount();
//        Assert.assertEquals(countHomePage, countThirdPartyPage);
//    }
//
//    @And("^I see a count for third parties on monitoring page$")
//    public void iSeeACountForThirdPartiesOnMonitoringPage() throws Throwable {
//        homePage.navigateToMonitoringPage();
//        wait.waitAndReturnElement(driver, By.id("screeningContent")).isDisplayed();
//        monitoringPage.openMonitoredThirParties();
//    }
//
//
//    @And("^I make sure the 'Questionnaires Outstanding' numbers are the same in right side bar and donut$")
//    public void iMakeSureTheQuestionnairesOutstandingNumbersAreTheSameInRightSideBarAndDonut() throws Throwable {
//       String donutNumber = wait.waitAndGetText(driver,
//               By.xpath(".//*[@id='thirdPartyFlowContainer']/div[1]/div/div[1]/div[2]"));
//       String rightNavNumber = wait.waitAndGetText(driver,
//               By.xpath(".//*[@id='thirdPartyTilesContainer']/div/ul/li[2]/div[1]/div[1]"));
//       Assert.assertEquals(donutNumber, rightNavNumber);
//    }
//
//    @And("^I choose the first dropdown option$")
//    public void iChooseTheFirstDropdownOption() throws Throwable {
//        wait.waitAndClick(driver, By.className("tt-selectable"));
//    }
//}
