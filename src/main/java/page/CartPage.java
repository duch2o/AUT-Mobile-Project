package page;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends AppiumBase {
    public CartPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.banggood.client:id/tv_product_name")
    private WebElement productName;

    @AndroidFindBy(id = "com.banggood.client:id/tv_product_options")
    private WebElement productSize;

    @AndroidFindBy(id = "com.banggood.client:id/tv_product_price")
    private WebElement productPrice;

    @AndroidFindBy(id = "com.banggood.client:id/edit_qty")
    private WebElement productQuantity;


    public boolean verifyProductNameDisplay(){
        webDriverWait.until(ExpectedConditions.visibilityOf(productName));
        return productName.isDisplayed();
    }

    public boolean verifyProductPriceDisplay(){
        webDriverWait.until(ExpectedConditions.visibilityOf(productPrice));
        return productPrice.isDisplayed();
    }

    public boolean verifyProductSizeDisplay(){
        webDriverWait.until(ExpectedConditions.visibilityOf(productSize));
        return productSize.isDisplayed();
    }

    public boolean verifyProductQuantityDisplay(){
        webDriverWait.until(ExpectedConditions.visibilityOf(productQuantity));
        return productQuantity.isDisplayed();
    }


}
