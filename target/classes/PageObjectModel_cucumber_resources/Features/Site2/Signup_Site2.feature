@site2
Feature: Site2 Signup functionality

  Scenario: user could signup on site 2
  //  (Given)for prerequisite - (When)for Actions - (Then)for assertion
    Given user navigate to HOMEPAGE
    And user click on sign in button
    And user type his email
    When user click on create an account button Button
    And  user insert personal data.
    And user insert address data
    And user click on register button
    Then user signed up successfully

  Scenario: user could not signup on site 2 by invalid address data
  //  (Given)for prerequisite - (When)for Actions - (Then)for assertion
    Given user navigate to HOMEPAGE
    And user click on sign in button
    And user type his Email
    When user click on create an account button Button
    And  user insert personal data.
    And user insert invalid address data
    And user click on register button
    Then user could not signed up to the site