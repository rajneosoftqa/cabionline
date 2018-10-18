@OMSRegression @diligence
Feature: OMS Regression

  Background:
    Given I login to OMS site

  #Scenario: Login page functionalities
#    Given User navigates to "diligenceqa.exiger.com" site
#    And The login page functionalities should be available


 #Leyon TOC Navigation
  @regressionLeyon @toc
  Scenario: Terms and Conditions Page should perform as expected
    And I click on terms and conditions
    And I navigate to the terms and conditions page

 #Leyon Support Page Navigation
  @regressionLeyon @support
    Scenario: Support Page should perform as expected
    And I click on support link
    And I navigate to support page

 #Leyon Log off
  @regressionLeyon
    Scenario: Log off functionality should perform as expected
    And I log off from the site

  @regressionLeyon
  Scenario: Dashboard page of OMS site should perform as expected
    And I am in dashboard page
    And I see in progress tile is active
    And I click on dashboard viewing options and choose "My Dashboard"
    And I see calendar is available
    And I see a search box is available
    And I see create order option is available
    And I see change password and log off option

#Leyon TeamDashboard
  @regressionLeyon @teamdashboard
  Scenario: User should be able to view team dashboard page
    And I click on dashboard viewing options and choose "Team Dashboard"
    And I see page changes for "Team Dashboard"
    And I should be able to click "Not Submitted" tile
    And I should be able to click "In Progress" tile and see in progress orders
    And I should be able to click "Unread Messages" tile and see my unread messages
    And I should be able to click on "Reports Delivered" tile view orders with delivered reports



#Leyon Calendar
  @regressionLeyon
  Scenario: User should be able to change Months in the calendar
    And   I click on back arrow in calendar to go to previous month
    And   I click on forward arrow in calendar to go to next month


#Leyon itemsperpage
  @regressionLeyon @page
  Scenario: User should be able to decide how many item to show per page
    And I choose "50" item per page
    And I see "50" item listed in the table


  #Leyon OrderSearch
  @regressionLeyon @searchoms
  Scenario: User should be able to search using Filter Criteria fields on Orders page
    And   I click on Orders
    And   I should be able to type "name" in Name field
    And   I should be able to click on Order type field and select a "Level 1"
    And   I should be able to pick Submited between start and end dates as "4/1/2018" and "4/24/2018" fields
    And   I should be able to pick Completed between start and end dates as "4/1/2018" and "4/24/2018" fields
    And   I should be able to click Order Status field and select "Draft"
    And   I should be able to type "1" in Order Number field
    And   I should be able to click on Search button
    Then  I should be able to see the results
    And   I should be able to click on Reset button

#Leyon CreateOrder
  #Scenario: User can create an order
  @regressionLeyon @create
  Scenario Outline: User creates an order and see the order listed on orders page
    And I click on create order button
    And I fill order details for "Level 1" type
    And I fill out the subject "<Type>" details
    And I move to next page
    And I see the name of the subject for "<Type>" is added
    And I review order details have order type
    And I submit the order

    Examples:
      |Type|
      |individual|
      |company|

#Leyon Quick Search
  @regressionLeyon @quick
  Scenario: User should be able to search subjects on OMS site
    And   I type "test" in search for subjects text box
    And   I should be able to see suggestions
    And   I should be able to click on the suggestion

  #failed 05/24/2018
  Scenario: User creates an order and see the order listed on dashboard page
    And I click on create order button
    And I fill order details for "Level 1" type
    And I fill out the subject "company" details
    And I move to next page
    And I see the name of the subject is added
    And I review order details have order type
    And I submit the order
    And I am in dashboard page
    And I choose "200" item per page
    And I sort the order by "DueDateFormatted" 2 times
    Then I see the order is listed in the table

##########################################

  @regressionLeyon
   Scenario:User should get unexpected error when accessing an invalid url
    And  I go to a page which doesnt exist
    Then I get unexpected error on the page

#Leyon Audit-Trail Export
  #failed 05/24/2018
  @regressionLeyon @ignore
  Scenario: Audit Trail Export functionality should work as expected
    And I click on Orders
    And I click on Download Audit
    Then The audit report is downloaded

