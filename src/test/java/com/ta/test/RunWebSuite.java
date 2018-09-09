package com.ta.test;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/webFeatures",plugin = {"pretty", "com.epam.reportportal.cucumber.ScenarioReporter"},glue = "com.ta.test")
public class RunWebSuite {
}
