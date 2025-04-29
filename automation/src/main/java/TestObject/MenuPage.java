package TestObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuBtn;
    @FindBy(id = "about_sidebar_link")
    private WebElement aboutLink;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutBtn;
    @FindBy (id = "reset_sidebar_link")
    private WebElement resetBtn;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    private void openMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(menuBtn)).click();
    }

    public void about(){
        openMenu();
        wait.until(ExpectedConditions.elementToBeClickable(aboutLink)).click();
    }

    public void reset(){
        openMenu();
        wait.until(ExpectedConditions.elementToBeClickable(resetBtn)).click();
    }
    public void logout() {
        openMenu();
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).click();
    }
}
