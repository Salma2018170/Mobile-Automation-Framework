package runner;

import basics.TestBase;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/features/AddCoupon.feature",glue = "steps"
,plugin = {"pretty","html:target/reports/report.html"})
public class TestRunner extends TestBase {
}
