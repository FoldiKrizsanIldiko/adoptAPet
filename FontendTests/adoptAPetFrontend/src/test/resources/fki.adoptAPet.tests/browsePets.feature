@browse
Feature: Browse adoptable pets
  I want to see if there are adoptable pets

  Background:
    Given I am on home page

  Scenario: I can see the adoptable pets
    When I click on Adoptable pets button
    Then I can see if there are any pets for adopt


    Scenario Outline: I can filter the pets
      When I click on Adoptable pets button
      When I click on the selector
      When I choose <option>
      Then I can see only <option> types of animal or message that there is no animal of this type

      Examples:
        | option    |
        | all       |
        | dogs      |
        | cats      |
        | rabbits   |
        | hamsters  |
        | elephants |


