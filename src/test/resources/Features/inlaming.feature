Feature: create account
  Scenario: Add account

    Given I have written my email "laaso7576@gmail.com"
    Given I have written my username "oer756qwr"
    Given I have written my password "Geedi@13"
    Given I have written my checkbox "checkbox"
    When  I click the SingUp button
    Then the following error message is displayed "Another user with this username already exists. Maybe it's your evil twin. Spooky."


  Scenario:  Add account
    Given I have written my email "osman123@gmail.com"
    Given I have written my username "longname"
    Given I have written my password "Geedi123_2"
    Given I have written my checkbox "checkbox"
    When  I click the SingUp button
    Then the following error message is displayed "Enter a value less than 100 characters long."

  Scenario:  Add account
    Given I have written my email "whoops! email missing"
    Given I have written my username "osman2456477868979834233"
    Given I have written my password "Geedi234_2"
    Given I have written my checkbox "checkbox"
    When  I click the SingUp button
    Then the following error message is displayed "Please enter a value."