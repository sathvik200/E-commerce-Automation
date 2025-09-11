package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement usernameField;

    @FindBy(id="password")
    WebElement passwordField;

    @FindBy(id="login-button")
    WebElement loginButton;

    @FindBy(css="h3[data-test='error']")
    WebElement errorMessage;

    public void loginToApplication(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }
}
