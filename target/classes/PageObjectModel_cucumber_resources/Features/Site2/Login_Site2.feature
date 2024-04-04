@site2
Feature: here will be the senarios of sign in valid and invalid
  Background:
    Given navigate to the site
    And click on Signin button

  Scenario: Valid Sign in
    When insert valid Email Address
    And insert valid password
    And click on Sign in buttonn
    Then Sign Up successfull must appeaer my account


  Scenario: InValid Sign in
    When insert Invalid Email Address
    And insert Invalid password
    And click on Sign in buttonn
    Then Sign in alart must appeaer