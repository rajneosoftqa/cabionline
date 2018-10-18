@CMSRegression @diligence
  Feature: CMS Cases

    Background:
      And I login to CMS site

    #Leyon IDI-17
    @IDI-17
    Scenario: Core details checkbox in Case Summary should work as expected
      And I click on Cases
      And I select "Pending Acceptance" in Status Dropdown
      And I click on Search button
      And I click on a case from the table
      And I navigate to Case Summary Page
      And I click on Edit Core Details
      And I enter date in Interim Report Due Date
      And I click on Complete checkbox
      Then I click on Save Core Details

    #Leyon IDM-160 AC-1
    @IDM-160 @160
    Scenario Outline: : DDIQ Tab should not be displayed
      And I click on Cases
      And I select case status as "<Status>" and click on Search
      And I see only "<Status>" cases
      And I click on a case from the table
      And I move to the next page for "<Status>"
      And I see the DDIQ tab is not present

      Examples:
        | Status             |
        | Pending Assignment |
        | Pending Acceptance |

    @IDM-160 @checks
    Scenario Outline: : DDIQ Tab should be displayed
      And I click on Cases
      And I select case status as "<Status>" and click on Search
      And I see only "<Status>" cases
      And I click on a case from the table
      And I move to the next page for "<Status>"
      And I see the DDIQ tab is present

      Examples:
        | Status                  |
        | In Progress             |
        | Closed                  |
        | Pending Checks Required |

#Leyon IDM-160 AC-2
    @IDM-160 @product
    Scenario Outline: User creates an order and see the order listed on orders page
      And I click on create order button
      And I fill order details for "<Type>" type
      And I fill out the subject "company" details
      And I move to next page
      And I see the name of the subject for "company" is added
      And I review order details "<Type>" type
      And I submit the order
      And I click on Orders
      And I should be able to click Order Status field and select "Submitted" in CMS
      And I should be able to type ordername in Name field
      And I should be able to click on Search button
      Then I should be able to see the results
      And I click on the searched order from the table
      And The order page opens in a new tab
      And I click on view case button
      Then I see the DDIQ tab is present

      Examples:
        | Type                  |
#        | Investigative Project |
#        | IPO                   |
        | Level 1               |

    #Leyon IDM-180
    @regressionLeyon @IDM-180
    Scenario: Report Draft Status, in Edit Report tab, should show the current status if clicked on cancel
      And I click on Cases
      And I should be able to click on Status field and select "Closed"
      And I should be able to click on Search button in CMS
      Then I should be able to see the results
      And I click on a case from the table
      And The case page opens in a new tab in CMS
      And I click on Documents tab
      And I navigate to Documents tab
      And I click on Edit Report Type
      And I select Multiple Master Reports option
      And I click cancel button
      And I click on Edit Report Type
      Then I see Single Master Report option is selected by default


 #Leyon IDM-181
    @regressionLeyon @IDM-181 @fail
    Scenario: Edit and Save report should work as expected
      And I click on Cases
      And I should be able to click on Status field and select "In Progress"
      And I should be able to click on Search button in CMS
      Then I should be able to see the results
      And I click on a in progress case from the table
      And The case page opens in a new tab in CMS
      And I click on Documents tab
      And I navigate to Documents tab
      And I click on Edit Draft Status
      And I click on saving option
      And The Draft is saved

  #Leyon IDM-175
    @IDM-175
    Scenario:Fields Spacing in Edit Assignment Section of Case Summary should work as expected
      And I click on Cases
      And I select "Pending Acceptance" in Status Dropdown
      And I click on Search button
      And I click on a case from the table
      And I navigate to Case Summary Page
      And I click on Edit Case Assignment
      And I select supervisor in the drop down
      And I select "Titu Datta [Researcher]" in the Primary Researcher drop down
      And I select a Third Party Contractor
      And I select currency as "USD" for first Third Party Contractor
      And I enter Budget as "10" for first Third Party Contractor
      And I select Due date for first Third Party Contractor
      And I click on Add Additional Contractor
      And I select a Second Third Party Contractor
      And I select currency as "USD" for second Third Party Contractor
      And I enter Budget as "20" for Second Third Party Contractor
      And I select Due date for Second Third Party Contractor
      Then I click on Save Assignments
      Then I check the filled details


 #Leyon IDM-357
    @IDM-357 @tre
    Scenario: When adding and saving hours in Case Summary Screen it should display as Saving
      Given I login to CMS with Researcher account
      And I click on Cases
      And I select "In Progress" in Status Dropdown
      And I should be able to click on Search button in CMS
      Then I should be able to see the results in CMS
      And I click on a case from the table
      And The case page opens in a new tab in CMS
      And I click on the plus icon in Hours Tracker
      And I enter "4" in the hours worked field
      And I select "Research & Writing" in the reason field
      And I select the Date in the date field
      Then I click on save button for working hours
      Then I verify the details entered


 #Leyon IDI-51
    @IDI-51 @tdatta
    Scenario: Advanced Search Functionality should work as expected
      Given I login to CMS with Researcher account
      And I navigate to "Advanced Search" page from the main nav panel
      And I search for "in as a" in the search box
      And I verify the searched results


