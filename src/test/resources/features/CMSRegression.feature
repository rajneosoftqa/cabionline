@CMSRegression
Feature: CMS Regression

  Background:
    And I login to CMS site


 #Leyon Remember Me Functionality
  @regressionLeyon
  Scenario: Remember Me functionality should work as expected
    And I navigate to login page
    And Remember Me Checkbox is Present
    Then I check the Remember Me box

 #Leyon Forgot Password Fucntionality
  @regressionLeyon
  Scenario: Forgot Password functionality should work as expectedl
    And I navigate to login page
    And I click on Forgot Password
    And I enter username
    Then I get password reset email sent message

 #Leyon Language Functionality
  @regressionLeyon @ignore
  Scenario: Language functionality should perform as expected
    And I navigate to login page
    And I change the language to English


 #Leyon Support Page Navigation
  @regressionLeyon @supportcms
  Scenario: Support page should perform as expected
    And I click on support link in CMS
    And I navigate to support page in CMS

  #Leyon Log off
  @regressionLeyon @logoff
  Scenario: Log off functionality should perform as expected in CMS
    And I log off from the site in CMS

 #Leyon Calendar
  @regressionLeyon
  Scenario: User should be able to change Months in the calendar
    And   I click on back arrow in calendar to go to previous month in CMS
    And   I click on forward arrow in calendar to go to next month in CMS


 #Leyon Quick Search
  @regressionLeyon @quicks
  Scenario: User should be able to search subjects on CMS site
    And   I type "test" in search for subjects text box in CMS
    #And   I should be able to see suggestions in CMS
    And   I should be able to click on the suggestion in CMS


#Leyon Privacy Policy Page Navigation
  @regressionLeyon @privacy
  Scenario: Privacy Policy Page should perform as expected
    And I click on Privacy Policy link
    And I navigate to privacy page

    #Leyon TOC Navigation
  @regressionLeyon @terms
  Scenario: Terms and Conditions Page should perform as expected
    And I click on terms and conditions in CMS
    And I navigate to the terms and conditions page in CMS

    #Leyon Dashboard Tiles
  @regressionLeyon
#  Scenario Outline: User should be able to click on each tiles under Dashboard
#    And I should be able to click "<Status>" tile and see past due cases
  Scenario: User should be able to click on each tiles under Dashboard
    And I should be able to click "Past Due" tile and see past due cases
    And I should be able to click "Pending Assignment" tile and see cases in pending assignment
    And I should be able to click "Pending Acceptance" tile and see cases not yet accepted for research
    And I should be able to click on "In Progress" tile and view currently in progress cases
    And I should be able to click on "Coming Due" and view cases due in the next five days
    And I should be able to click on "Unread Messages" and view cases with unread messages

#   Examples:
#    |Status|
#    |Past Due|
#    |Pending Assignment|
#    |Pending Acceptance|
#    |In Progress|
#    |Coming Due|
#    |Unread Messages|


#Leyon Download Reports
  # failed 05/24/2018
  @regressionLeyon @download @ignore
  Scenario: Download Reports functionality should perform as expected
    And I click on Cases
    And I click on Download Results in CMS
    Then The report gets downloaded in CMS


#Leyon Create Order
  @regressionLeyon @createcms
  Scenario Outline: User creates an order and see the order listed on orders page
    And I click on create order button in CMS
    And I fill order details for "Level 1" type in CMS
    And I fill out the subject "<Type>" details in CMS
    And I move to next page in CMS
    And I see the name of the subject for "<Type>" is added in CMS
    And I review order details have order type in CMS
    And I submit the order in CMS

    Examples:
      | Type       |
      | individual |
      | company    |


 # Leyon From Table /Company & Individual
  @regressionLeyon @editcms
  Scenario Outline: Company/Individual Fields in an existing order should work as expected
    And I click on create order button in CMS
    And I fill order details for "Level 1" type in CMS
    And I fill out the subject "<Type>" details in CMS
    And I move to next page in CMS
    And I see the name of the subject for "<Type>" is added in CMS
    And I review order details have order type in CMS
    And I click on Orders in CMS
    And I should be able to type ordername in Case Name field
    And I should be able to click Order Status field and select "Draft" in CMS
    And I should be able to click on Order type field and select a "Level 1" in CMS
    And I should be able to click on Search button in CMS
    And I click on an order from the table for "<Type>" in CMS
    And The order page opens in a new tab in CMS
    And I click on continue button in CMS
    And I navigate to subjects page in CMS
    And I fill out the subject "<Type>" details in CMS
    And I move to next page in CMS
    And I see the name of the subject for "<Type>" is added in CMS
    And I review order details have order type in CMS
    Then I submit the order in CMS

    Examples:
      | Type       |
      | individual |
      | company    |

 #Adding Sumbited Documents
  @regressionLeyon @submitdoc
  Scenario: Submitting documents in an order should work as expected
    And I create an order
    And I click on Orders in CMS
    And I should be able to type ordername in Case Name field
    And I should be able to click Order Status field and select "Draft" in CMS
    And I should be able to click on Order type field and select a "Level 1" in CMS
    And I should be able to click on Search button in CMS
    And I click on an order from the table in CMS
    And The order page opens in a new tab in CMS
    And I click on add new document
    And I upload the document in the order
    And I click on save button
    Then I check if the file was uploaded



