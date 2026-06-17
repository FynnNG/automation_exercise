package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutTests extends BaseTest {

    @Test
    public void placeOrderAfterLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCookieConsentButton();
        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);
        String email = "fynnng@test.com";
        String password = "1234567";
        loginPage.login(email, password);

        Assert.assertTrue(homePage.isLoggedIn(), "User should be logged in.");

        homePage.clickProducts();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();

        driver.get("https://automationexercise.com/view_cart");
        handleGoogleVignetteIfPresent();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.getNumberOfCartItems() > 0,
                "Cart should contain at least one item before checkout.");

        cartPage.clickProceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertTrue(checkoutPage.isAddressDetailsVisible(),
                "Address details section should be visible on checkout page.");
        Assert.assertTrue(checkoutPage.isReviewYourOrderVisible(),
                "Review your order section should be visible on checkout page.");

        checkoutPage.clickPlaceOrder();

        checkoutPage.enterPaymentDetailsAndConfirm(
                "Fynn Test",
                "4111222233334444",
                "123",
                "10",
                "2030"
        );

        Assert.assertTrue(checkoutPage.isOrderSuccessMessageVisible(),
                "Order success message should be visible after placing order.");
    }
}