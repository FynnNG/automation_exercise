package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private final WebDriver driver;
    private final By addressDetailsSection = By.xpath("//h2[contains(text(),'Address Details')]");
    private final By reviewYourOrderSection = By.xpath("//h2[contains(text(),'Review Your Order')]");
    private final By placeOrderButton = By.xpath("//a[contains(text(),'Place Order')]");
    private final By nameOnCardInput = By.name("name_on_card");
    private final By cardNumberInput = By.name("card_number");
    private final By cvcInput = By.name("cvc");
    private final By expiryMonthInput = By.name("expiry_month");
    private final By expiryYearInput = By.name("expiry_year");
    private final By payAndConfirmOrderButton = By.id("submit");
    private final By successMessage =
            By.xpath("//*[contains(text(),'Your order has been placed successfully')]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAddressDetailsVisible() {
        return driver.findElements(addressDetailsSection).size() > 0;
    }

    public boolean isReviewYourOrderVisible() {
        return driver.findElements(reviewYourOrderSection).size() > 0;
    }

    public void clickPlaceOrder() {
        driver.findElement(placeOrderButton).click();
    }

    public void enterPaymentDetailsAndConfirm(String name, String cardNumber, String cvc,
                                              String month, String year) {
        driver.findElement(nameOnCardInput).sendKeys(name);
        driver.findElement(cardNumberInput).sendKeys(cardNumber);
        driver.findElement(cvcInput).sendKeys(cvc);
        driver.findElement(expiryMonthInput).sendKeys(month);
        driver.findElement(expiryYearInput).sendKeys(year);
        driver.findElement(payAndConfirmOrderButton).click();
    }

    public boolean isOrderSuccessMessageVisible() {
        return driver.findElements(successMessage).size() > 0;
    }
}