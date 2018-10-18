package step_definitions;

import cucumber.api.java.en.And;
import static org.junit.Assert.*;
import pageobjects.ReportingPage;

/**
 * Created by tdatta on 6/29/17.
 */
public class ReportingSteps extends BaseClass{
    private ReportingPage reportingPage = new ReportingPage(driver);

    @And("^I filter by \"([^\"]*)\" relationship status$")
    public void iFilterByRelationshipStatus(String status) throws Throwable {
        reportingPage.chooseRelationStatus(status);
    }

    @And("^I see summary tab has all the info about the third party$")
    public void iSeeSummaryTabHasAllTheInfoAboutTheThirdParty() throws Throwable {
        reportingPage.summaryTab();
    }

    @And("^I see \"([^\"]*)\" and \"([^\"]*)\" buttons$")
    public void iSeeAndButtons(String arg0, String arg1) throws Throwable {
       String relationshipstatusText = reportingPage.setRelationshipStatus.getText();
        assertEquals(relationshipstatusText, arg0);

        String initiateDiligenceText = reportingPage.initiateDiligence.getText();
        assertEquals(initiateDiligenceText, arg1);
    }
}
