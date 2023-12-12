package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.AccountRegisterPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class AccountRegisterPageTest {

    HomePage homePage;
    AccountRegisterPage accountRegisterPage;
    MyAccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        accountRegisterPage = new AccountRegisterPage();
        accountPage = new MyAccountPage();
    }

    @Test(groups = {"sanity","regression","smoke"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        accountPage.clickOnMyQAccountTab();

        accountPage.selectMyAccountOptions("Register");

        Assert.assertEquals(accountRegisterPage.getRegisterAccountText(),
                "Register Account", "Register page not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        accountPage.clickOnMyQAccountTab();

        accountPage.selectMyAccountOptions("Register");

        accountRegisterPage.enterFirstName("prime" );

        accountRegisterPage.enterLastName("testing");

        accountRegisterPage.enterEmail("prime@gmail.com");

        accountRegisterPage.enterTelephone("123456");

        accountRegisterPage.enterPassword("9081811670@Dv");

        accountRegisterPage.enterConfirmPassword("9081811670@Dv");

        accountRegisterPage.selectSubscription("Yes");

        accountRegisterPage.clickOnPrivacyPolicyCheckBox();

        accountRegisterPage.clickOnContinueButton();

        Assert.assertEquals(accountPage.getYourAccountHasBeenCreatedText(), "Your Account Has Been Created!",
                "Account not created");

        accountPage.clickOnContinueButton();

        Thread.sleep(2000);
        accountPage.clickOnMyQAccountTab();

        accountPage.selectMyAccountOptions("Logout");

        Assert.assertEquals(accountPage.getAccountLogoutText(), "Account Logout", "Not logged out");

        accountPage.clickOnContinueButton();
    }
}
