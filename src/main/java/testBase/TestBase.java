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
            String browserstack,
            String browser,
            @Optional("") String browserVersion,
            @Optional("") String os,
            @Optional("") String osVersion) throws MalformedURLException {

        WebDriver driverInstance;

        if (Boolean.parseBoolean(browserstack)) {
            // BrowserStack remote setup
            String bsUser = "vaibhavs_0ZSQVa";
            String bsKey = "smycf4qcj3sUTytqCaSV";
            String bsUrl = "https://" + bsUser + ":" + bsKey + "@hub-cloud.browserstack.com/wd/hub";

            // Top-level capabilities
            MutableCapabilities caps = new MutableCapabilities();
            caps.setCapability("browserName", browser.isEmpty() ? "chrome" : browser);
            caps.setCapability("browserVersion", browserVersion.isEmpty() ? "latest" : browserVersion);

            // BrowserStack-specific options
            MutableCapabilities bstackOptions = new MutableCapabilities();
            bstackOptions.setCapability("os", os.isEmpty() ? "Windows" : os);
            bstackOptions.setCapability("osVersion", osVersion.isEmpty() ? "11" : osVersion);
            bstackOptions.setCapability("projectName", "My Project");
            bstackOptions.setCapability("buildName", "Build 1");
            bstackOptions.setCapability("sessionName", "Test Session");

            caps.setCapability("bstack:options", bstackOptions);

            driverInstance = new RemoteWebDriver(new URL(bsUrl), caps);

        } else {
            // Local setup
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");

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
                    throw new IllegalArgumentException("Invalid browser: " + browser);
            }
        }

        // Set WebDriver in DriverManager
        DriverManager.setDriver(driverInstance);

        // Common configurations
        WebDriver driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();

        // Open application URL
        driver.get("https://www.google.com/");
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
