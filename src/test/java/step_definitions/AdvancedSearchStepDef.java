package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import helpers.Wait;
import helpers.WebElementExtensions;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageobjects.AdvancedSearchPage;

import java.util.List;

public class AdvancedSearchStepDef extends BaseClass{
    AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage(driver);
    Wait wait = new Wait();
    WebElementExtensions elementExtensions = new WebElementExtensions();
    Actions actions =  new Actions(driver);

    @And("^I search for \"([^\"]*)\" in the search box$")
    public void iSearchForInTheSearchBox(String arg0) throws Throwable {
        advancedSearchPage.searchBox.sendKeys(arg0);
        Thread.sleep(1000);
        actions.moveToElement(advancedSearchPage.searchButton).click().build().perform();
        wait.waitUntilGridSpinnersNotPresent();
    }

    @And("^I see the result populates in a table$")
    public void iSeeTheResultPopulatesInATable() throws Throwable {
        wait.waitUntilPresent(By.className("ui-row-ltr"));
    }

    @And("^I should see only \"([^\"]*)\" or \"([^\"]*)\" or \"([^\"]*)\" client name$")
    public void iShouldSeeOnlyOrOrClientName(String arg0, String arg1, String arg2) throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
//        wait.waitUntilPresent(By.className("ui-row-ltr"));
        List<WebElement> elements = elementExtensions.multipleElementsByCSS("td", "aria-describedby", "jqGrid_ClientAccountName");
        for (int i = 0; i < elements.size(); i++) {
            String clientName = elementExtensions.findByCSS("td", "aria-describedby", "jqGrid_ClientAccountName").getText();
            System.out.println("The Client name is " + clientName);
            assertTrue(clientName.equalsIgnoreCase(arg0) || clientName.equalsIgnoreCase(arg1) || clientName.equalsIgnoreCase(arg2) || clientName.equalsIgnoreCase(""));
        }
    }

    @And("^Advanced search functionalities are available$")
    public void advancedSearchFunctionalitiesAreAvailable() throws Throwable {
        advancedSearchPage.searchButton.isDisplayed();
        advancedSearchPage.searchBox.isDisplayed();
        advancedSearchPage.resetButton.isDisplayed();
        advancedSearchPage.sort.isDisplayed();
        advancedSearchPage.resultTable.isDisplayed();
    }

    @And("^I should only see my account for the report result$")
    public void iShouldOnlySeeMyAccountForTheReportResult() throws Throwable {
        List<WebElement> clientAccountName = wait.waitAndReturnListElements(driver, By.cssSelector("td[aria-describedby='jqGrid_ClientAccountName']"));
        for (WebElement element : clientAccountName){
            assertEquals("A Titu Client Child 1", element.getText());
        }
    }

    @And("^I use some \"(.*)\" to search for items in the report$")
    public void iUseSomeToSearchForItemsInTheReport(String arg0) throws Throwable {
        advancedSearchPage.searchBox.sendKeys(arg0);
        Thread.sleep(1000);
        actions.moveToElement(advancedSearchPage.searchButton).click().build().perform();
    }
}
