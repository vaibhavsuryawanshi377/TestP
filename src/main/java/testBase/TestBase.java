package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");

			String os = System.getProperty("os.name").toLowerCase();
			if (os.contains("linux")) {
			    options.addArguments("--headless=new");
			    options.addArguments("--no-sandbox");
			    options.addArguments("--disable-dev-shm-usage");
			    options.addArguments("--disable-gpu");
			    options.addArguments("--user-data-dir=/tmp/chrome-profile");
			} else {
			    // Windows or Mac – don’t add Linux-only args
			    options.addArguments("--start-maximized");
			}
			driverInstance = new ChromeDriver(options);
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
		driver.get("https://dev-company3.pace-os.com/");
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
