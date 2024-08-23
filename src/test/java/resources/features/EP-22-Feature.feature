Feature: Enhanced Shopping Experience

  Scenario: Add single item to cart
    Given I am on the Product Page
    When I click on 'Add to Cart'
    Then the item should be added to the cart

  Scenario: Remove item from cart
    Given I am viewing the cart
    When I remove an item
    Then the cart should update to reflect the removal