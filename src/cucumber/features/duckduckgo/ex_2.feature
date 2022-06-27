Feature: Hotel account registration
  Scenario: User can create an account
    Given Open hotel main page
    When Create account using pppu@ga.com, Adrian, Adrian, password
    Then account should be created
    And close browser

  Scenario Outline:
    Given Open hotel main page
    When Create account using <email>, <firstName>, <lastName>, <password>
    Then account should be created
    And close browser

    Examples:
      | email          | firstName | lastName | password |
      | ppp@papa.com   | Ada       | Ada      | 12345    |
      | ppppa@pga.com  | Ada       | ada      | 12345    |
      | pppapi@pga.com | Ada       | adrian   | 12345    |
