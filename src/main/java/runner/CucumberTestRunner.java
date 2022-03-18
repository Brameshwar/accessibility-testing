package runner;


import io.cucumber.junit.Cucumber ;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = { "com", "core"},
//        dryRun = true,
        monochrome = true,
        tags = "@accessiblity",
        plugin = {"pretty", "html:target/cucumber",
                "json:target/report/cucumber.json",
                "junit:target/report/cucumber.xml"}
)
public class CucumberTestRunner {

}
