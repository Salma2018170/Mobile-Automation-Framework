package runner;

import basics.TestBase;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/features",glue = "steps",tags = "@SmokeTests"
,plugin = {"pretty","html:target/reports/report.html","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class TestRunner extends TestBase {
}
