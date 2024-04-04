@site2
Feature: here will be the senarios forgotPassword
  Background:
    Given navigate to the site .
    And click on Signin button .
    And click on forgot password

  Scenario: forgot Password valid senario
    When enter the valid email address
    And click on RetriveButton
    Then valid Alert

  Scenario: forgot Password Invalid senario
    When enter the INvalid email address
    And click on RetriveButton
    Then Invalid Alert