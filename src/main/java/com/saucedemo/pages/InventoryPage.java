package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.custtomerlisteners.CustomListeners;
import com.saucedemo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class InventoryPage extends Utility {


    @FindBy(xpath = "//span[@class='title']")
    WebElement titleOfPage;
    @FindBy(xpath = "//div[@class='inventory_item']")
    List<WebElement> listOfOfProducts;

    public int sizeOfTheList() {
        int listSize = listOfOfProducts.size();
        CustomListeners.test.log(Status.PASS, "Size of List is " + listSize);
        return listSize;
    }

    public String getTitleOfThePage() {
        CustomListeners.test.log(Status.PASS, "Title of the page " + titleOfPage);
        Reporter.log("Title of the page " + titleOfPage.toString());
        return titleOfPage.getText();
    }

}
