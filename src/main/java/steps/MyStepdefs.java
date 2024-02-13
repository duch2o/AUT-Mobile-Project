package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page.*;

import java.util.List;

public class MyStepdefs {
    HomePage homePage = new HomePage();
    CategoryPage categoryPage = new CategoryPage();

    HomeAndGardenPage homeAndGardenPage = new HomeAndGardenPage();
    HomeDecorPage homeDecorPage = new HomeDecorPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();

    FirstCategoryOfHotCategoriesPage firstCategoryOfHotCategoriesPage = new FirstCategoryOfHotCategoriesPage();

    AfterAddProductToCartPage afterAddProductToCartPage = new AfterAddProductToCartPage();

    CartPage cartPage = new CartPage();

    AccountPage accountPage = new AccountPage();

    SignInPage signInPage = new SignInPage();

    SettingPage settingPage = new SettingPage();

    CurrencyPage currencyPage = new CurrencyPage();

    @Given("Open Banggood Easy Online Shopping App")
    public void openBanggoodEasyOnlineShoppingApp() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("CLick to the Category on footer menu")
    public void clickToTheCategoryOnFooterMenu() {
        homePage.clickCategoryMenuBar();
    }

    @And("Scroll and click to Home and Garden in Left menu")
    public void scrollAndClickToHomeAndGardenInLeftMenu() {
        categoryPage.clickHOmeAndGardenNav();
    }


    @Then("the right category displayed, click to the Home Decor Sticker")
    public void theRightCategoryDisplayedClickToTheHomeDecorSticker() {
        homeAndGardenPage.clickHomeDecorNav();
    }


    @When("Click to the Filter and input price form {string} to {string}")
    public void clickToTheFilterAndInputPriceFormTo(String priceMin, String pricemax) {
        homeDecorPage.clickFilter();
        homeDecorPage.inputPriceMin(priceMin);
        homeDecorPage.inputPriceMax(pricemax);

    }

    @And("Click Done")
    public void clickDone() {
        homeDecorPage.clickDoneBtn();
    }

    @And("Click first product")
    public void clickFirstProduct() {
        homeDecorPage.clickFirstProduct();
    }


    @Then("Verify product name should be displayed and product price in range {string} to {string}")
    public void verifyProductNameShouldBeDisplayedAndProductPriceInRangeTo(String priceMin, String priceMax) {
        Assert.assertTrue(productDetailPage.verifyProductNameDisplay());
        Assert.assertTrue(productDetailPage.verifyProductPriceInRange(priceMin,priceMax));
    }

    @When("Scoll to HOt Categories")
    public void scollToHOtCategories() {
        homePage.scollToHotCategories();
    }

    @And("Click to first category")
    public void clickToFirstCategory() {
        homePage.clickFirstCategoryOfHotCategories();
    }


    @And("Click to the first product")
    public void clickToTheFirstProduct() {
        firstCategoryOfHotCategoriesPage.clickfirstProduct();
    }

    @Then("The product detail page should be displayed:")
    public void theProductDetailPageShouldBeDisplayed(DataTable dataTable) {
        List<List<String>> ls = dataTable.asLists();
//        System.out.println(ls.size());
        String  name = ls.get(0).get(1);
        String price = ls.get(1).get(1);
        String buyNowBtn = ls.get(2).get(1);
        String addtoCartBtn = ls.get(3).get(1);

        if(name.equals("Yes")){
            Assert.assertTrue(productDetailPage.verifyProductNameDisplay());
//            System.out.println("name is displayed");
        }

        if(price.equals("Yes")){
            Assert.assertTrue(productDetailPage.verifyProductPriceDisplay());
//            System.out.println("price is displayed");
        }

        if(buyNowBtn.equals("Yes")){
            Assert.assertTrue(productDetailPage.verifyBuyNowDisplay());
//            System.out.println("Buy now Butotn is displayed");
        }

        if(addtoCartBtn.equals("Yes")){
            Assert.assertTrue(productDetailPage.verifyAddToCartDisplay());
//            System.out.println("Add to cart butotn is displayed");
        }


    }



    @And("Click to Cart icon on footer")
    public void clickToCartIconOnFooter() {
        afterAddProductToCartPage.clickCartIcon();
    }

    @Then("Verify display")
    public void verifyDisplay(DataTable dataTable) {
        List<List<String>> ls = dataTable.asLists();
//        System.out.println(ls.size());
        String  name = ls.get(0).get(1);
        String size = ls.get(1).get(1);
        String price = ls.get(2).get(1);
        String quantity = ls.get(3).get(1);

        if(name.equals("Yes")){
            Assert.assertTrue(cartPage.verifyProductNameDisplay());
        }

        if(price.equals("Yes")){
            Assert.assertTrue(cartPage.verifyProductPriceDisplay());
        }

        if(quantity.equals("Yes")){
            Assert.assertTrue(cartPage.verifyProductQuantityDisplay());
        }

        if(size.equals("Yes")){
            Assert.assertTrue(cartPage.verifyProductSizeDisplay());
        }
    }

    @When("Click Add to cart")
    public void clickAddToCart() {
        productDetailPage.clickAddToCarBtn();
    }

    @And("Click to Add to Cart butotn")
    public void clickToAddToCartButotn() {
        productDetailPage.clickAddToCarBtn();
    }

    @When("CLick Account on footer menu")
    public void clickAccountOnFooterMenu() {
        homePage.clickAccountMenuBar();
    }

    @And("Click View All Order")
    public void clickViewAllOrder() {
        accountPage.clickOrderViewAllNav();
    }

    @Then("Verify th login creen should be displayed with:")
    public void verifyThLoginCreenShouldBeDisplayedWith(DataTable dataTable) {
        List<List<String>> ls = dataTable.asLists();
//        System.out.println(ls.size());
        String  email = ls.get(0).get(1);
        String password = ls.get(1).get(1);
        String signInBtn = ls.get(2).get(1);

        if(email.equals("Yes")){
            Assert.assertTrue(signInPage.verifyEmailEditTextDisplayed());
        }

        if(password.equals("Yes")){
            Assert.assertTrue(signInPage.verifyPasswordEditTextDisplayed());
        }

        if(signInBtn.equals("Yes")){
            Assert.assertTrue(signInPage.verifySignInButtonDisplayed());
        }
    }

    @When("Change Currency to USD")
    public void changeCurrencyToUSD() {
        homePage.clickAccountMenuBar();
        accountPage.clickSettingIcon();
        settingPage.clickCurrency();
        currencyPage.clickUSD();
        settingPage.clickbackIcon();
        accountPage.clickHomePageNav();
    }
}
