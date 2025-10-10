package utility;

import io.qameta.allure.Attachment;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.DriverManager;

public class AllureListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Allure.step("🚀 Starting test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Allure.step("✅ Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Allure.step("❌ Test failed: " + result.getName());

        // Get WebDriver from DriverManager
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            saveScreenshot(driver);
        }

        // Attach exception message
        Throwable throwable = result.getThrowable();
        if (throwable != null) {
            Allure.addAttachment("Exception", throwable.toString());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Allure.step("⚠️ Test skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        Allure.step("=== Test Suite Started: " + context.getName() + " ===");
    }

    @Override
    public void onFinish(ITestContext context) {
        Allure.step("=== Test Suite Finished: " + context.getName() + " ===");
    }

    // 🔹 Allure screenshot attachment
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
