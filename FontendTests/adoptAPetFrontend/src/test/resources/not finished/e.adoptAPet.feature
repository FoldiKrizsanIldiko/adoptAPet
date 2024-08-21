@adopt
Feature:
  I want to adopt an animal

  Background:
    Given I am on the home page
    Given I am logged in as a User

  Scenario: I can sign up to adopt the pet
    Given I am on adopt page
    Given I can see at least one adoptable pet i have not sign in for jet
    When I click on I'd like to adopt button
    Then I can see a notification
    And I am redirected to My Application page

  Scenario: I can not sign up two times for the same pet
    Given I am on My Application page
    Given I have at least one application
    When I click on Adoptable pets button
    And I am redirected to adopt page
    Then the I'd like to adopt button for the animal I am assigned on is disabled

  Scenario: I can assign to more animal
    Given I am on adopt page
    Given I have at least one application
    When I click on enabled I'd like to adopt button
    Then I can see a notification
    And I am redirected to My Application page
    And I have more than one application

