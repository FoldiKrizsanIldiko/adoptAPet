@login
  Feature: I can login to page
Background:
    Given I am on home page

    Scenario: I can login from home page
      Given I am NOT logged in
      When I click on Login button
      Then The login page is opening
      When I type in my valid email address
      And I type in my valid password
      And I click on Login button
      Then I should be logged in successfully
      And I should been redirected to page with adoptable pets
