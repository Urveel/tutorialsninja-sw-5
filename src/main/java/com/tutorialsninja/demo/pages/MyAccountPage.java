package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class MyAccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement accountCreatedText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueBtn;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountTab;

    @CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    List<WebElement> myAccountOptions;


    public String getAccountLogoutText() {
        Reporter.log("Get accountLogout text" + accountLogoutText.toString());
        CustomListeners.test.log(Status.PASS,"Get accountLogout text");
        return getTextFromElement(accountLogoutText);
    }

    public String getYourAccountHasBeenCreatedText() {
        Reporter.log("Get account created text" + accountCreatedText.toString());
        CustomListeners.test.log(Status.PASS,"Get account created text");
        return getTextFromElement(accountCreatedText);
    }
    public void clickOnContinueButton() {
        Reporter.log("Click on continueButton" + continueBtn.toString());
        clickOnElement(continueBtn);
        CustomListeners.test.log(Status.PASS,"Click on continueButton");
    }

    public void clickOnMyQAccountTab() {
        Reporter.log("Click on myAccountTab" + myAccountTab.toString());
        clickOnElement(myAccountTab);
        CustomListeners.test.log(Status.PASS,"Click on myAccountTab");
    }

    public void selectMyAccountOptions(String option) {
        Reporter.log("Select my account options" + myAccountOptions.toString());
        List<WebElement> myAccountList = myAccountOptions;
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = myAccountOptions;
            CustomListeners.test.log(Status.PASS,"Select my account options");

        }
    }
}
