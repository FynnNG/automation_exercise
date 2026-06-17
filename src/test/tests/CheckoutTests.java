package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTests extends BaseTest {

    @Test
    public void placeOrderAfterLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);
        // TODO: 用你已經註冊好的帳號
        String email = "valid_user@example.com";
        String password = "valid_password";
        loginPage.login(email, password);

        Assert.assertTrue(homePage.isLoggedIn(), "User should be logged in.");

        homePage.clickProducts();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCartAndViewCart();

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
                "Test User",
                "4111111111111111",
                "123",
                "12",
                "2030"
        );

        Assert.assertTrue(checkoutPage.isOrderSuccessMessageVisible(),
                "Order success message should be visible after placing order.");
    }
}