//package step_definitions;
//
//import cucumber.api.java.en.And;
//import helpers.Wait;
//import org.openqa.selenium.By;
//import pageobjects.AnalyticsPage;
//
//public class AnalyticsSteps extends BaseClass{
//    private Wait wait = new Wait();
//    private AnalyticsPage analyticsPage = new AnalyticsPage();
//
//    @And("^There should be a tip explaining the the legends in the chart can be toggled$")
//    public void thereShouldBeATipExplainingTheTheLegendsInTheChartCanBeToggled() throws Throwable {
//        wait.waitUntilPresent(analyticsPage.tip, );
//    }
//
//    @And("^I can dismiss the tip and see its not available$")
//    public void iCanDismissTheTipAndSeeItsNotAvailable() throws Throwable {
//        analyticsPage.tipDismissButton.click();
//        wait.waitUntilNotPresent(By.className("analytics-tip-area"));
//    }
//    @And("^I see a download pdf option is available$")
//    public void iSeeADownloadPdfOptionIsAvailable() throws Throwable {
//        analyticsPage.pdfDownload.isDisplayed();
//    }
//
//}
