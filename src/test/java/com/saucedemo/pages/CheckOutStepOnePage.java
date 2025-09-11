package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutStepOnePage {
    WebDriver driver;

    public CheckOutStepOnePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    WebElement FirstName;

    @FindBy(id = "last-name")
    WebElement LastName;

    @FindBy(id="postal-code")
    WebElement PostalCode;

    @FindBy(id = "continue")
    WebElement Continue;

    public CheckoutStepTwoPage fillShippingDetails(String firstName, String lastName, String postalCode){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
        FirstName.sendKeys(firstName);
        LastName.sendKeys(lastName);
        PostalCode.sendKeys(postalCode);
        Continue.click();

        return new CheckoutStepTwoPage(driver);
    }
}
