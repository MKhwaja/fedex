Feature:

  @1 @10.2 @312550 @Velocity @Desktop @fixed @pass
  Scenario: Verify FROM fields
    Given User:"Magsregister" logs in to Shipping application
    Then User clicks on start shipping button
    When User clicks on FROM EDIT
    Then Verify the from section address fields
