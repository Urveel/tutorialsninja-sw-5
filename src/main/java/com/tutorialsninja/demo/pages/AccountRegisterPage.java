package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class AccountRegisterPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;

    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstNameField;

    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastNameField;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephoneField;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement passwordConfirmField;

    @CacheLookup
    @FindBy(xpath = "//fieldset[3]//input")
    List<WebElement> subscribeRadios;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicyCheckBox;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueBtn;




    public String getRegisterAccountText() {
        Reporter.log("Get registerAccount text" + registerAccountText.toString());
        CustomListeners.test.log(Status.PASS,"Get registerAccount text ");
        return getTextFromElement(registerAccountText);
    }

    public void enterFirstName(String fName) {
        Reporter.log("Enter firstname" + firstNameField.toString());
        sendTextToElement(firstNameField, fName);
        CustomListeners.test.log(Status.PASS,"Enter firstname" + fName);
    }

    public void enterLastName(String lName) {
        Reporter.log("Enter lastname" + lastNameField.toString());
        sendTextToElement(lastNameField, lName);
        CustomListeners.test.log(Status.PASS,"Enter lastname" + lName);


    }

    public void enterEmail(String email) {
        Reporter.log("Enter email" + emailField.toString());
        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS,"Enter email" + email);

    }

    public void enterTelephone(String telephone) {
        Reporter.log("Enter Telephone" + telephoneField.toString());
        sendTextToElement(telephoneField, telephone);
        CustomListeners.test.log(Status.PASS,"Enter Telephone" + telephone);

    }

    public void enterPassword(String password) {
        Reporter.log("Enter password" + passwordField.toString());
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS,"Enter password" + password);

    }

    public void enterConfirmPassword(String cPassword) {
        Reporter.log("Enter confirm password" + passwordConfirmField.toString());
        sendTextToElement(passwordConfirmField, cPassword);
        CustomListeners.test.log(Status.PASS,"Enter confirmPassword" + cPassword);

    }

    public void selectSubscription(String option) {
        Reporter.log("Select subscription option" + subscribeRadios.toString());
        List<WebElement> radioButtons = webElementList((By) subscribeRadios);
        for (WebElement e : radioButtons) {
            if (e.getText().equals(option)) {
                e.click();
                break;
            }
        }
        CustomListeners.test.log(Status.PASS,"Select subscription option" + option);

    }

    public void clickOnPrivacyPolicyCheckBox() {
        Reporter.log("Click on privacy policy" + privacyPolicyCheckBox.toString());
        clickOnElement(privacyPolicyCheckBox);
        CustomListeners.test.log(Status.PASS,"Click on privacy policy");

    }

    public void clickOnContinueButton() {
        Reporter.log("Click on continue button" + continueBtn.toString());
        clickOnElement(continueBtn);
        CustomListeners.test.log(Status.PASS,"Click on continue button");
    }

}
