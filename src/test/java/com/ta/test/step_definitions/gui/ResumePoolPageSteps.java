package com.ta.test.step_definitions.gui;


import com.ta.test.page_objects.gui.ResumePoolPage;
import com.ta.test.page_objects.gui.UserHomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

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
        assertThat(numberOfElements > 0);
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

    @And("^search results have the correct group id \"([^\"]*)\" in it$")
    public void searchResultsHaveTheCorrectGroupIdInIt(String profile) throws Throwable {
        List<WebElement> profileGroup;
        int numberOfElementsInPage = 0;
        int numberOfSearchResultsDisplayed = resumePoolPage.getNumberOfTotalItemsDisplayed();
        int numberOfPages = 0;
        if (numberOfSearchResultsDisplayed % 10 == 0) {
            numberOfPages = numberOfSearchResultsDisplayed / 10;
        } else if (numberOfSearchResultsDisplayed <= 10) {
            numberOfPages =1;
        } else {
            numberOfPages = (numberOfSearchResultsDisplayed / 10) + 1;
        }
        for (int i = 1; i <= numberOfPages; i++) {
            profileGroup = resumePoolPage.getAllProfilesForDisplayedResults();
            for (int j = 0; j < profileGroup.size(); j++) {
                assertThat(profileGroup.get(j).getText()).containsIgnoringCase(profile);
            }
            
            if (i != numberOfPages) {
                resumePoolPage.navigateToNextPage();
            }
        }
    }


}
