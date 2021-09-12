Feature: Amazon Search Feature

  Scenario: Second most expensive product contains Nikon D3X
    Given User navigates to "https://www.amazon.com/"
    When user searches for "Nikon"
    And sorts the result from highest price to lowest
    And clicks second product for details
    Then checks product title contains "Nikon D3X"