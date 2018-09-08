package com.ta.test.page_objects.gui;

import com.ta.test.framework.PageObject;
import lombok.Getter;
import org.openqa.selenium.By;

/**
 * This class contains all the objects related to user home page.
 */
@Getter
public class UserHomePage extends PageObject {

    /**
     * This section contains all the objects present on the user home page
     */

    //Top navigation bar
    private By mnuHeaderDP = By.className("header-dp");
    private By imgLogo = By.id("logo");
    private By lnkPositions = By.xpath("//a[contains(string(),'Positions')]");
    private By lnkResumePool = By.xpath("//a[contains(string(),'Resume Pool')]");
    private By lnkRoles = By.xpath("//a[contains(string(),'Roles')]");
    private By lnkTemplates = By.xpath("//a[contains(string(),'Templates')]");
    private By lnkAdmin = By.xpath("//a[contains(string(),'Admin')]");
    private By subLinkAllTemplates = By.xpath("//a[contains(string(),'All Templates')]");
    private By subLinkCreateEditTemplates = By.xpath("//a[contains(string(),'Create/Edit Templates')]");
    private By btnCreate = By.xpath("//a[contains(string(),'Create')]");
    private By subLnkCreateProject = By.xpath("//a[contains(string(),'Create Project')]");
    private By subLnkCreatePosition = By.xpath("//a[contains(string(),'Create Position')]");
    private By subLnkMyProfile = By.xpath("//a[contains(string(),'My Profile')]");
    private By subLnkSource = By.xpath("//a[contains(string(),'Source')]");
    private By subLnkSettings = By.xpath("//a[contains(string(),'Settings')]");
    private By subLnkLogout = By.xpath("//a[contains(string(),'Logout')]");


    /**
     * This section contains all the actions which can be performed on the user home page
     */
    public String getMnuHeaderDPInitials() {return waitForExpectedElement(mnuHeaderDP).getText();}
    public boolean isImgLogoDisplayed(){return waitForExpectedElement(imgLogo).isDisplayed();}
    public boolean logOut(){
        try {
            waitForExpectedElement(mnuHeaderDP).click();
            waitForExpectedElement(subLnkLogout).click();
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }


}
