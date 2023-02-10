package basics;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.*;
import screens.HomeScreen;
import screens.LocationsScreen;
import screens.MyAccountScreen;
import screens.SignInScreen;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Base {
    //element
    protected LocationsScreen locationsScreen;
    AndroidDriver driver;
    protected HomeScreen homeScreen;
    protected MyAccountScreen myAccountScreen;
    protected SignInScreen signInScreen;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setDeviceName("4DSWVK4LCQORAI8H")
                .setAppPackage("com.noon.buyerapp")
                .setAppActivity("com.noon.buyerapp.MainActivity");
        driver = new AndroidDriver(
                // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                new URL("http://localhost:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        locationsScreen = new LocationsScreen(driver);

    }
//    @BeforeTest
//    public  void setUpPages(){
//        locationsScreen = new LocationsScreen(driver);
//    }

//    @AfterClass
//    public void tearDown() {
//        if (null != driver) {
//            driver.quit();
//        }
//    }
}
