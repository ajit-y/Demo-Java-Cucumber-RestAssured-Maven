Feature: Test user details at reqres.in

  Scenario:
    When reqres.in website receives list users request for a page
    Then reqres returns status 200
    And reqres returns list of users with user data