package steps;

import basics.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import screens.CartScreen;
import screens.ViewItemDetailsScreen;
import utils.JsonReader;

import java.io.IOException;
import java.text.ParseException;

public class LoginSteps extends TestBase {


    @Description("allow location")
    @Given("User allow their location")
    public void User_allow_their_location() throws IOException {
        setUp();
        homeScreen = locationsScreen.confirmYourLocation();

    }
    @Given("go to sign in screen")
    public void go_to_sign_in_screen() throws IOException {
        myAccountScreen = homeScreen.openMyAccount();
        signInScreen = myAccountScreen.clickLoginButton();

    }

    @When("User fill {string} and {string} and click on sign in button")
    public void singIn(String email, String password)  {
        signInScreen.setEmail(email);
        signInScreen.setPassword(password);
        myAccountScreen = signInScreen.clickSigInButton();
    }
    @Then("error message")
    public void error_message(){
        Assert.assertTrue(signInScreen.checkMessage(), "login wrong");
    }
}
