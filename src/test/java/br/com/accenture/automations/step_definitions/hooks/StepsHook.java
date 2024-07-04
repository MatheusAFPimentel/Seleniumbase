package br.com.accenture.automations.step_definitions.hooks;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Timestamp;

import static br.com.accenture.automations.webdriver.WebDriverManager.cleanupDriver;
import static br.com.accenture.automations.webdriver.WebDriverManager.getDriver;

public class StepsHook {
	@Before
	public void setup() {
		getDriver();
	}

	private String getFilename() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		return timestamp.getTime() + ".png";
	}

	@AfterStep("not @robot")
	public void captureExceptionImage(Scenario scenario) {
		String filename = getFilename();

		byte[] screenshot = ((TakesScreenshot) getDriver())
				.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", filename);
	}

	@AfterStep("@robot")
	public void captureImageRobot(Scenario scenario) throws AWTException {
		String filename = getFilename();

		Robot robot = new Robot();
		BufferedImage screenShotRobot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ByteArrayOutputStream bass = new ByteArrayOutputStream();

		try {
			ImageIO.write(screenShotRobot, "png", bass);
		} catch (IOException e){
			e.printStackTrace();
		}

		byte[] screenShot = bass.toByteArray();
		scenario.attach(screenShot, "image/png", filename);
	}

	@After
	public void tearDown() {
		cleanupDriver();
	}
}
