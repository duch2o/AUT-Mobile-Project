package page;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends AppiumBase {
    public AccountPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Orders']//following-sibling::android.widget.TextView[@text='View All']")
    private WebElement orderViewAllNav;

    @AndroidFindBy(id = "com.banggood.client:id/btn_setting")
    private WebElement settingIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
    private WebElement homePageNav;


    public void clickOrderViewAllNav(){
        webDriverWait.until(ExpectedConditions.visibilityOf(orderViewAllNav));
        orderViewAllNav.click();
    }
    public void clickSettingIcon(){
        webDriverWait.until(ExpectedConditions.visibilityOf(settingIcon));
        settingIcon.click();
    }

    public void clickHomePageNav(){
        webDriverWait.until(ExpectedConditions.visibilityOf(homePageNav));
        homePageNav.click();
    }




}
