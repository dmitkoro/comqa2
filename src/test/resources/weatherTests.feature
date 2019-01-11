Feature: Weather tests
  Scenario: Coordinates check
    Given city name: London,uk
    When we are requesting weather info
    Then lon is: -0.13
    And lat is: 51.51

  Scenario: Weather check
    Given city name: London,uk
    When we are requesting weather info
    Then weather_id is: 300 and main is Drizzle and description is light intensity drizzle and icon is 09d

  Scenario: Base check
    Given city name: London,uk
    When we are requesting weather info
    Then base is: stations

  Scenario: Main check
    Given city name: London,uk
    When we are requesting weather info
    Then temp is: 280.32
    And pressure is: 1012
    And humidity is: 81
    And temp_min is: 279.15
    And temp_max is: 281.15

  Scenario: Visibility check
    Given city name: London,uk
    When we are requesting weather info
    Then visibility is: 10000

  Scenario: Wind check
    Given city name: London,uk
    When we are requesting weather info
    Then speed is: 4.1
    And deg is: 80

  Scenario: Clouds check
    Given city name: London,uk
    When we are requesting weather info
    Then all is: 90

  Scenario: Dt check
    Given city name: London,uk
    When we are requesting weather info
    Then dt is: 1485789600

  Scenario: Sys check
    Given city name: London,uk
    When we are requesting weather info
    Then type is: 1
    Then sys_id is: 5091
    Then message is: 0.0103
    Then country is: GB
    Then sunrise is: 1485762037
    Then sunset is: 1485794875

  Scenario: Id check
    Given city name: London,uk
    When we are requesting weather info
    Then id is: 2643743

  Scenario: Name check
    Given city name: London,uk
    When we are requesting weather info
    Then name is: London

  Scenario: Cod check
    Given city name: London,uk
    When we are requesting weather info
    Then cod is: 200