#Leyon Upload Reports
  @regressionLeyon @uploadreport @fail
  Scenario: Upload Reports functionality in a case should perform as expected
    And I click on Cases
    And I should be able to click on Status field and select "In Progress"
    And I should be able to click on Search button in CMS
    And I should be able to click on an in progress case from the table
    And The case page opens in a new tab in CMS
    And I click on Reports tab in Case Page
    And I should be able to select "Report" option in Report field
    And I upload the report in the case
    And I enter a title for the report
    And I click on upload button
    Then I click Upload Report button


#Leyon Generate Reports
  @regressionLeyon @ignore
  Scenario: Generate PDF functionality in cases should work as expected
    And I click on Cases
    And I click on Generate PDF
    And I click on the first report
    And I click on Generate PDF button
     # And The report is getting generated
    Then Report is downloaded


    ##Leyon ICV Order Type
  @regressionLeyon @icvcms
  Scenario Outline: ICV Order Type should perform as expected
    And I login as child account
    And I click on create order button
    And I fill order details for "<Type>" type for child account

    Examples:
      | Type              |
      | ICV - Citizenship |
      | ICV - Residency   |

   #Leyon Internal Messages
  @regressionLeyon @internalmessage
  Scenario: Sending Internal Messages in Case Summary should work as expected
    And I click on Cases
    And I select "In Progress" in Status Dropdown
    And I should be able to click on Search button in CMS
    And I click on a case from the table
    And The case page opens in a new tab in CMS
    And I click on Messages tab in Case Page
    And I navigate to the messages tab in CMS
    And I send a message in the message textbox and click send in Case Page
    Then I check the sent internal message in CMS


#Leyon External Message
  @regresssionLeyon @externalmessage
  Scenario: Sending Messages functionality should work as expected
    And I login to OMS site for sending external message
    And I should be able to click "In Progress" tile and see in progress orders
    And I click on an in progress order from the table
    And The order page opens in a new tab
    And I click on Messages tab
    And I navigate to the messages tab
    And I send a message in the message textbox and click send
    And I check the sent message
    Then I log off from the site in CMS
    And I login to CMS site
    And I click on Cases
    And I should be able to type a Case in Case Name field
    And I should be able to click on Search button in CMS
    And I click on the searched case from the table
    And The case page opens in a new tab
    And I click on Messages tab in Case Page
    And I navigate to the messages tab in CMS
    Then I check the sent message in CMS


  #Leyon CaseSearch
  @regressionLeyon @casesearch
  Scenario: User should be able to search using Filter Criteria fields on Case page
    And I click on Cases
    And I should be able to type "name" in Case Name field
    And I should be able to click on Status field and select "Pending Assignment"
    And I should be able to type "1" in Order Number field in CMS
    And I should be able to type "name" in subject name field
    And I should be able to select "A Titu Client" option in account name field
    And I should be able to select Jurisdiction as "United States"
    And I should be able to click on Search button in CMS
    Then I should be able to see the searched results in CMS
    And  I should be able to click on Reset button in CMS



  #Leyon OrderSearch
  @regressionLeyon @searchcms
  Scenario: User should be able to search using Filter Criteria fields on Orders page
    And   I click on Orders in CMS
    And   I should be able to type "test" in Name field in CMS
    And   I should be able to click on Order type field and select a "Level 1" in CMS
    And   I should be able to pick Submited between start and end dates as "4/1/2018" and "4/24/2018" fields in CMS
    And   I should be able to pick Completed between start and end dates as "4/1/2018" and "4/24/2018" fields in CMS
    And   I should be able to click Order Status field and select "Submitted" in CMS
    And   I should be able to type "1" in Order Number field in CMS
    And   I should be able to click on Search button in CMS
    Then  I should be able to see the searched results in CMS
    And   I should be able to click on Reset button in CMS


  #Leyon CaseSummary
  @regressionLeyon @summary
  Scenario: User should be able to see case summary
    And I click on Cases
    And I select "Pending Assignment" in Status Dropdown
    And I click on Search button
    And I click on Order Submitted on date 3/13/2018
    And I navigate to Case Summary Page
    And I see the Case Summary Page


  #Leyon Edit Assignments
  @regressionLeyon @assignment1
  Scenario: Edit case assignment functionality should work as expected
    And I click on Cases
    And I select "Pending Acceptance" in Status Dropdown
    And I click on Search button
    And I click on Order Submitted on date 3/13/2018
    And I navigate to Case Summary Page
    And I click on Edit Case Assignment
    And I select supervisor in the drop down
    And I select Primary Researcher in the drop down
    Then I click on Save Assignments

  #Leyon IDI-21
