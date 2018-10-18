@OMSRegression @diligence
Feature: OMS Cases

  Background:
    Given I login to OMS site

     #Leyon IDM-188
  @regressionLeyon
  Scenario: Verify Order Status Submitted in Order Status Dropdown
    And  I click on Orders
    And  I click on Order Status dropdown
    Then I should not see "Submitted" status

     #Leyon IDM-98
  @IDM-98 @regressionLeyon
  Scenario: Orders page of OMS site should perform as expected
    And I click on Orders
    And I see name field is available
    And I see order type dropdown is available
    And I see Submitted 'Between Start date and End date' dropdowns are available
    And I see Order Name, Order Type, Submitted Start and End date fields are aligned horizontally
    And I see Completed 'Between Start date and End date' dropdowns are available
    And I see Order Status dropdown is available
    And I see Order Number field is available
    And I see Completed Start and End date, Order Status, Order Number fields are aligned horizontally
    And I see show more filters link is available
    And I see search and reset buttons are available
    And I see create order option is available
    And I see change password and log off option

     #Leyon IDM-50
  @IDM-50 @regressionLeyon
  Scenario: User should get unexpected error when accessing a not accesible directory
    And I go to a page which is not accesible
    Then I get unexpected error on the page


    #Leyon External Message
  @regresssionLeyon @externalmessage1
  Scenario: Sending Messages functionality should work as expected
#    And I login to OMS site for sending external message
    And I should be able to click "In Progress" tile and see in progress orders
    And I click on an in progress order from the table
    And The order page opens in a new tab
    And I click on Messages tab
    And I navigate to the messages tab
    And I send a message in the message textbox and click send
    And I check the sent message
    Then I log off from the site in CMS
    And I login to CMS site again as a client manager
    And I click on Cases
    And I should be able to type a Case in Case Name field
    And I should be able to click on Search button in CMS
    And I click on the searched case from the table
    And The case page opens in a new tab
    And I click on Messages tab in Case Page
    And I navigate to the messages tab in CMS
    Then I check the sent message in CMS