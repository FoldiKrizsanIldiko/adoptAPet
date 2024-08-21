@application
Feature: I want to see my applications

  Background:
    Given I am on the home page

  Scenario: I can browse my applications
    When I click on My applications button
    Then I can see only the pets I want to adapt or the message that I do not have application

  Scenario Outline: I can filter my applications
    When I click on My applications button
    And I check out the <filter> checkbox
    Then I can see only the <filter> applications or message that I do not have <filter> application
    Examples:
      | filter   |
      | pending  |
      | accepted |
      | refused  |

