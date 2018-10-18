package pageobjects;

import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;

/**
 * Created by tdatta on 6/19/17.
 */
public class MonitoringPage extends BaseClass{
    private WebElement element;
    private Wait wait = new Wait();

    @FindBy (id = "screeningContent")
    public WebElement resultTable;

    public MonitoringPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int openMonitoredThirParties() {
        int countNumber;
        WebElement totalDivs = wait.waitAndReturnElement
                (driver, By.xpath("//*[@id=\"main\"]/div[2]/div/section/section/ul/li[1]/a/span"));
        String count = element.getText();

        countNumber = Integer.parseInt(totalDivs.getText());
        System.out.println("The count is on third-parties page  " + countNumber);
        return countNumber;
    }
}
