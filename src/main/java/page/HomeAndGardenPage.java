package page;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeAndGardenPage extends AppiumBase {

    public HomeAndGardenPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home Decor']")
    private WebElement homeDecorNav;


    public void clickHomeDecorNav(){
        webDriverWait.until(ExpectedConditions.visibilityOf(homeDecorNav));
        homeDecorNav.click();
    }
}
