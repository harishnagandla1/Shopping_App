Feature: User Registration

  Scenario: User registers with valid details
    Given the user has navigated to the registration page
    When the user enters valid registration details
    And the user submits the registration form
    Then the user should be registered successfully

  Scenario: User registers with invalid email
    Given the user has navigated to the registration page
    When the user enters invalid email
    And the user submits the registration form
    Then the user should be shown an error message