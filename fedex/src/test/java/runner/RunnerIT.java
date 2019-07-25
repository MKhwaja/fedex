package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(glue = "stepdef", features = "src/test/resources/features/"/* , tags="@2" */ )
public class RunnerIT extends AbstractTestNGCucumberParallelTests {

}
