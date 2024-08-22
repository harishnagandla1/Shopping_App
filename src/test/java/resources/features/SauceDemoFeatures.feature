Feature: SauceDemo Website Functionality
  Scenario: Login to SauceDemo
    Given I am on the SauceDemo login page
    When I enter valid credentials
    Then I should be redirected to the product page

  Scenario: Add Item to Cart
    Given I am logged into SauceDemo
    When I add an item to the cart
    Then the item should be added successfully

  Scenario: Checkout
    Given I have items in my cart
    When I proceed to checkout
    Then I should be able to complete my purchase with correct details