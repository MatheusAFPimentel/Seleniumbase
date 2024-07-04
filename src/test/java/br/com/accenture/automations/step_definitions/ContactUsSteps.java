package br.com.accenture.automations.step_definitions;

import br.com.accenture.automations.actions.ContactUsAction;
import br.com.accenture.automations.utils.SeleniumUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsSteps extends SeleniumUtils {

	private ContactUsAction contact_us_action;

	public ContactUsSteps(ContactUsAction contact_us_action) {
		this.contact_us_action = contact_us_action;
	}

	@Given("I access the webdriver university contact us page")
	public void i_access_the_webdriver_university_contact_us_page() {
		contact_us_action.navigateTo_WebDriverUniversity_Contact_Us_Page();

	}

	@When("I enter a unique first name")
	public void i_enter_a_unique_first_name() {
		contact_us_action.setUnique_FirstName();
	}

	@And("I enter a unique last name")
	public void i_enter_a_unique_last_name() {
		contact_us_action.setUnique_LastName();
	}

	@And("I enter a unique email address")
	public void i_enter_a_unique_email_address() {
		contact_us_action.setUnique_EmailAddress();
	}

	@And("I enter a unique comment")
	public void i_enter_a_unique_comment() {
		contact_us_action.setUnique_Comment();
	}

	@When("I enter a specific first name {word}")
	public void i_enter_a_specific_first_name(String firstName) {
		contact_us_action.setSpecific_FirstName(firstName);
	}

	@When("I enter a specific last name {word}")
	public void i_enter_a_specific_last_name(String lastName) {
		contact_us_action.setSpecific_LastName(lastName);
	}

	@When("I enter a specific email address {word}")
	public void i_enter_a_specific_email_address(String email) {
		contact_us_action.setSpecific_EmailAddress(email);
	}

	@When("I enter a specific comment {string}")
	public void i_enter_a_specific_comment(String comment) {
		contact_us_action.setSpecific_Comment(comment);
	}

	@And("I click on the submit button")
	public void i_click_on_the_submit_button() {
		contact_us_action.clickOn_Submit_Button();
	}

	@Then("I should be presented with a successful contact us submission message")
	public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
		contact_us_action.validate_Successful_SubmissionMessage_Text();
	}
}
