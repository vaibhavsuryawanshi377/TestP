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

public class TestBase2 {

    @Parameters({ "browserstack", "browser", "browserVersion", "os", "osVersion" })
    @BeforeMethod
    public void setUp(
            @Optional("false") String browserstack,
            @Optional("chrome") String browser,
            @Optional("latest") String browserVersion,
            @Optional("Windows") String os,
            @Optional("11") String osVersion) throws MalformedURLException {

        WebDriver driverInstance;

        // Determine if we are using BrowserStack
        if (Boolean.parseBoolean(browserstack)) {

            // Use environment variables for security
          //  String bsUser = System.getenv("BROWSERSTACK_USER");
            //String bsKey = System.getenv("BROWSERSTACK_KEY");
            String bsUrl = "https://" + "vaibhavs_0ZSQVa" + ":" + "smycf4qcj3sUTytqCaSV" + "@hub-cloud.browserstack.com/wd/hub";

            MutableCapabilities caps = new MutableCapabilities();
            caps.setCapability("browserName", browser);
            caps.setCapability("browserVersion", browserVersion);

            MutableCapabilities bstackOptions = new MutableCapabilities();
            bstackOptions.setCapability("os", os);
            bstackOptions.setCapability("osVersion", osVersion);
            bstackOptions.setCapability("projectName", "My Project");
            bstackOptions.setCapability("buildName", "Build 1");
            bstackOptions.setCapability("sessionName", "Test Session");

            caps.setCapability("bstack:options", bstackOptions);

            driverInstance = new RemoteWebDriver(new URL(bsUrl), caps);

        } else {
            // Local setup with default safe browser
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
        }

        // Store WebDriver in DriverManager
        DriverManager.setDriver(driverInstance);

        // Common driver configurations
        WebDriver driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();

        // Open application
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
