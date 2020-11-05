Feature: Add contacts to the Simple Agenda app
  As a user
  I want to add contact name and phone number
  I order to organize my contacts

  Scenario: Add new contact
    Given I know someone named "John Doe"
    And his telephone number is "085994566898"
    When I add him to the list
    Then I get "John Doe" listed on my contact list

  Scenario: Add an already existing contact
    Given I have a contact named "Foo bar"
    When I add him to the list
    Then I get message informing this user already exists

  Scenario: Add an empty contact
    Given I don't fill contact's name and phone number
    When I try to add him to the list
    Then I get message informing the required fields

  Scenario: Add a contact with more than 12 characters phone number
    Given I enter a user with a phone number larger than 12 characters
    When I add him to the list
    Then I get a message informing the phone is to long

  Scenario: Add a contact with less than 8 characters phone number
    Given I enter a user with a phone number shorter than 8 characters
    When I add him to the list
    Then I get a message informing the phone is to short