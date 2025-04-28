# Automation Testing Project for saucedemo.com (Java)
Project for learning basic of automation testing

## Overview
This project demonstrates automation testing for the e-commerce website saucedemo.com using Selenium WebDriver (Java), JUnit 5, and Allure Report. It includes test cases for login, product navigation, cart operations, checkout, reset, and logout, with CI/CD integration via GitHub Actions.

## Setup

1. Install **JDK 11 or higher**.
2. Install **IntelliJ IDEA** or **Eclipse**.
3. Install **Maven dependencies**:

```bash
mvn clean install
```
## Running Tests Locally
```bash
mvn clean test
```
## Structure

- `src/main/java/TestObject/`: Page Object Model classes (`LoginPage`, `ProductsPage`, `CartPage`, `CheckoutPage`, `MenuPage`).
- `src/test/java/`: Test scripts (`TestLogin`, `TestProducts`, `TestAbout`, `TestCart`, `TestReset`, `TestLogout`).
- `pom.xml`: Maven dependencies.
## Test Cases
- **Login:** Valid/invalid credentials, special users (locked_out, problem, performance_glitch).
- **Products:** Navigate to product page, add to cart.
- **Cart:** Add/remove products, checkout (valid/invalid).
- **Menu:** About link, reset, logout.
## Result
- All test cases pass for standard scenarios.
