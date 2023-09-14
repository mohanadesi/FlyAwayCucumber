Feature: FlyAway Booking Process

  Scenario: User logs in
    Given the user is on the Login page
    When they enter valid credentials
    Then they should be successfully logged in

  Scenario: Searching for Flights
    Given the user is on the Search Flight page
    When they enter "Bangalore" as the source and "Chennai" as the destination
    Then they should see the Book Flight link
    And they should extract and store the ID value from the Book Flight link
    
  Scenario: User books a flight
    Given the user is on the Book Flight page
    When they select a flight
    Then they should see flight details

  Scenario: User confirms booking
    Given the user is on the Confirm Booking page
    When they click on the "Click to complete booking" link
    Then they should see a confirmation message
    And they should see the text after booking
