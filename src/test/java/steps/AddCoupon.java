package steps;

import basics.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.jfr.Description;
import org.testng.Assert;
import screens.CartScreen;
import screens.ViewItemDetailsScreen;

import java.io.IOException;

public class AddCoupon extends TestBase {
    //validData
  //  String email = "salmamoo504@gmail.com";
  //  String password = "11338899Hamed#";
    ViewItemDetailsScreen viewItemDetails;
    CartScreen cartScreen;
  //  String couponCode = "Salma20";

    @Description("Allow location and go to login screen")
    @Given("User go to login screen")
    public void user_go_to_login_screen() throws IOException {
        setUp();
        homeScreen = locationsScreen.confirmYourLocation();
        myAccountScreen = homeScreen.openMyAccount();
        signInScreen = myAccountScreen.clickLoginButton();
    }
    @Then("open account")
    public void open_account() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertFalse(signInScreen.checkMessage(),"still  in login screen");
    }
    @Description("fill data in login screen")
    @When("User fill email as {string} and Password as {string} and click on Sign in button")
    public void user_fill_email_as_and_password_as_and_click_on_sign_in_button(String email,String password) {
        signInScreen.setEmail(email);
        signInScreen.setPassword(password);
        myAccountScreen = signInScreen.clickSigInButton();
    }
    @When("User Search for item And Add item to cart")
    public void user_search_for_item_and_add_item_to_cart() throws InterruptedException {
        Thread.sleep(9000);
        homeScreen = myAccountScreen.clickHomeScreen();
        Thread.sleep(6000);
        viewItemDetails = homeScreen.SearchForItem();
        viewItemDetails.addToCart();


    }
    @When("Add Valid coupon {string}")
    public void add_valid_coupon(String couponCode) {
        cartScreen = viewItemDetails.viewCart();
        cartScreen.addCouponCode(couponCode);
    }
    @Then("Coupon added successfully")
    public void Coupon_added_successfully() {
        Assert.assertTrue(cartScreen.checkMessage(), "Coupon Not Added");
    }

}
