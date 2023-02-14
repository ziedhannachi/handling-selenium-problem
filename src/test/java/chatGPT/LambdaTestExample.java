package chatGPT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LambdaTestExample {
	public static void main(String[] args) throws Exception {

		// Set LambdaTest credentials
		String username = "yourLambdaTestUsername";
		String accesskey = "yourLambdaTestAccessKey";

		// Set ChromeDriver executable path
		System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

		// Define ChromeOptions with LambdaTest capabilities
		ChromeOptions options = new ChromeOptions();
		options.setCapability("platform", "Windows 10");
		options.setCapability("browserName", "Chrome");
		options.setCapability("version", "latest");
		options.setCapability("name", "LambdaTestExample");
		options.setCapability("username", username);
		options.setCapability("accessKey", accesskey);

		// Create WebDriver instance with ChromeOptions
		WebDriver driver = new ChromeDriver(options);

		// Navigate to google.com and print page title
		driver.get("https://www.google.com");
		System.out.println("Page title is: " + driver.getTitle());

		// Use Robot class to simulate key press of "Ctrl" + "P" to open print dialog
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_P);

		// Wait for print dialog to open
		Thread.sleep(5000);

		// Close print dialog by pressing "Esc" key
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);

		// Quit driver
		driver.quit();
	}
}