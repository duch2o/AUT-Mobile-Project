package page;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AfterAddProductToCartPage extends AppiumBase {
    public AfterAddProductToCartPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.banggood.client:id/menu_cart_icon")
    private WebElement cartIcon;

    public void clickCartIcon(){
        webDriverWait.until(ExpectedConditions.visibilityOf(cartIcon));
        cartIcon.click();
    }


}
