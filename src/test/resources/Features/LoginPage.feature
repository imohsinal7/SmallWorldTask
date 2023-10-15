Feature: Log Page SwagLabs, I want to test the Login Page functionality

  @ValidCredentails @LoginSuccessful
  Scenario Outline: As a user i want to test valid credentials
    Given User has arrived on SwagLabs website
    When Input username through "<userName>" and password through "<password>"
    Then Verify the Success login through displaying cart button at home Page
    Examples:
      | userName          | password     |
      | standard_user     | secret_sauce |

  @InvalidCredentails
  Scenario Outline: Failed login using invalid account
    Given User has arrived on SwagLabs website
    When Input username through "<userName>" and password through "<password>"
    Then Verify the Login failed with displaying error message
    Examples:
      | userName          | password |
      | standard          | 123456   |
      | locked_out_user   |          |
      | problem_user      |          |
      | performance_glitch_user |    |
      | error_user   |          |
      |   | 1234qw   |
      | mohsin@gmail.com |          |