#Leyon IDM-186
    @IDM-186 @assignment
    Scenario: I should be able to assign a case to any researcher in CMS
      And I click on Cases
      And I select "Pending Acceptance" in Status Dropdown
      And I should be able to click on Search button in CMS
      Then I should be able to see the results
      And I click on a case from the table
      And The case page opens in a new tab in CMS
      And I click on Edit Case Assignment
      And I select "Titu Datta [Researcher]" in the Primary Researcher drop down
      Then I click on Save Assignments
      And I check the details are saved

    @IDM-186 @matrixcms @fail
#    TituClildClient 1.1
    Scenario: Sub menu in Case Summary field should work as expected
      And I click on Cases
      And I should be able to type "matrix1.9" in Name field in CMS
      And I should be able to click on Search button in CMS
      And I click on "matrix1.9" case from the table in CMS
      And The case page opens in another new tab in CMS
      And I click on Edit Case Assignment
      And I select supervisor in the drop down
      And I select "Titu Datta [Researcher]" in the Primary Researcher drop down
      Then I click on Save Assignments
      Then I click on assign case button
      #And I should be able to type "TituClildClient 1.1" in Name field in CMS
      And I login to CMS with Researcher account
      And I click on Cases
      And I should be able to type "matrix1.5" in Name field in CMS
      #And I select "In Progress" in Status Dropdown
      And I should be able to click on Search button in CMS
      Then I should be able to see the results
      And I click on a case from the table
      And The case page opens in another new tab in CMS
      And I click on Research tab
      And I navigate to Research tab
#      And I complete the tasks via task matrix
      And I complete high priority tasks
      #Then I verify the task matrix was completed
      And I navigate to DDIQ tab
      And I click on profile edit pencil icon
      And I click on Cancel button
      And I click on Documents tab
      And I navigate to Documents tab
      And I click on Reports tab in Case Page

    #Leyon IDI-23
    @IDI-23
    Scenario: CMS user with access to Diligence Skills role should have access to Capacity Profile Tab
      Given User logs in with following credentials
        | automation@exiger.com | Exiger1! |
      And I see Capacity Profile Tab is present
      And I click on Capacity Profile Tab
      Then I navigate to Capacity Profile Tab

#Leyon IDI-24
    @IDI-24 @ui
    Scenario: Diligence skills page should perform as expected
      Given User logs in with following credentials
        | automation@exiger.com | Exiger1! |
      And I click on Capacity Profile Tab
      And I see First Name field is available
      And I see Last Name field is available
      And I see the Position drop down field is available
      And I see Home Office drop down field is available
      And I see Language drop down field is available
      And I see Order Type drop down field is available
      And I see Jurisdiction drop down field is available
      And I see Account Name drop down is available
      And I see all multi-select dropdowns have "-- Select --" as the default value
      And I see search and reset buttons are available
      And I enter alphanumeric values in First Name, Last Name fields and click search
      And I see all dropdown fields contain the required options


    @IDI-24 @defaultsearch
    Scenario: Search with Default values should perform as expected
      Given User logs in with following credentials
        | automation@exiger.com | Exiger1! |
      And I click on Capacity Profile Tab
      And I click on Search button for Diligence Skills results
      And I see the default results for users of all Positions
      Then I see the results are listed in an alphabetical order

