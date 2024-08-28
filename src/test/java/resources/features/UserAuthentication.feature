Feature: User Authentication and Security
   In order to maintain secure access to personalized features
   As a user
   I want to securely log in and out of the website

Background:
   Given the user is on the "https://www.saucedemo.com/" homepage

Scenario: Secure Login with Valid Credentials
   When the user navigates to the login page
   And enters valid username "standard_user" and password "secret_sauce"
   And clicks on the login button
   Then the user should be redirected to their personalized dashboard

Scenario Outline: Error Message for Incorrect Login
   When the user navigates to the login page
   And enters username "<username>" and password "<password>"
   And clicks on the login button
   Then the user should see an error message "<error_message>"
   But the user should not be redirected to the personalized dashboard

Examples:
   | username        | password       | error_message                     |
   | locked_out_user | secret_sauce   | "Sorry, this user has been locked out." |
   | standard_user   | wrong_password | "Username and password do not match."   |
   | ""              | secret_sauce   | "Username is required."           |
   | standard_user   | ""             | "Password is required."           |

Scenario: Single-Click User Logout
   Given the user is logged into their dashboard
   When the user clicks on the logout button
   Then the user's session should be ended
   And the user should see a confirmation message "You have successfully logged out."