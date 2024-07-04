package br.com.accenture.automations.actions;
import br.com.accenture.automations.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static br.com.accenture.automations.page_objects.HomePageObject.*;

public class HomeAction extends SeleniumUtils {
	private static final Logger logger = LoggerFactory.getLogger(HomeAction.class);

	public HomeAction() {
		super();
	}

	public void navigateToGoogle() {
		navigateToURL("https://google.com");
		logger.info("google");
	}

	/** Função para apagar as abas do site
	 * para localizar o componente.
	 *
	 */

	public void closeAllTabs() throws InterruptedException {
		boolean isPresent = isElementPresent(btnCloseTab, 10, false);
		Thread.sleep(5000);

		if (isPresent) {
			List<WebElement> tabButtons = getDriver().findElements(btnCloseTab);

			for (WebElement tabButton : tabButtons) {
				tabButton.click();
			}
		}
	}

	public void pesquisar(String text) {
		waitForWebElementAndClick(By.xpath("//div[contains(@class, 'RNNXgb')]//input"));
		sendKeys(By.xpath("//div[contains(@class, 'RNNXgb')]//input"), text + Keys.ENTER);
	}

	public void encontrarTextoPesquisa(String text) {
		//waitForAlert_And_ValidateText(text);
	}
}
