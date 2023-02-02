package qrCode;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleQRCode {

	private static WebDriver driver;

	@BeforeAll
	static void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://eliasnogueira.github.io/selenium-read-qrcode/");
	}

	@Test
	public void QRCodeTestSelenium() throws NotFoundException, IOException {

		// Find the element using its locator
		String src = driver.findElement(By.id("qr")).getAttribute("src");
		System.out.println("image url is : " + src);

		// Create an object for the URL class, using the src value
		URL urlOfImage = new URL(src);
		
		// Pass the URL class object to the ImageIO.read() method
		BufferedImage bufferedImage = ImageIO.read(urlOfImage);

		// Clear all the other parts in the image and convert the image into a bitmap
		LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

		Result result = new MultiFormatReader().decode(bitmap);
		
		// Get the qr code content and assert the result
		String qrCodeResult = result.getText();
		assertThat(qrCodeResult).isEqualTo("c72a0de5-eba3-4bf0-bde2-fc709e71df29");
	}

	@AfterAll
	static void tearDown() {
		driver.quit();
	}

}


