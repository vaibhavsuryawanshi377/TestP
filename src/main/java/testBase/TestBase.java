package testBase;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeMethod
    public void setUp() throws MalformedURLException {

    	 // BrowserStack credentials
        String username = "vaibhavs_0ZSQVa";
        String accessKey = "smycf4qcj3sUTytqCaSV";
        String hubURL = "https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";

        // Desired capabilities
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("browserVersion", "117.0");
        caps.setCapability("bstack:options", new MutableCapabilities() {{
            setCapability("os", "Windows");
            setCapability("osVersion", "11");
            setCapability("projectName", "My Selenium Project");
            setCapability("buildName", "Build-1");
            setCapability("sessionName", "Parallel Test Example");
        }});

        // Create RemoteWebDriver instance
        WebDriver driverInstance = new RemoteWebDriver(new URL(hubURL), caps);
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
