package testpackage;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
    features = "src/test/resources/RegisterUser.feature", // Path to your feature files
    glue = "steps" // Package where your step definitions are located
)

public class CucumberTestNGRunner extends AbstractTestNGCucumberTests {
}
