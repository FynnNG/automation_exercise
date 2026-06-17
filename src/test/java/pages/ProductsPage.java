package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductsPage {

    private final WebDriver driver;
    private final By searchInput = By.id("search_product");
    private final By searchButton = By.id("submit_search");
    private final By searchedProductsTitle = By.xpath("//h2[contains(text(),'Searched Products')]");
    private final By productListItems = By.cssSelector(".features_items .product-image-wrapper");
    private final By firstProductAddToCartButton = By.xpath("(//div[@class='productinfo text-center']/a[contains(text(),'Add to cart')])[1]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String keyword) {
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(keyword);
        driver.findElement(searchButton).click();
    }

    public boolean isSearchedProductsSectionVisible() {
        return driver.findElements(searchedProductsTitle).size() > 0;
    }

    public int getNumberOfDisplayedProducts() {
        return driver.findElements(productListItems).size();
    }

    public void addFirstProductToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addToCart = wait.until(
                ExpectedConditions.elementToBeClickable(firstProductAddToCartButton)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", addToCart);

        try {
            addToCart.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCart);
        }
    }
}