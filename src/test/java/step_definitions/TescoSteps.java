package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

/**
 * Created by tdatta on 7/10/17.
 */
public class TescoSteps extends BaseClass{


    @Then("^I see the r-status as \"([^\"]*)\"$")
    public void iSeeTheRStatusAs(String arg0) throws Throwable {
        driver.findElement(By.xpath(String.format
                (".//*[@id='jqGrid']//td[contains(.,'%s')]", arg0))).isDisplayed();
    }
}
