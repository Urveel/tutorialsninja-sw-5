package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopsAndNotebooksText;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productsPrices;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;



    public String getLaptopsAndNotebooksText() {
        Reporter.log("Get text from laptopsAndNotebooksTitle" + laptopsAndNotebooksText.toString());
        CustomListeners.test.log(Status.PASS,"Get text from laptopsAndNotebooksTitle ");
        return getTextFromElement(laptopsAndNotebooksText);
    }

    public ArrayList<Double> getProductsPriceList() {
        Reporter.log("Get products price list" + productsPrices.toString());
        List<WebElement> products =productsPrices;
        ArrayList<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return originalProductsPrice;
    }

    public void selectSortByOption(String option) {
        Reporter.log("Select sortBy option" + sortBy.toString());
        selectByVisibleTextFromDropDown(sortBy, option);
        CustomListeners.test.log(Status.PASS,"Select sortBy option" + option);
    }

    public void selectProductByName(String product) {
        Reporter.log("Select product by name" + productsList.toString());
        List<WebElement> products = productsList;
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }
}
