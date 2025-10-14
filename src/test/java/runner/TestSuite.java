package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "driver"},
        plugin = {"html:target/cucumber-reports/report.html"},
        snippets = CAMELCASE
)
public class TestSuite extends AbstractTestNGCucumberTests {
    @Override @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}