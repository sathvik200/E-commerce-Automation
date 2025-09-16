package com.saucedemo.base;

import com.saucedemo.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public ConfigReader configReader;

    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void setup() {
        configReader = new ConfigReader();

        // Disable password saving popups
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection_enabled", true);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        try {
            // Connect to Selenium Grid Hub
            driver.set(new RemoteWebDriver(
                    new URL("http://localhost:4444/wd/hub"), // ✅ correct endpoint
                    options
            ));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        getDriver().manage().window().maximize();
        getDriver().get(configReader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}
