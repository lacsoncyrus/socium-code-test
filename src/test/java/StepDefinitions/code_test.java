package StepDefinitions;



import org.junit.Assert;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Page.code_page;
import Tools.SeleniumGenericFunctions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class code_test {
	
	private  WebDriver driver = null;
	Scenario scn = null;
	TakesScreenshot screenshot = null;
	
	SeleniumGenericFunctions genericFunctions = new SeleniumGenericFunctions();
	code_page codePage = null;
	
	@Before
	public void setUpTest(Scenario s)
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		screenshot = (TakesScreenshot)driver;
		this.scn = s;
		codePage = new code_page(driver);
		
	}

	//Given
	@Given("that the user navigates to {string}")
	public void that_the_user_navigates_to(String url) {
		Assert.assertEquals(true,codePage.verifyPageCanBeNavigated(url));
	    genericFunctions.saveScreenShot(screenshot, scn, "Access the link "+url+" and navigated to the table");
	}
	
	//When
	@When("user inputs {string} as the person's name")
	public void user_inputs_as_the_person_s_name(String name) {
		Assert.assertEquals(true,codePage.setPersonName(name));
	    genericFunctions.saveScreenShot(screenshot, scn, "input the name of the person: "+name);
		
	}
	
	//And
	@And("user chooses the option {string} as the food")
	public void user_inputs_as_the_food(String food) {
		Assert.assertEquals(true,codePage.clickFoodDropdown());
		Assert.assertEquals(true,codePage.setFood(food));
	    genericFunctions.saveScreenShot(screenshot, scn, "input the food: "+food);
	}
	
	@And("user inputs {int} as the price")
	public void user_inputs_as_the_price(Integer price) {
		Assert.assertEquals(true,codePage.setPrice(price));
	    genericFunctions.saveScreenShot(screenshot, scn, "input the price: "+price);
	}
	
	@And("user inputs {string} on the date")
	public void user_inputs_on_the_date(String date) {
		Assert.assertEquals(true,codePage.setDate(date));
	    genericFunctions.saveScreenShot(screenshot, scn, "input the date: "+date);
	}
	
	@And("user chooses the option {string} as the country")
	public void user_selects_as_the_country(String country) {
		Assert.assertEquals(true,codePage.clickCountryDropdown());
		Assert.assertEquals(true,codePage.selectCountryOption(country));
	    genericFunctions.saveScreenShot(screenshot, scn, "input the country: "+country);
	}
	@And("user inputs {string}, {string}, and {string} as the  meals")
	public void user_inputs_and_as_the_meals(String meal1, String meal2, String meal3) {
		Assert.assertEquals(true,codePage.setMeals(meal1, meal2, meal3));
	    genericFunctions.saveScreenShot(screenshot, scn, "input the meals: "+meal1+", "+meal2+", "+meal3);
	}
	
	@And("user chooses the option {string} as the chef")
	public void user_selects_as_the_chef(String chefName) {
		Assert.assertEquals(true,codePage.clickChefDropdown());
		Assert.assertEquals(true,codePage.selectChefOption(chefName));
	    genericFunctions.saveScreenShot(screenshot, scn, "input the chef: "+chefName);

	}
	
	//Then
	@Then("the data of {string} should be returned")
	public void the_data_of_should_be_returned(String name) {
		Assert.assertEquals(name,codePage.getReturnedName(name));
	    genericFunctions.saveScreenShot(screenshot, scn, "the data that is returned is for: "+name);
	}
	
	@Then("a {string} result should be displayed")
	public void a_no_records_found_result_should_be_displayed(String result) {
		Assert.assertEquals(result,codePage.getReturnedData());
	    genericFunctions.saveScreenShot(screenshot, scn, result+" is displayed");
	}
	
	@After
	public void tearDownTest(Scenario s)
	{
		driver.close();
		driver.quit();
	}


}
