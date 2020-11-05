Feature: Edit contacts from the Simple Agenda app Contact List
  As a user
  I'd like to be able to update existing contacts from my list
  In order to keep it actualized

  Background: Existing User
    Given I have a contact named "Joseph Phiennes"

    Scenario: Successfully update contact's telephone Number
      When I change the telephone number
      Then The contact is updated

    Scenario: Contact not found
      But I want to update "Rudolph Giulliani"
      When I look for "Rudolph Giulliani"
      Then The contact is not on the list