@smoke
Feature: New User Registration

  Scenario: user could create new account with valid data
    Given click on register button
    When  user select gender
    And   user enter firstname "automation"
    And   user enter lastname "tester"
    And   user select day of birth
    And   user select month of birth
    And   user select year of birth
    And   user enter email "test1@example.com"
    And   user enter company name "automation"
    And   user unselect checkbox newsletter
    And   user enter password "P@ssw0rd"
    And   user enter confirm password "P@ssw0rd"
    And   user clicks on register button
    Then  verify account is created successfully