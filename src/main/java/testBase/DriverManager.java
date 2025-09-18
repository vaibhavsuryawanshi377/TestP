package testBase;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		if (tlDriver.get() == null) {
			throw new IllegalStateException("WebDriver is not set. Please initialize before use.");
		}
		return tlDriver.get();
	}

	public static void setDriver(WebDriver instance) {
		tlDriver.set(instance);
	}

	public static void unload() {
		tlDriver.remove();
	}

}
