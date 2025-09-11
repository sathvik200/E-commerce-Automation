package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "title")
    WebElement element;

    @FindBy(className = "inventory_item")
    List<WebElement> itemList;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCart;

    public boolean isProductsTitleVisible(){
        return element.isDisplayed();
    }

    public int getProductsCount(){
        return itemList.size();
    }

    public void addProductToCartByName(String productName){
        String productId = productName.toLowerCase().replace(" ", "-");
        String newProductId = "add-to-cart-"+productId;
        driver.findElement(By.id(newProductId)).click();
    }

    public String getCartBadgeCount(){
        return cartBadge.getText();
    }

    public CartPage goToCart(){
        shoppingCart.click();
        return new CartPage(driver);
    }
}

