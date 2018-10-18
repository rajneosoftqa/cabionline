@diligence
Feature: AdminRegression
#
  Background:
    And I login to Insight Admin
#
#
#  #IDM-99
  @IDM-99 @ignore
  Scenario: Case Creator role should not be available when adding Internal User in Insight Admin
    And I click on Internal Users tab
    And I click on add Internal User
    And I navigate to add Internal User Page
    And I check Case Creator role is not present in Roles

 #IDI-70
  @IDI-70 @refresher
  Scenario: ICV - Residency Refresher should be an available product for a given client account
    And I click on client accounts tab
    And I enter legal name as "A Titu Client" and click search
    And I clicked on details for the searched client
    And I navigate to Internal User Details Page
    And I verify that the client type is Diligence
    And I click on Update Account link
    And I check ICV - Residency Refresher is available in products
    And I verify ICV - Residency Refresher is listed between ICV - Residency and Investigative Project

  @IDI-70 @expedite
    Scenario: When ICV - Residency Refresher is selected as a product, expedite option is not available
    And I click on client accounts tab
    And I enter legal name as "A Titu Client" and click search
    And I clicked on details for the searched client
    And I navigate to Internal User Details Page
    And I verify that the client type is Diligence
    And I click on Update Account link
    And I check ICV - Residency Refresher is available in products
    When I check ICV - Residency Refresher as a product
    Then I verify Expedite option is not available


 #Leyon
  @IDI-80 @lacarte
  Scenario: New product type A la Carte Research is available in product options of client account
    And I click on client accounts tab
    And I enter legal name as "A Titu Client" and click search
    And I clicked on details for the searched client
    And I navigate to Internal User Details Page
    And I verify that the client type is Diligence
    And I click on Update Account link
    And I check A la Carte Research is available in products
    Then I verify A la Carte Research listed above Asset Tracing

# #Leyon
  @IDI-80 @xpedite
  Scenario: When A la Carte Research is selected as a product, expedite option is not available
  And I click on client accounts tab
  And I enter legal name as "A Titu Client" and click search
  And I clicked on details for the searched client
  And I navigate to Internal User Details Page
  And I verify that the client type is Diligence
  And I click on Update Account link
  And I check A la Carte Research is available in products
  When I check A la Carte Research as a product
  Then I verify Expedite option is not available

#  #Leyon
  @IDI-295 @typethirdparty
  Scenario: When selecting Diligence product types in third party client account all product types are selectable
    And I click on client accounts tab
    And I enter legal name as "3pmTest" and click search
    And I clicked on details for the searched client
    And I navigate to Internal User Details Page
    And I verify that the client type is Third Party
    And I click on Update Account link
    And I verify all product types are selectable

 @IDM-295 @typediligence @IDM-341
  Scenario: When selecting product types in Diligence client account only diligence product are selectable
   And I click on client accounts tab
   And I enter legal name as "A Titu Client" and click search
   And I clicked on details for the searched client
   And I navigate to Internal User Details Page
   And I verify that the client type is Diligence
   And I click on Update Account link
   And I verify only diligence product types are selectable

 #Leyon
 @IDM-308 @advancedcheckbox
 Scenario: Client Account on Admin should have flag to check or uncheck Advanced Search tab on or off
   And I click on client accounts tab
   And I enter legal name as "A Titu Client Child 2" and click search
   And I clicked on details for the searched client
   And I navigate to Internal User Details Page
   And I click on Update Account link
   And I verify Enable Advanced Search checkbox is available

 #Leyon
 @IDM-308 @advancevisiblity @ignore
 Scenario: When Enable Advance Search flag is unchecked or checked for a client account then Advanced search tab is invisible or visible respectively
   And I click on client accounts tab
   And I enter legal name as "A Titu Client 2" and click search
   And I clicked on details for the searched client
   And I navigate to Internal User Details Page
   And I click on Update Account link
   And I uncheck Enable Advanced Search checkbox and save
   Given User logs in with following credentials
     | tdattachild1@exiger.com | Exiger1!! |
   And I verify advanced search tab is not visible
   And I login to Insight Admin for Diligence
   And I click on client accounts tab
   And I enter legal name as "A Titu Client 2" and click search
   And I clicked on details for the searched client
   And I navigate to Internal User Details Page
   And I click on Update Account link
   Then I check Enable Advanced Search checkbox and save
   Given User logs in with following credentials
     | tdattachild1@exiger.com | Exiger1!! |
   And I navigate to "Advanced Search" page from the main nav panel
   And I use some "Ham w/3 Black" to search for items in the report
   And I should only see my account for the report result

