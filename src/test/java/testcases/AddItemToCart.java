package testcases;

import basics.TestBase;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.CartScreen;
import screens.ViewItemDetailsScreen;

public class AddItemToCart extends TestBase {
    //validData
    String email = "salmamoo504@gmail.com";
    String password = "11338899Hamed#";
    ViewItemDetailsScreen viewItemDetails;
    CartScreen cartScreen;
    String couponCode = "Salma20";

    @Description("allow location")
    @Test
    public void goToSignPage() {
        homeScreen = locationsScreen.confirmYourLocation();
        myAccountScreen = homeScreen.openMyAccount();
        signInScreen = myAccountScreen.clickLoginButton();
    }

    @Description("sign in with valid email and password")
    @Test(dependsOnMethods = "goToSignPage")
    public void singIn()  {
        signInScreen.setEmail(email);
        signInScreen.setPassword(password);
    }

    @Description("Go to home page to find item")
    @Test(dependsOnMethods = {"goToSignPage", "singIn"})
    public void goToHomePage() throws InterruptedException {
        myAccountScreen = signInScreen.clickSigInButton();
        Thread.sleep(5000);
        homeScreen = myAccountScreen.clickHomeScreen();
    }

    @Description("Search for item")
    @Test(dependsOnMethods = "goToHomePage")
    public void searchForItem() {
        viewItemDetails = homeScreen.SearchForItem();
    }

    @Description("Add item to cart")
    @Test(dependsOnMethods = "searchForItem")
    public void addItemsToCart() {
        viewItemDetails.addToCart();
    }

    @Description("View cart page")
    @Test(dependsOnMethods = "addItemsToCart")
    public void viewCart() {
        cartScreen = viewItemDetails.viewCart();
    }


    @Description("Add valid Coupon and check if coupon message shown")
    @Test(dependsOnMethods = "viewCart", priority = 1)
    public void addCoupon() {
        cartScreen.addCouponCode(couponCode);
        Assert.assertTrue(cartScreen.checkMessage(), "Coupon Not Added");
    }

}
