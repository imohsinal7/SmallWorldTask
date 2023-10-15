Feature: As a user, I want to test valid and Invalid login scenario

  @ValidCase @LoginSuccessful
  Scenario Outline: Successful login using valid account
    Given User has arrived on Swag Labs website
    When Submit email using "<userName>" and password using "<password>"
    Then Success login to home page with displaying cart button
    Examples:
      | userName          | password     |
      | standard_user     | secret_sauce |

  @InvalidCase @LoginFailed
  Scenario Outline: Failed login using invalid account
    Given User has arrived on Swag Labs website
    When Submit email using "<userName>" and password using "<password>"
    Then Login failed with displaying error message
    Examples:
      | userName          | password |
      | standard          | 123456   |
      |                   | 1234qw   |
      | akutest@email.com |          |