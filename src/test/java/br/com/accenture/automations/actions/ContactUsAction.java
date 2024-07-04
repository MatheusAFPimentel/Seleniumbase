package br.com.accenture.automations.actions;
import br.com.accenture.automations.utils.SeleniumUtils;
import org.junit.Assert;

import static br.com.accenture.automations.page_objects.ContactUsPageObject.*;

public class ContactUsAction extends SeleniumUtils {

	public ContactUsAction(){
		super();
	}
	public void navigateTo_WebDriverUniversity_Contact_Us_Page() {
		navigateToURL("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
	}

	public void setUnique_FirstName() {
		sendKeys(firstName_TextField, "AutoFN" + generateRandomNumber(5));
	}

	public void setUnique_LastName() {
		sendKeys(lastName_TextField, "AutoLN" + generateRandomNumber(5));
	}

	public void setUnique_EmailAddress() {
		sendKeys(emailAddress_TextField, "AutoEmail" + generateRandomNumber(10) + "@mail.com");
	}

	public void setUnique_Comment() {
		sendKeys(comment_TextField, "Hello world " + generateRandomString(20));
	}

	public void setSpecific_FirstName(String firstName) {
		sendKeys(firstName_TextField, firstName);
	}

	public void setSpecific_LastName(String lastName) {
		sendKeys(lastName_TextField, lastName);
	}

	public void setSpecific_EmailAddress(String emailAddress) {
		sendKeys(emailAddress_TextField, emailAddress);
	}

	public void setSpecific_Comment(String comment) {
		sendKeys(comment_TextField, comment);
	}

	public void clickOn_Submit_Button() {
		waitForWebElementAndClick(submit_Button);
	}

	public void validate_Successful_SubmissionMessage_Text() {
		waitFor(successfulSubmission_Message_Text);
		Assert.assertEquals(getDriver().findElement(successfulSubmission_Message_Text).getText(), "Thank You for your Message!");
	}
}
