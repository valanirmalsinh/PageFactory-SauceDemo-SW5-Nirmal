package com.saucedemo.testsuite;

import com.saucedemo.custtomerlisteners.CustomListeners;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {
    InventoryPage inventoryPage;
    LoginPage loginPage;


    @BeforeMethod (alwaysRun = true)
    public void setupBrowser() {
        inventoryPage = new InventoryPage();
        loginPage = new LoginPage();
    }

    @Test (groups = {"smoke","regression"})
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //sending text to username field
        loginPage.enterUserNameInTheUserNameField("standard_user");
        //sending the text to password field
        loginPage.enterPasswordInThePasswordField("secret_sauce");
        //clicking on the loging button
        loginPage.clickOnLoginButton();
        //comparing the actual and expected list size and the product text
        Assert.assertEquals(inventoryPage.getTitleOfThePage(), "Products", "Title of the page is incorrect");
        Assert.assertEquals(inventoryPage.sizeOfTheList(), 6, "The size of the list is incorrect");
    }

}
