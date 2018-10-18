package forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;

public class DiligenceTabForm extends BaseClass {
    
    @FindBy(id = "product-type-17")
    public WebElement creditSafe;
    
    @FindBy (id = "product-type-9")
    public WebElement DDIQ;
    
    @FindBy (id = "product-type-3")
    public WebElement level1;
    
    @FindBy (id = "product-type-4")
    public WebElement level1PlusSmartSource;

    @FindBy(id = "product-type-14")
    public WebElement questionnaire;

    @FindBy (id = "product-type-1")
    public WebElement questtionnairePLusDDIQ;

    @FindBy (id = "product-type-2")
    public WebElement redFlag;

    @FindBy (id = "product-type-8")
    public WebElement sanctions;
    
    @FindBy (id = "product-type-16")
    public WebElement screenIQ;

    
    public DiligenceTabForm (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
