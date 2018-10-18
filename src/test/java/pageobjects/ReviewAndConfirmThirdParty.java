package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by tdatta on 6/5/17.
 */
public class ReviewAndConfirmThirdParty {
    private WebDriver driver;

    @FindBy (xpath = "//*[@id=\"3\"]/ul/li[1]/h3")
    public WebElement reviewDiligence;

    @FindBy(xpath = "//*[@id=\"3\"]/div/div/div/div[1]/div[1]/p")
    public WebElement thirdPartyName;

    @FindBy(xpath = "//*[@id=\"3\"]/div/div/div/div[2]/div/div/div/div/div[1]/span[2]")
    public WebElement affiliateName;

    @FindBy(xpath = "//*[@id=\"3\"]/div/div/div/div[3]/div[2]/p")
    public WebElement orderType;

    @FindBy(xpath = "//*[@id=\"3\"]/div/div/div/div[3]/div[3]/p")
    public WebElement orderName;

    @FindBy(id = "previousStepButton")
    public WebElement backButton;

    @FindBy(id = "submitOrderButton")
    public WebElement submitButton;


    public ReviewAndConfirmThirdParty(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