#      @IDI-24 @requiredvalues
#      Scenario: All dropdowns should contain the required options
#        Given User logs in with following credentials
#          | automation@exiger.com | Exiger1! |
#        And I click on Capacity Profile Tab
#        And I see all dropdown fields contain the required options

#        #IDI-25
#    @IDI-25 @notsave
#    Scenario: When clicked on edit user profile the values in dropdown fields, all options are unselected by default
#      Given User logs in with following credentials
#        | automation@exiger.com | Exiger1! |
#      And I click on Capacity Profile Tab
#      And I enter alphabets in First Name and Last Name fields and click search for not save
#      And I see the results for the searched criteria
#      And I click on Edit link for the first user
#      And I select values in the editable fields on user profile page
#      And I navigate away from the user profile page
#      And I go back to the user profile page for that user
#      Then I see the selected values are not saved

# #Leyon IDI-25
    @IDI-25 @save25
    Scenario: When clicked on edit user profile the select and unselect state of dropdown fields are working as expected
      Given User logs in with following credentials
        | automation@exiger.com | Exiger1! |
      And I click on Capacity Profile Tab
      And I enter alphabets in First Name and Last Name fields and click search for UserProfile
      And I see the results for the searched criteria
      And I click on Edit link for the first user
      And I select values in the editable fields on user profile page
      And I navigate away from the user profile page
      And I go back to the user profile page for that user
      Then I see the selected values are not saved
      And I click on Capacity Profile Tab
      And I enter alphabets in First Name and Last Name fields and click search for UserProfile
      And I see the results for the searched criteria
      And I click on Edit link for the first user
      And I select values in the editable fields on user profile page
      And I click on Save option on the user profile page
      And I go back to the user profile page for that user for save scenario
      Then I see the selected values are saved

    @IDI-25 @userprofile
    Scenario: Edit User Profile in Capacity Profile should perform as expected
      Given User logs in with following credentials
        | automation@exiger.com | Exiger1! |
      And I click on Capacity Profile Tab
      And I enter alphabets in First Name and Last Name fields and click search for UserProfile
      And I see the results for the searched criteria
      And I click on Edit link for the first user
      And I navigate to user profile page for that user
      And I see First Name / Last Name / Position / Home Office / Hire Date fields are read only
      And I see  the only actionable fields are Language / Jurisdiction / Account Name / Order Type
      And I check all options in dropdown fields are unselected by default



