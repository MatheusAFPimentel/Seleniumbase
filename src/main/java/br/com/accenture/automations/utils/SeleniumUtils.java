package br.com.accenture.automations.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.com.accenture.automations.webdriver.WebDriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class SeleniumUtils {

	private static final Logger logger = LoggerFactory.getLogger(SeleniumUtils.class);

	public  SeleniumUtils() {
		PageFactory.initElements(getDriver(),this);
	}
	public WebDriver getDriver() {
		return WebDriverManager.getDriver();
	}

	public void navigateToURL(String url){
		getDriver().get(url);
		logger.info("Navigate to URL");
	}

	public String generateRandomNumber(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	public String generateRandomString(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	/**Método responsável pelo preenchimento de campos do tipo INPUT. Utiliza o By
	 * para localizar o componente.
	 * @param by Locator do elemento
	 * @param textToType Valor a ser preenchido no campo
	 */
	public  void sendKeys(By by, String textToType) {
		WebElement element;
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(by));
			element = getDriver().findElement(by);
			element.clear();
			element.sendKeys(textToType.trim());
			logger.debug("Ação sendKeys no elemento {} realizada com sucesso!", by);
		}catch (Exception e){
			logger.error("Ação sendKeys, elemento - {} não encontrado: {}", by, e);
			Assertions.fail("Ação sendKeys, elemento" + by+ "não encontrado: " + e);
		}

	}
	public void waitFor(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
			logger.debug("Elemento {} presente na página!", by);
		}catch (Exception e){
			logger.error("Elemento - {} não encontrado: {}", by, e);
			Assertions.fail("Elemento" + by+ "não encontrado: " + e);
		}
	}
	/**Verificar se após determinado tempo irá ser exibido um alerta na tela e validar a sua mensagem
	 * @param text mensagem que deverá ser exibida no alerta
	 */
	public void waitForAlert_And_ValidateText(String text) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
		String alert_Message_Text = getDriver().switchTo().alert().getText();
		Assertions.assertEquals(alert_Message_Text, text);
		Thread.sleep(3000);

	}

	/**Verificar se após determinado tempo, o elemento não está sendo mais exibido em tela, ira retornar true se o
	 * elemento não está sendo exibido, e false se ainda está sendo exibido
	 * @param by Locator do elemento
	 * @param tempoEspera Tempo maximo de espera para elemento ser exibido na página em segundos
	 * @param scrollToView se for true o elemento irá ser focado
	 * @return boolean
	 */
	public boolean isElementPresent(By by, int tempoEspera, boolean scrollToView){
		boolean isPresent;
		try{
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(tempoEspera));
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			WebElement element = getDriver().findElement(by);
			if(scrollToView){
				((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
				logger.debug("Ação scroll no elemento {} realizada com sucesso!", by);
			}
			isPresent = true;

		}catch (Exception e){
			isPresent = false;
		}
		return  isPresent;
	}

	/**Espera por um elemento por 60 segundos e realiza um click
	 * @param by elemento para ser clicado
	 */
	public void waitForWebElementAndClick(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	/**
	 * Realizar uma ação de click em um elemento através do javascript
	 * @param locator Locator do elemento
	 * @param time Tempo maximo de espera para elemento ser exibido na página
	 */
	public  void clickjs( By locator, int time) {
		WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
		wait1.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait1.until(ExpectedConditions.elementToBeClickable(locator));
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", getDriver().findElement(locator));
	}
	/**Ir para um determinado elemento da página utilizando javascript para ele se tornar visível no navegador
	 * @param by Locator do elemento
	 * @param tempoEspera Tempo maximo de espera para elemento ser exibido na página
	 */
	public  void scrollToElement(By by, int tempoEspera) {
		boolean isPresente = isElementPresent(by, tempoEspera,false);

		if (isPresente) {
			WebElement element = getDriver().findElement(by);
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
			logger.debug("Scroll realizado com sucesso para o elemnto {}!", by);
		} else {
			logger.error("Erro ao obter o elemnto {} para realizar scroll", by);
			Assertions.fail("Erro ao obter o elemento " +by+ " para realizar scroll");
		}
	}

	/**Retorna valor de um determinado atributo de um WebElement
	 * <p>
	 * <b>Exemplo:</b> getAtributo(driver, PageObjectCasos.dataInicioSLA, "innerText", 20);
	 * <p>
	 * <b>Exemplo:</b> getAtributo(driver, PageObjectCaso.data, "value", 40)
	 * <p>
	 * <b>Exemplo:</b> getAtributo(driver, PageObjectCaso.checkbox, "checked", 40)
	 *
	 * @param by Locator do elemento
	 * @param atributo Atributo que se deseja obter
	 * @param tempoEspera Tempo maximo de espera para elemento ser exibido na página
	 * @return {@link String}
	 */
	public  String getAtributo(By by, String atributo,int tempoEspera) {
		boolean isPresente = isElementPresent(by, tempoEspera,false);
		String valorObtido = "";

		if (isPresente) {
			WebElement element = getDriver().findElement(by);
			valorObtido = element.getAttribute(atributo);
			logger.debug("Atributo verificado com sucesso!");
		} else {
			logger.error("Erro ao procurar elemento");
			Assertions.fail("Erro ao procurar elemento");
		}
		return valorObtido;
	}

}
