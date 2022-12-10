@test
Feature: Test GET user details at reqres.in

  Scenario: GET users details on listed pages
    When reqres.in website receives list users request for a page
      | page number |
      | 1           |
      | 2           |
    Then reqres returns status 200 for each request
    And reqres returns list of users with user data

  Scenario Outline: GET users details on listed pages while exploring scenario outline functionality
    When reqres.in website receives list users request on page <page number>
    Then reqres returns response with status 200
    And reqres returns list of users with user data on page <page number>
    Examples:
      | page number |
      | 1           |
      | 2           |