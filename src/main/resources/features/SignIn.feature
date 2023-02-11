Feature:Login Functionality

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
