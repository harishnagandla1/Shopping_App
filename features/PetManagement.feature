Feature: Pet Management
  As a pet store manager
  I want to manage pets in the store inventory
  So that I can keep the inventory up to date

  Background:
    Given User logged in as a pet store manager

  @addPet
  Scenario: Add a new pet with valid data
    When Send a POST request to "/api/pets" endpoint with valid pet data
    Then Status_code equals 200
    And Response contains "Pet added successfully"
    And Response includes a non-empty "petId"
    
  @addPetError
  Scenario: Add a new pet with incomplete data
    When Send a POST request to "/api/pets" endpoint with incomplete pet data
    Then Status_code equals 400
    And Response contains "Missing required name field"

  @updatePetStatus
  Scenario: Update an existing pet's status to 'sold'
    Given A pet with "petId" "12345" exists in the inventory
    When Send a PUT request to "/api/pets/12345/status" endpoint with the new status "sold"
    Then Status_code equals 200
    And Response contains "Pet status updated successfully"

  @updatePetStatusError
  Scenario: Update the status of a non-existent pet
    Given A pet with "petId" "99999" does not exist in the inventory
    When Send a PUT request to "/api/pets/99999/status" endpoint with the new status "sold"
    Then Status_code equals 404
    And Response contains "Pet not found"
