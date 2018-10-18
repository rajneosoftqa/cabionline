package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.*;
import step_definitions.BaseClass;

import java.util.List;

public class OrderSearchPage extends BaseClass {

    @FindBy(id = "moreFiltersButton")
    public WebElement moreFiltersButton;

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

    @FindBy(xpath = "//*[@id=\"startSubmitDateContainer\"]/span")
    public WebElement calbtn1;

    @FindBy(xpath = "//*[@id=\"endSubmitDateContainer\"]/span")
    public WebElement calbtn2;

    @FindBy(xpath = "//*[@id=\"startCompletedDateContainer\"]/span")
    public WebElement calbtn3;

    @FindBy(xpath = "//*[@id=\"endCompletedDateContainer\"]/span")
    public WebElement calbtn4;

    @FindBy(xpath = "//*[@id=\"filterForm\"]/div[1]/div[2]/div")
    public WebElement ordertypediv;

    @FindBy(xpath = "//*[@id=\"filterForm\"]/div[1]/div[2]/div/button")
    public WebElement ordertypebutton;

    @FindBy(xpath = "//*[@id=\"filterForm\"]/div[2]/div[3]/div")
    public WebElement orderstatusdiv;

    @FindBy(xpath = "//*[@id=\"filterForm\"]/div[2]/div[3]/div/button")
    public WebElement orderstatusbutton;

    @FindBy(id = "OrderNumber")
    public WebElement ordernumber;

    @FindBy(id = "SearchButton")
    public WebElement searchbutton;

    @FindBy(id = "ResetButton")
    public WebElement resetbutton;

    @FindBy(className = "indicator")
    public WebElement results;

    @FindBy(className = "fc-icon-left-single-arrow")
    public WebElement previousmonth;

    @FindBy(className = "fc-icon-right-single-arrow")
    public WebElement nextmonth;

    @FindBy(id = "subjectFormTypeCompany'")
    public WebElement subjectTypeCompany;

    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr[2]/td[6]")
    public WebElement firstOrderCms;

    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr[3]/td[5]")
    public WebElement secondOrderCms;

    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr[2]/td[5]")
    public WebElement submittedCms;





    public OrderSearchPage(){
        PageFactory.initElements(driver, this);
    }

    public void verifyAbsenceOfStatus(String status){

        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElement> inputs = orderstatusdiv.findElements(By.tagName("input"));
        for (WebElement input : inputs) {
            js.executeScript("arguments[0].setAttribute('style', 'display:none;')",input);
        }
        List<WebElement> options = orderstatusdiv.findElements(By.tagName("label"));
        for (WebElement option : options) {
            assertNotEquals(status, option.getText());
        }
    }
}
