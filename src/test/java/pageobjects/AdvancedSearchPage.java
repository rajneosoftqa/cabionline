package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;

public class AdvancedSearchPage extends BaseClass{

    @FindBy(id = "SearchQuery")
    public WebElement searchBox;
    
    @FindBy (id = "SearchButton")
    public WebElement searchButton;
    
    @FindBy (id = "ResetButton")
    public WebElement resetButton;
    
    @FindBy (id = "SelectedAdvancedSearchSortId")
    public WebElement sort;
    
    @FindBy (id = "jqPager")
    public WebElement resultTable;

    @FindBy (xpath = "//span[@class='fa fa-info-circle']/parent::div")
    public WebElement advancedSearchInfo;

    @FindBy (xpath = "//span[@class='fa fa-info-circle']")
    public WebElement advancedSearchToolTip;


    public AdvancedSearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
