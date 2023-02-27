#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Game Rock, Paper, or Scissors

  Scenario: The user wins when chooses Rock and computer chooses Scissors
    Given the user will choose "rock"
    And the computer will choose "scissors"
    When they play
    Then verify that the computer chose "scissors"
    And the user wins

  Scenario: The user wins when chooses Scissors and computer chooses Paper
    Given the user will choose "scissors"
    And the computer will choose "paper"
    When they play
    Then verify that the computer chose "paper"
    And the user wins

  Scenario: The user wins when chooses Paper and computer chooses Rock
    Given the user will choose "paper"
    And the computer will choose "rock"
    When they play
    Then verify that the computer chose "rock"
    And the user wins

  Scenario: The user lose when chooses Rock and computer chooses Paper
    Given the user will choose "rock"
    And the computer will choose "paper"
    When they play
    Then verify that the computer chose "paper"
    And the user lose

  Scenario: The user tie when chooses Rock and computer chooses Rock
    Given the user will choose "rock"
    And the computer will choose "rock"
    When they play
    Then verify that the computer chose "rock"
    And the user tie
