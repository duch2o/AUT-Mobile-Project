package page;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailPage extends AppiumBase {
    public ProductDetailPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.banggood.client:id/tv_product_name")
    private WebElement productName;

    @AndroidFindBy(id = "com.banggood.client:id/tv_product_price")
    private WebElement productPrice;

    @AndroidFindBy(id = "com.banggood.client:id/btn_slide_buy")
    private WebElement buyNowBtn;

    @AndroidFindBy(id = "com.banggood.client:id/btn_slide_cart")
    private WebElement addToCartBtn;



    public boolean verifyProductNameDisplay(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        webDriverWait.until(ExpectedConditions.visibilityOf(productName));
        return productName.isDisplayed();
    }

    public boolean verifyProductPriceDisplay(){
        webDriverWait.until(ExpectedConditions.visibilityOf(productPrice));
        return productPrice.isDisplayed();
    }

    public boolean verifyBuyNowDisplay(){
        webDriverWait.until(ExpectedConditions.visibilityOf(buyNowBtn));
        return buyNowBtn.isDisplayed();
    }

    public boolean verifyAddToCartDisplay(){
        webDriverWait.until(ExpectedConditions.visibilityOf(addToCartBtn));
        return addToCartBtn.isDisplayed();
    }

    public void clickAddToCarBtn(){
        webDriverWait.until(ExpectedConditions.visibilityOf(addToCartBtn));
        addToCartBtn.click();
    }

    public boolean verifyProductPriceInRange(String minPrice,String maxPrice){
        webDriverWait.until(ExpectedConditions.visibilityOf(productPrice));


        String[] text = productPrice.getText().split("\\$");
        float price = Float.parseFloat(text[1]);
        float priceMin = Float.parseFloat(minPrice);
        float priceMax = Float.parseFloat(maxPrice);
        if(price<= priceMax && price >= priceMin){
            return true;
        }
        return false;
    }


}
