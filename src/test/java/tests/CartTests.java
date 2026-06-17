package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class CartTests extends BaseTest {

    @Test
    public void addProductToCartAndVerify() {
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookiesIfPresent();

        homePage.clickProducts();

        ProductsPage productsPage = new ProductsPage(driver);

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.getNumberOfCartItems() > 0,
                "Cart should contain at least one item after adding product.");
    }
}