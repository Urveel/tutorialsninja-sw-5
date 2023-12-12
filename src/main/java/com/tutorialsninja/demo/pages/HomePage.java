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

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    List<WebElement> topMenu;

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopLink;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooksLink;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentsLinks;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyTab;

    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li")
    List<WebElement> currencyList;




    public void selectMenu(String menu) {
        Reporter.log("Select Menu" + topMenu.toString());
        List<WebElement> topMenuList = topMenu;
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = topMenu;
            CustomListeners.test.log(Status.PASS,"Select Menu" + menu);

        }
    }

    public void mouseHoverOnDesktopsLinkAndClick() {
        Reporter.log("Mouse hover on desktopLink and click" + desktopLink.toString());
        mouseHoverToElementAndClick(desktopLink);
        CustomListeners.test.log(Status.PASS,"Mouse hover on desktopLink and click");
    }

    public void mouseHoverOnLaptopsAndNotebooksLinkAndClick() {
        Reporter.log("Mouse hover on laptopsAndNotebooksLink and click" + laptopsAndNotebooksLink.toString());
        mouseHoverToElementAndClick(laptopsAndNotebooksLink);
        CustomListeners.test.log(Status.PASS,"Mouse hover on laptopsAndNotebooksLink and click");
    }

    public void mouseHoverOnComponentLinkAndClick() {
        Reporter.log("Mouse hover on componentsLink and click" + componentsLinks.toString());
        mouseHoverToElementAndClick(componentsLinks);
        CustomListeners.test.log(Status.PASS,"Mouse hover on componentsLink and click");

    }

    public void selectCurrency(String currency) {
        Reporter.log("Selected Currency" + currencyList.toString());
        clickOnElement(currencyTab);
        List<WebElement> listOfElements = currencyList;
        for (WebElement e : listOfElements) {
            if (e.getText().equalsIgnoreCase(currency)) {
                e.click();
                break;
            }
        }
        CustomListeners.test.log(Status.PASS,"Selected Currency");
    }
}
