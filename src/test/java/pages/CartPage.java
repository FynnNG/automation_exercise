package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver driver;
    private final By cartRows = By.cssSelector("#cart_info_table tbody tr");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getNumberOfCartItems() {
        return driver.findElements(cartRows).size();
    }

    public void clickProceedToCheckout() {
        driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]")).click();
    }
}