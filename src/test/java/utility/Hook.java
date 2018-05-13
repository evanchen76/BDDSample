/**
 * 
 */
package utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Hook {

	public enum TestPlatform{
		Android,
		iOS
	}

	public static TestPlatform platform;
	public static AppiumDriver driver;

	
	@Before()
	public void setUpAppium() throws MalformedURLException
	{
		if ( Hook.platform == TestPlatform.Android) {
			//Android
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0"); //作業系統版本
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); //手機DeviceId
			cap.setCapability(MobileCapabilityType.APP, "/Users/Evan/app-debug.apk"); //要測試的APK路徑
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap); //AppiumDriver位址
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}else{
			//iOS 模擬器

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS"); //平台
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.1"); //作業系統版本
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8"); //手機名稱
			cap.setCapability(MobileCapabilityType.APP, "app.ipa"); //要測試的ipa路徑
			driver = new IOSDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap); //AppiumDriver位址
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			//iOS 實機測試

//			DesiredCapabilities cap = new DesiredCapabilities();
//			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
//			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS"); //平台
//			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.1"); //作業系統版本
//			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Evan's iPhone"); //手機名稱
//			cap.setCapability(MobileCapabilityType.UDID, "xxxxx"); //UDID
//			cap.setCapability("xcodeOrgId",  "<TeamId>"); //Team ID
//			cap.setCapability("xcodeSigningId",  "iPhone Developer"); //SigningId
//			cap.setCapability("useNewWDA", true);
//			cap.setCapability(MobileCapabilityType.FULL_RESET, true);
//			cap.setCapability(MobileCapabilityType.APP, "/Users/Evan/Documents/projects/ui_test/ui_test_project/app.ipa"); //要測試的ipa路徑
//
//			driver = new IOSDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap); //AppiumDriver位址
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	@After()
	public void tearDown()
	{
		driver.quit();

	}

	public static void setPlatform(TestPlatform platform)
	{
		Hook.platform = platform;
	}

	public static AppiumDriver getDriver(){

		return driver;
	}

}
