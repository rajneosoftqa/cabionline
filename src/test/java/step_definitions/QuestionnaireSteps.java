package step_definitions;

import cucumber.api.java.en.And;
import formSteps.FillUpQuestions;
import helpers.PopupWindow;
import helpers.Wait;
import org.openqa.selenium.By;

public class QuestionnaireSteps extends BaseClass{
    private PopupWindow popupWindow = new PopupWindow();
    private Wait wait = new Wait();

    @And("^I go to survey landing page$")
    public void iGoToSurveyLandingPage() throws Throwable {
        String currentURL = driver.getCurrentUrl();
        String newURL = currentURL+"/survey/landing";
        driver.get(newURL);
        Thread.sleep(1000);
        System.out.println("Current URL is "+ driver.getCurrentUrl());
    }

    @And("^I see list of questionnaire$")
    public void iSeeListOfQuestionnaire() throws Throwable {
      driver.findElement(By.id("activeSurveys")).isDisplayed();
    }

    @And("^I can click on any question to open in a new window$")
    public void iCanClickOnAnyQuestionToOpenInANewWindow() throws Throwable {
        driver.findElement(By.xpath(".//*[@id='activeSurveys']/div/ul[2]/li[1]/div")).click();
        Thread.sleep(1000);
    }

    @And("^I see the options for downloading documents$")
    public void iSeeTheOptionsForDownloadingDocuments() throws Throwable {
        driver.findElement(By.linkText("Click here to download the training manual")).isDisplayed();
        driver.findElement(By.linkText("Click here to download the terms and conditions")).isDisplayed();
        driver.findElement(By.linkText("Download Blank Questionnaire")).isDisplayed();
    }

    @And("^I start the questionnaire$")
    public void iStartTheQuestionnaire() throws Throwable {
        driver.findElement(By.linkText("Begin")).click();
    }

    @And("^I see the question being loaded$")
    public void iSeeTheQuestionBeingLoaded() throws Throwable {
       wait.waitUntilPresent(By.className("QuestionBody"));
    }

    @And("^I fill out the question first page$")
    public void iFillOutTheQuestionFirstPage() throws Throwable {
        FillUpQuestions fillUpQuestions = new FillUpQuestions();
        fillUpQuestions.fillQuestionnaireDetails();
    }
}
