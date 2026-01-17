Feature: Demo tutorial

  Scenario: validate login functionality with valid data
    Given user is at loginpage
    When Enter the username and password
    And click on the login button
    Then user logged to the application
    And profile picture should display