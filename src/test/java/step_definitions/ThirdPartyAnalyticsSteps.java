package step_definitions;

import cucumber.api.java.en.And;
import helpers.SelectElements;
import pageobjects.AnalyticsPage;

public class ThirdPartyAnalyticsSteps extends BaseClass{
    private AnalyticsPage analyticsPage = new AnalyticsPage();
    private SelectElements selectElements = new SelectElements();


    @And("^I filter by \"([^\"]*)\" requestor$")
    public void iFilterBy(String arg0) throws Throwable {
        selectElements.selectJavaScriptItems("Filters_SelectedRequestorIds", arg0);
    }

    @And("^I click on the filter button$")
    public void iClickOnTheFilterButton() throws Throwable {
        Thread.sleep(3000);
        analyticsPage.filterButton.click();
    }

    @And("^I can reset the result to the original$")
    public void iCanResetTheResultToTheOriginal() throws Throwable {
        analyticsPage.resetButton.click();
    }

}
