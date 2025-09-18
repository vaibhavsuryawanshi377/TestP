package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {

	@Parameters({ "browser" })
	@BeforeMethod
	public void setUp(String browser) {
		WebDriver driverInstance = null;

		switch (browser.toLowerCase()) {
		case "chrome":
			driverInstance = new ChromeDriver();
			break;
		case "edge":
			driverInstance = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Invalid browser: " + browser);
		}

		DriverManager.setDriver(driverInstance);

		WebDriver driver = DriverManager.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		driver.get("https://www.flipkart.com");
	}

	@AfterMethod
	public void tearDown() {
		WebDriver driver = DriverManager.getDriver();
		if (driver != null) {
			driver.quit();
			DriverManager.unload();
		}
	}

}
