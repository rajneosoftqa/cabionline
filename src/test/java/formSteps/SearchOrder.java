package formSteps;

import forms.BaseFormClass;
import helpers.Dropdown;
import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.CasePage;
import step_definitions.BaseClass;
import forms.SearchOrderForm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SearchOrder extends BaseClass {
    Wait wait = new Wait();
    Dropdown dropdown = new Dropdown();
    SearchOrderForm search = new SearchOrderForm();
    CasePage casePage = new CasePage(driver);

    public void fillordername(String name){
        search.orderName.sendKeys(name);
    }

    public void selectordertype(String ordertypename){
        dropdown.selectValueFromUnorderedListWithCheckbox(driver,search.ordertypediv,search.ordertypebutton, ordertypename);
    }


    public void fillorderstatus(String orderstatusname){
        dropdown.selectValueFromInput(search.orderstatusdiv,search.orderstatusbutton, orderstatusname);

    }

    public void fillorderstatusCMS(String orderstatusname){
        dropdown.selectValueFromInput(search.orderstatusdiv,search.orderstatusbutton, orderstatusname);

    }

    public void submitcal_1(String xpath){
        String id = "startSubmitDateContainer";
        if(!xpath.equals("")){
            id = xpath;
        }
        search.calbtn1.click();
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, -1);
        //dt = c.getTime();
        int cal_for_month = c.get(Calendar.DATE);
        System.out.println(cal_for_month);
        //cal_for_month = cal_for_month - 1;
        driver.findElement(By.xpath("//*[@id='"+id+"']/div/ul/li[1]/div/div[1]/table/tbody/*/td[text()="+cal_for_month+"]")).click();

    }


    public void submitcal_2(){
        search.calbtn2.click();
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, +1);
        int cal_for_month = c.get(Calendar.DATE);
//        cal_for_month = cal_for_month + 1;
        driver.findElement(By.xpath("//*[@id='endSubmitDateContainer']/div/ul/li[1]/div/div[1]/table/tbody/*/td[text()="+cal_for_month+"]")).click();
    }

    public void submitcal_3(){
        search.calbtn3.click();
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, -1);
        int cal_for_month = c.get(Calendar.DATE);
        //cal_for_month = cal_for_month - 1;
        driver.findElement(By.xpath("//*[@id='startCompletedDateContainer']/div/ul/li[1]/div/div[1]/table/tbody/*/td[text()="+cal_for_month+"]")).click();
    }

    public void submitcal_4(){
        search.calbtn4.click();
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, +1);
        int cal_for_month = c.get(Calendar.DATE);
//        cal_for_month = cal_for_month + 1;
        driver.findElement(By.xpath("//*[@id='endCompletedDateContainer']/div/ul/li[1]/div/div[1]/table/tbody/*/td[text()="+cal_for_month+"]")).click();
    }

    public void submitcal(String xpath){
        String id = "startSubmitDateContainer";
        if(!xpath.equals("")){
            id = xpath;
        }
        casePage.calButton.click();
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, -1);
        //dt = c.getTime();
        int cal_for_month = c.get(Calendar.DATE);
        System.out.println(cal_for_month);
        //cal_for_month = cal_for_month - 1;
        driver.findElement(By.xpath("//*[@id='"+id+"']/div/ul/li[1]/div/div[1]/table/tbody/*/td[text()="+cal_for_month+"]")).click();

    }

    public  void ordernumber(String orderno){
        search.ordernumber.sendKeys(orderno);
    }

    public  void searchbuttonclick() {
        search.searchbutton.click();
    }


    public  void resetbuttonclick() {
        wait.waitAndClick(search.resetbutton);
    }

    public  void viewresults() {
        wait.waitUntilPresent(search.result);
    }

    public  void viewresultscms() {
        wait.waitUntilPresent(search.noRecords);
    }
}
