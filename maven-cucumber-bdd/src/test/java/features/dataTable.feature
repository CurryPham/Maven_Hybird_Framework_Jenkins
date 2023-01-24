@dataTable
Feature: DataTable Facebook login page


  @table_step
  Scenario Outline: Login Facebook with <Username> and <Password>
    Given Open facebook application
    When Input to Username and Password
      | Username   | Password   |
      | <Username> | <Password> |
    And Click to Submit button
    And Close application

    Examples:
      | Username              | Password |
      | automation1@gmail.com | 123456   |

  Scenario Outline: Login Facebook with <Username> and <Password>
    Given Open facebook application
    When Input to Username Textbox with <Username>
    And Input to Password Textbox with <Password>
    And Click to Submit button
    And Close application

    Examples:
      | Username              | Password |
      | automation1@gmail.com | 123456   |


