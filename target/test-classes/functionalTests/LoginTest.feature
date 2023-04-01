Feature: feature to test login functionality

  Background: Given user is on login page

  Scenario: Login test with valid credential
    When user enters username<"Admin"> and password<"admin123">
    And click on login button
    Then user is navigated to the home page

  Scenario: Login test with invalid credential password
    When user enters username<"Admin"> and password<"admin123">
    And click on login button
    Then user is navigated to the home page

  Scenario: Login test with valid credential username
    When user enters username<"Admin"> and password<"admin123">
    And click on login button
    Then user is navigated to the home page
