package pageobjects;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import cucumber.api.java.en.And;
import formSteps.CreateOrder;
import formSteps.SearchOrder;
import helpers.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import step_definitions.BaseClass;

import java.io.File;
import java.util.List;

public class OrderPage extends BaseClass {
    SelectElements selectElements = new SelectElements();
    Faker faker = new Faker();
    Wait wait = new Wait();
    Actions actions = new Actions(driver);
    CssHelpers cssHelpers = new CssHelpers();
    String ordersName = faker.superhero().name().toLowerCase().replaceAll("'","");
    String companyName = faker.company().name().replaceAll("'","");;
    CreateOrder createOrder = new CreateOrder();
    private Name name = faker.name();
    String firstname = name.firstName();
    String lastname = name.lastName();
    SubjectCompanyFormPage subjectCompanyFormPage = new SubjectCompanyFormPage(driver);
    CasePage casePage = new CasePage(driver);


    public OrderPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "SelectedClientAccountId")
    public WebElement account;

    @FindBy(xpath = "//*[@id='SelectedClientAccountId']")
    public WebElement accountType;

    @FindBy(id = "SelectedProductTypeId")
    public WebElement orderType;

    @FindBy(id = "OrderName")
    public WebElement orderName;

    @FindBy(id = "DueDate")
    public WebElement dueDate;

    @FindBy(id = "ReferenceNumber")
    public WebElement referenceNumber;

    @FindBy(id = "nextStepButton")
    public WebElement continueButton;

    @FindBy(xpath = "//*[@id='subjectsReviewContainer']/div[2]/div[1]/div/div/div/div/div[1]")
    public WebElement subjectNameDiv;

    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr[2]/td[2]")
    public WebElement firstOrder;

    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr[2]/td[4]")
    public WebElement firstOrdercCms;

    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr[2]/td[2]")
    public List<WebElement> firstOrderCheck;


    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr[2]/td[4]")
    public List<WebElement> firstOrderCheckCms;

    @FindBy(xpath = "//*[@id=\"jqGrid\"]/tbody/tr[3]/td[2]")
    public WebElement secondOrder;

    @FindBy(xpath = "//*[@id=\"jqGrid\"]/tbody/tr[3]/td[2]")
    public List<WebElement> secondOrderCheck;

    @FindBy(id = "order-title")
    public WebElement ordertitle;

    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr[2]/td[3]")
    public WebElement inProgressOrder;

    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr[2]/td[2]")
    public WebElement inProgressCase;

    @FindBy(xpath = "//*[@id=\"1\"]/div[1]/h3")
    public WebElement enterSubjects;

    @FindBy(id = "messagesTab")
    public WebElement messagesTab;

    @FindBy(id = "messages")
    public WebElement messageHistory;

    @FindBy(className = "panel-body")
    public WebElement sentMessage;

    @FindBy(id = "Comment")
    public WebElement comment;

    @FindBy(id = "addMessageButton")
    public WebElement addMessage;

    @FindBy(partialLinkText = "Add New Document")
    public WebElement addNewdocument;

    @FindBy(xpath = "//*[@id='File']")
    public WebElement submitDocuments;

    @FindBy(id = "addOrderDocumentButton")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id='deleteOrderDocumentButton']/span")
    public WebElement deleteButton;

    @FindBy(xpath = "//a[contains(text(),'View Case')]")
    public WebElement viewCase;

    @FindBy(xpath = "/html/body/nav[1]/div[2]/div[1]/a")
    public WebElement backToDashBoard;

    @FindBy(id = "SelectedUserId")
    public WebElement requesterCreateOrder;

    @FindBy(xpath = "//*[@id='submittedDocumentsContainer']/a/span")
    public WebElement addDocument;


    public String createOrder(String arg0)  throws Throwable {
        wait.waitAndClick(driver, By.className("btn-create-dash"));
        fillOrderDetails("Level 1", ordersName);
        System.out.println("order name is used: " + ordersName);
        if (arg0.equals("company")) {
            companyName = createOrder.fillCompanySubjectForm(companyName);
            System.out.println("Company name is " + companyName);
        } else if (arg0.equals("individual")) {
            createOrder.fillIndividualSubjectForm(firstname, lastname);
        }
        subjectCompanyFormPage.continueButton.click();
        if(arg0.equals("company")){
            String actual = wait.waitAndGetText(driver, By.xpath("//*[@id='subjectsReviewContainer']//*[contains(text(),'"+companyName+"')]"));
//        System.out.println(companyName.toLowerCase()+" ===== "+actual.toLowerCase());
            assertEquals(companyName.toLowerCase(), actual.toLowerCase());
        }
        else{
            String actual = wait.waitAndGetText(driver, By.xpath("//*[@id='subjectsReviewContainer']//*[contains(text(),'"+firstname+"')]"));
            System.out.println(firstname.toLowerCase() + " " + lastname.toLowerCase()+" ===== "+actual.toLowerCase());
            assertEquals(firstname.toLowerCase() + " " + lastname.toLowerCase(), actual.toLowerCase());
        }
        return ordersName;
    }

    public void createCaseOrder(String arg0, String arg1) throws Throwable {
        new HomePage(driver).navigateToOrdersPage();
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitAndClick(driver, By.className("btn-create-dash"));
        fillOrderCaseDetails(arg0);
        System.out.println("order name is used: " + ordersName);
        if (arg1.equals("company")) {
            companyName = createOrder.fillCompanySubjectForm(companyName);
            System.out.println("Company name is " + companyName);
        } else if (arg1.equals("individual")) {
            createOrder.fillIndividualSubjectForm(firstname, lastname);
        }
        subjectCompanyFormPage.continueButton.click();
        if(arg1.equals("company")){
            String actual = wait.waitAndGetText(driver, By.xpath("//*[@id='subjectsReviewContainer']//*[contains(text(),'"+companyName+"')]"));
//        System.out.println(companyName.toLowerCase()+" ===== "+actual.toLowerCase());
            assertEquals(companyName.toLowerCase(), actual.toLowerCase());
        }
        else{
            String actual = wait.waitAndGetText(driver, By.xpath("//*[@id='subjectsReviewContainer']//*[contains(text(),'"+firstname+"')]"));
            System.out.println(firstname.toLowerCase() + " " + lastname.toLowerCase()+" ===== "+actual.toLowerCase());
            assertEquals(firstname.toLowerCase() + " " + lastname.toLowerCase(), actual.toLowerCase());
        }
        wait.waitAndClick(new ReviewAndConfirmOrderPage(driver).submitOrderButton);
        Thread.sleep(5000);
        new HomePage(driver).navigateToOrdersPage();
        wait.waitUntilGridSpinnersNotPresent();
        new SearchOrder().fillordername(arg0);
        new SearchOrder().fillorderstatusCMS("Submitted");
        new SearchOrder().searchbuttonclick();
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitUntilClickable(firstOrdercCms).click();
        new PopupWindow().moveToNewTab();
        Thread.sleep(5000);
        assertTrue(wait.waitUntilPresent(ordertitle).isDisplayed());
        System.out.println(wait.waitUntilPresent(ordertitle).isDisplayed());
        Thread.sleep(5000);
        new ScrollintoView().scrollToView(viewCase);
        wait.waitAndClick(viewCase);

        wait.waitAndClick(casePage.editCaseAssignment);
        casePage.selectSupervisorid();
        casePage.selectPrimaryresearcher("Titu Datta [Researcher]");
        wait.waitAndClick(casePage.assignCasebutton);
        new ScrollintoView().scrollUp();
//        scrollintoView.scrollToView(casePage.assignCase);
        wait.waitAndClick(casePage.assignCase);
        wait.waitAndClick(casePage.confirmAssignCase);

    }

    public String[] fillOrderDetails(String orderTypeName, String orderNameString) throws Throwable {
        selectElements.selectByIndexNumbert(account, 1);
        selectElements.selectByVisibleText(orderType, orderTypeName);
        orderName.sendKeys(orderNameString);
        wait.waitAndClick(addDocument);
        String fileUpload = System.getProperty("user.dir") + File.separator + "testData" + File.separator + "Upload" + File.separator + "test1kb.pdf";
        wait.waitUntilPresent(casePage.uploadReport).sendKeys(fileUpload);
        casePage.caseReportTitle.sendKeys("Dummy Report");
        wait.waitAndClick(saveButton);
        wait.waitUntilPresent(deleteButton);
        Thread.sleep(5000);
        wait.waitAndClick(continueButton);
        return new String[]{orderTypeName, orderNameString};
    }

    public String[] fillOrderCaseDetails(String orderNameString) {
        selectElements.selectByVisibleText(account, "A Titu Client Child 1");
        selectElements.selectByIndexNumbert(orderType, 4);
        selectElements.selectByIndexNumbert(requesterCreateOrder,1);
        orderName.sendKeys(orderNameString);
        continueButton.click();
        return new String[]{new Select(orderType).getFirstSelectedOption().getText(), orderNameString};
    }


    public  String[] fillOrderDetailsicv(String orderTypeicv, String orderNameicv) {
        selectElements.selectByVisibleText(orderType, orderTypeicv);
        orderName.sendKeys(orderNameicv);
        continueButton.click();
        return new String[]{orderTypeicv, orderNameicv};
    }


    public void sortOrderByColumnHeader(String sortColumnName, int numberOfTimes) throws Throwable {
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitUntilPresent(By.id(String.format("jqgh_jqGrid_%s", sortColumnName)));
        if (numberOfTimes == 1) {
            wait.waitAndClick(driver.findElement(By.id(String.format
                    ("jqgh_jqGrid_%s", sortColumnName))));
        }
        if (numberOfTimes == 2) {
            wait.waitAndClick(driver.findElement(By.id(String.format
                    ("jqgh_jqGrid_%s", sortColumnName))));
            wait.waitUntilGridSpinnersNotPresent();
            Thread.sleep(10000);
            wait.waitAndClick(driver.findElement(By.id(String.format
                    ("jqgh_jqGrid_%s", sortColumnName))));
            Thread.sleep(10000);
            wait.waitUntilGridSpinnersNotPresent();
        }
        if (numberOfTimes == 3) {
            driver.findElement(By.id(String.format("jqgh_jqGrid_%s", sortColumnName))).click();
            wait.waitUntilGridSpinnersNotPresent();
            driver.findElement(By.id(String.format("jqgh_jqGrid_%s", sortColumnName))).click();
            wait.waitUntilGridSpinnersNotPresent();
            driver.findElement(By.id(String.format("jqgh_jqGrid_%s", sortColumnName))).click();

        }
        wait.waitUntilGridSpinnersNotPresent();
    }

    public void reviewOrderType(String orderType){
        String orderTypeActual = wait.waitAndGetText(driver, By.xpath("//*[@id='orderDetailsReview']/div[1]/p"));
        assertEquals(orderTypeActual,orderType);
    }

    public WebElement clickSearchedOrder(String ordername){
        return driver.findElement(By.xpath("//*[@id='jqGrid']/tbody/tr/td[text()='"+ordername+"']"));
    }


    public void fillOrderName() throws Throwable {
        casePage.caseName.sendKeys(ordersName);
    }


}
