Feature: Secure Login
  As a user, I want to securely log into the application so that I can access my account safely.

  Scenario: User logs in with valid credentials
    Given I am on the login page
    When I enter valid credentials
    Then I should be redirected to the dashboard page

  Scenario: User fails to login with invalid credentials
    Given I am on the login page
    When I enter invalid credentials
    Then I should see an error message indicating login failure