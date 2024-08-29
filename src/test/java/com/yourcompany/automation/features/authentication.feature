Feature: User Authentication API
  User Authentication is crucial for securing access to the application. This feature verifies
  that the authentication mechanism works correctly through various scenarios including valid
  and invalid credentials, and token expiration.

  Background:
    Given the authentication API endpoint is "/api/authenticate"

  @validCredentials
  Scenario: Successful user authentication with valid credentials
    Given a registered user with username "user1" and password "correctpass"
    When the user sends a POST request with valid credentials
    Then the response status code should be 200
    And the response contains an authentication token
    And the token should be valid for the specified period

  @invalidPassword
  Scenario: User authentication fails with invalid password
    Given a registered user with username "user1" and correct password "correctpass"
    When the user sends a POST request with username "user1" and password "wrongpass"
    Then the response status code should be 401
    And the response does not contain an authentication token

  @nonExistentUser
  Scenario: User authentication fails with non-existent username
    Given a username "nonexistentuser" not registered in the system
    When the user sends a POST request with username "nonexistentuser" and password "anyPassword"
    Then the response status code should be 404
    And the response does not contain an authentication token

  @tokenExpiration
  Scenario: Verify that the authentication token expires after the specified period
    Given a valid authentication token that expires after 1 hour
    And 1 hour and 5 minutes have passed since the token was issued
    When the user sends a GET request to a protected resource using the expired token
    Then the response status code should be 401
    And the response contains an error message indicating an expired token