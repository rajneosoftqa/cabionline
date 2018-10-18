package pageobjects;

import helpers.CssHelpers;
import helpers.Dropdown;
import helpers.SelectElements;
import helpers.Wait;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import step_definitions.BaseClass;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CasePage extends BaseClass{

    private SelectElements selectElements = new SelectElements();
    private Dropdown dropdown = new Dropdown();
    private CssHelpers cssHelpers = new CssHelpers();
    private Wait wait = new Wait();
    private String startDate;
    private String endDate;
    private int noOfDays;
    ArrayList<Integer> daysList = new ArrayList<Integer>();
    String driverDirectory = System.getProperty("user.dir") + "/testData";

    @FindBy(id = "OrderName")
    public WebElement caseName;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div/div[2]/div/form[2]/div[1]/div[2]/div/button")
    public WebElement statusDropdown;

    @FindBy (id = "OrderNumber")
    public WebElement orderNumber;
    
    @FindBy (id = "SubjectName")
    public WebElement subjectName;
    
    @FindBy (id = "AccountId")
    public WebElement accountName;

    @FindBy (className = "modal-backdrop")
    public WebElement modal;

    @FindBy (className = "modal-backdrop")
    public List<WebElement> modals;

    @FindBy (id = "SupervisorId")
    public WebElement supervisorID;

    @FindBy (id = "PrimaryResearcherId")
    public WebElement primaryResearcherid;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div/div[2]/div/form[2]/div[1]/div[6]/div/button")
    public WebElement jurisdictionDorpdown;
    
    @FindBy (id = "SearchButton")
    public WebElement searchButton;

    @FindBy (xpath = "//div[contains(text(),'No subjects found')]")
    public WebElement quickSearchNotFound;

    @FindBy (className = "tt-open")
    public WebElement quickSearchContainer;

    @FindBy (xpath = "//div[@class='tt-menu']/div[@class='tt-dataset tt-dataset-subjects']/div")
    public WebElement quickSearchContainerLoad;

    @FindBy (xpath = "//div[@class='tt-menu']/div[@class='tt-dataset']/div")
    public List<WebElement> quickSearchContainerLoad1;

    @FindBy (className = "tt-open")
    public List<WebElement> quickSearchContainers;

    @FindBy (className = "tt-selectable")
    public List<WebElement> quickSearchResults;
    
    @FindBy (id = "ResetButton")
    public WebElement resetButton;

    @FindBy (xpath = "//*[@id='jqGrid']//tr[not(contains(@class,'jqgfirstrow'))][1]/td[3]")
    public WebElement firstrow;

    @FindBy (xpath = ".//*[@id='SupervisorId']")
    public WebElement coredetails;

    @FindBy (xpath = "//*[@id='caseDetails']/div/div[5]/span")
    public WebElement coredetailslink;

    @FindBy (xpath = "//*[@id='dueDateContainer']/span")
    public WebElement coredetailsDueDate;

    @FindBy(name = "DueDate")
    public WebElement duedate;

    @FindBy(name = "InterimReportDueDate")
    public WebElement interimreportduedate;

    @FindBy(className = "interim-due-date-completed-checkbox-center")
    public WebElement interimreportcheckbox;

    @FindBy(name = "InterimReportDueDateComplete")
    public WebElement interimreportbox;

    @FindBy(id = "cancelCaseCoreDetailsButton")
    public WebElement cancelCoreDetails;

    @FindBy(className = "generate-report-draft-btn")
    public WebElement generateSharedNotes;

    @FindBy(className = "generate-report-draft-btn")
    public List<WebElement> generateReports;

    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr/td[2 and text()='Kayli']/parent::tr/td[6]/p[text()='Research In Progress']")
    public WebElement reportStatus;

    @FindBy(xpath = "//*[@id='reportDraftJqGrid']/tbody/tr[2]/td[14]/div/a")
    public WebElement generateReport1;

    @FindBy(xpath = "//*[@id='reportDraftJqGrid']/tbody/tr[3]/td[14]/div/a")
    public WebElement generateReport2;

    @FindBy(id = "modalDialogConfirmButton")
    public WebElement confirmGenerate;

    @FindBy(id = "saveCaseCoreDetailsButton")
    public WebElement savecoredetails;

    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr[2]/td[6]")
    public WebElement firstCaseCms;

    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr/td[contains(text(),'IDM186')]")
    public WebElement firstCaseCmsNotes;

    @FindBy(xpath = "//*[@id='pageContentHeader']/ul[1]/li/h2")
    public WebElement caseTitle;

    @FindBy (id = "messagesTab")
    public WebElement messagesTab;

    @FindBy (id = "messages")
    public WebElement messageHistory;

    @FindBy(xpath = "//*[@id='orderMessageForm']/div/div/textarea")
    public WebElement messageBox;

    @FindBy(xpath = "//*[@id='orderMessageForm']/ul/li[2]/a")
    public WebElement sendMessage1;

    @FindBy (id = "modalDialogConfirmButton")
    public WebElement confirmSend;

    @FindBy(xpath = "//*[@id='filterForm']/div[1]/div[6]/div")
    public WebElement caseJurisdictiondiv;

    @FindBy(xpath = "//*[@id='filterForm']/div[1]/div[6]/div/button")
    public WebElement caseJurisdictionbutton;

    @FindBy(xpath = "//*[@id='summary']/div[1]/h3")
    public WebElement orderDetails;

    @FindBy(xpath = "//*[@id='caseDetails']/h3")
    public WebElement caseDetails;

    @FindBy(xpath = "//*[@id='caseDetails']/div/div[5]/h4")
    public WebElement coreDetails;

    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr[2]/td[4]")
    public WebElement externalMessageCMS;

    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr[2]/td[6]")
    public WebElement inProgresscase;

    @FindBy (xpath = "//a[contains(text(),'Reports')]")
    public WebElement reportsTab;

    @FindBy (xpath = "//a[contains(text(),'Summary')]")
    public WebElement summaryTab;

    @FindBy (xpath = "//*[@id='reports']/div/ul/li[1]/h3")
    public WebElement reportsTabtitle;

    @FindBy (id = "File")
    public WebElement uploadReport;

    @FindBy (id = "CaseDocumentTypeId")
    public WebElement reportType;

    @FindBy (id = "Title")
    public WebElement caseReportTitle;

    @FindBy (xpath = "//*[@id='supportingDocs']/div/div[5]/div/ul/li[1]/h3")
    public WebElement subjectSequence;

    @FindBy (xpath = "//*[@id='supportingDocs']/div/div[5]/div/ul/li[1]/h3")
    public List<WebElement> subjectSequenceList;

    @FindBy (xpath = "//*[@id='supportingDocs']/div/div[7]/div[1]/ul/li[1]/h3")
    public WebElement clientSubmittedDocs;

    @FindBy (xpath = "//*[@id='supportingDocs']/div/div/div[1]/ul/li[1]/h3")
    public WebElement clientSingleSubmittedDocs;

    @FindBy (id = "downloadAllClientButton")
    public WebElement downloadAllDocs;

    @FindBy (xpath = "//*[@id='supportingDocs']/div/div[7]/div[2]/div/ul/li[1]/h3")
    public WebElement caseDocuments;

    @FindBy (xpath = "//*[@id='column-header-row']/div[4]/div/h4")
    public WebElement criminalRecordsDeliverable;

    @FindBy (xpath = "//*[@id='column-header-row']/div[4]/div/h4")
    public List<WebElement> criminalRecordsDeliverableList;

    @FindBy (xpath = "//*[@id='jqGridProducts']/tbody/tr[7]/td[5]/a")
    public WebElement level1Details;

    @FindBy (xpath = "//*[@id='DeliverablesConfiguration_DeliverablesSelectedIds']/option[6]")
    public WebElement criminalRecordsOption;

    @FindBy (xpath = "//*[@id='DeliverablesConfiguration_DeliverablesAvailableIds']/option[1]")
    public WebElement criminalRecordsOptionRemove;

    @FindBy (xpath = "//*[@id='deselect-deliverable']/span")
    public WebElement deselectDeliverable;

    @FindBy (xpath = "//*[@id='select-deliverable']/span")
    public WebElement selectDeliverable;

    @FindBy (id = "selectOrderDeliverablesSubmit-button")
    public WebElement deliverablesSaveButton;

    @FindBy (xpath = "//*[@id='supportingDocs']/div/div[7]/div[2]/div/ul/li[1]/h3")
    public List<WebElement> caseDocumentsList;

    @FindBy (xpath = "//*[@id='supportingDocs']/div/div[7]/table[1]/tbody/tr/td[1]")
    public WebElement fileName;

    @FindBy (id = "saveReportDocumentButton")
    public WebElement uploadButton;

    @FindBy (id = "modalDialogConfirmButton")
    public WebElement confirmUploadbutton;

    @FindBy (id = "GeneratePdf")
    public WebElement generatePdfLink;

    @FindBy (xpath = "//*[@id='modalJqGrid']/tbody/tr[2]/td[1]/input")
    public WebElement firstRowpdf;

    @FindBy (id = "modalBody")
    public WebElement generatingPDF;

    @FindBy (id = "modalDialogConfirmButton")
    public WebElement generatePdfButton;

    @FindBy (xpath = "//*[@id='caseDetails']/div/div[1]/span/a")
    public WebElement editCaseAssignment;

    @FindBy (id = "assignCaseButton")
    public WebElement assignCasebutton;

    @FindBy (linkText = "DDIQ")
    public List<WebElement> ddiqTab;

    @FindBy (linkText = "DDIQ")
    public WebElement ddiqTabCMS;

    @FindBy (xpath = "//*[@id='subjectsContainer']/div[1]/h3")
    public WebElement verifyDDIQ;

    @FindBy (linkText = "Documents")
    public WebElement documentsTab;

    @FindBy (xpath = "//*[@id='pageContainer']/div[2]/div[2]/div[3]/div/div[1]/div/ul/li[1]/h3")
    public WebElement verifyDocumentstab;

    @FindBy(className = "dz-message")
    public WebElement uploadCasedocuments;

    @FindBy(id = "generatingButton")
    public WebElement editReportTypebutton;

    @FindBy(xpath = "//*[@id='modalBody']/div[2]/div[3]/input")
    public WebElement multipleMasterreportsOption;

    @FindBy(id = "modalDialogConfirmButton")
    public WebElement editReportNextButton;

    @FindBy(id = "modalDialogConfirmButton")
    public WebElement editReportUpdateButton;

    @FindBy(xpath = "//*[@id='modalFooterElement']/ul/li[1]/input")
    public WebElement generateReporttypeCancelbutton;

    @FindBy(id = "task-popup")
    public WebElement taskPopup;

    @FindBy(xpath = "//*[@id='modalBody']/div[1]/div[3]/input")
    public WebElement singleMasterreportOption;

    @FindBy(xpath = "//*[@id='pageContainer']/div[2]/div[2]/div[3]/div/div[3]/div/ul/li[1]/h3")
    public WebElement sharedNotes;

    @FindBy(xpath = "//*[@id='pageContainer']/div[2]/div[2]/div[3]/div/div[3]/div/ul/li[1]/h3")
    public List<WebElement> sharedNotesList;

    @FindBy(xpath = "//*[@id='pageContainer']/div[2]/div[2]/div[3]/div/div[4]/div/label")
    public WebElement sharedNotesfileName;

    @FindBy(linkText = "Open in Word")
    public WebElement sharedNotesOpeninWord;

    @FindBy(linkText = "Research")
    public WebElement researchTab;

    @FindBy(className = "fa-refresh")
    public WebElement refreshButton;

    @FindBy (className = "task")
    public List<WebElement> tasks;

    @FindBy (xpath = "//*[starts-with(@id,'reportDraftBtn')]/a/span")
    public WebElement editDraftstatusButton;

    @FindBy (xpath = "(//*[starts-with(@id,'reportDraftBtn')])[2]")
    public WebElement editDraftstatusButton2;

    @FindBy (xpath = "//*[starts-with(@id,'reportDraftSave')]/a/span")
    public WebElement getEditDraftstatusSavingoption;

    @FindBy(xpath = "//*[@id='thirdPartyContractorsForm']/div/div[1]/select")
    public WebElement thirdPartyContractorId;

    @FindBy(xpath = "//*[@id='thirdPartyContractorsForm']/div[1]/div[2]/select")
    public WebElement firstthirdPartyCurrencyid1;

    @FindBy(xpath = "//*[@id='thirdPartyContractorsForm']/div[1]/div[3]/input")
    public WebElement firstThirdPartybudjetid1;

    @FindBy(xpath = "//*[@id='thirdPartyContractorsForm']/div[2]/div[1]/select")
    public WebElement thirdPartyContractorId1;

    @FindBy(xpath = " //*[@id='thirdPartyContractorsForm']/div[1]/div[4]/div/span/span")
    public WebElement firstThirdpartyduedateid;

    @FindBy(xpath = "//*[@id='thirdPartyContractorsForm']/div[2]/div[4]/div/span/span")
    public WebElement secondThirdpartyduedateid;

    @FindBy(linkText = "Add Additional Contractor")
    public WebElement addAdditionalcontractorlink;

    @FindBy(id = "SelectedThirdPartyContractorId")
    public WebElement verifyThirdpartyDetails;

    @FindBy(id = "PrimaryResearcherId")
    public WebElement verifyPrimaryResearcherDetails;

    @FindBy(xpath = "//span[@class='fa fa-plus plus-icon-hourstracker']")
    public WebElement hoursTrackericon;

    @FindBy(xpath = "//*[@id='caseDetails']/div/div[2]/form[2]/div[2]/div[2]/select")
    public WebElement secondthirdPartyCurrencyid2;

    @FindBy(xpath = "//*[@id='caseDetails']/div/div[2]/form[2]/div[2]/div[3]/input")
    public WebElement secondThirdPartybudjetid2;

    @FindBy(id = "Hours")
    public WebElement inputHours;

    @FindBy(id = "SelectedHourReasonTypeId")
    public WebElement hourReasontype;

    @FindBy(xpath = "//*[@id='entryDateTimePicker']/span/span")
    public WebElement workingHoursdate;

    @FindBy(className = "save-text-hourstracker")
    public WebElement workingHoursSaveoption;

    @FindBy(className = "delete-icon-hourstracker")
    public WebElement deleteHoursTracker;

    @FindBy(id = "modalDialogConfirmButton")
    public WebElement confirmDeleteHoursTracker;

    @FindBy(xpath = "//div[@class='task']/i[not(contains(@style,'display: none'))]")
    public List<WebElement> highPriorityTasks;

    @FindBy(xpath = "//*[@id='headerActionButtons']/ul/li[1]/input")
    public WebElement assignCase;

    @FindBy(xpath = "//*[@id='headerActionButtons']/ul/li[1]/input")
    public WebElement firstAssignCase;

    @FindBy(id = "modalDialogConfirmButton")
    public WebElement confirmAssignCase;

    @FindBy(id = "calendarContainer")
    public WebElement calendarList;

    @FindBy(xpath = "//*[@id='caseDetails']/div/div[2]/div[5]/p")
    public WebElement associateEditor;

    @FindBy(xpath = "//*[@id='caseDetails']/div/div[2]/div[4]/p")
    public WebElement associateReviewer;

    @FindBy(xpath = "//table[@id='jqGridHoursTracker']/tbody/tr[last()-1]/td[@aria-describedby='jqGridHoursTracker_Hours']")
    public WebElement verifyHoursWorked;

    @FindBy(xpath = "//*[@id='jqGridHoursTracker']/tbody/tr[last()-1]/td[7]")
    public WebElement verifyReasonType;

    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr[2]/td[3]")
    public WebElement verifyAdvancedSearch;

    @FindBy(xpath = "//*[@id='column-header-row']/div/div/div/div/div")
    public List<WebElement> listMatrixBar;

    @FindBy(xpath = "//*[@id='taskMatrixScrollArea']/div[1]/div")
    public List<WebElement> listMatrixBox;

    @FindBy(xpath = "//*[@id='subjectsContainer']/div[2]/div[1]/div/div/div[1]/div/div[2]/ul/li[3]/span")
    public WebElement editProfilePencilDDIQ;

    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr[2]/td[3]")
    public List<WebElement> firstCasesCheck;

    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr[2]/td[3]")
    public WebElement firstCaseCheck;

    @FindBy(xpath = "//*[@id='headerActionButtons']/ul/li[3]/input")
    public WebElement completeCaseButton;

    @FindBy(id = "modalDialogConfirmButton")
    public WebElement confirmCompleteCaseButton;

    @FindBy(xpath = "//*[@id='headerActionButtons']/ul/li/input")
    public WebElement upgradeOrder;

    @FindBy(xpath = "/html/body/div[4]/div[2]")
    public WebElement inputDateToolTip;

    @FindBy(xpath = "//*[@id='deleteReportDocumentButton']/span")
    public List<WebElement> deleteReport;

    @FindBy(xpath = "//div[text()='Past Due']/parent::div/div[1]")
    public WebElement pastDueCount;

    @FindBy(xpath = "//*[@id='task-matrix']/div[1]/div[2]/div/div[2]/div[1]/i")
    public WebElement refresherIcon;

    @FindBy(linkText = "Dashboard")
    public WebElement dashboardCMS;

    @FindBy(className = "form-action addCompanySubjectJurisdictionButton")
    public WebElement addButton;

    @FindBy(className = "tooltip")
    public WebElement tooltipStatus;

    @FindBy(id= "modalDialogConfirmButton")
    public WebElement confirmAddButton;

    @FindBy(id= "saveCompanySubjectButton")
    public WebElement updateButton;

    @FindBy(xpath= "//*[@id='interimReportDueDateContainer']/span")
    public WebElement calButton;

    @FindBy(xpath= "//p[@id='singleProductDisplay']")
    public WebElement singleOrderType;

    @FindBy(xpath= "//*[@id='assignCaseForm']/div[5]/div")
    public WebElement editorDiv;

    @FindBy(xpath= "//*[@id='assignCaseForm']/div[5]/div/button")
    public WebElement editorButton;

    @FindBy(xpath= "//*[@id='assignCaseForm']/div[4]/div")
    public WebElement contentReviewerDiv;

    @FindBy(xpath= "//*[@id='assignCaseForm']/div[4]/div/button")
    public WebElement contentReviewerButton;

    @FindBy(id= "gridContainer")
    public WebElement dashboardContainer;

    @FindBy(className= "navbar")
    public WebElement navBar;

    @FindBy(xpath= "//*[@id='reportDraftJqGrid']/tbody/tr[2]/td[14]/div/a")
    public WebElement generateLink;

    @FindBy(xpath= "//*[@id='ReportTemplateFileNameForm']/div[2]/div/p/b")
    public WebElement duplicateFileNameMessage;

    @FindBy(xpath= "//div[@class='tooltip-inner']/div/div[@class='row'][1]/p[1]")
    public WebElement tooltipSubject1;

    @FindBy(xpath= "//div[@class='tooltip-inner']/div/div[@class='row'][1]/p[2]")
    public WebElement tooltipSubjectStatus1;

    @FindBy(xpath= "//div[@class='tooltip-inner']/div/div[@class='row'][2]/p[1]")
    public WebElement tooltipSubject2;

    @FindBy(xpath= "//div[@class='tooltip-inner']/div/div[@class='row'][2]/p[2]")
    public WebElement tooltipSubjectStatus2;

    @FindBy(id= "jqgh_jqGrid_ReportTemplateStatus")
    public WebElement reportStatusColumn;

    @FindBy(id= "modalDialogCancelButton")
    public WebElement reportDraftCancel;

    @FindBy(xpath= "//*[@id='jqGrid']/tbody/tr[not(@class='jqgfirstrow')]/td[6]/div[last()]")
    public List<WebElement> upcomingCasesList;

    @FindBy(xpath= "//*[@id='thirdPartyContractorsForm']/div/div[1]/label")
    public WebElement thirdPartyContractorField;

    @FindBy(xpath= "//*[@id='companySubjectFormContainer']/div[5]/div/div/div[2]/div[1]/span")
    public WebElement editJurisdiction;

    @FindBy(xpath= "//*[@id='companySubjectFormContainer']/div[5]/div/div/div[2]/div[1]/span")
    public List<WebElement> editJurisdictionList;

    @FindBy(id= "modalDialogConfirmButton")
    public WebElement controlledcaseConfirm;

    @FindBy(className= "saveCompanySubjectJurisdictionButton")
    public WebElement jurisdictionformSave;

    @FindBy(className= "controlled-case-banner")
    public WebElement controlledcaseBanner;

    @FindBy(linkText= "Advanced Search")
    public List<WebElement> advancedSearchList;



    int i = 1;


    public void reportDownloaded(String filename, String extension) throws Throwable {
        Thread.sleep(10000);
        File[] files = new File(driverDirectory).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
                assertTrue(FilenameUtils.getExtension(file.getName()).equals(extension) && file.getName().contains(filename));

                file.delete();
            }
        }
    }

    public void selectCaseEditor(String editortypename){
        dropdown.selectValueFromUnorderedListWithCheckbox(driver,editorDiv,editorButton,editortypename);
    }

    public void selectCaseContentReviewer(String contentReviewerTypeName){
        dropdown.selectValueFromUnorderedListWithCheckbox(driver,contentReviewerDiv,contentReviewerButton,contentReviewerTypeName);
    }

    public ArrayList<Integer> calculateDate(int no){
        noOfDays = no;
        Date now = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar start = Calendar.getInstance();
        start.setTime(now);

        int workingDays = 0;
        int i = 0;
        while(i < noOfDays)
        {
            int day = start.get(Calendar.DAY_OF_WEEK);
            if ((day != Calendar.SATURDAY) && (day != Calendar.SUNDAY))
            {
                workingDays++;
                Date date = start.getTime();
                String days = new SimpleDateFormat("dd").format(date);
                String month = new SimpleDateFormat("MM").format(date);
                String year = new SimpleDateFormat("yyyy").format(date);
                //System.out.println(days);
                daysList.add(Integer.parseInt(days));
            }
            start.add(Calendar.DATE, 1);
            i++;
        }
            //System.out.println(workingDays);
            //System.out.println(daysList.size());
        return daysList;
    }

    public WebElement reportStatusFunction(String ordername,String status){
    WebElement reportStatus = driver.findElement(By.xpath("//*[@id='jqGrid']/tbody/tr/td[2 and text()='"+ordername+"']/parent::tr/td[6]/p[text()='"+status+"']"));
    return reportStatus;
}

    public void selectfirstThirdpartyBudjet(String firstThirdpartybudjet1){
        firstThirdPartybudjetid1.clear();
        firstThirdPartybudjetid1.sendKeys(firstThirdpartybudjet1);
    }

    public void selectSecondThirdpartyBudjet(String secondThirdPartybudjet2){
        secondThirdPartybudjetid2.clear();
        secondThirdPartybudjetid2.sendKeys(secondThirdPartybudjet2);
    }

    public void inputWorkinghours(String workingHours){
        inputHours.sendKeys(workingHours);
    }

    public void selecthoursReasontype(String reasonType) {
        selectElements.selectByVisibleText(hourReasontype, reasonType);
    }

    public void selectThirdpartyContractor1() {
        selectElements.selectByIndexNumbert(thirdPartyContractorId1, 1);
    }

    public String selectThirdpartyContractor() {
        String thirdParty = selectElements.selectByIndexNumbert(thirdPartyContractorId, 1);
        return thirdParty;
    }

    public void selectfirstThirdpartyCurrency(String firstthirdPartyCurrency1) {
        selectElements.selectByVisibleText(firstthirdPartyCurrencyid1, firstthirdPartyCurrency1);
    }

    public void selectSecondThirdpartyCurrency(String secondThirdPartyCurrency2) {
        selectElements.selectByVisibleText(secondthirdPartyCurrencyid2, secondThirdPartyCurrency2);
    }

    public void selectPrimaryresearcherId(){
        selectElements.selectByIndexNumbert(primaryResearcherid,1);
    }

    public void selectPrimaryresearcher(String primaryResearcher){
        selectElements.selectByVisibleText(primaryResearcherid,primaryResearcher);
//        for(WebElement w : new Select(primaryResearcherid).getOptions()){
//            System.out.println(w.getText());
//        }
    }

    public void selectSupervisorid(){
        selectElements.selectByIndexNumbert(supervisorID,1);
    }

    public void selectSupervisoridText(String primarySupervisor){
        selectElements.selectByVisibleText(supervisorID,primarySupervisor);
    }


    public void selectAccountId(String accountId){
        selectElements.selectByVisibleText(accountName,accountId);
    }

    public void selectreportType(String uploadReporttype){
        selectElements.selectByVisibleText(reportType,uploadReporttype);
    }

    public void fillcaseJurisdiction(String caseJurisdiction) {
        dropdown.selectValueFromUnorderedListWithCheckbox(driver,caseJurisdictiondiv,caseJurisdictionbutton,caseJurisdiction);

    }

    public void completeMatrixtasks()throws Throwable{
        List<WebElement> element = driver.findElements(By.xpath("//*[@class='task' and contains(@style,'52, 152, 219')]"));

        System.out.println(element.size());
        if(element.size()>0){
            for(WebElement task1 : element){
                    task1.click();
                    cssHelpers.HideElement(taskPopup);
                    //Thread.sleep(1000);
                    try {
                        wait.waitUntilExpectedCss(driver, task1, "background-color", "211, 211, 211");
                    }
                    catch (Exception e){
                        cssHelpers.HideElement(taskPopup);
                        Thread.sleep(5000);
                        task1.click();
                        wait.waitUntilExpectedCss(driver, task1, "background-color", "211, 211, 211");
                    }
                    assertTrue(task1.getAttribute("style").contains("211, 211, 211"));
            }
        }
        for(WebElement tasks : tasks){
            if(tasks.getAttribute("style").equals("211, 211, 211")){
                tasks.click();
                cssHelpers.HideElement(taskPopup);
                //Thread.sleep(1000);
                try{
                    wait.waitUntilExpectedCss(driver,tasks,"background-color","52, 152, 219");
                }
                catch (Exception e){
                    cssHelpers.HideElement(taskPopup);
                    Thread.sleep(5000);
                    tasks.click();
                    wait.waitUntilExpectedCss(driver,tasks,"background-color","52, 152, 219");
                }
                assertTrue(tasks.getAttribute("style").contains("52, 152, 219;"));


            }
        }
        System.out.println(tasks.size());
        for(WebElement task1 : tasks){
            if(task1.getAttribute("style").contains("52, 152, 219")){
                task1.click();
                cssHelpers.HideElement(taskPopup);
                //Thread.sleep(1000);
                try {
                    wait.waitUntilExpectedCss(driver, task1, "background-color", "211, 211, 211");
                }
                catch (org.openqa.selenium.TimeoutException e){
                    cssHelpers.HideElement(taskPopup);
                    Thread.sleep(5000);
                    task1.click();
                    wait.waitUntilExpectedCss(driver, task1, "background-color", "211, 211, 211");
                }
                assertTrue(task1.getAttribute("style").contains("211, 211, 211"));

            }
        }
    }

    public void setHighPriorityTasks(){
        List<WebElement> element = driver.findElements(By.xpath("//*[@class='task' and contains(@style,'52, 152, 219')]"));
        System.out.println("Size: "+element.size());
        if(element.size()>0){
            for(WebElement task1 : element){
                task1.click();
                cssHelpers.HideElement(taskPopup);
                System.out.println("color: "+task1.getCssValue("background-color"));
                //Thread.sleep(1000);
                wait.waitUntilExpectedCss(driver,task1,"background-color","211, 211, 211");
                assertTrue(task1.getAttribute("style").contains("211, 211, 211"));
            }
        }

        System.out.println("test  " + highPriorityTasks);
        for(WebElement task : highPriorityTasks){
            task.click();
            cssHelpers.HideElement(taskPopup);
        }
    }

    public void verifyTaskMatrix()throws Throwable{
        for(WebElement box: listMatrixBox){
            List<WebElement> tasks = box.findElements(By.xpath("//*[@id='taskMatrixScrollArea']/div[1]/div["+i+"]/div/div"));
            System.out.println("size - "+tasks.size());
            for (WebElement task: tasks){
                task.click();
                cssHelpers.HideElement(taskPopup);
                System.out.println("color: "+task.getCssValue("background-color"));
//                wait.waitUntilExpectedCss(driver,task,"background","rgb(52, 152, 219)");
                try {
                    wait.waitUntilExpectedCss(driver, task, "background-color","52, 152, 219");
                }
                catch (org.openqa.selenium.TimeoutException e){
                    cssHelpers.HideElement(taskPopup);
                    Thread.sleep(5000);
                    task.click();
                    wait.waitUntilExpectedCss(driver, task, "background-color","52, 152, 219");
                }
                String test = StringUtils.substringBetween(/*listMatrixBar.get(i)*/driver.findElement(By.xpath("//*[@id='column-header-row']/div["+i+"]/div/div/div/div")).getAttribute("style"),"width:", ";");
                //System.out.println(listMatrixBar.get(i).getAttribute("style"));
                System.out.println(test);
                //System.out.println(listMatrixBar.get(i).getCssValue("height"));
            }
            i++;
        }
    }

    public CasePage(WebDriver driver){
        PageFactory.initElements(this.driver, this);
    }
}

