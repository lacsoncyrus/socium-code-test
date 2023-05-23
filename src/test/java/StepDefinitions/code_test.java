package StepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	private  WebDriverWait wait = null;
	JavascriptExecutor js = null;
	Scenario scn = null;
	TakesScreenshot screenshot = null;
	
	SeleniumGenericFunctions genericFunctions = new SeleniumGenericFunctions();

	By By_FullPage = By.id("demoPage");
	By By_inputPersonName = By.id("GridFrow2fltPerson-awed");
	By By_dropdownFood = By.id("GridFrow2fltFood-awed");
	By By_inputFood = By.xpath("//*[@id=\"GridFrow2fltFood-dropmenu\"]/div[1]/input");
	By By_inputPrice = By.id("GridFrow2fltPrice-awed");
	By By_inputDate = By.id("GridFrow2fltDate");
	By By_dropdownCountry = By.id("GridFrow2fltCountry-awed");
	By By_inputMeals = By.id("GridFrow2fltMeals-awed");
	By By_dropdownChef = By.id("GridFrow2fltChef-awed");
	
	@Before
	public void setUpTest(Scenario s)
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
		screenshot = (TakesScreenshot)driver;
		this.scn = s;
		
	}

	//Given
	@Given("that the user navigates to {string}")
	public void that_the_user_navigates_to(String url) {
	    driver.get(url);
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By_FullPage)));
	    js.executeScript("window.scrollBy(0,1000)", "");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    genericFunctions.saveScreenShot(screenshot, scn, "Access the link "+url+" and navigated to the table");
	}
	
	//When
	@When("user inputs {string} as the person's name")
	public void user_inputs_as_the_person_s_name(String name) {
		driver.findElement(By_inputPersonName).sendKeys(name,Keys.ENTER);
	    genericFunctions.saveScreenShot(screenshot, scn, "input the name of the person: "+name);
		
	}
	
	//And
	@And("user chooses the option {string} as the food")
	public void user_inputs_as_the_food(String food) {
		driver.findElement(By_dropdownFood).click();
		driver.findElement(By_inputFood).sendKeys(food,Keys.ENTER);
	    genericFunctions.saveScreenShot(screenshot, scn, "input the food: "+food);
	}
	
	@And("user inputs {int} as the price")
	public void user_inputs_as_the_price(Integer price) {
		driver.findElement(By_inputPrice).sendKeys(price.toString(),Keys.ENTER);
	    genericFunctions.saveScreenShot(screenshot, scn, "input the price: "+price);
	}
	
	@And("user inputs {string} on the date")
	public void user_inputs_on_the_date(String date) {
		driver.findElement(By_inputDate).sendKeys(date,Keys.ENTER);
	    genericFunctions.saveScreenShot(screenshot, scn, "input the date: "+date);
	}
	
	@And("user chooses the option {string} as the country")
	public void user_selects_as_the_country(String country) {
		By optionCountry = By.xpath("//*[@id=\"GridFrow2fltCountry-dropmenu\"]/div[2]/ul/li[contains(text(), \""+country+"\")]");
		driver.findElement(By_dropdownCountry).click();
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(optionCountry)).click();
		} catch(StaleElementReferenceException exception)
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(optionCountry)).click();
		}
	    genericFunctions.saveScreenShot(screenshot, scn, "input the country: "+country);
	}
	@And("user inputs {string}, {string}, and {string} as the  meals")
	public void user_inputs_and_as_the_meals(String meal1, String meal2, String meal3) {
		driver.findElement(By_inputMeals).sendKeys(meal1,Keys.ENTER,meal2,Keys.ENTER,meal3,Keys.ENTER);
	    genericFunctions.saveScreenShot(screenshot, scn, "input the meals: "+meal1+", "+meal2+", "+meal3);
	}
	
	@And("user chooses the option {string} as the chef")
	public void user_selects_as_the_chef(String chefName) {
		By optionChef = By.xpath("//*[@id=\"GridFrow2fltChef-dropmenu\"]/div[2]/ul/li[contains(text(), \""+chefName+"\")]");
		driver.findElement(By_dropdownChef).click();
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(optionChef)).click();
		} catch(StaleElementReferenceException exception)
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(optionChef)).click();
		}
	    genericFunctions.saveScreenShot(screenshot, scn, "input the chef: "+chefName);

	}
	
	//Then
	@Then("the data of {string} should be returned")
	public void the_data_of_should_be_returned(String name) {
		Assert.assertEquals(name, driver.findElement(By.xpath("//*[@id=\"GridFrow2\"]/div[3]/div[2]/div/table/tbody/tr/td[contains(text(), \""+name+"\")]")).getText());
	    genericFunctions.saveScreenShot(screenshot, scn, "the data that is returned is for: "+name);
	}
	
	@Then("a {string} result should be displayed")
	public void a_no_records_found_result_should_be_displayed(String result) {
		Assert.assertEquals(result, driver.findElement(By.xpath("//div[contains(@class, \"o-gempt\")]")).getText());
	    genericFunctions.saveScreenShot(screenshot, scn, result+" is displayed");
	}
	
	@After
	public void tearDownTest(Scenario s)
	{
		driver.close();
		driver.quit();
	}


}
