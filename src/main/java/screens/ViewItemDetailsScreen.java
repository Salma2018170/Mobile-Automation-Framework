package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ViewItemDetailsScreen {
    AndroidDriver driver;
    //Element
    private final By cartButton=By.xpath("//android.widget.TextView[@text='ADD TO CART']");
    private final By viewCartButton=By.xpath("//android.widget.TextView[@text='VIEW CART']");

    ViewItemDetailsScreen(AndroidDriver driver){
        this.driver=driver;
    }
    public void addToCart(){
        WebElement cartElement= driver.findElement(cartButton);
        cartElement.click();
    }
    public CartScreen viewCart(){
        WebElement viewCartElement= driver.findElement(viewCartButton);
        viewCartElement.click();
        return new CartScreen(driver);
    }
}
