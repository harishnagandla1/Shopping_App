Feature: Search for Pets by Status

Background:
Given the API endpoint is set to "/api/pets"

@searchAvailable
Scenario: Verify that the API returns pets with status 'available'
Given there are pets with status 'available' in the system
When I send a GET request with parameter "status=available"
Then the response status code should be 200
And the response body contains a list of pets with status 'available'

@searchPending
Scenario: Verify that the API returns pets with status 'pending'
Given there are pets with status 'pending' in the system
When I send a GET request with parameter "status=pending"
Then the response status code should be 200
And the response body contains a list of pets with status 'pending'

@searchSold
Scenario: Verify that the API returns pets with status 'sold'
Given there are pets with status 'sold' in the system
When I send a GET request with parameter "status=sold"
Then the response status code should be 200
And the response body contains a list of pets with status 'sold'

@searchInvalid
Scenario: Verify that the API returns an error with an invalid status
When I send a GET request with parameter "status=invalid_status"
Then the response status code should be 400
And the response body contains message "Invalid status value"