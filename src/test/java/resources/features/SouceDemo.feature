Feature: SouceDemo Project

  Scenario: Secure User Login
    Given I am on the Login page
    When I enter valid credentials
    Then I should be redirected to the homepage

  Scenario: Error Message on Incorrect Login
    Given I am on the Login page
    When I enter invalid credentials
    Then I should see an error message

  Scenario: User Logout
    Given I am logged in
    When I click on the logout button
    Then I should be logged out

  Scenario: View All Products
    Given I am on the Products page
    When I access the page
    Then I should see all available products

  Scenario: Filter and Sort Products
    Given I am on the Products page
    When I apply filters and sort options
    Then the products should be displayed according to the selected criteria

  Scenario: Product Details
    Given I am on a specific product page
    When I view the product details
    Then I should see images, description, price, availability, and reviews

  Scenario: Ask Questions on Product Page
    Given I am on a specific product page
    When I choose to ask a question
    Then I should be able to submit my question

  Scenario: Add to Cart
    Given I am on a product's details page
    When I add the product to my cart
    Then I should see a confirmation message

  Scenario: Accessing and Modifying Cart
    Given I am viewing my cart
    When I modify quantities or remove items
    Then the cart should update immediately

  Scenario: Checkout Process
    Given I am ready to checkout
    When I proceed through the checkout steps
    Then I should see progress and options

  Scenario: Shipping Options
    Given I am at the shipping options page
    When I choose a shipping method
    Then I should see the costs associated with the method

  Scenario: Order Confirmation
    Given I have completed my purchase
    When I receive the confirmation
    Then it should display order details and expected delivery

  Scenario: Help Section Accessibility
    Given I am on any page
    When I access the Help section
    Then I should find FAQs and contact options

  Scenario: Submit and View User Feedback
    Given I am on a product's details page
    When I submit a review
    Then it should be visible to others