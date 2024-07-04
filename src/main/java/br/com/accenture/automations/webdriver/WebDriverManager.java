package br.com.accenture.automations.webdriver;

import br.com.accenture.automations.constants.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class WebDriverManager {
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		if (webDriver.get() == null) {
			webDriver.set(createDriver());
		}
		return webDriver.get();
	}

	private static WebDriver createDriver() {
		WebDriver driver = null;

		switch (getBrowserType()) {
			case CHROME: {
				ClassLoader classLoader = WebDriverManager.class.getClassLoader();
				//String extension = Objects.requireNonNull(classLoader.getResource("extensions/salesforce_inspector.crx")).getFile();

				ChromeOptions options = new ChromeOptions();
				options.addArguments("test-type");
				options.addArguments("--disable-popup-blocking");
				options.addArguments("--disable-web-security");
				options.addArguments("--disable-notifications");
				options.addArguments("--disable-session-crashed-bubble");
				options.addArguments("--profile-directory=Default");
				options.addArguments("--user-data-dir=C:/Temp/ChromeProfile");
				//options.addExtensions(new File(extension));
//				options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				// setup the chromedriver using WebDriverManager
				io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();

				// Create driver object for Chrome
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				break;
			}
			case FIREFOX:{
				// setup the Firefox using WebDriverManager
				io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
				// Create driver object
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				break;
			}
		}
		assert driver != null;
		driver.manage().window().maximize();
		return driver;
	}

	private static BrowserType getBrowserType() {
		String browserName = null;

		try {
			Properties properties = new Properties();
//			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/br.com.accenture.btg_automation.properties/config.br.com.accenture.btg_automation.properties");
			InputStream file = WebDriverManager.class.getResourceAsStream("/config.properties");
			properties.load(file);
			browserName = properties.getProperty("browser").trim();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		return BrowserType.get(browserName);
	}

	public static void cleanupDriver() {
		if (webDriver != null && webDriver.get() != null) {
			webDriver.get().quit();
			webDriver.remove();
		}
	}
}
