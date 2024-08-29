Feature: Secure Login
   In order to access personalized features and my order history
   As a Website User
   I want to log in securely using my username and password

Background:
   Given the user is on "https://www.saucedemo.com/"

Scenario: Successful Login
   When the user navigates to the login form
   And the user enters valid username "standard_user" and password "secret_sauce"
   And the user clicks on the login button
   Then the user should be logged in successfully
   And have access to personalized features
   And see their order history on the dashboard

Scenario Outline: Login with Invalid Credentials
   When the user navigates to the login form
   And the user enters username "<username>" and password "<password>"
   And the user clicks on the login button
   Then the user should receive an error message "<error_message>"
   But the user should not have access to personalized features or order history

Examples:
   | username        | password     | error_message              |
   | locked_out_user | secret_sauce | "Sorry, this user has been locked out." |
   | standard_user   | wrong_pass   | "Username and password do not match."   |
   | ""              | secret_sauce | "Username is required."     |
   | standard_user   | ""           | "Password is required."     |

Scenario: Login Form Load Performance
   When the user accesses "https://www.saucedemo.com/"
   Then the login form should load within 2 seconds