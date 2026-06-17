package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void loginWithValidCredentials() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("your_email@example.com", "your_password");

        Assert.assertTrue(loginPage.isLoggedIn());
    }
}
