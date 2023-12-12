package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ProductPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class DesktopsPageTest extends BaseTest {
    HomePage homePage ;
    DesktopPage desktopPage;
    ProductPage productPage;
    ShoppingCartPage cartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        productPage = new ProductPage();
        cartPage = new ShoppingCartPage();
    }

    @Test(groups = {"sanity","regression","smoke"})
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        homePage.selectCurrency("£Pound Sterling");

        homePage.mouseHoverOnDesktopsLinkAndClick();

        homePage.selectMenu("Show AllDesktops");

        desktopPage.selectSortByOption("Name (Z - A)");

        desktopPage.verifySortedElementsInReverseOrder();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        Thread.sleep(2000);
        homePage.selectCurrency("£Pound Sterling");

        Thread.sleep(1000);
        homePage.mouseHoverOnDesktopsLinkAndClick();

        Thread.sleep(1000);
        homePage.selectMenu("Show AllDesktops");

        desktopPage.selectSortByOption("Name (A - Z)");

        desktopPage.selectProductByName("HP LP3065");

        Assert.assertEquals(productPage.getProductText(), "HP LP3065", "HP LP3065 Product not display");

        productPage.selectDeliveryDate("30", "November", "2023");

        productPage.enterQuantity("1");

        productPage.clickOnAddToCartButton();

        Assert.assertTrue(productPage.getProductAddedSuccessMessage().contains("Success: You have added HP LP3065 to your shopping cart!"),
                "Product not added to cart");

        productPage.clickOnShoppingCartLinkIntoMessage();

        Assert.assertTrue(cartPage.getShoppingCartText().contains("Shopping Cart"));

        Assert.assertEquals(cartPage.getProductName(), "HP LP3065", "Product name not matched");

        Assert.assertTrue(cartPage.getDeliveryDate().contains("2023-11-30"), "Delivery date not matched");

        Assert.assertEquals(cartPage.getModel(), "Product 21", "Model not matched");

        Assert.assertEquals(cartPage.getTotal(), "£74.73", "Total not matched");
    }
}