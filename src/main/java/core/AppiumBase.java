package core;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumBase {

    public static AndroidDriver driver;
    public static WebDriverWait webDriverWait;

    public void createDriver() throws MalformedURLException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setUdid("emulator-5554")
                .setAppPackage("com.banggood.client")
                .setAppActivity("com.banggood.client.module.startup.SplashActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),uiAutomator2Options);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void closeDriver(){
        driver.quit();
    }

    public void swipe(int startx, int starty, int endx, int endy, AndroidDriver driver){
        new TouchAction(driver).longPress(PointOption.point(startx,starty))
                .moveTo(PointOption.point(endx,endy))
                .release().perform();
    }

    public void swipeUpUntil(AndroidDriver driver, WebElement element){
        int scrollTime=0;
        while(scrollTime<=10){
            try {
                if(element.isDisplayed()){
//                    System.out.println("Da display");
                    break;
                }
            }catch (NoSuchElementException e){
                swipeMobileUp(driver);
//                System.out.println("Chua display");
            }
            scrollTime++;
        }
    }
    public void swipeMobileUp(AndroidDriver driver){
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height*0.8);
        int endy = (int) (size.height*0.2);
        int startx = size.width/2;
        swipe(startx,starty,startx,endy,driver);
    }
}
