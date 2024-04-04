package PageObjectModel_cucumber_tests.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = "src/main/resources/PageObjectModel_cucumber_resources/Features",
        glue = "PageObjectModel_cucumber_tests.stepDefinitions",
        tags = "@site2",
        plugin = {
                "pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cukes.xml",
                "rerun:target/rerun.txt"
        }

)


public class runners1 extends AbstractTestNGCucumberTests {
}
