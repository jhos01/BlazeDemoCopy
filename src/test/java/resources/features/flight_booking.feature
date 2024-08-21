Feature: Flight booking on BlazeDemo

  Scenario: Complete the purchase of a flight
    Given the user is on the BlazeDemo homepage
    When they select "Boston" as the departure city
    And they select "London" as the destination city
    And they search for flights
    Then they should see the flight results page
    When they select the cheapest available flight
    And they enter the purchase information
    Then they should see a purchase confirmation with a success message
    And they should see a booking ID
