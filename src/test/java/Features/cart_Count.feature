Feature:Abcd


  @cartValidation
Scenario Outline:dcbdj
  Given User opens browser and load eBAY application
  Then  User seraches for "<item>"
  And   User clicks on the first item in the list
  When  User clicks on Add to cart
  Then  User verifies the cart has been updated with appropriate number of items added

  Examples:
    | item |
    | book |