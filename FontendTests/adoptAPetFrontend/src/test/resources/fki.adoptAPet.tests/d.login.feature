@login
Feature: I can login to page

  Background:
    Given I am on the home page

  @workflow
  Scenario Outline: I can login from home page
    Given I am NOT logged in
    When I click on Login button
    And I enter <email> as username and <password> as password
    Then I am logged in successfully
    And I am redirected to the page with adoptable pets

    Examples:
      | email                | password |
      | tom.taylor@email.com | String!2 |
      | staff@adoptapet.com  | String!1 |
      | admin@adoptapet.com  | String!0 |


  Scenario:Login with invalid credentials
    Given I am NOT logged in
    When I click on Login button
    And I enter "wrongUsername" as username and "wrongPassword" as password
    Then I am notified that the login failed