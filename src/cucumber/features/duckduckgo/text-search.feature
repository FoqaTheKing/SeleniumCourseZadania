Feature: DuckDuckGo Search
  Scenario: User can search any keyword
    Given open a browser with duckduckgo
    When a keyword selenium is entered in input field
    Then the first record should contain selenium
    And close browser

  Scenario Outline: user can search any keywords
    Given open a browser with duckduckgo
    When a keyword <keyword> is entered in input field
    Then the first record should contain <expectedKeyword>
    And close browser

    Examples:
      | keyword  | expectedKeyword |
      | java     | java            |
      | cucumber | cucumber        |
      | bartek   | bartek          |