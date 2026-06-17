package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    private final By emailInput = By.xpath("//input[@data-qa='login-email']");
    private final By passwordInput = By.xpath("//input[@data-qa='login-password']");
    private final By loginButton = By.xpath("//button[@data-qa='login-button']");
    private final By logoutButton = By.xpath("//button[@data-qa='logout-button']");
    private final By loggedInAsText = By.xpath("//a[contains(text(),'Logged in as')]");
    private final By loginError = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isLoggedIn() {
        return driver.findElements(loggedInAsText).size() > 0;
    }
    public boolean isLoginErrorVisible() {
        return driver.findElements(loginError).size() > 0;
    }
}