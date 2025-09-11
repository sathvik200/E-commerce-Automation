package com.saucedemo.testcases;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsPageTest extends BaseTest {

    ProductsPage productsPage;

    @BeforeMethod
    public void setupTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication("standard_user", "secret_sauce");
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void verifyPageTitleIsVisible(){
        Assert.assertTrue(productsPage.isProductsTitleVisible());
    }
    @Test
    public void verifyProductCount(){
        int expectedProductCount = 6;
        int actualProductCount = productsPage.getProductsCount();
        Assert.assertEquals(actualProductCount, expectedProductCount, "Incorrect product Count");
    }
    @Test
    public void verifyingAddingItemToCart(){
        productsPage.addProductToCartByName("Sauce Labs Backpack");
        String expectedBadge = "1";
        String actualBadge = productsPage.getCartBadgeCount();
        Assert.assertEquals(expectedBadge, actualBadge, "The badge on shopping cart does not match");
    }
}

