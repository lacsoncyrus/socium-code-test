Feature: To perform test challenge using the demo website provided by Socium

Scenario: Retrieve a specific entry from the dynamic web table
    Given that the user navigates to "https://demo.aspnetawesome.com/"
    When user inputs "Earl" as the person's name
		And user chooses the option "Big Salad" as the food
		And user inputs 21 as the price
		And user inputs "1/21/2018" on the date 
		And user chooses the option "Elwynn Forest" as the country
		And user inputs "Cauliflower", "Broccoli", and "Potato" as the  meals
		And user chooses the option "Bruce Nolan" as the chef
		Then the data of "Earl" should be returned
		
Scenario: Retrieve a non existing entry from the dynamic web table
    Given that the user navigates to "https://demo.aspnetawesome.com/"
    When user inputs "Sebastian" as the person's name
		And user chooses the option "Cheesecake" as the food
		Then a "no records found" result should be displayed