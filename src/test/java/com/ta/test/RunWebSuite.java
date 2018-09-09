package com.ta.test;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/webFeatures",plugin = {"pretty", "com.epam.reportportal.cucumber.ScenarioReporter","json:target/cucumber-report/runwebat/cucumber.json",
        "rerun:target/cucumber-report/runwebat/rerun.txt"},glue = "com.ta.test")
public class RunWebSuite {
}
