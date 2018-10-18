package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;

public class ThirdPartySummaryPage extends BaseClass{

    @FindBy(className = "subject-card")
    public WebElement affiliateSubjectCard;
    
    @FindBy (xpath = ".//*[@id='affiliates']/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/a/span")
    public WebElement editPencilButton;
    
    @FindBy (css = "ul.text-right:nth-child(1) > li:nth-child(2) > button:nth-child(1)")
    public WebElement initiateDilligenceButton;
    
    
    @FindBy (id = "editMonitoringDetailsActionLinks")
    public WebElement addRefreshEvents;

    public ThirdPartySummaryPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

}
