package com.ta.test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "src/test/resources/webFeatures", monochrome = true, plugin = {
        "pretty", "html:target/cucumber-report/runjenkins",
        "json:target/cucumber-report/runjenkins/cucumber.json",
        "rerun:target/cucumber-report/runjenkins/rerun.txt"},
        glue = "com.ta.test")
public class RunJenkinsSuite extends AbstractTestNGCucumberTests {
}
