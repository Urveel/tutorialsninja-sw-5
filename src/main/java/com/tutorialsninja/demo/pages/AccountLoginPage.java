package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AccountLoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[2]//h2")
    WebElement returningCustomerText;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[1]//h2")
    WebElement newCustomerText;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailAddressField;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;



    public String getReturningCustomerText() {

        Reporter.log("Get returningCustomerText " + returningCustomerText.toString());
        CustomListeners.test.log(Status.PASS,"Get returningCustomerText ");
        return getTextFromElement(returningCustomerText);


    }

    public String getNewCustomerText() {

        Reporter.log("Get newCustomerText " + newCustomerText.toString());
        CustomListeners.test.log(Status.PASS,"Get newCustomerText ");
        return getTextFromElement(newCustomerText);
    }

    public void enterEmailAddress(String email) {
        Reporter.log("Enter email" + emailAddressField.toString());
        sendTextToElement(emailAddressField, email);
        CustomListeners.test.log(Status.PASS,"Enter email" + email);

    }

    public void enterPassword(String password) {
        Reporter.log("Enter password" + passwordField.toString());
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS,"Enter Password" + password);

    }

    public void clickOnLoginButton() {
        Reporter.log("Click on loginButton " + loginBtn.toString());
        clickOnElement(loginBtn);
        CustomListeners.test.log(Status.PASS,"Click on loginButton");

    }
}
