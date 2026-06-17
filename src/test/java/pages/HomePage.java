package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    private final By signupLoginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    private final By productsLink = By.xpath("//a[contains(text(),'Products')]");
    private final By continueShoppingButton = By.xpath("//a[contains(text(),'Continue Shopping')]");
    private final By loggedInAsLabel = By.xpath("//a[contains(text(),'Logged in as')]");
    public final By cookieConsentButton = By.cssSelector("button.fc-button.fc-cta-consent.fc-primary-button");
    private final By logoutButton = By.xpath("//a[contains(text(),'Logout')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCookieConsentButton() {
        driver.findElement(cookieConsentButton).click();
    }

    public void clickSignupLogin() {
        driver.findElement(signupLoginLink).click();
    }

    public void clickProducts() {
        driver.findElement(productsLink).click();
    }

    public boolean isLoggedIn() {
        return driver.findElements(loggedInAsLabel).size() > 0;
    }

    public void clicklogoutButton() {
        driver.findElement(logoutButton).click();
    }

    public void clickcontinueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
    }
    public void acceptCookiesIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            By cookieConsentButton = By.cssSelector("button.fc-button.fc-cta-consent.fc-primary-button");
            wait.until(ExpectedConditions.elementToBeClickable(cookieConsentButton)).click();
        } catch (Exception e) {
        }
    }
}