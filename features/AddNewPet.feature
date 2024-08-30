Feature: Add New Pet Functionality
  As a user, I want to be able to add a new pet to the system so that I can track it.

  Background:
    Given User has valid authentication credentials

  @addPet
  Scenario: User should be able to add a new pet with valid details
    Given Authenticate with the API to obtain a valid session/token
    When Send a POST request to "/api/pets" with valid pet details in the request body
      """
      {
        "name": "Buddy",
        "type": "Dog",
        "age": 3
      }
      """
    Then The API should return a status code of 201
    And The response body confirms the pet's details including a unique pet ID

  @invalidAddPet
  Scenario: User should not be able to add a pet with incomplete details
    Given Authenticate with the API to obtain a valid session/token
    When Send a POST request to "/api/pets" with incomplete pet details in the request body
      """
      {
        "name": "Coco"
      }
      """
    Then The API should return a status code of 400
    And The response body contains an error message indicating missing required fields