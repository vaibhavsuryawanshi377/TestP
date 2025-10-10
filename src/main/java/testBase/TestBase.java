package testBase;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

	 @Parameters({ "browserstack", "browser", "browserVersion", "os", "osVersion" })
	    @BeforeMethod
	    public void setUp(
	            @Optional("false") String browserstack,
	            @Optional("chrome") String browser,
	            @Optional("latest") String browserVersion,
	            @Optional("Windows") String os,
	            @Optional("11") String osVersion) throws MalformedURLException {
		 
		 WebDriver driverInstance;
		 if(Boolean.parseBoolean(browserstack)) {
			 
    	 // BrowserStack credentials
        String username = "vaibhavsuryawans_Z05sin";
        String accessKey = "pgfuK3NqJxeNvb66oyVb";
        String hubURL = "https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";

        // Desired capabilities
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("browserName", browser);
        caps.setCapability("browserVersion", browserVersion);
        caps.setCapability("bstack:options", new MutableCapabilities() {{
            setCapability("os", os);
            setCapability("osVersion", osVersion);
            setCapability("projectName", "TestP");
            setCapability("buildName", "Build-3");
            setCapability("sessionName", "Parallel Test Example");
        }});

        // Create RemoteWebDriver instance
        driverInstance = new RemoteWebDriver(new URL(hubURL), caps);
		 }
		 else { 
			 // Local setup with default safe browser
		 }
	            String selectedBrowser = (browser == null || browser.isEmpty()) ? "chrome" : browser.toLowerCase();

	            switch (selectedBrowser) {
	                case "chrome":
	                    ChromeOptions chromeOptions = new ChromeOptions();
	                    chromeOptions.addArguments("--remote-allow-origins=*");

	                    // Headless if running on CI Linux
	                    String osName = System.getProperty("os.name").toLowerCase();
	                    if (osName.contains("linux")) {
	                        chromeOptions.addArguments("--headless=new");
	                        chromeOptions.addArguments("--no-sandbox");
	                        chromeOptions.addArguments("--disable-dev-shm-usage");
	                        chromeOptions.addArguments("--disable-gpu");
	                        chromeOptions.addArguments("--user-data-dir=/tmp/chrome-profile");
	                    } else {
	                        chromeOptions.addArguments("--start-maximized");
	                    }

	                    driverInstance = new ChromeDriver(chromeOptions);
	                    break;

	                case "edge":
	                    driverInstance = new EdgeDriver();
	                    break;

	                default:
	                    throw new IllegalArgumentException("Invalid browser: " + selectedBrowser);
	            }
		 DriverManager.setDriver(driverInstance);
        WebDriver driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();

        // Open application
        driver.get("https://www.flipkart.com/");
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
