package br.com.accenture.automations.constants;

import java.util.Arrays;

public enum BrowserType {
	CHROME("chrome"),
	EDGE("edge"),
	FIREFOX("firefox");

	private final String description;

	BrowserType(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return description;
	}

	public boolean is(String browserName) {
		if (browserName == null) {
			return false;
		}

		return description.equalsIgnoreCase(browserName);
	}

	public static BrowserType get(String browserName) {
		return Arrays.stream(BrowserType.values())
				.filter(browserType -> browserType.is(browserName))
				.findFirst()
				.orElse(null);
	}
}
