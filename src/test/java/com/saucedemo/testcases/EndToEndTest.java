package com.saucedemo.testcases;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseTest {

    ProductsPage productsPage;
    CartPage cartPage;
    CheckOutStepOnePage C1P;
    CheckoutStepTwoPage C2P;
    CheckoutCompletePage CCP;
    String expectedCT = "Thank you for your order!";

    @BeforeMethod
    public void setupTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication("standard_user", "secret_sauce");
        productsPage = new ProductsPage(driver);
    }


    @Test
    public void verifySuccesfulE2ECheckout(){
        productsPage.addProductToCartByName("Sauce Labs Backpack");
        cartPage = productsPage.goToCart();
        C1P = cartPage.goToCheckout();
        C2P = C1P.fillShippingDetails("Test", "Test", "123456");
        CCP = C2P.clickFinish();
        String ActualCT = CCP.getConfirmationMessage();
        Assert.assertEquals(ActualCT, expectedCT, "Text does not match");
    }
}
