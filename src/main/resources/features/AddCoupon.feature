Feature:Coupon Functionality
  @End2End
  Scenario:Add valid Coupon
    Given User go to login screen
    When User fill email as "salmamoo504@gmail.com" and Password as "11338899Hamed#" and click on Sign in button
    And User Search for item And Add item to cart
    And Add Valid coupon "Salma20"
    Then Coupon added successfully
