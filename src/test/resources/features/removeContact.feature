Feature: Remove contacts from the Simple Agenda app
  As a User
  I want to be able to remove contacts from my contact lists
  So I can keep only correct and useful contacts

  Scenario: Remove an existing contact
    Given I have a contact listed
    When I select the remove contact icon
    Then the contact is no longer listed

  Scenario: Cancel contact removal
    Given I have a contact listed
    When I select the remove contact icon
    And cancel my action
    Then the contact remain listed

  Scenario: Remove multiple contacts
    Given I have more than one contacts
    And Selected some of them
    When I select to mass remove than
    And confirm my action
    Then the selected contacs are no longer listed