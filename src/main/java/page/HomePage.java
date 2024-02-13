package page;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AppiumBase {

    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Category']")
    private WebElement categoryMenuBar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Hot Categories']")
    private WebElement hotCategoriesLabel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Hot Categories']//following-sibling::androidx.recyclerview.widget.RecyclerView//android.widget.FrameLayout")
    private WebElement firstCatogoryOfHotCategories;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Account']")
    private WebElement accountMenuBar;



    public void clickCategoryMenuBar(){
        webDriverWait.until(ExpectedConditions.visibilityOf(categoryMenuBar));
        categoryMenuBar.click();
    }

    public void clickAccountMenuBar(){
        webDriverWait.until(ExpectedConditions.visibilityOf(accountMenuBar));
        accountMenuBar.click();
    }

    public void scollToHotCategories(){
        swipeUpUntil(driver,hotCategoriesLabel);
    }

    public void clickFirstCategoryOfHotCategories(){
        webDriverWait.until(ExpectedConditions.visibilityOf(firstCatogoryOfHotCategories));
        firstCatogoryOfHotCategories.click();
    }






}
