Feature: Shopping Cart Management
  Scenario: Add a single product to the shopping cart
    Given I am logged in as a valid user
    When I add a product to the shopping cart
    Then the product should be added to the cart

  Scenario: Remove a product from the shopping cart
    Given I have added a product to the shopping cart
    When I remove the product from the shopping cart
    Then the product should be removed from the cart

  Scenario: Adjust quantity of a product in the shopping cart
    Given I have added a product to the shopping cart
    When I adjust the quantity of the product
    Then the product quantity should be updated in the cart

  Scenario: Validate the shopping cart contents
    Given I have added products to the shopping cart
    When I view the shopping cart
    Then I should see all added products listed in the cart