#  Scenario: Case Summary PDF details should be proper
#    And I login to CMS site
#    And I navigate to Case Search Page
#    And I click on Generate PDF
#    And When I view the PDF
#    Then Then the Core Details are included
 #   Then The Interim Due Date Completion check box should be displayed to the right of the Interim Report  Due data field

   #Leyon IDM-100
#  Scenario:Case Summary PDF should not have "Upgraded From #" text in header
#    And I login to CMS site
#    And I navigate to Case Search Page
#    And I click on Generate PDF
#    And I select the case and click on Generate
#    Then I check the header in the PDF file it doesnt have "Upgraded From #" text



#----------------------------------------------------------------------------------

#Leyon Upload Case Documents
  @regressionLeyon @casedoc
  Scenario: Upload Case Documents should perform as expected
    And I click on Cases
    And I should be able to click on Status field and select "Closed"
    And I should be able to click on Search button in CMS
    Then I should be able to see the results
    And I click on a case from the table
    And The case page opens in a new tab in CMS
    And I click on Documents tab
    And I navigate to Documents tab
    And I click on Case Documents

#Leyon View Shared Notes
  @regressionLeyon @notes
  Scenario: View Shared Notes should be available
    And I click on Cases
    And I should be able to click on Status field and select "Closed"
    And I should be able to click on Search button in CMS
    Then I should be able to see the results
    And I click on a in progress case from the table
    And The case page opens in a new tab in CMS
    And I click on Documents tab
    And I navigate to Documents tab
    And I see View Shared Notes is available



 #Leyon Complete Task Via Task Matrix
  @regressionLeyon @matrix
  Scenario: Task Matrix Functionality should work as expected
    Given I login to CMS with Researcher account
    And I click on Cases
    And I should be able to type "TituClildClient 1.5" in Name field in CMS
    And I should be able to click on Search button in CMS
    Then I should be able to see the results
    And I click on a case from the table for matrix
    And The case page opens in a new tab in CMS
    And I click on Research tab
    And I navigate to Research tab
    And I complete the tasks via task matrix
    Then I verify the task matrix was completed

 #Leyon
  @regressionLeyon @report
  Scenario Outline: User should be able to generate reports in shared notes section
    And I click on create order button in CMS
    And I fill order details for "Level 1" type in CMS
    And I fill out the subject "<Type>" details in CMS
    And I move to next page in CMS
    And I see the name of the subject for "<Type>" is added in CMS
    And I review order details have order type in CMS
    And I submit the order in CMS
    And I click on Orders in CMS
    And I should be able to type ordername in Case Name field
    And I should be able to click Order Status field and select "Submitted" for CMS
    And I should be able to click on Search button in CMS
    And I click on an order from the table for "<Type>" in CMS
    And The order page opens in a new tab in CMS
    And I click on view case button
    And I click on Edit Case Assignment
    And I select supervisor in the drop down
    And I select "Titu Datta [Researcher]" in the Primary Researcher drop down
    And I click on Save Assignments
    Then I click on assign case button
    Given I login to CMS with Researcher account
    And I click on Cases
    And I should be able to type ordername in Case Name field
    And I should be able to click on Search button in CMS
    And I click on an order from the table for "<Type>" in CMS
    And The case page opens in another new tab in CMS
    And I click on Research tab
    And I complete high priority tasks
    And I click on Documents tab
    Then I click on Generate button

    Examples:
    | Type       |
#    | individual |
    | company    |


