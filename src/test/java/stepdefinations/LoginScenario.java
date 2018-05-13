package stepdefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import pages.LoginPage;
import utility.Hook;

public class LoginScenario {

	private LoginPage loginPage;

	public LoginScenario() {
		this.loginPage = new LoginPage(Hook.getDriver());
	}
	
	@Given("^我開啟登入頁")
	public void i_open_the_application() throws Throwable {

	}

	@When("^我在帳號輸入 \"([^\"]*)\"")
	public void i_type_on_loginId(String loginId) throws Throwable {
		this.loginPage.loginId.sendKeys(loginId);
	}

	@And("^我在密碼輸入 \"([^\"]*)\"")
	public void i_type_on_password(String password) throws Throwable {
		this.loginPage.loginPassword.sendKeys(password);

	}

	@And("^我點擊登入")
	public void i_tap_login() throws Throwable {
		this.loginPage.login.click();
	}

	@Then("^Result 會顯示:\"([^\"]*)\"")
	public void i_validate_result(String result) throws Throwable {

		Assert.assertEquals(result, this.loginPage.result.getText());
	}
}
