package forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by tdatta on 6/14/17.
 */
public class OrderDetailsForm {

    WebDriver driver;

    @FindBy(id = "SelectedUserId")
    public WebElement selectUser;

    @FindBy(id = "SelectedProductTypeId")
    public WebElement selectOrderType;

    @FindBy(id = "OrderName")
    public WebElement orderName;

    @FindBy(id = "DueDate")
    public WebElement requestedDueDate;

    @FindBy(id = "RequestedBudgetCurrencyTypeId")
    public WebElement currency;

    @FindBy(id = "RequestedBudget")
    public WebElement budget;

    @FindBy(id = "ReferenceNumber")
    public WebElement clientReferenceID;


    @FindBy(id = "ProjectName")
    public WebElement project;

    @FindBy(id = "Notes")
    public WebElement orederNotes;

    @FindBy(className = "form-action")
    public WebElement addNewDoc;

    @FindBy(id = "saveOrderButton")
    public WebElement saveAsDraft;

    @FindBy(id = "cancelOrderButton")
    public WebElement cancelOrder;

    @FindBy(id = "nextStepButton")
    public WebElement continueButton;


    public OrderDetailsForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
