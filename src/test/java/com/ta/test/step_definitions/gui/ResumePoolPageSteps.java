package com.ta.test.step_definitions.gui;


import com.ta.test.page_objects.gui.ResumePoolPage;
import com.ta.test.page_objects.gui.UserHomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class ResumePoolPageSteps {

    private ResumePoolPage resumePoolPage;

    public ResumePoolPageSteps(ResumePoolPage resumePoolPage) {
        this.resumePoolPage = resumePoolPage;
    }

    @And("^user is on \"([^\"]*)\" page$")
    public void userIsOnPage(String pageHeading) throws Throwable {
        assertThat(resumePoolPage.getHdgPageHeadingText()).isEqualToIgnoringCase(pageHeading);
    }


    @When("^user clicks in \"([^\"]*)\" field$")
    public void userClicksInField(String arg0) throws Throwable {
        resumePoolPage.clickInTxtSelectGroupUntouched();
    }

    @Then("^user should be able to see the list of existing groups$")
    public void userShouldBeAbleToSeeTheListOfExistingGroups() throws Throwable {
        int numberOfElements = resumePoolPage.getAllGroupElements().size();
        assertThat(numberOfElements>0);
    }

    @And("^user selects the group item \"([^\"]*)\"$")
    public void userSelectsTheGroupItem(String groupName) throws Throwable {
        resumePoolPage.enterTxtSelectGroupDirty(groupName);
        resumePoolPage.selectEleGroupClassifications();
    }

    @And("^user enters the search candidate \"([^\"]*)\"$")
    public void userEntersTheSearchCandidate(String candidateName) throws Throwable {
        resumePoolPage.enterTxtSearchUntouched(candidateName);
    }

    @When("^user clicks on candidate search button$")
    public void userClicksOnCandidateSearchButton() throws Throwable {
        resumePoolPage.clickBtnSearch();
    }

    @Then("^user sees the list of candidates matching with the search criteria$")
    public void userSeesTheListOfCandidatesMatchingWithTheSearchCriteria() throws Throwable {
        
    }
}
