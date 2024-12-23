package Runner;



import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "./src/test/java/Features",
            glue = {"StepDefinition"},
            plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json"}, // Output formats
            monochrome = true,
            tags = "@cartValidation"
    )
    public class TestRunner {
    }

