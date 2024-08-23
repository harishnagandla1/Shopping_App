Feature: Comprehensive UI tests for EP-22

  Scenario: Verify the new user registration process
    Given I am on the registration page
    When I enter valid user details
    And I submit the registration form
    Then I should be registered successfully

  Scenario: Verify the error message for invalid email format
    Given I am on the registration page
    When I enter an invalid email format
    And I submit the registration form
    Then I should see an error message about invalid email format