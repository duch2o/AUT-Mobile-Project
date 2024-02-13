package page;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CategoryPage extends AppiumBase {
    public CategoryPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home and Garden']")
    private WebElement homeAndGardenNav;



    public void clickHOmeAndGardenNav(){
        webDriverWait.until(ExpectedConditions.visibilityOf(homeAndGardenNav));
        homeAndGardenNav.click();
    }


}