##Leyon idi-27
    @IDI-27 @adduser @ignore
    Scenario: Diligence Skills Role should be present when adding a Internal User
      Given I login to Insight Admin
      And I click on Internal Users tab
      And I click on add Internal User
      And I navigate to add Internal User Page
      Then I see Diligence Skills role is present
      And I see Diligence Skills role is listed between Diligence Administration and Editor

      @IDI-27 @existinguser @ignore
    Scenario: Diligence Skills Role should be present when adding a Internal User
      Given I login to Insight Admin
      And I click on Internal Users tab
      And I enter "leyon@exiger.com" in Email field and click Filter button
      And I click on Details link for the searched user
      And I navigate to Internal User Details Page
      And I click on Update User link
      Then I see Diligence Skills role is present
      And I see Diligence Skills role is listed between Diligence Administration and Editor for existing user

      @IDI-27 @rolecheck
      Scenario: When attempting to select Diligence skill role then atleast one other role must be enabled
        Given I login to Insight Admin
        And I click on Internal Users tab
        And I enter "diligence_skill@exiger.com" in Email field and click Filter button
        And I click on Details link for the searched user
        And I navigate to Internal User Details Page
        And I click on Update User link
        Then I see Diligence Skills role is present
        And I unselect all roles
        And I see Diligence Skills role is disabled
        And I select "Diligence Administration" role
        And I see Diligence skill role is enabled
        And I select the Diligence Skills role
        And I click the submit button

    @IDI-27 @enabled @ignore
      Scenario: When logging with a user having Diligence skill role access, Capacity Profile tab is Present
      Given I login to Insight Admin
      And I click on Internal Users tab
      And I enter "leyon@exiger.com" in Email field and click Filter button
      And I click on Details link for the searched user
      And I navigate to Internal User Details Page
      And I click on Update User link
      Then I see Diligence Skills role is checked
      And I log off from Diligence Admin
      Given User logs in with following credentials
        | automation@exiger.com | Exiger1! |
      And I see Capacity Profile Tab is present


    @IDI-27 @notenabled @ignore
    Scenario: When logging with a user having Diligence skill role access, Capacity Profile tab is Present
      Given I login to Insight Admin
      And I click on Internal Users tab
      And I enter "tdattacm@exiger.com" in Email field and click Filter button
      And I click on Details link for the searched user
      And I navigate to Internal User Details Page
      And I click on Update User link
      Then I see Diligence Skills role is not checked
      And I log off from Diligence Admin
      And I login to CMS site
      And I see Capacity Profile Tab is not present

    @IDM-217 @ignore
    Scenario Outline: Generate PDF functionality in cases should work as expected
      And I click on Cases
      And I should be able to click on Order type field and select a "<Type>"
      And I should be able to click on Search button
      And I click on Generate PDF
      And I click on the first report
      And I click on Generate PDF button
      Then Report is downloaded

      Examples:
      |  Type                       |
      |  Red Flag                  |
      |  Level 1                   |
      |  Level 1 + SmartSource (™) |
      |  Exiger Express            |


    @IDM-5 @ignore
    Scenario: When searching orders in CMS it gives duplicate results
      And I click on Cases
      And I enter "2017.92324" in the Case Number box
      And I click on Search button
      Then I see duplicate results in the table

  #Leyon
  @IDI-69
  Scenario Outline: Verify ability to upgrade diligence order types after the case is completed
    And I click on create order button
    And I fill order details for "<Type>" type in CMS
    And I fill out the subject "company" details in CMS
    And I move to next page in CMS
    And I see the name of the subject for "company" is added in CMS
    And I review order details have order "<Type>"
    And I submit the order
    And I click on Orders in CMS
    And I should be able to type ordername in Case Name field
    And I should be able to click on Order type field and select a "<Type>" in CMS
    And I should be able to click Order Status field and select "Submitted" for CMS
    And I should be able to click on Search button in CMS
    And I click on an order from the table in CMS
    And The order page opens in a new tab in CMS
    And I click on view case button
    And I click on Edit Case Assignment
    And I select "Titu Datta [Supervisor]" in the Primary Supervisor drop down
    And I select "Titu Datta [Researcher]" in the Primary Researcher drop down
    And I click on Save Assignments
    Then I click on assign case button
    Given I login to CMS with Researcher account
    And I click on Cases
    And I should be able to type ordername in Case Name field
    And I select "Pending Acceptance" in Status Dropdown
    And I should be able to click on Search button in CMS
    And I click on an order from the table in CMS
    And The case page opens in another new tab in CMS
    And I enter working hours
    And I click on Research tab
    And I complete high priority tasks
    Given I login to CMS with Supervisor account
    And I click on Cases
#    And I should be able to type ordername in Case Name field
    And I click on show more filters
    And I select "In Progress" in Status Dropdown
    And I search the order for "<Type>"
#    And I should be able to click on Search button in CMS
    And I click on an order from the table in CMS
    And The case page opens in another new tab in CMS
    And I enter working hours
    And I click on Complete Case Button
    Given I login to CMS site
    And I click on Orders in CMS
    And I click on show more filters
    And I select "In Progress" in Status Dropdown
    And I search the order for "<Type>"
    And I should be able to click on Search button in CMS
    And I click on an order from the table in CMS
    And The case page opens in another new tab in CMS
    And I verify if the upgrade option is available for the case


        Examples:
      |  Type                      |
      |  Red Flag                  |
      |  Level 1                   |
      |  Level 1 + SmartSource (™) |
      |  M&A                       |


#Leyon
  @IDM-256
    Scenario: Saving Hours
    Given I login to CMS with Researcher account
    And I click on Cases
    And I select "In Progress" in Status Dropdown
    And I should be able to click on Search button in CMS
    Then I should be able to see the results in CMS
    And I click on a case from the table
    And The case page opens in a new tab in CMS
    And I click on the plus icon in Hours Tracker
    And I enter "4" in the hours worked field
    And I select "Research & Writing" in the reason field
    Then I click on save button for working hours
    Then The I get error for not inputting date and save icon doesnt turn into saving


