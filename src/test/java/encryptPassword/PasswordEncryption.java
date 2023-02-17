package encryptPassword;

import java.util.Base64;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PasswordEncryption {
	
	private static WebDriver driver;

	@BeforeAll
	static void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}

	@Test
	public void login() {
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.id("login-button"));
		
		username.sendKeys("standard_user");
		System.out.println(encoderString("secret_sauce"));
		password.sendKeys(encoderString("secret_sauce"));
		login.click();
	}

	@AfterAll
	static void tearDown() {
		driver.quit();
	}
	
    /**
     * method Encoder string : Une méthode pour chiffrer les données.
     *
     * @param realStr
     * @return string
     */
    public static String encoderString(String realStr)
    {
        byte[] encodedStr = Base64.getEncoder().encode(realStr.getBytes());
        return (new String(encodedStr));
    }

    /**
     * method Decoder string :Une méthode pour déchiffrer les données.
     *
     * @param encodedStr
     * @return string
     */
    public static String decoderString(String encodedStr)
    {
        byte[] decoderString = Base64.getDecoder().decode(encodedStr.getBytes());
        return (new String(decoderString));
    }

}
