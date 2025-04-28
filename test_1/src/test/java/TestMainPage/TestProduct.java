package TestMainPage;

import TestObject.LoginPage;
import TestObject.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestProduct {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);

        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void testProduct() {
        productPage.goToProduct();
        assertTrue(driver.getCurrentUrl().endsWith("inventory-item.html?id=4"), "failed to go to product page");
    }

    @AfterEach
    public void tearDown() {
//        driver.quit();
    }
}
