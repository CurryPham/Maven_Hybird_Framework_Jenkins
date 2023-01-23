@login
Feature: Facebook login page

  @no_param
  Scenario: Scenario have no parameters
    Given Open facebook application
    When Input to Username Textbox
    And Input to Password Textbox
    And Click to Submit button
    And Close application

  @param_mark
  Scenario: Scenario have parameters
    Given Open facebook application
    When Input to Username Textbox with "automationtest@gmail.com"
    And Input to Password Textbox with "@123"
    And Click to Submit button
    And Close application

  @no_param_mark
  Scenario: Scenario have parameters
    Given Open facebook application
    When Input to Username Textbox with automationtest@gmail.com
    And Input to Password Textbox with @123
    And Click to Submit button
    And Close application

  @multiple_param
  Scenario: Scenario have parameters
    Given Open facebook application
    When Input to Username Textbox with "automationtest@gmail.com" and Password with "@123"
    And Click to Submit button
    And Close application

  @table_step
  Scenario Outline: Scenario have parameters
    Given Open facebook application
    When Input to Username and Password
      | Username   | Password   | Address   | Phone   |
      | <Username> | <Password> | <Address> | <Phone> |
    And Click to Submit button
    When Input to Username and Password
      | Username   | Password   | Address   | City   |
      | <Username> | <Password> | <Address> | <City> |
    And Close application

    Examples:
      | Username | Password | Address | Phone  | City   |  |
      | Curry    | @1234    | 269     | 434334 | Ha Noi |  |



