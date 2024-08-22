@application
Feature: I want to see my applications

  Background:
    Given I am on the home page
    And I am logged in as a User

  Scenario: I can browse my applications
    When I click on My applications button
    Then I can see only the pets I want to adapt or the message that I do not have application

  Scenario Outline: I can filter my applications
    When I click on My applications button
    And I check out the <filter> checkbox
    Then I can see only the <filtered> applications or message that I do not have <filter> application
    Examples:
      | filter   | filtered          |
      | All      |                   |
      | Pending  | wasn't a decision |
      | Accepted | accepted          |
      | Refused  | refused           |
