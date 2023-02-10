package screens;

import basics_funcations.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LocationsScreen extends ScreenBase {
    //element location
    private final By egyptButton = By.xpath("(//*[@text='Egypt'])");
    private final By permissionButton = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    private final By confirmLocationButton = By.xpath("(//android.widget.TextView[@text='CONFIRM LOCATION'])");
    AndroidDriver driver;

    public LocationsScreen(AndroidDriver driver) {

        super(driver);
        this.driver = driver;
    }

    public HomeScreen confirmYourLocation() {
        WebElement egyptElement = driver.findElement(egyptButton);
        waitForElement(egyptElement);
        egyptElement.click();
        WebElement permissionElement = driver.findElement(permissionButton);
        waitForElement(permissionElement);
        permissionElement.click();
        WebElement confirmElement = driver.findElement(confirmLocationButton);
        waitForElement(confirmElement);
        confirmElement.click();
        return new HomeScreen(driver);
    }
}
