package br.com.accenture.automations.page_objects;

import org.openqa.selenium.By;

public class ContactUsPageObject {
	public static By firstName_TextField = By.xpath("//input[@name='first_name']");
	public static By lastName_TextField = By.xpath("//input[@name='last_name']");
	public static By emailAddress_TextField = By.xpath("//input[@name='email']");
	public static By comment_TextField = By.xpath("//textarea[@name='message']");
	public static By submit_Button = By.xpath("//input[@value='SUBMIT']");
	public static By successfulSubmission_Message_Text = By.xpath("//div[@id='contact_reply']/h1");
}
