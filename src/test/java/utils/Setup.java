package utils;

import org.openqa.selenium.WebDriver;

/**
 * This class is used to start driver
 */
public class Setup {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		Setup.driver = driver;
	}
}
