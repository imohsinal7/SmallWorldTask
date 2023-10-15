Feature: As a user, I want to test checkout order

  @ValidCase @CheckOutSuccessful
  Scenario Outline: Successful order checkout test
    Given User has arrived on Swag Labs website
    When Submit email using "<userName>" and password using "<password>"
    And Success login to home page with displaying cart button
    And Add Sauce Labs Backpack into cart
    And Add Sauce Labs Bike Light into cart
    And I am clicking on cart Button
    And I am clicking on Check Out Button
    And I send First Name "<FirstName>" on information page
    And I send Last Name "<LastName>" on information page
    And I send Postal Code "<PostalCode>" on information page
    And I am clicking on Continue Button on information page
    Then Verify Checkout Overview page
    And Success Check out page with message displayed "<Success_Message>"
    Examples:
      | userName          | password     | FirstName | LastName | PostalCode | Success_Message                                                                         |
      | standard_user     | secret_sauce | Test      | TestTest | 12345      | Your order has been dispatched, and will arrive just as fast as the pony can get there! |
