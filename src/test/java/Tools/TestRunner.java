package Tools;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/resources/Features",glue= {"StepDefinitions"}
					, monochrome = false
					, plugin = { "pretty", "html:target/code-test-report.html" }
                    , tags = "@PositiveTest or @NegativeTest"
				)
public class TestRunner extends AbstractTestNGCucumberTests {


}