#Leyon From Table /Company & Individual
  @regressionLeyon @editorder
  Scenario Outline: Company/Individual Fields in an existing order should work as expected
    And I should be able to click "Not Submitted" tile
    And I click on an order from the table for "<Type>"
    And The order page opens in a new tab
    And I click on continue button
    And I navigate to subjects page
    And I fill out the subject "<Type>" details
    And I move to next page
    And I see the name of the subject for "<Type>" is added
#    And I review order details have order type
    Then I submit the order

    Examples:
    |Type|
    |individual|
    |company|

##Leyon ICV Order Type
  @regressionLeyon @icv
  Scenario Outline: ICV Order Type should perform as expected
    And I login as child account
    And I click on create order button
    And I fill order details for "<Type>" type for child account

   Examples:
     |Type|
     |ICV - Citizenship|
     |ICV - Residency|

#  @regressionLeyon @residence
#  Scenario: ICV Order Type should perform as expected
#    And I login as child account
#    And I click on create order button
#    And I fill order details for "ICV - Residency" type for child account



 #Leyon Order Details
  @orderdetails
  Scenario: Company tab under an order should perform as expected
    And I should be able to click "In Progress" tile and see in progress orders
    And I click on an in progress order from the table
    And The order page opens in a new tab
    And I see the order details page


#Leyon Download Reports
  #failed 05/24/2018
  @regressionLeyon @ignore
  Scenario: Download Results functionality should work as expected
    And I click on Orders
    And I click on Download Results
    And The report gets downloaded

 #Leyon Sending Messages
  @regressionLeyon @messages
    Scenario: Sending Messages functionality should work as expected
    And I should be able to click "In Progress" tile and see in progress orders
    And I click on an in progress order from the table
    And The order page opens in a new tab
    And I click on Messages tab
    And I navigate to the messages tab
    And I send a message in the message textbox and click send
    Then I check the sent message


##########################################

    #Leyon IDM-103
 # Scenario: User should be able to upload a pdf document of size upto 80mb  #######issue
#    Given I am an OMS user
#    When I create an order
#    And attached a pdf document under submitted documents
#    Then  The file is attached and saved in the order
#
#    Given I am an OMS user
#    When I navigate to an existing order
#    And attached a pdf document under submitted documents under Order Details
#    Then  The file is attached and saved in the order
#
#    Given I am an CMS user
#    When I create an order
#    And attached a pdf document under submitted documents
#     Then  The file is attached and saved in the order
#
#    Given I am an CMS user
#    When I navigate to an existing order [Order>Details]
#    And attached a pdf document under submitted documents
#    Then The file is attached and saved in the order

 # Scenario: User should be able to upload a pdf document of size upto 99mb  #######issue
#    Given I am an OMS user
#    When I create an order
#    And attached a pdf document under submitted documents
#    Then  The file is attached and saved in the order
#
#    Given I am an OMS user
#    When I navigate to an existing order
#    And attached a pdf document under submitted documents under Order Details
#    Then  The file is attached and saved in the order
#
#    Given I am an CMS user
#    When I create an order
#    And attached a pdf document under submitted documents
#     Then  The file is attached and saved in the order
#
#    Given I am an CMS user
#    When I navigate to an existing order [Order>Details]
#    And attached a pdf document under submitted documents
#    Then The file is attached and saved in the order

 # Scenario: User should be able to upload a pdf document of size upto 100mb   #######issue
#    Given I am an OMS user
#    When I create an order
#    And attached a pdf document under submitted documents
#    Then  The file is attached and saved in the order
#
#    Given I am an OMS user
#    When I navigate to an existing order
#    And attached a pdf document under submitted documents under Order Details
#    Then  The file is attached and saved in the order
#
#    Given I am an CMS user
#    When I create an order
#    And attached a pdf document under submitted documents
#     Then  The file is attached and saved in the order
#
#    Given I am an CMS user
#    When I navigate to an existing order [Order>Details]
#    And attached a pdf document under submitted documents
#    Then The file is attached and saved in the order


  @ignore
  Scenario: Calendar should show the orders currently in progress
    And If a order is available it should show in calendar
