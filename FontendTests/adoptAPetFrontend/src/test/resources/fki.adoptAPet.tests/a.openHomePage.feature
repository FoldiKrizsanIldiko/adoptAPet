@home
Feature: The home page can be opened

  Background:
    Given I am on home page

  Scenario: The page is working
    Then I can see navbar
    And I can see welcome message

  Scenario: Navbar without logging in
    When I am NOT logged in
    When I click on Home button
    Then I can see on the navbar home, adoptable pets, login and registration buttons

  Scenario:
    When I am logged in
    When I click on Home button
    Then I can see home, adoptable pets, my applications and logout buttons

