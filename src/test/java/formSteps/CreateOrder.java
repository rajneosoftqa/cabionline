package formSteps;

import com.github.javafaker.*;
import com.github.javafaker.Number;
import forms.OrderDetailsForm;
import helpers.Dropdown;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.SubjectIndividualFormPage;
import helpers.ScrollintoView;
import helpers.Wait;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pageobjects.SubjectCompanyFormPage;
import step_definitions.BaseClass;

import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by tdatta on 6/14/17.
 */
public class CreateOrder extends BaseClass {


    private OrderDetailsForm orderDetailsForm = new OrderDetailsForm(driver);
    private SubjectCompanyFormPage subjectCompanyFormPage = new SubjectCompanyFormPage(driver);
    private SubjectIndividualFormPage sif = new SubjectIndividualFormPage(driver);
    private Wait wait = new Wait();
    private Faker faker = new Faker();
    Dropdown dropdown = new Dropdown();
    @FindBy(xpath = "//*[@id=\"companySubjectForm\"]/div[10]/div/button")
    public WebElement button;

    @FindBy(xpath = "//*[@id=\"companySubjectForm\"]/div[10]/div")
    public WebElement div;


    private Company company = faker.company();
    private Number number = faker.number();
    private IdNumber idNumber = faker.idNumber();
    private Address address = faker.address();
    private ScrollintoView scrollintoView = new ScrollintoView();


    public void fillOrderDetails(String accountName)throws InterruptedException {

            new Select(driver.findElement(By.id("SelectedUserId"))).selectByVisibleText(accountName);
            new Select(driver.findElement(By.id("SelectedProductTypeId"))).selectByVisibleText("Level 1");
            orderDetailsForm.orderName.sendKeys("test");
            orderDetailsForm.continueButton.click();
        }

    public String fillCompanySubjectForm(String companyName) throws Exception{
//        String companyName = faker.company().name();
        wait.waitUntilPresent(subjectCompanyFormPage.enterSubjectVisible);
        scrollintoView.scrollUp();
        wait.waitAndClick(subjectCompanyFormPage.subjectFormTypeCompany);
        subjectCompanyFormPage.name.sendKeys(companyName);
        subjectCompanyFormPage.taxID.sendKeys(idNumber.validSvSeSsn());
        new Select(driver.findElement(By.id("CountryId"))).selectByVisibleText("United States");
        new Select(driver.findElement(By.id("CountryOfIncorporationId"))).selectByVisibleText("United States");
        subjectCompanyFormPage.addresSubjectCompany.sendKeys(address.streetAddress());
        new Select(driver.findElement(By.id("RegionId"))).selectByVisibleText(address.state());
        subjectCompanyFormPage.city.sendKeys(address.city());
        subjectCompanyFormPage.zipCode.sendKeys(address.zipCode());
        subjectCompanyFormPage.website.sendKeys(company.url());
//        dropdown.selectValueFromUnorderedListWithCheckbox(driver, div, button, "United States");
        wait.waitAndClick(subjectCompanyFormPage.addSubjectToOrder);
        Thread.sleep(10000);
//        wait.waitUntilTextIs(subjectCompanyFormPage.addSubjectToOrder,"Add Subject To Order");
//        wait.waitUntilPresent(subjectCompanyFormPage.addSubjectToOrder);
//        System.out.println("clicking order");
        return companyName;
    }

    public void fillIndividualSubjectForm(String firstname, String lastname) throws Throwable{
        String firstName = firstname;
        String lastName = lastname;
        wait.waitUntilPresent(subjectCompanyFormPage.enterSubjectVisible);
        sif.firstName.sendKeys(firstName);
        sif.lastName.sendKeys(lastName);
        wait.waitUntilPresent(By.id("GenderId"));
        new Select(driver.findElement(By.id("GenderId"))).selectByVisibleText("Male");
        wait.waitAndSendKeys(driver, By.id("Employer"),"test");
        new Select(driver.findElement(By.xpath("//*[@id='individualSubjectForm']/div[12]/select"))).selectByVisibleText("United States");
        wait.waitAndClick(sif.addSubjectToOrder);
        Thread.sleep(10000);
//        wait.waitUntilTextIs(sif.addSubjectToOrder,"Add Subject To Order");
//        wait.waitUntilPresent(sif.addSubjectToOrder);
//        assertThat(sif.addedSubject.getText(), CoreMatchers.containsString(firstName));
//        sif.continueButton.click();
    }
}
