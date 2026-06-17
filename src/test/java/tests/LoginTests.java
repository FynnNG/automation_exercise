package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void loginWithValidCredentials() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickCookieConsentButton();
        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);
        String email = "fynnng@test.com";
        String password = "1234567";

        loginPage.login(email, password);

        Assert.assertTrue(homePage.isLoggedIn(), "User should be logged in.");

        homePage.clicklogoutButton();
    }

    @Test
    public void loginWithInvalidPasswordShowsError() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCookieConsentButton();
        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("aaa@test.com", "111");

        Assert.assertTrue(loginPage.isLoginErrorVisible(),
                "Your email or password is incorrect!' is visible");
    }

}