#
  #Leyon
  @IDM-258
   Scenario: When user hovers over Advanced Search field , message pop up comes up stating field is case-sensitive
    And I navigate to "Advanced Search" page from the main nav panel
    And I hover over the info icon
    Then Message pops up to includes a message that the field is case-sensitive

#Leyon
  @IDM-245
  Scenario: Past Due Notifications should include checking the interim report completed checkbox
    And I create an order for "Level 1" and assign case
    Given I login to CMS with Researcher account
    And I search the case with status "Pending Acceptance" for interim due date
    And I click on Reports tab in Case Page
    And I check no interim report is uploaded
    Given I login to CMS site
    And I take the past due count
    And I search the case with status "In Progress" for interim due date
    And I click on Edit Core Details
    And I enter date in Interim Report Due Date
    Then I click on Save Core Details
    And I am in CMS dashboard page
    And I should be able to click "Past Due" tile and see past due cases
    And I choose "200" item per page
    And I sort the order by "E" 2 times
    Then I see the order is listed in the table on CMS Dashboard
#    Then I see the past due count increased by 1
    And I search the case with status "In Progress" for interim due date
    And I click on Edit Core Details
    And I click on Complete checkbox
    Then I click on Save Core Details
    And I am in CMS dashboard page
    And I should be able to click "Past Due" tile and see past due cases
    And I choose "200" item per page
    And I sort the order by "E" 2 times
    Then I see the order is not listed in the table on CMS Dashboard
#    Then I see the past due count decreased by 1
    And I search the case with status "In Progress" for interim due date
    And I click on Edit Core Details
    And I click on Complete checkbox
    Then I click on Cancel for Core Details
    And I am in CMS dashboard page
    And I should be able to click "Past Due" tile and see past due cases
    And I choose "200" item per page
    And I sort the order by "E" 2 times
    Then I see the order is not listed in the table on CMS Dashboard
#    Then I see the past due count

   #Leyon
    @IDI-70 @refresher @ignore
    Scenario: When  ICV - Residency Refresher is a selected product then ICV Case Logic is Applied
      And I create an order for "ICV - Residency Refresher" and assign case
      Given I login to CMS with Researcher account
      And I click on Cases
      And I should be able to type ordername in Case Name field
      And I click on Search button
      And I click on a case from the table
      And I navigate to Case Summary Page
      And I click on Research tab
      And I click on Refresher Icon on the page
      And I select Country in Jurisdictions form
      And I click on Add button
      And I click on update button

  #Leyon
  @IDM-246
  Scenario: Interim Report Check box gets automatically checked when interim report is uploaded in the case
    And I create an order for "Level 1" and assign case to CM
    And I click on Cases
    And I should be able to type ordername in Case Name field
    And I should be able to click on Status field in case search and select "Pending Acceptance"
    And I click on Search button
    And I click on a case from the table
    And I navigate to Case Summary Page
    And I verify Interim Report checkbox is not checked
    And I click on Reports tab in Case Page
    And I should be able to select "Interim Report" option in Report field
    And I upload the report in the case
    And I enter a title for the report
    And I click on upload button
    Then I click Upload Report button
    And I click on Summary tab in Case Page
    And I verify if interim report check box is checked

  #Leyon
  @IDM-277 @single
  Scenario: Report Status column should be visible in Past Due Bucket
    And I create an order for "Level 1" and assign case to CM
     #Added patch for selecting third party contractor
    And I click on Cases
    And I should be able to type ordername in Case Name field
    And I should be able to click on Status field in case search and select "Pending Acceptance"
    And I click on Search button
    And I click on a case from the table
    And I navigate to Case Summary Page
    And I enter date in Interim Report Due Date and save
    And I click on Research tab
    And I complete high priority tasks
    And I click on Documents tab
    And I click generate and reports get generated
    And I am in CMS dashboard page
    And I should be able to click "Past Due" tile and see past due cases
    And I choose "200" item per page
    And I sort the order by "E" 2 times
    Then I see the order is listed in the table on CMS Dashboard
    And I see Report Status column is present
    And I see draft status of the report is "Research In Progress"
    And I change the draft status of the order to "Content Review in Progress"
    And I should be able to click "Past Due" tile and see past due cases
    And I choose "200" item per page
    And I sort the order by "E" 2 times
    And I see draft status of the report is "Content Review in Progress"

  @IDM-277 @multiple @ignore
  Scenario: Report with status as multiple drafts have tooltip with report status and subject
    And I create an order for "Level 1" with "2" "unique" subjects and assign case to CM
    And I click on Cases
    And I should be able to type ordername in Case Name field
    And I should be able to click on Status field in case search and select "Pending Acceptance"
    And I click on Search button
    And I click on a case from the table
    And I navigate to Case Summary Page
    And I enter date in Interim Report Due Date and save
    And I click on Research tab
    And I complete high priority tasks
    And I click on Documents tab
    And I click on Edit Report Type
    And I select Multiple Master Reports option and click next
    And I click generate for multiple reports
    And I am in CMS dashboard page
    And I should be able to click "Past Due" tile and see past due cases
    And I sort the order by "E" 2 times
    Then I see the order is listed in the table on CMS Dashboard
    And I see Report Status column is present
    And I see draft status of the report is "Multiple Drafts *"
    And I hover over the status and see status of drafts and their subjects

