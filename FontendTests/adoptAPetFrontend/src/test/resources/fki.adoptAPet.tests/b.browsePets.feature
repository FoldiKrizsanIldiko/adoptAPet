@browsePets
Feature: Browse adoptable pets
  I want to see if there are adoptable pets available

  Background:
    Given I am on home page

  Scenario: I can see the adoptable pets
    And I am NOT logged in
    When I click on Adoptable pets button
    Then I can see if there are any pets for adoption

  Scenario Outline: I can filter the pets
    When I am NOT logged in
    When I click on Adoptable pets button
    When I choose <option>
    Then I can see only <option> types of animal or message that there are no animals of this type

    Examples:
      | option    |
      | all       |
      | dogs      |
      | cats      |
      | rabbits   |
      | hamsters  |
      | elephants |

