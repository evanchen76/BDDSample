package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    public LoginPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
    }

    @iOSFindBy(accessibility = "loginId")
    @AndroidFindBy(id = "loginId")
    public MobileElement loginId;

    @iOSFindBy(accessibility = "loginPassword")
    @AndroidFindBy(id = "loginPassword")
    public MobileElement loginPassword;

    @iOSFindBy(accessibility = "login")
    @AndroidFindBy(id = "login")
    public MobileElement login;

    @iOSFindBy(accessibility = "result")
    @AndroidFindBy(id = "result")
    public MobileElement result;

}