#Leyon
  @IDM-278
  Scenario: Cases present in Dashboard calendar panel should be associated with the user logged in
    And I create an order for "Level 1" and assign case
    And I assign "Titu Datta [Editor]" and "Titu Datta [Content Review]" as editor and content reviewer respectively to the case
    Given I login to CMS with Editor account
    And I see the order is visible in the calendar panel to "Titu Datta [Editor]" user
    Given I login to CMS with Content Reviewer account
    And I see the order is visible in the calendar panel to "Titu Datta [Content Review]" user
    And I login to CMS site
    And I click on Cases
    And I should be able to type ordername in Case Name field
    And I click on Search button
    And I click on a case from the table
    And I navigate to Case Summary Page
    And I remove "Titu Datta [Editor]" and "Titu Datta [Content Review]" as editor and content reviewer from the case
    Given I login to CMS with Editor account
    And I see the case is now not present in the calendar panel
    Given I login to CMS with Content Reviewer account
    And I see the case is now not present in the calendar panel

#Leyon
  @IDM-276
  Scenario: When generating report in documents tab for any case it should show warning for duplicate name
    And I create an order for "Level 1" with "2" "" subjects and assign case to CM
    And I click on Cases
    And I should be able to type ordername in Case Name field
    And I should be able to click on Status field in case search and select "Pending Acceptance"
    And I click on Search button
    And I click on a case from the table
    And I navigate to Case Summary Page
    And I click on Research tab
    And I complete high priority tasks
    And I click on Documents tab
    And I click on Generate button
    And I see warning message for duplicate file name
    And I click on Edit Report Type
    And I select Multiple Master Reports option and click next
    And I click generate for multiple reports in CMS
    And I see it gives error as filename already exists

#Leyon
  @IDI-79
  Scenario: When creating a new Order there should be only 1 order available for order type
    And I click on create order button
    And I should be able to choose "Single Product Type Client" in Account for order details
    And I verify that order type field is non editable with single order displayed

#Leyon
  @IDM-272
  Scenario: Coming Due Bucket should show cases only for the next 5 days excluding today and weekends
    And I should be able to click "Coming Due" tile and see coming due cases
    And I see only cases that are due in the next 5 days excluding weekends

#Leyon
  @IDM-265
  Scenario: Title textbox in Reports tab supports upto 200 characters
    And I create an order for "Level 1" and assign case to CM
    And I click on Cases
    And I should be able to type ordername in Case Name field
    And I should be able to click on Status field in case search and select "Pending Acceptance"
    And I click on Search button
    And I click on a case from the table
    And I navigate to Case Summary Page
    And I click on Reports tab in Case Page
    And I should be able to select "Interim Report" option in Report field
    And I upload the report in the case
    And I enter a title for the report with 200 characters
    And I click on upload button
    Then I click Upload Report button
    Then I verify Report is uploaded


 #Leyon
  @IDM-229
  Scenario: Third Party Contractor values in Case Summary Page should not reset once the page is refreshed
    And I click on Cases
    And I should be able to click on Status field in case search and select "Pending Acceptance"
    And I click on Search button
    And I click on a case from the table
    And I navigate to Case Summary Page
    And I click on Edit Case Assignment
    And I select supervisor in the drop down
    And I select "Titu Datta [Researcher]" in the Primary Researcher drop down
    And I select a Third Party Contractor
    And I select currency as "USD" for first Third Party Contractor
    And I enter Budget as "10" for first Third Party Contractor
    And I select Due date for first Third Party Contractor
    Then I click on Save Assignments
    Then I check the filled details
    And I reload the page
    Then I check the filled details

