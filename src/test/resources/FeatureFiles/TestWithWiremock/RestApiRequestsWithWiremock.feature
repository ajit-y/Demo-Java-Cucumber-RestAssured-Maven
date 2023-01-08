@wiremock
Feature: Explore testing API requests using Wiremock for stubbing responses

  Scenario: Test POST request with Wiremock
    Given Scenario for handling POST request is setup in Wiremock
    When the API endpoint receives a POST request
    Then the API endpoint returns status 200

  Scenario: Test GET request with Wiremock
    Given Scenario for handling GET request is setup in Wiremock
    When the API endpoint receives a GET request
    Then the API endpoint returns status 200
    And the response body contains text "success"

  Scenario: Test PUT request with Wiremock
    Given Scenario for handling PUT request is setup in Wiremock
    When the API endpoint receives a PUT request
    Then the API endpoint returns status 200
    And the response body contains text "Update Successful"

  Scenario: Test DELETE request with Wiremock
    Given Scenario for handling DELETE request is setup in Wiremock
    When the API endpoint receives a DELETE request
    Then the API endpoint returns status 200
    And the response message contains text "Delete Successful"