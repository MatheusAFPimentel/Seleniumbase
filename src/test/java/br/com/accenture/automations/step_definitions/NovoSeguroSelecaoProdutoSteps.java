package br.com.accenture.automations.step_definitions;

import br.com.accenture.automations.actions.HomeAction;
import br.com.accenture.automations.utils.SeleniumUtils;
import io.cucumber.java.pt.E;

public class NovoSeguroSelecaoProdutoSteps extends SeleniumUtils {

	private HomeAction homeAction;

	public NovoSeguroSelecaoProdutoSteps(HomeAction homeAction){
		this.homeAction = homeAction;
	}

	@E("eu fecho a aba aberta")
	public void eu_fecho_a_aba_aberta() throws InterruptedException {
		homeAction.closeAllTabs();
		Thread.sleep(1500);
	}

}