#Leyon
 @IDM-230
 Scenario: When all Third Party Contractor values are removed in Case Summary Page and saved, one third party field should be available to select by default
   And I click on Cases
   And I should be able to click on Status field in case search and select "Pending Acceptance"
   And I click on Search button
   And I click on a case from the table
   And I navigate to Case Summary Page
   And I click on Edit Case Assignment
   And I select supervisor in the drop down
   And I select "Titu Datta [Researcher]" in the Primary Researcher drop down
   And I select a Third Party Contractor
   And I select currency as "USD" for first Third Party Contractor
   And I enter Budget as "10" for first Third Party Contractor
   And I select Due date for first Third Party Contractor
   And I click on Add Additional Contractor
   And I select a Second Third Party Contractor
   And I select currency as "USD" for second Third Party Contractor
   And I enter Budget as "20" for Second Third Party Contractor
   And I select Due date for Second Third Party Contractor
   Then I click on Save Assignments
   Then I check the filled details
   And I click on Edit Case Assignment
   And I remove both Third Party Contractor values
   Then I click on Save Assignments
   And I verify one Third Party Contractor field is available by default

#Leyon
  @IDI-84 @IDI-70
   Scenario: When Syrian Republic is selected in Jurisdiction form in researcher tab , case becomes controlled case
   And I create an order for "ICV - Residency Refresher" and assign case
   Given I login to CMS with Researcher account
   And I click on Cases
   And I should be able to type ordername in Case Name field
   And I click on Search button
   And I click on a case from the table
   And I navigate to Case Summary Page
   And I click on Research tab
   And I click on Refresher Icon on the page
   And I click on pencil icon to change Jurisdiction country
   And I select Country in Jurisdictions form
   And I click on save button for Jurisdiction
   Then I verify case is marked as controlled case

#Leyon
 @IDI-105 @editable
 Scenario: When any given case is not a controlled case, the jurisdiction form in researcher tab is editable
  And I create an order for "ICV - Residency Refresher" and assign case
  Given I login to CMS with Researcher account
  And I click on Cases
  And I should be able to type ordername in Case Name field
  And I click on Search button
  And I click on a case from the table
  And I navigate to Case Summary Page
  And I click on Research tab
  And I click on Refresher Icon on the page
  And I verify pencil is present for Jurisdiction

#Leyon
 @IDI-105 @noneditable
 Scenario: When any given case is a controlled case, the jurisdiction form in researcher tab is not editable
   And I create an order for "ICV - Residency Refresher" and assign case to CM
   And I click on Cases
   And I should be able to type ordername in Case Name field
   And I click on Search button
   And I click on a case from the table
   And I navigate to Case Summary Page
   And I click on Research tab
   And I click on Refresher Icon on the page
   And I verify pencil is not present for Jurisdiction

