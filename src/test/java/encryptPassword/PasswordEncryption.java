package encryptPassword;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.SeleniumUtils;

public class PasswordEncryption {
	
	private static WebDriver driver;

	@BeforeAll
	static void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}

	@Test
	public void googleSearch() {
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.id("login-button"));
		
		username.sendKeys("standard_user");
		password.sendKeys(SeleniumUtils.decoderString("secret_sauce"));
		login.click();
	}

	@AfterAll
	static void tearDown() {
		driver.quit();
	}

}
