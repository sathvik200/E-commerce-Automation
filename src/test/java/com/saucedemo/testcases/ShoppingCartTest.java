package com.saucedemo.testcases;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {

    CartPage cartPage;
    String productName = "Sauce Labs Backpack";

    @BeforeMethod
    public void setupTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductToCartByName(productName);
        cartPage = productsPage.goToCart();
    }

    @Test
    public void verifyItemAddedToCartSuccessfully() {
        Assert.assertTrue(cartPage.isProductInCart(productName), "The product is not in the cart.");
    }
}