#Leyon
 @IDM-274 @submitteddoc
  Scenario: Submitted documents section in cases should fall between subject sequence and case documents section
   And I create an order for "Level 1" and assign case to CM
   And I click on Cases
   And I should be able to type ordername in Case Name field
   And I should be able to click on Status field in case search and select "Pending Acceptance"
   And I click on Search button
   And I click on a case from the table
   And I navigate to Case Summary Page
   And I click on Documents tab
   And I navigate to Documents tab
   And I verify Submitted documents section is between subject sequence and case documents section
   And I verify file is uploaded in client submitted docs section

 #Leyon
 @IDI-98 @documentssection
  Scenario: When viewing a case before its assigned/accepted the documents section is visible
   And I create an order for "Level 1" and view case
   And I navigate to Case Summary Page
   And I click on Documents tab
   And I navigate to Documents tab
   And I verify Submitted documents section is the only section visibile and interactable

 #Leyon
  @IDI-98 @othersections
 Scenario: When viewing a case before its assigned/accepted then case documents, subject sequence, shared notes, report generate sections are not visible in Documents tab
  And I create an order for "Level 1" and view case
  And I navigate to Case Summary Page
  And I click on Documents tab
  And I navigate to Documents tab
  And I verify case documents, subject sequence, shared notes, report generate sections are not visible

 #Leyon
 @IDI-98 @accept
  Scenario: When primary researcher accepts the case then all sections in documents tab are visible and interactable
   And I create an order for "Level 1" and assign case to CM
   And I click on Cases
   And I should be able to type ordername in Case Name field
   And I should be able to click on Status field in case search and select "Pending Acceptance"
   And I click on Search button
   And I click on a case from the table
   And I navigate to Case Summary Page
   And I click on Documents tab
   And I navigate to Documents tab
   And I verify all sections are visible and interactable in Documents tab

  #Leyon
  @IDI-114 @deliverable
  Scenario: When a deliverable is removed from client account configuration then it stays static in an existing order
    And I click on Cases
    And I should be able to click on Status field in case search and select "In Progress"
    And I click on Search button
    And I click on a case from the table
    And I navigate to Case Summary Page
    And I click on Research tab
    And I verify Criminal Records deliverable is present
    And I complete the tasks via task matrix
    Given I login to Insight Admin for Diligence
    And I click on client accounts tab
    And I enter legal name as "A Titu Client" and click search
    And I clicked on details for the searched client
    And I navigate to Internal User Details Page
    And I click on details link for Level 1 product
    And I remove Criminal Records option from deliverables
    Given I login to CMS site
    And I verify Criminal Records deliverable is still present
    And I am in CMS dashboard page
    Then I create an order for "Level 1" and assign case to CM
    And I click on Cases
    And I should be able to type ordername in Case Name field
    And I should be able to click on Status field in case search and select "Pending Acceptance"
    And I click on Search button
    And I click on a case from the table
    And I navigate to Case Summary Page
    And I verify Criminal Records deliverable is not present


#-------------------------------------------------------------
#    Given the current date is past the interim due date
#    And the interim report completed box is checked off
#    When I deselect the interim report completed box
#    And hit save
#    Then the case is past due
#
#    Given the current date is past the interim due date
#    And the interim report completed box is checked off
#    When I deselect the interim report completed box
#    And hit cancel
#    Then the completed box is still checked and the case is not past due


##Leyon
#  @IDM-233 @ignore
#  Scenario: Task Matrix should continue to display in the cases even if the task/deliverables are modified via Admin Portal



#Leyon
#    @IDI-71 @ignore
#    Scenario: Task Matrix should generate correctly regardless of task/deliverables being added/updated
#      And I create a case with Task Matrix Generated
#      And I login to admin account
#      And I modify the tasks for the client within the admin portal
#      And I Login back to the researcher account
#      And I click on cases
#      And I select "Pending Acceptance" in Status Dropdown
#      And I click on a case from the table
#      And I navigate to Case Summary Page
#      And I click on Reports tab in Case Page
#      And I see new tasks are available in the task matrix
#
#    Scenario: Tasks in the Task Matrix remain locked and completed if they are removed after the completion is done
#      And I create a case with Task Matrix Generated
#      And I complete the tasks via task matrix
#      And I login to admin account
#      And I remove some tasks for the client within the admin portal
#      And I Login back to the researcher account
#      And I click on cases
#      And I select "Pending Acceptance" in Status Dropdown
#      And I click on a case from the table
#      And I navigate to Case Summary Page
#      And I click on Reports tab in Case Page
#      And I see the removed tasks remain locked and completed in the task matrix
#
#
#    Scenario: Task matrix remains the same after marking the case completed and then adding high priority tasks from portal
#      And I create a case with Task Matrix Generated
#      And I complete high priority tasks on the research tab
#      And I login to admin account
#      And I add new high priority tasks for the client within the admin portal
#      And I Login back to the researcher account
#      And I click on cases
#      And I select "Pending Acceptance" in Status Dropdown
#      And I click on a case from the table
#      And I navigate to Case Summary Page
#      And I click on Reports tab in Case Page
#      And I see the tasks matrix does not pull the newly added tasks
#
#      Given a case is created
#      And the Task Matrix is generated
#      And high priority tasks are marked completed
#      And the case has a status of 'in progress'
#      When tasks are modified within the admin portal (new high priority task added)
#      Then the task matrix would pull in the new high priority task and it would be required before completing the case



