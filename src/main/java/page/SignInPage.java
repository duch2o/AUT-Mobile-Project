package page;

import core.AppiumBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends AppiumBase {
    public SignInPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.banggood.client:id/et_email")
    private WebElement emailEdittext;

    @AndroidFindBy(id = "com.banggood.client:id/et_pwd")
    private WebElement passwordEdittext;

    @AndroidFindBy(id = "com.banggood.client:id/btn_sign_in")
    private WebElement signInBtn;

    public boolean verifyEmailEditTextDisplayed(){
        webDriverWait.until(ExpectedConditions.visibilityOf(emailEdittext));
        return emailEdittext.isDisplayed();
    }

    public boolean verifyPasswordEditTextDisplayed(){
        webDriverWait.until(ExpectedConditions.visibilityOf(passwordEdittext));
        return passwordEdittext.isDisplayed();
    }

    public boolean verifySignInButtonDisplayed(){
        webDriverWait.until(ExpectedConditions.visibilityOf(signInBtn));
        return signInBtn.isDisplayed();
    }


}
