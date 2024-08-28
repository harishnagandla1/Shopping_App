Feature: Checkout Process and Order Confirmation
   In order to complete purchases with confidence
   As a user
   I want a clear and intuitive checkout process with immediate order confirmations

Background:
   Given the user has items in their cart and is ready to checkout

Scenario: Intuitive Multi-Step Checkout
   When the user begins the checkout process
   Then the process should be divided into clear steps with progress indicators

Scenario Outline: Shipping Options and Costs
   When the user selects the shipping option "<shipping_option>"
   Then the associated cost for "<shipping_option>" should be clearly displayed

Examples:
   | shipping_option |
   | standard        |
   | expedited       |
   | overnight       |

Scenario: Immediate Order Confirmation
   Given the user has completed the payment information
   When the user finalizes the purchase
   Then an on-screen confirmation with order details and expected delivery date should be displayed
   And a confirmation email with the same details should be sent to the user