package forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;

public class QuestionnaireRecipientForm extends BaseClass{
    @FindBy(id = "SelectedSurveyId-0")
    public WebElement chooseQuestionnaire;

    @FindBy (id = "SurveyRecipientFirstName-0")
    public WebElement firstName;

    @FindBy(id = "SurveyRecipientLastName-0")
    public WebElement lastName;

    @FindBy (id = "SurveyRecipientEmailAddress-0")
    public WebElement email;
    
    @FindBy (id = "SurveyRecipientLanguageId-0")
    public WebElement languages;

    public QuestionnaireRecipientForm(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

}
