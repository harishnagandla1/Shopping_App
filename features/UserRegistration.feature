Feature: User Registration
  As an administrator
  I want users to register
  So that they can access the system

  Background:
    Given The application is up and running

  @userRegistration
  Scenario: Register a new user successfully
    Given Username "newuser" is not already taken
    When Send a POST request to "/api/users" endpoint with new user details
    Then Status_code equals 201
    And Response contains "User created successfully"
    And Response includes a non-empty "userId"

  @userRegistrationError
  Scenario: Registration fails when username is already in use
    Given Username "existinguser" is already in use
    When Send a POST request to "/api/users" endpoint with the username "existinguser"
    Then Status_code equals 409
    And Response contains "Username already in use"