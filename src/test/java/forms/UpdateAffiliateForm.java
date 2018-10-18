package forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateAffiliateForm extends BaseFormClass{

    @FindBy(id = "modalDailogCancelButton")
    public WebElement canelButton;
    
    @FindBy (id = "modalDialogConfirmButton")
    public WebElement saveAffiliates;

    public UpdateAffiliateForm(WebDriver driver) {
        super(driver);
    }
}
