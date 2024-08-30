Feature: Create a New Pet Entry

Background:
Given the API endpoint is set to "/api/pets"
And I have manager permissions

@createPet
Scenario: Verify that a new pet can be added with the required details
Given I have the following pet details
| name   | status     |
| Buddy  | available  |
When I send a POST request with the pet details
Then the response status code should be 201
And the response body contains the pet's details including a unique pet ID

@createPetNoName
Scenario: Verify that adding a new pet without a name returns an error
Given I have the following pet details
| status     |
| available  |
When I send a POST request with the pet details
Then the response status code should be 400
And the response body contains message "Pet name is required"

@createPetNoStatus
Scenario: Verify that adding a new pet without a status returns an error
Given I have the following pet details
| name   |
| Buddy  |
When I send a POST request with the pet details
Then the response status code should be 400
And the response body contains message "Pet status is required"