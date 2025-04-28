package TestAuthentication;

import TestObject.LoginPage;
import TestObject.MenuPage;
import TestObject.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class TestLogoutExample {
    private WebDriver driver;
    private MenuPage menuPage;
    private LoginPage loginPage;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        menuPage = new MenuPage(driver);

        loginPage.login("standard_user", "secret_sauce");
    }
    @Test
    public void testLogout() {
        menuPage.logout();
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/"), "Failed to navigate to login page");
    }

    @AfterEach
    void tearDown() {
//        webdriver.quit();
    }
}
