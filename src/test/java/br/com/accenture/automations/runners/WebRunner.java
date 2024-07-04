package br.com.accenture.automations.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@ContextConfiguration
@CucumberOptions(
		features = "classpath:features",
		glue = {"br.com.accenture.automations.step_definitions"},
		monochrome = true,
		tags = "@Google",
		plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class WebRunner {

}
