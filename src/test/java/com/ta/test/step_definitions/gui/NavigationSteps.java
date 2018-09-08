package com.ta.test.step_definitions.gui;


import com.ta.test.framework.helpers.UrlBuilder;
import cucumber.api.java.en.Given;

public class NavigationSteps {

    @Given("^user launches hire alchemy portal$")
    public void userLaunchesHireAlchemyPortal() throws Throwable {
        UrlBuilder.startAtHomePage();
    }


}