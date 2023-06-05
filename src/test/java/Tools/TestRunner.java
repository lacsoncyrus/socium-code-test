package Tools;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"StepDefinitions"}
					, monochrome = false
					, plugin = { "pretty", "html:target/code-test-report.html" }
                    , tags = "@PositiveTest or @NegativeTest"
				)
public class TestRunner {


}



