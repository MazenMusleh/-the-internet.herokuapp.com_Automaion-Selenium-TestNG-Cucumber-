
Feature: login functionality

Background:
  Given user navigate to homePage


  @runtest
  Scenario: user could login with valid data (happy case)
    //  (Given)for prerequisite - (When)for Actions - (Then)for assertion
    When user enter valid username and password
    And user click on login button
    Then user logged in successfully

  Scenario: user couldn't login with invalid username
  //  (Given)for prerequisite - (When)for Actions - (Then)for assertion
    When user enter invalid username and valid password
    And user click on login button
    Then user cant log in successfully
  @runtest
  Scenario: user couldn't login with invalid password
  //  (Given)for prerequisite - (When)for Actions - (Then)for assertion
    When user enter valid username and invalid password
    And user click on login button
    Then user cant log in successfully

  Scenario: user couldn't login with invalid username and invalid password
  //  (Given)for prerequisite - (When)for Actions - (Then)for assertion
    When user enter invalid username and invalid password
    And user click on login button
    Then user cant log in successfully