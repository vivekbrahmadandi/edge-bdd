package com.ta.test.page_objects.gui;

import com.ta.test.framework.PageObject;
import lombok.Getter;
import org.openqa.selenium.By;

/**
 * This class contains all the objects related to landing page.
 */
@Getter
public class LandingPage extends PageObject {

    /**
     * This section contains all the objects present on the landing page
     */

    //header section

    private By headingBranding = By.xpath("//div[@class='branding-wrapper']//h1");
    //Login section
    private By txtUserName = By.name("username");
    private By txtPassword = By.name("password");
    private By btnSignIn = By.xpath("//input[@value='Sign In']");
    //Forgot password link
    private By lnkForgotPassword = By.linkText("Forgot Password?");
    //Sign up link
    private By lnkSignUp = By.xpath("//a[contains(string(),'Sign up')]");
    //Email field error message
    private By msgEmailError = By.xpath("(//div[@class='form-group'])[1]//span");
    //Password field error message
    private By msgPasswordError = By.xpath("(//div[@class='form-group'])[2]//span");
    //Toast error message
    private By msgToastError = By.xpath("//div[@class='toast-message']");



    /**
     * This section contains all the actions which can be performed on the landing page
     */
    public void enterUserName(String userName) {
        waitForExpectedElement(txtUserName).sendKeys(userName);
    }
    public void enterPassword(String password) {
        waitForExpectedElement(txtPassword).sendKeys(password);
    }
    public void clickOnSignInBtn() {
        waitForExpectedElement(btnSignIn).click();
    }
    public String getBrandingPageTitleText() {return waitForExpectedElement(headingBranding).getText();}
    public String getMsgEmailErrorText() {return waitForExpectedElement(msgEmailError).getText();}
    public String getMsgPasswordErrorText() {return waitForExpectedElement(msgPasswordError).getText();}
    public String getMsgToastErrorText() {return waitForExpectedElement(msgToastError).getText();}

    /**
     * @param userName user name for login
     * @param password password for login
     */
    public void login(String userName,String password) {
        enterUserName(userName);
        enterPassword(password);
        clickOnSignInBtn();
    }

}
