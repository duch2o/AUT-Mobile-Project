package page;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CurrencyPage extends AppiumBase {
    public CurrencyPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.banggood.client:id/ll_currency_item")
    private WebElement usdCurrency;

    public void clickUSD(){
        webDriverWait.until(ExpectedConditions.visibilityOf(usdCurrency));
        usdCurrency.click();
    }
}
