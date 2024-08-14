@registration
Feature: I can register as a user

  Background:
    Given I am on home page

  Scenario: I can register
    Given I open the registration page
    When I fill the required fields with valid data
    And I push the Register button
    Then I can see message about successful registration
    And I am redirected to login page


