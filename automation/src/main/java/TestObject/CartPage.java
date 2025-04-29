package TestObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartBtn;

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;
    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBtn;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void goToCart(){
        cartBtn.click();
    }
    public void removeProduct(){
        removeBtn.click();
    }
    public void checkout(){
        checkoutBtn.click();
    }
}
