Feature: Ticket Reservation
  Scenario: Ticket Reservation Testing
    Given departure airport RIX
    And destination airport MEL
    And user data is:
      | name          | John       |
      | surname       | Goldman    |
      | discountCode  | abcd       |
      | travelerCount | 3          |
      | children      | 1          |
      | luggage       | 4          |
      | nextFlight    | 13-05-2018 |
    And seat number is 15
    And we are on home page

    When we are selecting airports
    And we are pressing Go Go Go button
    Then registration page appears

    When we are filling registration form
    And we are pressing Get Price button
    Then our price will be 4580 euro

    When we are pressing Book button
    Then we are on page seat selecting

    When we are selecting our seat number
    And we are clicking Book button
    Then successful registration page appears

    When we are requesting registration list
    Then we can see our reservation in the list

    When we are deleting our reservation ticket
    And we are requesting registration list again
    Then we can see our reservation is not in the list