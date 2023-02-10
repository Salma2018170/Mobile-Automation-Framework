package basics_funcations;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScreenBase {
    AndroidDriver driver;
    //
    //30
    private static final Duration DURATION=Duration.ofMinutes(2);
    public ScreenBase(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        this.driver=driver;
    }
    public void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,DURATION);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clear(WebElement element) {
        waitForElement(element);
        element.clear();
    }
    public void click(WebElement element){
        waitForElement(element);
        element.click();
    }
    public void sendKey(WebElement element ,String text){
        waitForElement(element);
        element.sendKeys(text);
    }
}
