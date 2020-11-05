package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber_reports.html"},
        features = "src/test/resources/features/",
        //if have more tags, separate with comma
        //{"@InProgress, @Ready"}
        glue = "steps",
        //dryRun = true,
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerTest {
}
