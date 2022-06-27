Feature: Adding first address to existing account
  Scenario: User can add address to their account
    Given Open hotels main page
    And Sign in to existing account with pppu@ga.com, password
    And Go to add address page
    When Add address using: address, 11-111, city, 666666666
    Then Address should be added successfully
    And Close browser

    Scenario Outline:
      Given Open hotels main page
      And Sign in to existing account with <email>, <password>
      And Go to add address page
      When Add address using: <address>, <zipCode>, <city>, <phoneNumber>
      Then Address should be added successfully
      And Close browser

      Examples:
        | email          | address | zipCode | password | city | phoneNumber |
        | ppp@papa.com   | do      | 11-111  | 12345    | do   | 666666666   |
        | ppppa@pga.com  | do      | 11-111  | 12345    | do   | 666666666   |
        | pppapi@pga.com | do      | 11-111  | 12345    | do   | 666666666   |