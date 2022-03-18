Feature: Testing the Deque

  @functional
  Scenario: Check the basic flow
    Then Ensure the main-nav (CSS selector) has been loaded
    And Ensure the number of radio buttons under “Let the Adventure Begin” is 5
    And Ensure that clicking “add a traveler” adds another select to the page
    And Ensure that when clicking the arrows under the video, the heading changes


