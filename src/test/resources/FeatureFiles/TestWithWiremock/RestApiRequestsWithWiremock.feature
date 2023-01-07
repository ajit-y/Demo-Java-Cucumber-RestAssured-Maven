@wiremock
Feature: Explore testing API requests using Wiremock for stubbing responses

  Scenario: Test POST request with Wiremock
    Given Scenario for handling POST request is setup in Wiremock
    When the API endpoint receives a POST request
    Then the API endpoint returns status 200