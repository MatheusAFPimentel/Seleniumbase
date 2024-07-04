package br.com.accenture.automations.actions;

import br.com.accenture.automations.utils.SeleniumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static br.com.accenture.automations.page_objects.LoginPageObject.*;

public class LoginAction extends SeleniumUtils {
	private static final Logger logger = LoggerFactory.getLogger(LoginAction.class);

	public LoginAction() {
		super();
	}
	public void navigateTo_WebDriver_University_Login_Page(){
		navigateToURL("https://www.webdriveruniversity.com/Login-Portal/index.html?");
		logger.warn("Página acessada com sucesso");
		System.out.println("print Página acessada com sucesso");
	}
	public void setUsername(String userName){
		sendKeys(userName_TextField,userName);
		logger.info("Nome colocado com sucesso!");
		System.out.println("print Nome colocado com sucesso");
	}

	public void setPassword(String password) {
		sendKeys(password_TextField, password);
		logger.info("Senha colocada com sucesso!");
		System.out.println("ptint Senha colocada com sucesso!");
	}

	public void clickOn_Login_Button() {
		waitForWebElementAndClick(login_Button);
		logger.error("Botão Apertado com sucesso!");
		System.out.println("pitnt Botão Apertado com sucesso!");
	}

	public void validate_SuccessfulLogin_Message() throws InterruptedException{
		waitForAlert_And_ValidateText("validation succeeded");
		Thread.sleep(3000);
	}

	public void validate_UnsuccessfulLogin_Message() throws InterruptedException {
		waitForAlert_And_ValidateText("validation failed");
		Thread.sleep(3000);
	}
}
