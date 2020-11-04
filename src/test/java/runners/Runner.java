package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber_reports"},
        //features = "src/test/resources/features",
        features = "src/test/resources/features/start.feature",
        //if have more tags, separate with comma
        //{"@InProgress, @Ready"}
        glue = "steps",
        //dryRun = true,
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {
}
