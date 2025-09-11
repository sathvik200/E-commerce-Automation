# SauceDemo E2E Test Automation Framework

This project is a complete end-to-end test automation framework for the e-commerce practice website [saucedemo.com](https://www.saucedemo.com).

---

## Features Automated
- User Authentication (Positive & Negative Login)
- Product Catalog Verification
- Add to Cart & Cart Verification
- Full End-to-End Checkout Process

---

## Tech Stack
- **Language:** Java
- **Automation Tool:** Selenium WebDriver
- **Test Runner:** TestNG
- **Build & Dependency Management:** Maven
- **Browser Driver Management:** WebDriverManager

---

## Framework Design
- **Page Object Model (POM):** Each page is modeled as a separate class for high reusability and low maintenance.
- **Page Chaining:** Methods that cause navigation return the page object for the destination page, creating a fluent API.
- **Data-Driven:** TestNG's `@DataProvider` is used to run the same test logic with multiple data sets.
- **Configuration:** Global settings like the base URL are managed in an external `config.properties` file.

---

## How to Run
1. **Prerequisites:**
   - Java JDK installed
   - Apache Maven installed
2. **Clone the repository:**
   ```bash
   git clone [https://github.com/your-username/E-commerce-Automation.git](https://github.com/your-username/E-commerce-Automation.git)
