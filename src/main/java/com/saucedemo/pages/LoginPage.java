package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.custtomerlisteners.CustomListeners;
import com.saucedemo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    //declaring the variables


    @CacheLookup
    @FindBy(id = "user-name")
    WebElement usernameField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(xpath = "//input[@class='submit-button btn_action']")
    WebElement loginButton;

    //this method will enter the username
    public void enterUserNameInTheUserNameField(String username) {
        CustomListeners.test.log(Status.PASS, "Enter Username " + username);
        sendTextToElement(usernameField, username);
    }

    // this method will enter the password
    public void enterPasswordInThePasswordField(String password) {
        CustomListeners.test.log(Status.PASS, "Enter Password " + password);
        sendTextToElement(passwordField, password);
        Reporter.log("Enter password " + password + " to email field " + passwordField.toString());
    }

    //this method will click on the  login button
    public void clickOnLoginButton() {
        CustomListeners.test.log(Status.PASS, "click on button " + loginButton);
        clickOnElement(loginButton);
        Reporter.log("click on log in button " + loginButton.toString());


    }
}