package stedefination;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\Administrator\\IdeaProjects\\Weekendmaven1230\\src\\test\\resources\\featurefile\\Login.feature", // Path to feature files
        glue = {"stedefination"},                // Package name for step definitions
        plugin = {"pretty", "html:target/login-reports.html"}, // Reporting options
        monochrome = true                       // Makes console output more readable
                               // Runs only scenarios with this tag
)
public class Testrunner {


}
