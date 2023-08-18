package AppiumCucumber.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Appium.feature",
        glue="AppiumCucumber/StepDef",
        dryRun = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTest.txt"},
        tags = "@appium"
)
public class Runner {


}
