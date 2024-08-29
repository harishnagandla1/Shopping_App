Feature: Order Management
  As a pet store customer
  I want to place orders for pets
  So that I can purchase pets from the store inventory

  Background:
    Given User logged in as a customer

  @placeOrder
  Scenario: Place an order for a pet that is in stock
    Given A pet with "petId" "12345" is available in stock
    When Send a POST request to "/api/store/order" endpoint with the order details
    Then Status_code equals 200
    And Response includes an "orderId"
    And Response contains "placed" status

  @placeOrderError
  Scenario: Place an order for a pet that is out of stock
    Given A pet with "petId" "12345" is not available in stock
    When Send a POST request to "/api/store/order" endpoint with the order details
    Then Status_code equals 400
    And Response contains "Pet is out of stock"