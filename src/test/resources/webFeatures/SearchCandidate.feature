@gui @search
Feature: SearchCandidate:- User should be able to perform candidate search and results should be in accordance with the business rules

  Background: User is logged in
    Given user launches hire alchemy portal
    And the landing page is displayed with brand name "Hirealchemy"
    When user enters user name "abcuser@edgenetworks.in"
    And user enters password "welcome@123"
    When user clicks on sign in button
    Then user is able to login successfully


  Scenario Outline: Check if user can search through single group selection
    Given user navigates to "Resume Pool" page
    And user is on "Internal resume pool" page
    When user clicks in "Selected Resume Group(s)" field
    Then user should be able to see the list of existing groups
    And user selects the group item "<profile>"
    And user enters the search candidate "<candidateName>"
    When user clicks on candidate search button
    Then user sees the list of candidates matching with the search criteria
    And search results have the correct group id "<profile>" in it
    And user logs out
    Examples:
      | profile      | candidateName |
      | IBM profiles | krishna       |
      | IBM profiles |               |








