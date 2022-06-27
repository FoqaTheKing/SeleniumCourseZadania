Feature: Address of existing account

  Scenario: User is able to add address to his account
    Given Open presta shop main page
    And log into existing account with adrian@adrian.adrian and adrian
    And open Addresses page
    When Add address using alias, address, city, 11-111, United Kingdom, 666666666
    Then Address should contain address
    And Address should be deleted after
    And Close browser

  Scenario Outline:
    Given Open presta shop main page
    And log into existing account with <email> and <password>
    And open Addresses page
    When Add address using <alias>, <address>, <city>, <postCode>, <country>, <phoneNo>
    Then Address should contain <address>
    And Address should be deleted after
    And Close browser

    Examples:
      |email|password|alias|address|city|postCode|country|phoneNo|
      |adrian@adrian.adrian|adrian|alias|address 13|city|11-111|United Kingdom|666666666|

