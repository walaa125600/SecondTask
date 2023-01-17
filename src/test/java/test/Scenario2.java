package test;

import Pages.BraceletsPage;
import Pages.CartPage;
import Pages.HomePage;
import Pages.SearchResult;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenario2 extends tests.TestBase {
    @Test(priority = 0)
    public void SelectCategory() throws Exception {
        HomePage HomeObject=new HomePage(driver);
        HomeObject.ClickOnBracelets();
    }

    @Test(priority = 1)
    public void AssertOnRightPage() throws Exception {
        BraceletsPage BraceletsObject=new BraceletsPage(driver);
        String ActualURL= BraceletsObject.GetCurrentURL();
        Assert.assertEquals(ActualURL, "http://demo.themeparrot.com/shopy/index.php/catalog/product-category/bracelets" );
        System.out.println("URL matching --> Part executed");
    }

    @Test(priority = 2)
    public void Search() throws Exception {
        BraceletsPage BraceletsObject=new BraceletsPage(driver);
        BraceletsObject.SearchForItem();
    }

    @Test(priority = 3)
    public void AssertionOnSearchResult() throws Exception {
       SearchResult SearchResultObject=new SearchResult(driver);
        String s="Fa";
        String Actual =SearchResultObject.GetAllList();
        Assert.assertTrue(Actual.startsWith(s));
        System.out.println("Search Result are relevant to the search done");
    }

    @Test(priority = 4)
    public void AddToCart() throws Exception {
        SearchResult SearchResultObject=new SearchResult(driver);
        SearchResultObject.AddFirstElementToCart();

    }

    @Test(priority = 5)
    public void AssertOnPrice() throws Exception {
        SearchResult SearchResultObject=new SearchResult(driver);
        Double priceSearchResult=SearchResultObject.GetElementPriceInSearchResult();
        CartPage cartObject=new CartPage(driver);
        cartObject.OpenTheCart();
        Double priceInTheCart=cartObject.GetTotalPrice();
        Assert.assertEquals(priceSearchResult,priceInTheCart);
        System.out.println("the total price equals the price of the product in the search results of the previous page ");

    }




}
