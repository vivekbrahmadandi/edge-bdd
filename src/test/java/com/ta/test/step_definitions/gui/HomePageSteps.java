package com.ta.test.step_definitions.gui;


import com.ta.test.page_objects.gui.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps {

    private HomePage homePage;

    public HomePageSteps(HomePage homePage) {
        this.homePage = homePage;
    }


    @Given("^i click \"(.*?)\" on the Home Page$")
    public void i_click_on_the_Home_Page(String pageToNavigate) throws Throwable {
        if (pageToNavigate.equals("SIGN_IN")) {
            homePage.clickSignInLink();
        } else if (pageToNavigate.equals("SIGN_OUT")) {
            homePage.clickSignOutLink();
        }
    }


}