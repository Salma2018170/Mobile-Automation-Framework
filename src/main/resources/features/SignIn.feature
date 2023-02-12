Feature:Login Functionality

  @SmokeTests
  Scenario:User login with valid data
    Given User go to login screen
    When User fill email as "salmamoo504@gmail.com" and Password as "11338899Hamed#" and click on Sign in button
    Then open account

  Scenario Outline:User Login with invalid data
    Given User allow their location
    And go to sign in screen
    When User fill "<email>" and "<password>" and click on sign in button
    Then error message
   Examples:
   |email|password|
   |salma@gmail.com|12432wrong|
   |salmawrong@gmail.com|11338899Hamed#|
   |salmawrong@gmail.com|12432wrong|

