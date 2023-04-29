@smoke
Feature: users could use login functionality to use their accounts

  Scenario: user could login with valid email and password

    Given   user go to login page
    When    user login with "valid" "test1@example.com" and "P@ssw0rd"
    And     user clicks on login button
    Then    verify that user logged in successfully
    And     getCurrentUrl and verify it

  Scenario: user could login with invalid email and password

    Given   user go to login page
    When    user login with "invalid" "wrong@example.com" and "P@ssw0rd"
    And     user clicks on login button
    Then    verify that user didn't logged in successfully
    And     verify the color of this message is red