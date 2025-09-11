package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public boolean isProductInCart(String productName){
        String xpathProduct = "//div[@class='inventory_item_name' and text()='" + productName + "']";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathProduct)));
        return !driver.findElements(By.xpath(xpathProduct)).isEmpty();
    }

    public CheckOutStepOnePage goToCheckout(){
        checkoutButton.click();
        return new CheckOutStepOnePage(driver);
    }
}
