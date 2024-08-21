@home
Feature: Home page tests

  Background:
    Given I am on the home page

  Scenario: The page is working
    Then I can see the navbar
    And I can see the welcome message

  Scenario: Navbar without logging in
    Given I am NOT logged in
    When I click on the Home button
    Then I can see the Home, Adoptable Pets, Login, and Registration buttons on the navbar

  Scenario: Navbar when logged in
    Given I am logged in as a User
    When I click on the Home button
    Then I can see the Home, Adoptable Pets, My Applications, and Logout buttons on the navbar