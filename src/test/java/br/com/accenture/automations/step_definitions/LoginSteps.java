package br.com.accenture.automations.step_definitions;

import br.com.accenture.automations.actions.LoginAction;
import br.com.accenture.automations.utils.SeleniumUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends SeleniumUtils {
	private LoginAction login_action;
	public LoginSteps(LoginAction login_action ) {
		this.login_action = login_action;
	}

	@Given("I access the webdriver university login page")
	public void i_access_the_webdriver_university_login_page() {
		login_action.navigateTo_WebDriver_University_Login_Page();
	}

	@When("I enter a username {}")
	public void i_enter_a_username(String username) {
		login_action.setUsername(username);
	}

	@And("I enter a password {string}")
	public void i_enter_a_password(String password) {
		login_action.setPassword(password);
	}

	@Then("I should be presented with the successful login message")
	public void i_should_be_presented_with_the_successful_login_message() throws InterruptedException {
		login_action.clickOn_Login_Button();
		login_action.validate_SuccessfulLogin_Message();
	}

	@Then("I should be presented with the unsuccessful login message")
	public void i_should_be_presented_with_the_unsuccessful_login_message() throws InterruptedException {
		login_action.clickOn_Login_Button();
		login_action.validate_UnsuccessfulLogin_Message();
	}

	@Then("I should be presented with the following login validation message {}")
	public void i_should_be_presented_with_the_following_login_validation_message(String expectedMessage) throws InterruptedException {
		login_action.clickOn_Login_Button();
		waitForAlert_And_ValidateText(expectedMessage);
	}
}
