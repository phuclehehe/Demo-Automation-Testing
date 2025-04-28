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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class TestAboutLink {
    private WebDriver driver;
    private MenuPage menuPage;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        menuPage = new MenuPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("inventory.html"));
    }

    @Test
    public void testAboutLink() {
        menuPage.about();
        String currentUrl= driver.getCurrentUrl();
        System.out.print(currentUrl);
        assertEquals("https://saucelabs.com/", currentUrl, "Failed to navigate to About page");
        assertTrue(driver.getTitle().contains("Sauce Labs"), "About page title mismatch");
    }

    @AfterEach
    void tearDown() {
//        webdriver.quit();
    }
}
