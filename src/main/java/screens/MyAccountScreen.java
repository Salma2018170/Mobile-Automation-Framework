package screens;

import basics_funcations.ScreenBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountScreen extends ScreenBase {
    private final By homeButton = By.xpath("//android.widget.FrameLayout[@content-desc='Home, tab, 1 out of 5']");
    AndroidDriver driver;
    private final By signUp = By.xpath("//android.widget.TextView[@text='Sign Up']");
    //element path
    private final By logIn = By.xpath("//android.widget.TextView[@text='Sign In']");

    public MyAccountScreen(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public SignInScreen clickLoginButton() {
        WebElement logInButton = driver.findElement(logIn);
        click(logInButton);
        return new SignInScreen(driver);
    }

    public HomeScreen clickHomeScreen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        WebElement webElement= driver.findElement(AppiumBy.accessibilityId("Home, tab, 1 out of 5"));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
        return new HomeScreen(driver);
    }
//    public SignUpScreen clickSignUpButton(){
//        WebElement SignUpButton=driver.findElement(signUp);
//        click(SignUpButton);
//        return new SignUpScreen(driver);
//    }
}
