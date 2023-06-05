package Tools;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/resources/Features",glue= {"StepDefinitions"}
					, monochrome = false
					, plugin = { "pretty", "html:target/code-test-report.html" }
                    , tags = ""
				)
public class TestRunner extends AbstractTestNGCucumberTests {

	@DataProvider(parallel = false)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
	@BeforeTest
	@Parameters({"browser"})
	public void defineBrowser(@Optional("chrome") String browser) throws Throwable{
		ConfigReader.setBrowserType(browser);
	}

}



