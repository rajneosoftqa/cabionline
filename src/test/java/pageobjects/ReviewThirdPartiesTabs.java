package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewThirdPartiesTabs {

    @FindBy(css = "[data-bind='click: ViewInsightScoreOverride']")
    public WebElement riskModelOverride;

    public ReviewThirdPartiesTabs(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
