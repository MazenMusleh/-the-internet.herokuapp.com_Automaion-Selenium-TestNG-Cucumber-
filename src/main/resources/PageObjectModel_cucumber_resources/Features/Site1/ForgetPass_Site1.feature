Feature: forget password functionality
  @runtest
  Scenario: user could change pass while forget it
  //  (Given)for prerequisite - (When)for Actions - (Then)for assertion
    Given user navigate to HomePage
    When user click on forget pass link
    And user type its email
    And user click on forget pass Button
    Then user changed Forget pass successfully