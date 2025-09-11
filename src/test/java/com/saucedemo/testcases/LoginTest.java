package com.saucedemo.testcases;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider(name = "LoginCredentials")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", "https://www.saucedemo.com/inventory.html"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"problem_user", "secret_sauce", "https://www.saucedemo.com/inventory.html"}, // Another positive case
                {"performance_glitch_user", "secret_sauce", "https://www.saucedemo.com/inventory.html"},
                {"invalid_username", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "LoginCredentials")
    public void loginTest(String username, String password, String expectedResult){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication(username, password);

        if(expectedResult.contains("inventory.html")) {
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl, expectedResult);
        }else{
            String actualErrorMessage = loginPage.getErrorMessage();
            Assert.assertEquals(actualErrorMessage, expectedResult);
        }
    }
}
