package testLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import testBase.DriverManager;
import testBase.TestBase;

public class TestClass2 extends TestBase {
	
	@Test
	public void testMethod12() throws InterruptedException {
		Thread.sleep(3000);
		WebDriver testDriver = DriverManager.getDriver();
		Thread.sleep(1500);
		testDriver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		Thread.sleep(1500);
		testDriver.findElement(By.xpath("//input[@name='emailPhone']")).sendKeys("admin@teknobuilt.com");
		Thread.sleep(1500);
		testDriver.findElement(By.xpath("//input[@name='password']")).sendKeys("u5s3[CY1T$i=");
		Thread.sleep(1500);
		testDriver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(1500);
		WebDriverWait wait = new WebDriverWait(testDriver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Select area and sub-area in the project']")));
		Thread.sleep(1500);
		testDriver.findElement(By.xpath("//p[normalize-space()='CLU']")).click();
		Thread.sleep(1500);
		testDriver.findElement(By.xpath("//p[normalize-space()='Common Area']")).click();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Advanced Project Engineering']")));
		Thread.sleep(1500);
		testDriver.findElement(By.xpath("//button[@aria-label='Menu']")).click();
		Thread.sleep(1500);
		testDriver.findElement(By.xpath("//span[normalize-space()='Departments']")).click();
		Thread.sleep(1500);
		testDriver.findElement(By.xpath("//button[@aria-label='Search']")).click();
		Thread.sleep(1500);
		testDriver.findElement(By.xpath("//input[@aria-label=\"Search\"]")).sendKeys("Design Department");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'1-1 of 1')]")));
		Thread.sleep(1500);
				
		
	}
	@Test
	public void testMethod13() throws InterruptedException {
		WebDriver testDriver = DriverManager.getDriver();
		testDriver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		testDriver.findElement(By.xpath("//input[@name='emailPhone']")).sendKeys("admin@teknobuilt.com");
		testDriver.findElement(By.xpath("//input[@name='password']")).sendKeys("u5s3[CY1T$i=");
		testDriver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		WebDriverWait wait = new WebDriverWait(testDriver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Select area and sub-area in the project']")));
		testDriver.findElement(By.xpath("//p[normalize-space()='CLU']")).click();
		testDriver.findElement(By.xpath("//p[normalize-space()='Common Area']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Advanced Project Engineering']")));
		testDriver.findElement(By.xpath("//button[@aria-label='Menu']")).click();
		testDriver.findElement(By.xpath("//span[normalize-space()='Departments']")).click();
		testDriver.findElement(By.xpath("//button[@aria-label='Search']")).click();
		testDriver.findElement(By.xpath("//input[@aria-label=\"Search\"]")).sendKeys("Design Department");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'1-1 of 1')]")));
				
		
	}
	//@Test
	public void testMethod4() throws InterruptedException {
		WebDriver testDriver = DriverManager.getDriver();
		Thread.sleep(3000);
		testDriver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
		testDriver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("mobiles"+Keys.ENTER);
		
		
	}
	

}
