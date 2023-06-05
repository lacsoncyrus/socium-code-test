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
	By By_filterTable = By.id("GridFrow2");
	
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
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By_FullPage));
		    js.executeScript("window.scrollBy(0,1000)", "");
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By_filterTable));
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean setPersonName(String name)
	{
		try {
			driver.findElement(By_inputPersonName).sendKeys(name,Keys.ENTER);
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean clickFoodDropdown()
	{
		try {
			driver.findElement(By_dropdownFood).click();
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean setFood(String food)
	{
		try {
			driver.findElement(By_inputFood).sendKeys(food,Keys.ENTER);
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean setPrice(Integer price)
	{
		try {
			driver.findElement(By_inputPrice).sendKeys(price.toString(),Keys.ENTER);
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean setDate(String date)
	{
		try {
			driver.findElement(By_inputDate).sendKeys(date,Keys.ENTER);
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean clickCountryDropdown()
	{
		try {
			driver.findElement(By_dropdownCountry).click();
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean selectCountryOption(String country)
	{
		try {
			By optionCountry = By.xpath("//*[@id=\"GridFrow2fltCountry-dropmenu\"]/div[2]/ul/li[contains(text(), \""+country+"\")]");
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(optionCountry)).click();
			} catch(StaleElementReferenceException exception)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(optionCountry)).click();
			}
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean setMeals(String meal1, String meal2, String meal3)
	{
		try {
			driver.findElement(By_inputMeals).sendKeys(meal1,Keys.ENTER,meal2,Keys.ENTER,meal3,Keys.ENTER);
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean clickChefDropdown()
	{
		try {
			driver.findElement(By_dropdownChef).click();
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public boolean selectChefOption(String chefName)
	{
		try {
			By optionChef = By.xpath("//*[@id=\"GridFrow2fltChef-dropmenu\"]/div[2]/ul/li[contains(text(), \""+chefName+"\")]");
			
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(optionChef)).click();
			} catch(StaleElementReferenceException exception)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(optionChef)).click();
			}
			boolReturn = true;
			
		} catch (NoSuchElementException e) {

			boolReturn = false;
		}
		
		return boolReturn;
	}
	
	public String getReturnedName(String name)
	{
		String returnedName = "";
		try {
			returnedName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"GridFrow2\"]/div[3]/div[2]/div/table/tbody/tr/td[contains(text(), \""+name+"\")]"))).getText();
			
		} catch (NoSuchElementException e) {

			returnedName = null;
		}
		
		return returnedName;
	}
	
	public String getReturnedData()
	{
		String returnedData = "";
		try {
			
			returnedData = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, \"o-gempt\")]"))).getText();
			
		} catch (NoSuchElementException e) {

			returnedData = null;
		}
		
		return returnedData;
	}

}
