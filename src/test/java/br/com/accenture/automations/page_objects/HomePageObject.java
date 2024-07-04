package br.com.accenture.automations.page_objects;

import org.openqa.selenium.By;

public class HomePageObject {
	public static By userNameSalesForce = By.id("username");
	public static By passwordSalesForce = By.id("password");
	public static By btnLonginSalesForce = By.id("Login");
	public static By btnIndicadorAplicativos = By.xpath("//button[contains(@data-aura-class,'salesforceIdentityAppLauncherHeader')]");
	public static By campoPesquisarIndicadorAplicativos = By.xpath("//input[@type='search'][@placeholder='Pesquisar aplicativos e itens…']");
	public static By btnMenuNavegacao = By.xpath("//button[@aria-label='Mostrar Menu de navegação']");
	public static By btnNovoSeguroOffshore = By.xpath("//div[contains(@class,'action-template')]");
	public static By lablePaginaSelecaoProduto = By.xpath("//h1[text()='Seleção de Produto']");
	public static By btnCloseTab = By.xpath("//button[contains(@title, 'Fechar')]");

	public static By campoPesquisa = By.xpath("//div[contains(@class, 'RNNXgb')]//input");


	public static By abaMenuNavegacao(String aba){
		return By.xpath("//a[@data-label='"+aba+"']//parent::div");
	}
	public static By btnAplicativosPesquisa(String boletador){
		return By.xpath("//b[text()='"+boletador+"']//ancestor::div[@aria-label='Aplicativos']");
	}
	public static By lableNomeBoletador(String boletador){
		return By.xpath("//div[@class='appName slds-context-bar__label-action slds-context-bar__app-name']//span[text()='"+boletador+"']");
	}

}
