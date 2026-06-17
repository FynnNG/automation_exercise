package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;

public class SearchTests extends BaseTest {

    @Test
    public void searchExistingProductShowsResults() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCookieConsentButton();
        homePage.clickProducts();

        ProductsPage productsPage = new ProductsPage(driver);
        String keyword = "dress";
        productsPage.searchProduct(keyword);

        Assert.assertTrue(productsPage.isSearchedProductsSectionVisible(),
                "Searched Products section should be visible.");
        Assert.assertTrue(productsPage.getNumberOfDisplayedProducts() > 0,
                "At least one product should be displayed for search result.");
    }
}