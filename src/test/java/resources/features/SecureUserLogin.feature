Feature: Secure User Login
  As a Website User
  I want to securely log in using my username and password through the authentication page
  So that I can access personalized features and my order history

Background:
  Given the user is on the login page at "https://www.saucedemo.com/"

Scenario: Successful User Login
  When the user enters valid username "standard_user" and password "secret_sauce"
  And the user clicks on the login button
  Then the user should be redirected to their personalized dashboard
  And the user should see their order history

Scenario Outline: Unsuccessful User Login with Incorrect Credentials
  When the user enters username "<username>" and password "<password>"
  And the user clicks on the login button
  Then the user should see an error message "<error_message>"
  But the user should not be redirected to their dashboard

Examples:
  | username      | password       | error_message                     |
  | locked_out_user | secret_sauce | "Sorry, this user has been locked out." |
  | standard_user | wrong_password | "Username and password do not match."   |
  | ""            | secret_sauce   | "Please enter your username."      |
  | standard_user | ""             | "Please enter your password."      |

Scenario: Redirect to Personalized Dashboard After Successful Login
  When the user successfully logs in with valid credentials
  Then the user should be taken to their personalized dashboard with recent orders

Scenario: Error Handling for Repeated Failed Login Attempts
  When the user enters incorrect credentials more than three times
  Then the user should see a message indicating login attempts are limited
  And the user should be advised to try again later or recover their password

Scenario: Secure Logout Functionality from Dashboard
  Given the user is logged in and on their personalized dashboard
  When the user clicks on the logout button
  Then the user should be logged out
  And the user should receive confirmation of successful logout
  And the user should be redirected to the login page