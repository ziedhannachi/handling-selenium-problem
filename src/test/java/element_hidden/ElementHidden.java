package element_hidden;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementHidden {

	private static WebDriver driver;

	@BeforeAll
	static void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void handleElementHidden() {

		// identify element and click
		driver.findElement(By.id("hide-textbox")).click();

		// Javascript executor class with executeScript method
		JavascriptExecutor j = (JavascriptExecutor) driver;

		// identify element and set value
		j.executeScript("document.getElementById('displayed-text').value='Selenium';");
		String s = (String) j.executeScript("return document.getElementById('displayed-text').value");
		System.out.print("Value entered in hidden field: " + s);
	}

	@AfterAll
	static void tearDown() {
		driver.quit();
	}

}
