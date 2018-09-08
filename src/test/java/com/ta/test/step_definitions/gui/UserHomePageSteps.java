package com.ta.test.step_definitions.gui;


import com.ta.test.page_objects.gui.LandingPage;
import com.ta.test.page_objects.gui.UserHomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class UserHomePageSteps {

    private UserHomePage userHomePage;

    public UserHomePageSteps(UserHomePage userHomePage) {
        this.userHomePage = userHomePage;
    }

    @Then("^user is able to see the navigation bar and logo$")
    public void userIsAbleToSeeTheNavigationBarAndLogo() throws Throwable {
        assertThat(userHomePage.isImgLogoDisplayed());
    }


    @And("^user is also able to see the drop down button with his/her \"([^\"]*)\"$")
    public void userIsAlsoAbleToSeeTheDropDownButtonWithHisHer(String initials) throws Throwable {
        assertThat(userHomePage.getMnuHeaderDPInitials()).isEqualToIgnoringCase(initials);
    }

    @Then("^user logs out$")
    public void userLogsOut() throws Throwable {
        assertThat(userHomePage.logOut());
    }

    @Then("^user is able to login successfully$")
    public void userIsAbleToLoginSuccessfully() throws Throwable {
        assertThat(userHomePage.getMsgToastSuccessText()).isEqualToIgnoringCase("Login successful");
    }
}
