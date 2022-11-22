@test
Feature: Test user details at reqres.in

  Scenario: Get users details on listed pages
    When reqres.in website receives list users request for a page
      | page number |
      | 1           |
      | 2           |
    Then reqres returns status 200
    And reqres returns list of users with user data