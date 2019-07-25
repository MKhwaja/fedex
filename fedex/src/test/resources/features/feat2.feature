Feature:


  @2 @10.4 @321637 @Tacocat @Desktop @Mobile @fixed
  Scenario: Verify User stays in From Page if their is an error existing in From Email field
    Given User:"MAGICJP" logs in to Shipping application
    Then User clicks on start shipping button
    When User clicks on FROM EDIT
    Then Verify error message for From User Email field when below values are entered
      | @. |
    When User clicks on FromSubmit button
    Then Verify Element isDisplayed
      | GoogleSearchPO.fromfieldHeader |
    And Verify whether active element in screen is matched to expected element:"GoogleSearchPO.fromfieldEmail" using attribute:"id"
    #Then User logs out from Shipping