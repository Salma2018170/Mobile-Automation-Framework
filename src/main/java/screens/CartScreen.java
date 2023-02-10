package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartScreen {
    AndroidDriver driver;
    //element
    By couponApply=By.xpath("//android.widget.TextView[@text='Apply']");
    By couponMessage=By.xpath("//android.widget.TextView[@text='Hurray! You got a discount!']");
    CartScreen(AndroidDriver driver){
        this.driver=driver;
    }
    public void addCouponCode(String couponCode){
        //search for coupon button
        WebElement searchElement = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"Enter Coupon Code\"))"));
        searchElement.click();
        searchElement.sendKeys(couponCode);
        //apply coupon
        driver.findElement(couponApply).click();
     }
    public boolean checkMessage(){
        return driver.findElement(couponMessage).isDisplayed();
    }

}
