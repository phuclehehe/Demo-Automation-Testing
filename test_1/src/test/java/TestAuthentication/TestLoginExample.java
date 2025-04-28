package TestAuthentication;

import TestObject.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLoginExample {
   private WebDriver webdriver ;
   private LoginPage loginPage;
    @BeforeEach
    void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-features=PasswordCheck,PasswordManager");
        options.addArguments("--disable-notifications");
        webdriver = new ChromeDriver();
        webdriver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(webdriver);
    }
    @Test
    public void testLoginSuccess(){
       loginPage.login("standard_user", "secret_sauce");
       assertTrue(webdriver.getCurrentUrl().contains("inventory.html"),"Login failed");

    }
    @Test
    public void testLoginFailureWithWrongUsername(){
        loginPage.login("invalid_user", "wrong_password");
        String error = loginPage.getErrorMessage();
        assertTrue(error.contains("Username and password do not match any user in this service"),"Login failed");
    }

    @Test
    public void testLoginFailureWithLockedUser(){
        loginPage.login("locked_out_user", "secret_sauce");
        String error = loginPage.getErrorMessage();
        assertTrue(error.contains("Sorry, this user has been locked out."),"Login failed");
    }
    @Test
    public void testLoginFailureWithProblemUser(){
        loginPage.login("problem_user", "secret_sauce");
        String error = loginPage.getErrorMessage();
        assertTrue(webdriver.getCurrentUrl().contains("inventory.html"),"Login failed for problem user");
    }
    @AfterEach
    void tearDown() {
//        webdriver.quit();
    }
}
