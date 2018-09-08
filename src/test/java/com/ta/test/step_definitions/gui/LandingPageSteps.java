package com.ta.test.step_definitions.gui;




import com.ta.test.page_objects.gui.LandingPage;

import cucumber.api.java.en.And;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class LandingPageSteps {

    private LandingPage landingPage;

    public LandingPageSteps(LandingPage landingPage) {
        this.landingPage = landingPage;
    }


    @And("^the landing page is displayed with brand name \"([^\"]*)\"$")
    public void theLandingPageIsDisplayed(String brandName) throws Throwable {
        assertThat(landingPage.getBrandingPageTitleText()).isEqualToIgnoringCase(brandName);
    }

    @When("^user enters user name \"([^\"]*)\"$")
    public void userEntersUserName(String userName) throws Throwable {
        landingPage.enterUserName(userName);
    }

    @And("^user enters password \"([^\"]*)\"$")
    public void userEntersPassword(String password) throws Throwable {
        landingPage.enterPassword(password);
    }

    @When("^user clicks on sign in button$")
    public void userClicksOnSignInButton() throws Throwable {
        landingPage.clickOnSignInBtn();
    }

    @Then("^proper validation message \"([^\"]*)\" is displayed when \"([^\"]*)\"$")
    public void properValidationMessageIsDisplayed(String validationMessage, String condition) throws Throwable {
        switch (condition) {
            case "email field is empty":
                assertThat(landingPage.getMsgEmailErrorText()).isEqualToIgnoringCase(validationMessage);
                break;
            case "password field is empty":
                assertThat(landingPage.getMsgPasswordErrorText()).isEqualToIgnoringCase(validationMessage);
                break;
            case "both email and password fields are empty":
                assertThat(landingPage.getMsgEmailErrorText()).isEqualToIgnoringCase(validationMessage);
                assertThat(landingPage.getMsgPasswordErrorText()).isEqualToIgnoringCase(validationMessage);
                break;
            case "email entered has only normal characters":
                assertThat(landingPage.getMsgEmailErrorText()).isEqualToIgnoringCase(validationMessage);
                break;
            case "email entered has no domain name":
                assertThat(landingPage.getMsgEmailErrorText()).isEqualToIgnoringCase(validationMessage);
                break;
            case "email entered doesn't have domain type identifier":
                assertThat(landingPage.getMsgEmailErrorText()).isEqualToIgnoringCase(validationMessage);
                break;
            case "user enters non-existing email address":
                assertThat(landingPage.getMsgToastErrorText()).isEqualToIgnoringCase(validationMessage);
                break;
            case "user enters incorrect password":
                assertThat(landingPage.getMsgToastErrorText()).isEqualToIgnoringCase(validationMessage);
                break;
            default:
                System.out.println("Please provide the parameters");
                break;

        }

    }


}