package br.com.accenture.automations.step_definitions;

import br.com.accenture.automations.actions.ContactUsAction;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class ContactUsStepsPT {

	private ContactUsAction contact_us_action;

	public ContactUsStepsPT(ContactUsAction contact_us_action) {
		this.contact_us_action = contact_us_action;
	}

	@Dado("que eu acessei a página Contact us")
	public void que_eu_acessei_a_pagina_contact_us() {
		contact_us_action.navigateTo_WebDriverUniversity_Contact_Us_Page();
	}
	@Quando("eu insiro um nome exclusivo")
	public void eu_insiro_um_nome_exclusivo() {
		contact_us_action.setUnique_FirstName();
	}
	@Quando("eu insiro um sobrenome único")
	public void eu_insiro_um_sobrenome_unico() {
		contact_us_action.setUnique_LastName();
	}
	@Quando("eu insiro um endereço de e-mail exclusivo")
	public void eu_insiro_um_endereco_de_e_mail_exclusivo() {
		contact_us_action.setUnique_EmailAddress();
	}
	@Quando("eu insiro um comentário único")
	public void eu_insiro_um_comentario_unico() {
		contact_us_action.setUnique_Comment();
	}
	@Quando("eu clico no botão enviar")
	public void eu_clico_no_botao_enviar() {
		contact_us_action.clickOn_Submit_Button();
	}
	@Entao("devo receber uma mensagem de envio de contato bem-sucedida")
	public void devo_receber_uma_mensagem_de_envio_de_contato_bem_sucedida() {
		contact_us_action.validate_Successful_SubmissionMessage_Text();
	}
	@Quando("eu insiro um nome específico {word}")
	public void eu_insiro_um_nome_especifico(String firstName) {
		contact_us_action.setSpecific_FirstName(firstName);
	}
	@Quando("eu insiro um sobrenome específico {word}")
	public void eu_insiro_um_sobrenome_especifico(String lastName) {
		contact_us_action.setSpecific_LastName(lastName);
	}
	@Quando("eu insiro um endereco de e-mail específico {word}")
	public void eu_insiro_um_endereco_de_e_mail_especifico(String email) {
		contact_us_action.setSpecific_EmailAddress(email);
	}
	@Quando("eu insiro um comentário específico {string}")
	public void eu_insiro_um_comentario_especifico(String comment) {
		contact_us_action.setSpecific_Comment(comment);
	}

}
