Feature: User Creation API

  Scenario Outline: Successful creation of users with different data sets
    Given the API endpoint '/api/users' is ready to accept POST requests
    When a POST request is sent to '/api/users' with the payload body:
      """
      {
        "name": "<name>",
        "email": "<email>",
        "role": "<role>",
        "password": "<password>"
      }
      """
    Then the response should have a status code of 201
    And the response should confirm user creation in JSON format

    Examples:
      | name       | email                  | role          | password |
      | John Doe   | john.doe@example.com   | Admin         | P@ssw0rd |
      | Jane Smith | jane.smith@example.com | User          | P@ssw0rd |
      | Mike Ross  | mike.ross@example.com  | Moderator     | P@ssw0rd |
      | Sara Lee   | sara.lee@example.com   | Guest         | P@ssw0rd |