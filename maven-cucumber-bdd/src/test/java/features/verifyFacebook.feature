Feature: Facebook login page

  @displayed
  Scenario: Verify login page
    Given Open facebook application
    Then Verify email textbox is displayed
    And Verify password textbox is displayed
    And Close application