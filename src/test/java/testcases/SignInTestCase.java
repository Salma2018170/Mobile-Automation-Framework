package testcases;

import basics.TestBase;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import screens.CartScreen;
import screens.ViewItemDetailsScreen;
import utils.JsonReader;

import java.io.IOException;
import java.text.ParseException;

public class SignInTestCase extends TestBase {
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
    @DataProvider(name = "login data")
    public Object[][] passData() throws IOException, ParseException, org.json.simple.parser.ParseException {
        return JsonReader.getJSONData(System.getProperty("user.dir") + "/data/LoginData.json", "Users", 2);
    }

    @Test(dataProvider ="login data", dependsOnMethods = "goToSignPage")
    public void singIn(String email, String password)  {
        signInScreen.setEmail(email);
        signInScreen.setPassword(password);
        myAccountScreen = signInScreen.clickSigInButton();
        Assert.assertTrue(signInScreen.checkMessage(), "login wrong");
    }



}
