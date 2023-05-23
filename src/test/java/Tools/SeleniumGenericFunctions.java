package Tools;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.Scenario;

public class SeleniumGenericFunctions {

	public void saveScreenShot(TakesScreenshot screenshot, Scenario scn, String description)
	{
	    byte[] capture = screenshot.getScreenshotAs(OutputType.BYTES);
	    scn.attach(capture, "image/png", description);
	}
	
}
