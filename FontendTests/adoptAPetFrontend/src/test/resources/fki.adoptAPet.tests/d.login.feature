@login
Feature: I can login to page

  Background:
    Given I am on home page

  Scenario: I can login from home page
    Given I am NOT logged in
    When I click on Login button
    When I submit login form with valid credentials
    Then I am logged in successfully
    And I am redirected to the page with adoptable pets
