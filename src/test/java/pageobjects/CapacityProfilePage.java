package pageobjects;

import helpers.Dropdown;
import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.BaseClass;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class CapacityProfilePage extends BaseClass {

    private Dropdown dropdown = new Dropdown();
    private Wait wait = new Wait();


    @FindBy(id = "FirstName")
    public WebElement firstName;

    @FindBy(xpath = "//a[contains(text(),'Capacity Profile')]")
    public WebElement capacityProfileTab;

    @FindBy(xpath = "//a[contains(text(),'Capacity Profile')]")
    public List<WebElement> capacityProfile;

    @FindBy(xpath = "//*[@id='pageContainer']/div[1]/ul/li/h2")
    public WebElement verifyCapacityProfileTab;

    @FindBy(id = "FirstName")
    public WebElement firstNameDiligenceSkills;

    @FindBy(id = "HireDate")
    public WebElement hireDateDiligenceSkillsButton;

    @FindBy(id = "LastName")
    public WebElement lastNameDiligenceSkills;

    @FindBy(xpath = "//*[@id='filterForm']/div[1]/div[3]/div/button")
    public WebElement positionDiligenceSkills;

    @FindBy(xpath = "//*[@id='filterForm']/div[1]/div[4]/div/button")
    public WebElement homeOfficeDiligenceSkillsButton;

    @FindBy(xpath = "//*[@id='filterForm']/div[1]/div[5]/div/button")
    public WebElement languageDiligenceSkillsButton;

    @FindBy(xpath = "//*[@id='filterForm']/div[1]/div[6]/div/button")
    public WebElement orderTypeDiligenceSkillsButton;

    @FindBy(xpath = "//*[@id='filterForm']/div[1]/div[7]/div/button")
    public WebElement jurisdictionDiligenceSkillsButton;

    @FindBy(xpath = "//*[@id='filterForm']/div[1]/div[8]/div/button")
    public WebElement accountNameDiligenceSkills;

    @FindBy(xpath = "//*[@id='filterForm']/div[1]/div[3]/div/button")
    public WebElement dropdownDiligencePositionButton;

    @FindBy(xpath = "//*[@id='filterForm']/div[1]/div[3]/div")
    public WebElement positionDiv;

    @FindBy(xpath = "//*[@id='filterForm']/div[1]/div[4]/div")
    public WebElement homeOfficeDiv;

    @FindBy(xpath = "//*[@id='filterForm']/div[1]/div[5]/div")
    public WebElement languageDiv;

    @FindBy(xpath = "//*[@id='edit-profile-form']/div/div[6]/div")
    public WebElement languageEditDiv;

    @FindBy(xpath = "//*[@id='edit-profile-form']/div/div[8]/div")
    public WebElement jurisdictionEditDiv;

    @FindBy(xpath = "//*[@id='edit-profile-form']/div/div[9]/div")
    public WebElement accountNameEditDiv;

    @FindBy(xpath = "//*[@id='edit-profile-form']/div/div[7]/div")
    public WebElement orderTypeEditDiv;

    @FindBy(xpath = "//*[@id='filterForm']/div[1]/div[6]/div")
    public WebElement orderTypeDiv;

    @FindBy(xpath = "//*[@id='filterForm']/div[1]/div[7]/div")
    public WebElement jurisdictionDiv;

    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr/td[4]/p")
    public List<WebElement> positionTableList;

    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr[@class='ui-widget-content jqgrow ui-row-ltr']/td[2]")
    public List<WebElement> nameList;

    @FindBy(xpath = "//*[@id='next_jqPager']/span")
    public WebElement pageNext;

    @FindBy(xpath = "//*[@id='prev_jqPager']/span")
    public WebElement pagePrev;

    @FindBy(id = "SearchButton")
    public WebElement searchButtonDiligenceSkills;

    @FindBy(id = "ResetButton")
    public WebElement resetButtonDiligenceSkills;

    @FindBy(id = "filterForm")
    public WebElement filterForm;

    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr[2]/td[2]")
    public WebElement firstUserDiligenceSkills;

    @FindBy(xpath = "//label[contains(text(),'Position')]/parent::div//select")
    public WebElement labelPositionDiligence;

    @FindBy(xpath = "//label[contains(text(),'Home Office')]/parent::div//input")
    public WebElement labelHomeOfficeDiligence;

    @FindBy(xpath = "//label[contains(text(),'Hire Date')]/parent::div//input")
    public WebElement labelHireDateDiligence;

    @FindBy(xpath = "//label[contains(text(),'Language')]/parent::div//select")
    public WebElement labelLanguageDiligence;

    @FindBy(xpath = "//label[contains(text(),'Language')]/parent::div//button")
    public WebElement buttonLanguageDiligence;

    @FindBy(xpath = "//label[contains(text(),'Jurisdiction')]/parent::div//button")
    public WebElement buttonJurisdictionDiligence;

    @FindBy(xpath = "//label[contains(text(),'Account Name')]/parent::div//button")
    public WebElement buttonAccountNameDiligence;

    @FindBy(xpath = "//label[contains(text(),'Order Type')]/parent::div//button")
    public WebElement buttonOrderTypeDiligence;

    @FindBy(xpath = "//label[contains(text(),'Order Type')]/parent::div//select")
    public WebElement labelOrderTypeDiligence;

    @FindBy(xpath = "//label[contains(text(),'Jurisdiction')]/parent::div//select")
    public WebElement labelJurisdictionDiligence;

    @FindBy(xpath = "//label[contains(text(),'Account Name')]/parent::div//select")
    public WebElement labelAccountNameDiligence;

    @FindBy(xpath = "//a[contains(text(),'Edit')]")
    public WebElement editLink;

    @FindBy(id = "SelectedRoleIds_DiligenceSkills")
    public WebElement diligenceSkillsRole;

    @FindBy(id = "SelectedProductTypeIds_ICVResidencyRefresher")
    public WebElement icvResidencyRefresher;

    @FindBy(id = "SelectedProductTypeIds_ALaCarteResearch")
    public WebElement aLaCarteResearch;

    @FindBy(id = "save-profile-button")
    public WebElement saveButtonDiligenceSkills;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/div[11]/div/div/label[10]")
    public WebElement pathDiligenceAdministrator;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/div[8]/div/div/label[10]")
    public WebElement editPathDiligenceAdministrator;

    @FindBy(xpath = "//input[@value='ICVResidency']/parent::label")
    public WebElement icvResidency;

    @FindBy(xpath = "//input[@value='ICVResidencyRefresher']/parent::label")
    public WebElement icvResidencyRefresherPath;

    @FindBy(xpath = "//input[@value='ALaCarteResearch']/parent::label")
    public WebElement aLaCarteResearchPath;

    @FindBy(xpath = "//input[@value='AssetTracing']/parent::label")
    public WebElement assetTracingPath;

    @FindBy(xpath = "//input[@value='InvestigativeProject']/parent::label")
    public WebElement investigativeProject;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/div[11]/div/div/label[11]")
    public WebElement pathDiligenceSkills;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/div[8]/div/div/label[11]")
    public WebElement editPathDiligenceSkills;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/div[11]/div/div/label[12]")
    public WebElement pathEditor;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/div[8]/div/div/label[12]")
    public WebElement editPathEditor;

    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr[2]/td[4]")
    public WebElement userSearchDiligence;

    @FindBy(id = "Email")
    public WebElement emailDiligenceSkills;

    @FindBy(id = "LegalName")
    public WebElement legalName;

    @FindBy(id = "SearchButton")
    public WebElement filterButtonDiligenceSkills;

    @FindBy(xpath = "//a[contains(text(),'Details')]")
    public WebElement detailsLinkDiligenceSkills;

    @FindBy(xpath = "//*[@id='jqGrid']/tbody/tr[2]/td[5]/a")
    public WebElement detailsLinkFirstUser;

    @FindBy(xpath = "//a[contains(text(),'Update User')]")
    public WebElement updateUserLinkDiligenceSkills;

    @FindBy(xpath = "//a[contains(text(),'Update Account')]")
    public WebElement updateAccountLink;

    @FindBy(linkText = "Log Off")
    public WebElement adminLogOffLink;

    @FindBy(id = "submit-button")
    public WebElement updateAccount;

    @FindBy(xpath = "/html/body/div[2]/div/h2")
    public WebElement verifyUpdateUserPageDiligenceSkills;

    @FindBy(xpath = "/html/body/div[2]/div/h2")
    public WebElement internalUserDiligenceSkills;


    public void iSeeAllDropdownFieldsContainTheRequiredOptions(){
        Set<String> fromPositionDropdown = new HashSet<>(dropdown.getAllValuesFromUnorderedListWithCheckbox(driver,positionDiv,dropdownDiligencePositionButton));
        String[] requiredListPosition = {"Researcher", "Case Supervisor", "Client Account Representative", "Client Account Manager", "Content Reviewer", "Editor"};
        Set<String> requiredPosition = new HashSet<>(Arrays.asList(requiredListPosition));
        assertTrue(fromPositionDropdown.containsAll(requiredPosition));

        Set<String> fromHomeOfficeDropdown = new HashSet<>(dropdown.getAllValuesFromUnorderedListWithCheckbox(driver,homeOfficeDiv,homeOfficeDiligenceSkillsButton));
        String[] requiredListHomeOffice = {"Hong Kong", "London", "Miami", "New York", "Silver Spring", "Singapore", "Toronto", "Vancouver"};
        Set<String> requiredHomeOffice = new HashSet<>(Arrays.asList(requiredListHomeOffice));
        assertTrue(fromHomeOfficeDropdown.containsAll(requiredHomeOffice));

        Set<String> fromLanguageDropdown = new HashSet<>(dropdown.getAllValuesFromUnorderedListWithCheckbox(driver,languageDiv,languageDiligenceSkillsButton));
        String[] requiredListLanguage = {"Myanmar", "Slovak", "Russian", "Bosnian", "Hebrew", "Belarusian", "Serbian", "Marathi", "Armenian (Eastern)", "Mongolian", "Swedish", "Turkish", "Ukrainian", "Arabic", "Kannada", "Portuguese", "Chinese (Traditional)", "Catalan", "Malay", "Spanish", "Hindi", "Thai", "Norwegian", "Swahili", "Urdu", "Romanian", "Macedonian", "Japanese", "Estonian", "Bengali", "Gujarati", "Icelandic", "Odia/Oriya", "Italian", "Sinhalese", "Persian", "German", "Slovenian", "Azeri/Azerbaijani (Latin script)", "Telugu", "Chinese (Simplified)", "French", "English (UK)", "Indonesian", "Esperanto", "Tagalog", "Finnish", "Georgian", "English (US)", "Cebuano", "Albanian", "Malayalam", "Spanish (Latin America)", "Polish", "Lithuanian", "Latvian", "Brazilian Portuguese", "Bulgarian", "Korean", "Assamese", "Welsh", "Khmer", "Tamil", "Croatian", "Kazakh (Cyrilic)", "Ilonggo/Hiligaynon", "Montenegrin", "Danish", "Vietnamese", "Czech", "Hungarian", "Greek", "Dutch", "Punjabi"};
        Set<String> requiredLanguage = new HashSet<>(Arrays.asList(requiredListLanguage));
        assertTrue(fromLanguageDropdown.containsAll(requiredLanguage));

        Set<String> fromOrderTypeDropdown = new HashSet<>(dropdown.getAllValuesFromUnorderedListWithCheckbox(driver,orderTypeDiv,orderTypeDiligenceSkillsButton));
        String[] requiredListOrderType = {"ICV - Residency", "Red Flag", "IPO + SmartSource", "Investment Manager Review", "IPO", "M&A", "Investigative Project", "Exiger Express", "Level 1", "Level 1 + SmartSource (™)", "Investment Advisor Review", "Asset Tracing", "ICV - Citizenship", "M&A + SmartSource"};
        Set<String> requiredOrderType = new HashSet<>(Arrays.asList(requiredListOrderType));
        assertTrue(fromOrderTypeDropdown.containsAll(requiredOrderType));

        Set<String> fromJurisdictionDropdown = new HashSet<>(dropdown.getAllValuesFromUnorderedListWithCheckbox(driver,jurisdictionDiv,jurisdictionDiligenceSkillsButton));
        String[] requiredListJurisdiction = {"Saint Barthalemy", "Papua New Guinea", "Cambodia", "Kazakhstan", "Paraguay", "Bahamas", "Solomon Islands", "Montserrat", "Mali", "Marshall Islands", "Guadeloupe", "Panama", "Argentina", "Seychelles", "Belize", "Zambia", "Bahrain", "Guinea-Bissau", "Namibia", "Comoros", "Faroe Islands", "Finland", "Georgia", "Saint Kitts and Nevis", "Yemen", "Eritrea", "Puerto Rico", "Vietnam", "Macedonia- the Former Yugoslav Republic of", "Aruba", "Madagascar", "Libya", "Svalbard and Jan Mayen", "South Georgia and the South Sandwich Islands", "Sweden", "Cocos (Keeling) Islands", "Malawi", "Andorra", "Liechtenstein", "Poland", "Bulgaria", "Jordan", "Tunisia", "Tuvalu", "United Arab Emirates", "Kenya", "French Polynesia", "Djibouti", "Lebanon", "Azerbaijan", "Cuba", "Czech Republic", "Mauritania", "Saint Lucia", "Guernsey", "Mayotte", "Israel", "San Marino", "Australia", "Bonaire", "Micronesia- Federated States of", "Tajikistan", "Myanmar", "Cameroon", "Gibraltar", "Cyprus", "Northern Mariana Islands", "Malaysia", "Taiwan- Province of China", "Iceland", "Oman", "Armenia", "Gabon", "Luxembourg", "Brazil", "Turks and Caicos Islands", "Algeria", "Jersey", "Slovenia", "Antigua and Barbuda", "Colombia", "Ecuador", "Lao People's Democratic Republic", "Vanuatu", "United States Minor Outlying Islands", "Honduras", "Italy", "Antarctica", "Moldova- Republic of", "Nauru", "Haiti", "Afghanistan", "Burundi", "Russian Federation", "Singapore", "French Guiana", "American Samoa", "Christmas Island", "Netherlands", "Congo- Republic of the", "China", "Martinique", "Saint Pierre and Miquelon", "Kyrgyzstan", "Reunion", "Bhutan", "Romania", "Falkland Islands (Malvinas)", "Togo", "Philippines", "Cote d'Ivoire", "Holy See (Vatican City State)", "Uzbekistan", "Pitcairn", "British Virgin Islands", "Zimbabwe", "British Indian Ocean Territory", "Montenegro", "Dominica", "Indonesia", "Benin", "Angola", "Sudan", "Brunei Darussalam", "Portugal", "New Caledonia", "Grenada", "Cayman Islands", "Greece", "Latvia", "Mongolia", "Morocco", "Guatemala", "Guyana", "Iraq", "Chile", "Nepal", "Isle of Man", "Ukraine", "Ghana", "Anguilla", "Korea- Democratic People's Republic of", "India", "Canada", "Maldives", "Turkey", "Belgium", "South Africa", "Trinidad and Tobago", "Bermuda", "Iran- Islamic Republic of", "Aland Islands", "Central African Republic", "Jamaica", "Peru", "Tanzania- United Republic of", "Turkmenistan", "Germany", "Fiji", "Tokelau", "Hong Kong", "United States", "Guinea", "Chad", "Somalia", "Sao Tome and Principe", "Thailand", "Equatorial Guinea", "Kiribati", "Costa Rica", "Saint Martin (French part)", "Kuwait", "Nigeria", "Croatia", "Syrian Arab Republic", "Cook Islands", "Sri Lanka", "Uruguay", "Timor-Leste", "United Kingdom", "Switzerland", "Samoa", "Spain", "Liberia", "Venezuela", "Burkina Faso", "Swaziland", "Palau", "Estonia", "Wallis and Futuna", "Niue", "Heard Island and McDonald Mcdonald Islands", "Austria", "Mozambique", "El Salvador", "Monaco", "Korea- Republic of", "Guam", "Lesotho", "Tonga", "Western Sahara", "Hungary", "Republic of Kosovo", "South Sudan", "Japan", "Belarus", "Curacao", "Mauritius", "Bouvet Island", "Albania", "Norfolk Island", "New Zealand", "Sint Maarten (Dutch part)", "Senegal", "Ethiopia", "US Virgin Islands", "Congo- Democratic Republic of the", "Egypt", "Sierra Leone", "Bolivia", "Malta", "Saudi Arabia", "Cape Verde", "Pakistan", "Gambia", "Ireland", "Qatar", "Slovakia", "France", "Lithuania", "Serbia", "Bosnia and Herzegovina", "Niger", "Rwanda", "French Southern Territories", "Bangladesh", "Barbados", "Nicaragua", "Norway", "Palestine- State of", "Botswana", "Saint Vincent and the Grenadines", "Macao", "Denmark", "Dominican Republic", "Mexico", "Uganda", "Suriname", "Greenland", "Saint Helena"};
        Set<String> requiredJurisdiction = new HashSet<>(Arrays.asList(requiredListJurisdiction));
//        System.out.println(fromJurisdictionDropdown + " ==== " +requiredJurisdiction);
        assertTrue(fromJurisdictionDropdown.containsAll(requiredJurisdiction));

    }

    public void iCheckAlphaNumericInput(String input){
        wait.waitUntilGridSpinnersNotPresent();
        wait.waitAndSendKeysByElement(firstNameDiligenceSkills, input);
        wait.waitAndSendKeysByElement(lastNameDiligenceSkills, input);
        wait.waitAndClick(searchButtonDiligenceSkills);
        wait.waitAndClick(resetButtonDiligenceSkills);
    }

    public void isSelectedCheckbox(WebElement optionlistdiv, WebElement button){
        button.click();
        assertTrue(optionlistdiv.findElement(By.tagName("input")).isSelected());
        button.click();
    }

    public boolean isSelectedCheckboxReturnStatus(WebElement optionlistdiv, WebElement button){
        button.click();
        boolean state = optionlistdiv.findElement(By.tagName("input")).isSelected();
        button.click();
        return state;
    }

    public void isNotSelectedCheckbox(WebElement optionlistdiv, WebElement button){
        button.click();
        assertFalse(optionlistdiv.findElement(By.tagName("input")).isSelected());
        button.click();
    }

    public void checkInput(WebDriver driver, WebElement optionlistdiv, WebElement button, final String value){
        button.click();

        List<WebElement> options = optionlistdiv.findElements(By.tagName("label"));
        for (WebElement option : options) {
            System.out.println(value + " === " + option.getText());
            if ((value.trim()).equalsIgnoreCase(option.getText())) {
                System.out.println("matched");
                option.click();
                break;
            }
        }
        button.click();
    }
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div[2]/div/form/div[1]/div[5]/div/button")
    public WebElement langaugeDropdown;


    public CapacityProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void checkAllTheFuntionSwork() {
        firstName.isDisplayed();
        

    }
}
