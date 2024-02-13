package page;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FirstCategoryOfHotCategoriesPage extends AppiumBase {

    public FirstCategoryOfHotCategoriesPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView//android.widget.FrameLayout")
    private WebElement firstProduct;



    public void clickfirstProduct(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        webDriverWait.until(ExpectedConditions.visibilityOf(firstProduct));
        firstProduct.click();
    }


}
