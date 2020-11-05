Feature: Open Initial Page
  As someone with lots of contacts
  I want to be able to run an simple agenda
  In order to get myself organized and in touch with important people

  Scenario: Open initial page
    Given I'm in the home page
    When the list is loaded
    Then I get the list of my contacts

  Scenario: The list shows Name, Phone and Actions
    Given I have a contact named "John Doe"
    When the list is loaded
    Then I get "John Doe" listed on my contact list
