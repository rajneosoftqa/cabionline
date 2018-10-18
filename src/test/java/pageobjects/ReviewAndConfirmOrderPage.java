package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by tdatta on 6/19/17.
 */
public class ReviewAndConfirmOrderPage {

    WebDriver driver;

    @FindBy(id = "cancelOrderButton")
    public WebElement cancelOrderButton;
    
    @FindBy (id = "previousStepButton")
    public WebElement backButton;
    
    @FindBy (id = "submitOrderButton")
    public WebElement submitOrderButton;

    @FindBy (className = "panel-subject")
    public WebElement subjectConfirm;


    public ReviewAndConfirmOrderPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
}
