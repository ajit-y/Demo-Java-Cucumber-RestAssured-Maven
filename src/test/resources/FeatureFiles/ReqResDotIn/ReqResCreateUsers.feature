@test
Feature: Test create user functionality at reqres.in

  Scenario: Create new user successfully
    When reqres.in website receives request with name and job details for creating a new user
      | name | job     |
      | pujo | leader  |
      | cujo | partner |
    Then reqres returns status 201 for each request
    And  reqres response contains user data for new user