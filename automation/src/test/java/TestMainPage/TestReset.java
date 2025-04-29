package TestMainPage;

import TestObject.LoginPage;
import TestObject.MenuPage;
import TestObject.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestReset {
    private WebDriver driver;
    private LoginPage loginPage;
    private MenuPage menuPage;
    private ProductPage productPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        menuPage = new MenuPage(driver);
        productPage = new ProductPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void testReset() {
        productPage.addProductToCart();
        menuPage.reset();
        assertTrue(driver.getCurrentUrl().contains("inventory.html"),"Failed to reset");
    }
    @AfterEach
    public void tearDown() {
//        driver.quit();
    }
}
