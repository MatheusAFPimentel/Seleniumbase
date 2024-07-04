package br.com.accenture.automations.step_definitions;

import br.com.accenture.automations.actions.HomeAction;
import br.com.accenture.automations.page_objects.HomePageObject;
import br.com.accenture.automations.utils.SeleniumUtils;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class BasicSteps extends SeleniumUtils {

    private HomeAction homeAction;
    private HomePageObject homePage;
    private SeleniumUtils seleniumUtils;

    public BasicSteps(HomeAction homeAction) {
        this.homeAction = homeAction;
    }

    @Dado("que esteja na pagina desejada")
    public void que_esteja_na_pagina_desejada() {
        homeAction.navigateToGoogle();
    }

    @Quando("Pesquisar {string}")
    public void pesquisar(String string) {
        homeAction.pesquisar("Santa Cruz");
    }

    @Entao("deve ser mostrado o texto da {string}")
    public void deve_ser_mostrado_o_texto_da(String string) {
       // waitForAlert_And_ValidateText(string);
    }
}
