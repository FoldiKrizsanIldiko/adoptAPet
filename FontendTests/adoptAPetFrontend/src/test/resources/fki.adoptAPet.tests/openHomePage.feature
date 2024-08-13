@home
Feature: The home page can be opened

  Scenario: The page is working
    When I navigate to the home page
    Then I can see navbar
    And I can see welcome message

  Scenario:
    Given I am on home page
    When I am NOT logged in
    Then I can see on the navbar home, adoptable pets, login and registration buttons

    Scenario:
      Given I am on home page
      When I am logged in
      Then I can see home, adoptable pets, my applications and logout buttons


