package forms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;

import java.util.List;

public class SearchOrderForm extends BaseClass {

    @FindBy(id = "OrderName")
    public WebElement orderName;

    @FindBy(className = "checkbox")
    public List<WebElement> ordertype;

    @FindBy(id = "StartSubmitDate")
    public WebElement submitstart;

    @FindBy(id = "EndSubmitDate")
    public WebElement submitend;

    @FindBy(id = "StartCompletedDate")
    public WebElement completestart;

    @FindBy(id = "EndCompletedDate")
    public WebElement completeend;

    @FindBy(xpath = "//*[@id='startSubmitDateContainer']/span")
    public WebElement calbtn1;

    @FindBy(xpath = "//*[@id='endSubmitDateContainer']/span")
    public WebElement calbtn2;

    @FindBy(xpath = "//*[@id='startCompletedDateContainer']/span")
    public WebElement calbtn3;

    @FindBy(xpath = "//*[@id='endCompletedDateContainer']/span")
    public WebElement calbtn4;

    @FindBy(xpath = "//*[@id='filterForm']/div[1]/div[2]/div")
    public WebElement ordertypediv;

    @FindBy(xpath = "//*[@id='filterForm']/div[1]/div[2]/div/button")
    public WebElement ordertypebutton;

    @FindBy(xpath = "//*[@id='filterForm']/div[2]/div[3]/div")
    public WebElement orderstatusdiv;

    @FindBy(xpath = "//*[@id='filterForm']/div[2]/div[3]/div/button")
    public WebElement orderstatusbutton;

    @FindBy(xpath = "//*[@id='filterForm']/div[2]/div[3]/div")
    public WebElement orderstatusdivCMS;

    @FindBy(xpath = "//*[@id='filterForm']/div[2]/div[3]/div/button")
    public WebElement orderstatusbuttonCMS;

    @FindBy(id = "OrderNumber")
    public WebElement ordernumber;

    @FindBy(id = "SearchButton")
    public WebElement searchbutton;

    @FindBy(id = "ResetButton")
    public WebElement resetbutton;

    @FindBy(className = "indicator")
    public WebElement results;

    @FindBy(id = "grid-container")
    public WebElement result;

    @FindBy(id = "grid-no-records")
    public WebElement noRecords;




    public SearchOrderForm()
    {
        PageFactory.initElements(driver, this);
    }
}
