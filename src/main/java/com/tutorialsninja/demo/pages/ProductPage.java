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

public class ProductPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id = 'content']//h1")
    WebElement productText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement calenderButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement monthAndYearText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement nextButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']")
    List<WebElement> dateList;

    @CacheLookup
    @FindBy(css = "#input-quantity")
    By qtyField;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(css = "body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")
    WebElement successMessage;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement datePicker;



    public String getProductText() {
        Reporter.log("Get productText" + productText.toString());
        CustomListeners.test.log(Status.PASS,"Get productText");
        return getTextFromElement(productText);
    }

    public void selectDeliveryDate(String day, String month, String year) {
        Reporter.log("Select delivery date" + monthAndYearText.toString());
        clickOnElement(datePicker);
        while (true) {
            String monthAndYear = getTextFromElement(monthAndYearText);
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextButton);
            }
        }
        List<WebElement> allDates = dateList;
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(day)) {
                e.click();
                break;
            }
        }
        CustomListeners.test.log(Status.PASS,"Select delivery date"+ day + month+ year);

    }

    public void clickOnAddToCartButton() {
        Reporter.log("Click on addToCartButton" + addToCartButton.toString());
        clickOnElement(addToCartButton);
        CustomListeners.test.log(Status.PASS,"Click on addToCartButton");
    }

    public String getProductAddedSuccessMessage() {
        Reporter.log("Get productAdded success message" + successMessage.toString());
        CustomListeners.test.log(Status.PASS,"Get productAdded success message");
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCartLinkIntoMessage() {
        Reporter.log("Click on shopping cart link in message" + shoppingCartLink.toString());
        clickOnElement(shoppingCartLink);
        CustomListeners.test.log(Status.PASS,"Click on shopping cart link in message");
    }

    public void enterQuantity(String qty) {
        Reporter.log("Enter quantity" + qtyField.toString());
        clearTextFromField(qtyField);
        sendTextToElement(qtyField, qty);
        CustomListeners.test.log(Status.PASS,"Enter quantity" + qty);
    }
}
