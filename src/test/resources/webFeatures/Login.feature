@gui
Feature: Login:- A user should be logged in only if he/she provides correct credentials and valid error messages should be displayed wherever required

  Scenario Outline: Check all negative login scenarios
    Given user launches hire alchemy portal
    And the landing page is displayed with brand name "Hirealchemy"
    When user enters user name "<username>"
    And user enters password "<password>"
    When user clicks on sign in button
    Then proper validation message "<validationMessage>" is displayed when "<condition>"
    Examples:
      | username                | password    | validationMessage   | condition                                         |
      |                         | welcome@123 | Field is Required   | email field is empty                              |
      | abcuser@edgenetworks.in |             | Field is Required   | password field is empty                           |
      |                         |             | Field is Required   | both email and password fields are empty          |
      | abcuser                 | welcome@123 | Invalid email       | email entered has only normal characters          |
      | abcuser@                | welcome@123 | Invalid email       | email entered has no domain name                  |
      | abcuser@edgenetworks    | welcome@123 | Email seems invalid | email entered doesn't have domain type identifier |
      | abcuser@gmail.in        | welcome@123 | Username not found. | user enters non-existing email address            |
      | abcuser@edgenetworks.in | abc123      | Invalid password    | user enters incorrect password                    |

  Scenario Outline: Check if a user with correct credentials is able to log in
    Given user launches hire alchemy portal
    And the landing page is displayed with brand name "Hirealchemy"
    When user enters user name "<username>"
    And user enters password "<password>"
    When user clicks on sign in button
    Then user is able to see the navigation bar and logo
    And user is also able to see the drop down button with his/her "<initials>"
    Then user logs out
    Examples:
      | username                  | password    | initials |
      | abcuser@edgenetworks.in   | welcome@123 | a       |
      | krishna.k@edgenetworks.in | welcome@123 | k       |




