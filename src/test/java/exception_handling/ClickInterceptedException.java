package exception_handling;

import java.time.Duration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickInterceptedException {

	private static WebDriver driver;

	@BeforeAll
	static void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}

	@Test
	public void googleSearch() {
		// Typing search keyword
		driver.findElement(By.name("q")).sendKeys("facebook");
		// Locating first suggestion button and click on it. Why first suggestion bcz
		// whatever we type hat will come always at first
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement ele = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@role = 'option']//span)[1]")));
		ele.click();
		Assert.assertTrue(ExpectedConditions.titleContains("facebook").apply(driver).booleanValue());
	}

	@AfterAll
	static void tearDown() {
		driver.quit();
	}
}