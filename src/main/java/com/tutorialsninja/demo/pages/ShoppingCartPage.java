package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement model;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement total;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    By qtyField;

    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement qtyUpdateBtn;

    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement successModifiedMessage;



    public String getShoppingCartText() {
        Reporter.log("Get shoppingCart text" + shoppingCartText.toString());
        CustomListeners.test.log(Status.PASS,"Get shoppingCart text");
        return getTextFromElement(shoppingCartText);
    }

    public String getProductName() {
        Reporter.log("Get productName text" + productName.toString());
        CustomListeners.test.log(Status.PASS,"Get productName text");
        return getTextFromElement(productName);
    }

    public String getDeliveryDate() {
        Reporter.log("Get deliveryDateText" + deliveryDate.toString());
        CustomListeners.test.log(Status.PASS,"Get deliveryDateText");
        return getTextFromElement(deliveryDate);
    }

    public String getModel() {
        Reporter.log("Get model Text" + model.toString());
        CustomListeners.test.log(Status.PASS,"Get model Text ");
        return getTextFromElement(model);
    }

    public String getTotal() {
        Reporter.log("Get the total" + total.toString());
        CustomListeners.test.log(Status.PASS,"Get the total ");
        return getTextFromElement(total);
    }

    public void changeQuantity(String qty) {
        Reporter.log("Enter quantity" + qtyField.toString());
        clearTextFromField(qtyField);
        sendTextToElement(qtyField, qty);
        CustomListeners.test.log(Status.PASS,"Enter quantity"+ qty);
    }

    public void clickOnQtyUpdateButton() {
        Reporter.log("Click on quantity updateButton" + qtyUpdateBtn.toString());
        clickOnElement(qtyUpdateBtn);
        CustomListeners.test.log(Status.PASS,"Click on quantity updateButton");
    }

    public String getSuccessModifiedMessage() {
        Reporter.log("Get success modifiedMessage" + successModifiedMessage.toString());
        CustomListeners.test.log(Status.PASS,"Get success modifiedMessage");
        return getTextFromElement(successModifiedMessage);
    }
}
