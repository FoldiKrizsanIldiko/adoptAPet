@logout
  Feature: I want to log out from page

    Background:
      Given I am on the home page
      And I am logged in as a User

      Scenario: I want to log out
        When I press logout button
        And I confirm that I want to logout
        Then I am notified that I am no longer logged in
        And I am redirected to home page
