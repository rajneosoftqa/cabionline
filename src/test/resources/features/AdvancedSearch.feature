@AdvancedSearch @diligence
Feature: Client user should be able to perform advanced search

  @adv
  Scenario: User should be able to see advanced search page and functionalities
    Given User logs in with following credentials
      | tdattaresearcher@exiger.com | Admin123!! |
    And I navigate to "Advanced Search" page from the main nav panel
    And Advanced search functionalities are available

  @testadvanced
  Scenario Outline: User should be able to perform advanced search
    Given User logs in with following credentials
      | tdattaresearcher@exiger.com | Admin123!! |
    And I navigate to "Advanced Search" page from the main nav panel
    And I search for "<items>" in the search box
    And I see the result populates in a table

    Examples:
      | items     |
      | Chocolate |

  @differentclient
  Scenario Outline: A different client should not be able to see the search for another client
    Given User logs in with following credentials
      | tdattaparent@exiger.com | Exiger1!! |
    And I navigate to "Advanced Search" page from the main nav panel
    And I search for "<items>" in the search box
    And I should see only "A Titu Client" or "A Titu Client Child 1" or "A Titu Client Child 2" client name

    Examples:
      | items     |
      | Chocolate |

  Scenario: As a child account user I only see report for my account
    Given User logs in with following credentials
      | tdattachild1@exiger.com | Exiger1!! |
    And I navigate to "Advanced Search" page from the main nav panel
    And I search for "Pineapple" in the search box
    And I should only see my account for the report result

  Scenario: When the key words are available in multiple client report
  I should only see the reports from my account

#    Make sure two or more clients have same keywords in the report
    Given User logs in with following credentials
      | tdattachild1@exiger.com | Exiger1!! |
    And I navigate to "Advanced Search" page from the main nav panel
    And I search for "Cheese" in the search box
    And I should only see my account for the report result

   @onlyuser
  Scenario Outline: Make sure the search criteria showing only the user
    Given User logs in with following credentials
      | tdattachild1@exiger.com | Exiger1!! |
    And I navigate to "Advanced Search" page from the main nav panel
    And I use some "<SearchCriteria>" to search for items in the report
    And I should only see my account for the report result

    Examples:
      | SearchCriteria     |
      | Ham w/3 Black      |
      #   looks for pepper and anything after
#      | Pepper!            |
      # shows report either Pizza or Sausage
      | Pizza or Sausage   |
#      | Pizza and Sausage  |
      #looks for a phrase
      | "Bacon Ham Pickle" |






