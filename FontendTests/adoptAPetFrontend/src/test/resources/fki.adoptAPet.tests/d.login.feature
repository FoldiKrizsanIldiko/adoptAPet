@login
Feature: I can login to page

  Background:
    Given I am on the home page

  Scenario: I can login from home page
    Given I am NOT logged in
    When I click on Login button
    When I submit login form with valid credentials
    Then I am logged in successfully
    And I am redirected to the page with adoptable pets


  Scenario:Login with invalid credentials
    Given I am NOT logged in
    When I click on Login button
    And I enter "wrongUsername" as username and "wrongPassword" as password
    Then I am notified that the login failed