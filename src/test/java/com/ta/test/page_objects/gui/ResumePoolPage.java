package com.ta.test.page_objects.gui;

import com.ta.test.framework.PageObject;
import com.ta.test.framework.helpers.WebDriverHelper;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * This class contains all the objects related to resume pool page.
 */
@Getter
public class ResumePoolPage extends PageObject {

    /**
     * This section contains all the objects present on the resume pool page
     */

    //Top navigation bar
    private By hdgPageHeading = By.xpath("//*[@class='project-details block']/h2");
    private By txtSelectGroupUntouched = By.xpath("//*[@class='ui-select-search input-xs ng-pristine ng-untouched ng-valid']");
    private By txtSearchUntouched = By.xpath("//*[@class='form-control ng-pristine ng-untouched ng-valid']");
    private By lstSelectGroup = By.xpath("//*[@class='ui-select-choices ui-select-choices-content ui-select-dropdown dropdown-menu']");
    private By eleGroupClassifications = By.xpath("//*[@class='ng-binding ng-scope']");
    private By txtSelectGroupDirty = By.xpath("//input[@class='ui-select-search input-xs ng-valid ng-dirty ng-touched ng-valid-parse']");
    private By btnSearch = By.xpath("//button[text(),'Search']");

    /**
     * This section contains all the actions which can be performed on the user home page
     */
    public String getHdgPageHeadingText(){
        return waitForExpectedElement(hdgPageHeading).getText();
    }

    public void clickInTxtSelectGroupUntouched(){
        waitForExpectedElement(txtSelectGroupUntouched).click();
    }

    public List<WebElement> getAllGroupElements(){
        return WebDriverHelper.getWebDriver().findElements(eleGroupClassifications);
    }

    public void enterTxtSelectGroupDirty(String groupName){
        waitForExpectedElement(txtSelectGroupDirty).sendKeys(groupName);
    }
    public void selectEleGroupClassifications(){
        waitForExpectedElement(eleGroupClassifications).click();
    }
    public void enterTxtSearchUntouched(String candidateName){
        waitForExpectedElement(txtSearchUntouched).sendKeys(candidateName);
    }
    public void clickBtnSearch(){
        waitForExpectedElement(btnSearch).click();
    }

}
