package TestMainPage;

import TestObject.CartPage;
import TestObject.CheckoutPage;
import TestObject.LoginPage;
import TestObject.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCart {
    private WebDriver driver;
    private LoginPage  loginPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-blink-features=AutomationControlled");
        options.addArguments("disable-password-manager-reauthentication");
        options.addArguments("disable-autofill-keyboard-accessory-view[8]");

        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void testAddToCart(){
        productPage.addProductToCart();
        assertTrue(driver.getCurrentUrl().contains("inventory.html"),"Failed add product to cart");
    }
    @Test
    public void testGoToCart(){
        cartPage.goToCart();
        assertTrue(driver.getCurrentUrl().contains("cart.html"),"Failed go to cart page");
    }
    @Test
    public void testRemoveFromCart(){
        productPage.addProductToCart();
        cartPage.removeProduct();
        assertTrue(driver.getCurrentUrl().contains("inventory.html"),"Failed remove product from cart");
    }
    @Test
    public void testCheckout(){
        productPage.addProductToCart();
        cartPage.goToCart();
        cartPage.checkout();
        checkoutPage.fillFormCheckout("abc","xyz","123456");
        checkoutPage.finishCheckout();
        checkoutPage.back();
        assertTrue(driver.getCurrentUrl().contains("inventory.html"),"Failed checkout page");
    }
    @AfterEach
    public void tearDown(){
//        driver.quit();

    }
}
