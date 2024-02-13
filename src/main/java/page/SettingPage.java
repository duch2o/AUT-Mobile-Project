package page;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SettingPage extends AppiumBase {

    public SettingPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.banggood.client:id/ll_currency")
    private WebElement currencyNav;

    @AndroidFindBy(xpath = "//android.widget.ImageButton")
    private WebElement backIcon;

    public void clickCurrency(){
        webDriverWait.until(ExpectedConditions.visibilityOf(currencyNav));
        currencyNav.click();
    }

    public void clickbackIcon(){
        webDriverWait.until(ExpectedConditions.visibilityOf(backIcon));
        backIcon.click();
    }
}
