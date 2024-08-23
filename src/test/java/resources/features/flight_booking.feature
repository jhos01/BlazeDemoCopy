Feature: Flight booking on BlazeDemo

  Scenario: Complete the purchase of a flight
    Given the user is on the BlazeDemo homepage
    When they select "Boston" as the departure city and they select "London" as the destination city
    And they search for flights
    Then they should see the flight results page
    When they select the cheapest available flight
    Then they see a message that confirms the cheapest flight was selected successfully
    When they enter the purchase information
    Then they should see a purchase confirmation with a success message
    And they should see a booking ID

  Scenario:  Complete the purchase of a flight without filling out the purchase information
    Given the user is on the BlazeDemo homepage
    When they select "Boston" as the departure city and they select "London" as the destination city
    And they search for flights
    Then they should see the flight results page
    When they select the cheapest available flight
    Then they see a message that confirms the cheapest flight was selected successfully
    And they omit entering the purchase information
    Then they should see a purchase confirmation with a success message
    And they should see a booking ID
