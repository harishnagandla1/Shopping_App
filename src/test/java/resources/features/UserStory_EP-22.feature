Feature: Enhance User Profile Settings

Scenario: Update Password
Given I am logged into the application
When I navigate to the 'Profile Settings' page
And I enter current password, new password and confirm the new password
Then the password should be updated and a confirmation notification displayed

Scenario: Update Email with Verification
Given I am on the 'Profile Settings' page
When I enter a new email and submit
Then I should receive a verification link
And when I verify the email
Then the email should be updated and a confirmation notification displayed

Scenario: Update Phone Number with OTP
Given I am on the 'Profile Settings' page
When I enter a new phone number and submit
Then I should receive an OTP
And when I verify the OTP
Then the phone number should be updated and a confirmation notification displayed