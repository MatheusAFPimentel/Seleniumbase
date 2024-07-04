package br.com.accenture.automations.step_definitions;

import br.com.accenture.automations.actions.LoginAction;
import br.com.accenture.automations.utils.SeleniumUtils;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class LoginStepsPT extends SeleniumUtils {
	private LoginAction login_action;

	public LoginStepsPT(LoginAction login_action ) {
		this.login_action = login_action;
	}

	@Dado("que eu acesso a página de login")
	public void que_eu_acesso_a_pagina_de_login() {
		login_action.navigateTo_WebDriver_University_Login_Page();
	}
	@Quando("eu insiro o nome de usuário {}")
	public void eu_insiro_o_nome_de_usuario(String username) {
		login_action.setUsername(username);
	}
	@Quando("eu insiro uma senha {}")
	public void eu_insiro_uma_senha(String password) {
		login_action.setPassword(password);
	}
	@Então("deve ser apresentada a mensagem de login bem-sucedida")
	public void deve_ser_apresentada_a_mensagem_de_login_bem_sucedida() throws InterruptedException {
		login_action.clickOn_Login_Button();
		login_action.validate_SuccessfulLogin_Message();
	}
	@Então("deve ser apresentada a mensagem de login sem sucesso")
	public void deve_ser_apresentada_a_mensagem_de_login_sem_sucesso() throws InterruptedException {
		login_action.clickOn_Login_Button();
		login_action.validate_UnsuccessfulLogin_Message();
	}
	@Então("deve ser apresentada a mensagem de validação de login {}")
	public void deve_ser_apresentada_a_mensagem_de_validacao_de_login(String expectedMessage) throws InterruptedException {
		login_action.clickOn_Login_Button();
		waitForAlert_And_ValidateText(expectedMessage);
	}
}
