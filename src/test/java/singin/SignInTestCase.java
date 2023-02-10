package singin;

import basics.Base;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.CartScreen;
import screens.ViewItemDetailsScreen;

public class SignInTestCase extends Base {
    //validData
    String email = "salma@gmail.com";
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

    @Test(dependsOnMethods = "goToSignPage")
    public void singIn()  {
        signInScreen.setEmail(email);
        signInScreen.setPassword(password);
        myAccountScreen = signInScreen.clickSigInButton();
    }

//    @Test(dependsOnMethods = {"goToSignPage", "singIn"})
//    public void goToHomePage() throws InterruptedException {
//        //myAccountScreen = signInScreen.clickSigInButton();
//        Thread.sleep(5000);
//        homeScreen = myAccountScreen.clickHomeScreen();
//    }
//
//    @Test(dependsOnMethods = "goToHomePage")
//    public void searchForItem() {
//        viewItemDetails = homeScreen.SearchForItem();
//    }
//
//    @Test(dependsOnMethods = "searchForItem")
//    public void addItemsToCart() {
//        viewItemDetails.addToCart();
//    }
//
//    @Test(dependsOnMethods = "addItemsToCart")
//    public void viewCart() {
//
//        cartScreen = viewItemDetails.viewCart();
//    }
//
//    @Test(dependsOnMethods = "viewCart")
//    public void addCoupon() {
//        cartScreen.addCouponCode(couponCode);
//        Assert.assertTrue(cartScreen.checkMessage(), "Coupon Not Added");
//    }


}
