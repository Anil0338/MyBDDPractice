package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags= "@smokeTest",
features = "src/main/resources/com/feature/Login.feature",
glue = {"StepDef"},
plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class testRunner extends AbstractTestNGCucumberTests{

}
