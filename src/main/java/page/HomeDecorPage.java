package page;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeDecorPage extends AppiumBase {
    public HomeDecorPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.banggood.client:id/tv_filter_label")
    private WebElement filter;

    @AndroidFindBy(id = "com.banggood.client:id/edit_price_min")
    private WebElement priceMin;

    @AndroidFindBy(id = "com.banggood.client:id/edit_price_max")
    private WebElement priceMax;

    @AndroidFindBy(id = "com.banggood.client:id/btn_done")
    private WebElement doneBtn;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView//android.widget.FrameLayout//android.view.ViewGroup")
    private WebElement firstProduct;
    public void clickFilter(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        webDriverWait.until(ExpectedConditions.visibilityOf(filter));
        filter.click();
    }

    public void inputPriceMin(String price){
        webDriverWait.until(ExpectedConditions.visibilityOf(priceMin));
        priceMin.sendKeys(price);
    }

    public void inputPriceMax(String price){
        webDriverWait.until(ExpectedConditions.visibilityOf(priceMax));
        priceMax.sendKeys(price);
    }

    public void clickDoneBtn(){
        webDriverWait.until(ExpectedConditions.visibilityOf(doneBtn));
        doneBtn.click();
    }

    public void clickFirstProduct(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        webDriverWait.until(ExpectedConditions.visibilityOf(firstProduct));
        firstProduct.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }






}
