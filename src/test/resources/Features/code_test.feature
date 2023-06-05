Feature: To perform test challenge using the demo website provided by Socium

@PositiveTest
  Scenario: Retrieve a specific entry from the dynamic web table
    Given that the user navigates to "https://demo.aspnetawesome.com/"
    When user inputs "Pedro" as the person's name
    And user chooses the option "Apple" as the food
    And user inputs 23 as the price
    And user inputs "11/3/2016" on the date
    And user chooses the option "Stone Cutter" as the country
    And user inputs "Wheat", "Buckwheat", and "Cauliflower" as the  meals
    And user chooses the option "Peter Gibbons" as the chef
    Then the data of "Pedro" should be returned

@NegativeTest
  Scenario: Retrieve a non existing entry from the dynamic web table
    Given that the user navigates to "https://demo.aspnetawesome.com/"
    When user inputs "Claudia" as the person's name
    And user chooses the option "Cheesecake" as the food
    Then a "no records found" result should be displayed
