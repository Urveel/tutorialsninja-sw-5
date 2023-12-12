package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopsText;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;



    public String getDesktopsText() {
        Reporter.log("Get Desktops text" + desktopsText.toString());
        CustomListeners.test.log(Status.PASS,"Get Desktops text" );
        return getTextFromElement(desktopsText);
    }



    public void selectProductByName(String product) {
        Reporter.log("Select product name" + productsList.toString());
        List<WebElement> products = productsList;
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
        CustomListeners.test.log(Status.PASS,"Select product name" );

    }

    public void verifySortedElementsInReverseOrder() {
        Reporter.log("Get elements sorted in reverse order" + sortBy.toString());
        List<WebElement> elements = productsList;
        ArrayList<String> originalElementList = new ArrayList<>();
        for (WebElement e : elements) {
            originalElementList.add(e.getText());
        }
        System.out.println(originalElementList);

        Collections.reverse(originalElementList);
        System.out.println(originalElementList);



        elements = productsList;
        ArrayList<String> afterSortByReverseList = new ArrayList<>();
        for (WebElement e : elements) {
            afterSortByReverseList.add(e.getText());
        }
        System.out.println(afterSortByReverseList);
        CustomListeners.test.log(Status.PASS,"Get elements sorted in reverse order"  );


    }


    public void selectSortByOption(String option) {
        Reporter.log("Select sortBy option" + sortBy.toString());
        selectByVisibleTextFromDropDown(sortBy, option);
        CustomListeners.test.log(Status.PASS,"Select sortBy option" + option);
    }
}