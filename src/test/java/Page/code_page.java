package Page;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class code_page {
	
	WebDriver driver = null;
	WebDriverWait wait = null;
	JavascriptExecutor js = null;

	By By_FullPage = By.id("demoPage");
	By By_inputPersonName = By.id("GridFrow2fltPerson-awed");
	By By_dropdownFood = By.id("GridFrow2fltFood-awed");
	By By_inputFood = By.xpath("//*[@id=\"GridFrow2fltFood-dropmenu\"]/div[1]/input");
	By By_inputPrice = By.id("GridFrow2fltPrice-awed");
	By By_inputDate = By.id("GridFrow2fltDate");
	By By_dropdownCountry = By.id("GridFrow2fltCountry-awed");
	By By_inputMeals = By.id("GridFrow2fltMeals-awed");
	By By_dropdownChef = By.id("GridFrow2fltChef-awed");
	
	private boolean boolReturn = false;
	
	public code_page(WebDriver drv)
	{
		this.driver = drv;
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public boolean verifyPageCanBeNavigated(String url)
	{
		try {
		    driver.get(url);
		    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By_FullPage)));
		    js.executeScript("window.scrollBy(0,1000)", "");
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean verifyPersonNameIsInputted(String name)
	{
		try {
			driver.findElement(By_inputPersonName).sendKeys(name,Keys.ENTER);
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean verifyFoodDropdownIsClickable()
	{
		try {
			driver.findElement(By_dropdownFood).click();
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean verifyFoodIsInputted(String food)
	{
		try {
			driver.findElement(By_inputFood).sendKeys(food,Keys.ENTER);
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean verifyPriceIsInputted(Integer price)
	{
		try {
			driver.findElement(By_inputPrice).sendKeys(price.toString(),Keys.ENTER);
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean verifyDateIsInputted(String date)
	{
		try {
			driver.findElement(By_inputDate).sendKeys(date,Keys.ENTER);
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean verifyCountryDropdownIsClicked()
	{
		try {
			driver.findElement(By_dropdownCountry).click();
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean verifyCountryOptionIsChosen(String country)
	{
		try {
			By optionCountry = By.xpath("//*[@id=\"GridFrow2fltCountry-dropmenu\"]/div[2]/ul/li[contains(text(), \""+country+"\")]");
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(optionCountry)).click();
			} catch(StaleElementReferenceException exception)
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(optionCountry)).click();
			}
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean verifyMealsAreInputted(String meal1, String meal2, String meal3)
	{
		try {
			driver.findElement(By_inputMeals).sendKeys(meal1,Keys.ENTER,meal2,Keys.ENTER,meal3,Keys.ENTER);
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean verifyChefDropdownIsClicked()
	{
		try {
			driver.findElement(By_dropdownChef).click();
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean verifyChefOptionIsChosen(String chefName)
	{
		try {
			By optionChef = By.xpath("//*[@id=\"GridFrow2fltChef-dropmenu\"]/div[2]/ul/li[contains(text(), \""+chefName+"\")]");
			
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(optionChef)).click();
			} catch(StaleElementReferenceException exception)
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(optionChef)).click();
			}
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean verifyReturnedNameMatchesExpectedResult(String name)
	{
		try {
			Assert.assertEquals(name, driver.findElement(By.xpath("//*[@id=\"GridFrow2\"]/div[3]/div[2]/div/table/tbody/tr/td[contains(text(), \""+name+"\")]")).getText());
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean verifyReturnedDataIsEmpty(String data)
	{
		try {
			Assert.assertEquals(data, driver.findElement(By.xpath("//div[contains(@class, \"o-gempt\")]")).getText());
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}

}
