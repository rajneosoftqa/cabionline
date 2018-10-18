package forms;

import com.github.javafaker.Address;
import com.github.javafaker.Company;
import com.github.javafaker.Faker;
import helpers.SelectElements;
import helpers.Wait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.awt.SystemColor.window;

/**
 * Created by tdatta on 6/22/17.
 */
public class UpdateDDIQSubjectForm extends ThirdPartyCompanyDetailsForm {
    private Faker faker = new Faker();
    private Company company = faker.company();
    private Address addressFaker = faker.address();
    private Random random = new Random();
    private SelectElements selectElements = new SelectElements();
    private Wait wait = new Wait();

    @FindBy(id = "Name")
    public WebElement Name;

    @FindBy(id = "modalDialogConfirmButton")
    public WebElement updateSubjectConfirmButton;


    public UpdateDDIQSubjectForm(WebDriver driver) {
        super(driver);
    }

    public void fillUpdateDDIQSubjectForm() throws InterruptedException {

        wait.waitAndClick(driver, By.cssSelector("span[title='Edit Subject']"));

        WebDriverWait block = new WebDriverWait(driver, 10);
        WebElement modal = block.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalDialog")));

        try {
            WebElement firstName = modal.findElement(By.id("FirstName"));
            firstName.clear();
            firstName.sendKeys(addressFaker.firstName());
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            WebElement name = modal.findElement(By.id("Name"));
            name.clear();
            name.sendKeys(company.name());
        }
        catch (Exception e){
            System.out.println(e);
        }


        try {
            WebElement webSite = modal.findElement(By.id("Website"));
            webSite.clear();
            webSite.sendKeys(company.url());

        }
        catch (Exception e){
            System.out.println(e);
        }
        try {
            WebElement lastName = modal.findElement(By.id("LastName"));
            lastName.clear();
            lastName.sendKeys(addressFaker.lastName());

        }
        catch (Exception e){
            System.out.println(e);
        }



        WebElement zipCode = modal.findElement(By.id("ZipCode"));
        zipCode.clear();
        zipCode.sendKeys(addressFaker.zipCode());

        WebElement streetAdress = modal.findElement(By.id("Address"));
        streetAdress.clear();
        streetAdress.sendKeys(addressFaker.streetAddress());

        modal.findElement(By.id("modalDialogConfirmButton")).click();

    }
}
