package testLayer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import testBase.DriverManager;
import testBase.TestBase;

public class TestClass1 extends TestBase {
	
	@Test
	public void testMethod1() throws InterruptedException {
		LocalDateTime dt1 = LocalDateTime.now();
		System.out.println("Method1 started--"+dt1.format( DateTimeFormatter.ofPattern("hh:mm:ss")));
		Thread.sleep(60000);

		//WebDriver testDriver = DriverManager.getDriver();
		//testDriver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).click();
		//testDriver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("iphone16"+Keys.ENTER);
		//testDriver.findElement(By.xpath("//div[normalize-space()='Apple iPhone 16 (Black, 128 GB)']")).click();
		//System.out.println("===============/////////////////"+testDriver.getTitle());
		
		LocalDateTime dt2 = LocalDateTime.now();
		System.out.println("Method1 End---"+dt2.format( DateTimeFormatter.ofPattern("hh:mm:ss")));
	}
	@Test
	public void testMethod2() throws InterruptedException {
		LocalDateTime dt = LocalDateTime.now();
		System.out.println("Method2 started--"+dt.format( DateTimeFormatter.ofPattern("hh:mm:ss")));
		//Thread.sleep(60000);
		WebDriver testDriver = DriverManager.getDriver();
		testDriver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).click();
		testDriver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("iphone16"+Keys.ENTER);
		testDriver.findElement(By.xpath("//div[normalize-space()='Apple iPhone 16 (Black, 128 GB)']")).click();
		System.out.println("===============/////////////////"+testDriver.getTitle());;	
		//Thread.sleep(1000);
		LocalDateTime dt2 = LocalDateTime.now();
		System.out.println("Method2 End--"+dt2.format( DateTimeFormatter.ofPattern("hh:mm:ss")));
	}
	@Test
	public void testMethod3() throws InterruptedException {
		LocalDateTime dt = LocalDateTime.now();
		System.out.println("Method2 started--"+dt.format( DateTimeFormatter.ofPattern("hh:mm:ss")));
		//Thread.sleep(60000);
		WebDriver testDriver = DriverManager.getDriver();
		testDriver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).click();
		testDriver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("iphone16"+Keys.ENTER);
		testDriver.findElement(By.xpath("//div[normalize-space()='Apple iPhone 16 (Black, 128 GB)']")).click();
		System.out.println("===============/////////////////"+testDriver.getTitle());;	
		//Thread.sleep(1000);
		LocalDateTime dt2 = LocalDateTime.now();
		System.out.println("Method3 End--"+dt2.format( DateTimeFormatter.ofPattern("hh:mm:ss")));
	}
	@Test
	public void testMethod4() throws InterruptedException {
		LocalDateTime dt = LocalDateTime.now();
		System.out.println("Method2 started--"+dt.format( DateTimeFormatter.ofPattern("hh:mm:ss")));
		//Thread.sleep(60000);
		WebDriver testDriver = DriverManager.getDriver();
		testDriver.findElement(By.xpath("//input[@placeholder='Sffearch for Products, Brands and More']")).click();
		testDriver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("iphone16"+Keys.ENTER);
		testDriver.findElement(By.xpath("//div[normalize-space()='Apple iPhone 16 (Black, 128 GB)']")).click();
		System.out.println("===============/////////////////"+testDriver.getTitle());;	
		//Thread.sleep(1000);
		LocalDateTime dt2 = LocalDateTime.now();
		System.out.println("Method4 End--"+dt2.format( DateTimeFormatter.ofPattern("hh:mm:ss")));
	}
	//@Test
	public void testMethod5() throws InterruptedException {
		LocalDateTime dt = LocalDateTime.now();
		System.out.println("Method2 started--"+dt.format( DateTimeFormatter.ofPattern("hh:mm:ss")));
		//Thread.sleep(60000);
		WebDriver testDriver = DriverManager.getDriver();
		testDriver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).click();
		testDriver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("iphone16"+Keys.ENTER);
		testDriver.findElement(By.xpath("//div[normalize-space()='Apple iPhone 16 (Black, 128 GB)']")).click();
		System.out.println("===============/////////////////"+testDriver.getTitle());;	
		//Thread.sleep(1000);
		LocalDateTime dt2 = LocalDateTime.now();
		System.out.println("Method5 End--"+dt2.format( DateTimeFormatter.ofPattern("hh:mm:ss")));
	}
	//@Test
	public void testMethod31() throws InterruptedException {
		WebDriver testDriver = DriverManager.getDriver();
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
	public void testMethod55() throws InterruptedException {
		WebDriver testDriver = DriverManager.getDriver();
		Thread.sleep(3000);
		testDriver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
		testDriver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("mobiles"+Keys.ENTER);
		
		
	}
	

}
