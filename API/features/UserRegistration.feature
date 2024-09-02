@UserRegistration
Feature: User Registration

Scenario: User registration with valid details
Given a user has navigated to the registration page
When the user enters valid registration details
Then the user registration should be successful

Scenario: User registration with invalid details
Given a user has navigated to the registration page
When the user enters invalid registration details
Then the user registration should fail with an error message