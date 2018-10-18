package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;

public class AnalyticsPage extends BaseClass{
    
    @FindBy(id = "Filters_StartCreateDate")
    public WebElement filtersStartCreateDate;
    
    @FindBy (id = "Filters_EndCreateDate")
    public WebElement filtersEndCreateDate;

    @FindBy (id = "search-button")
    public WebElement filterButton;

    @FindBy (id = "reset-button")
    public WebElement resetButton;

    @FindBy (id = "report-card-4ab6fdcb-ae0c-4f58-b30a-dca52dd556b1")
    public WebElement reportGraph;
    
    @FindBy (id = "tip-dismiss-button")
    public WebElement tipDismissButton;

    @FindBy (className = "analytics-tip-area")
    public WebElement tip;

    @FindBy (id = "pdf-export-button-text")
    public WebElement pdfDownload;


    public AnalyticsPage(){
        PageFactory.initElements(driver, this);
    }

}
