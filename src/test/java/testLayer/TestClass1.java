package testLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import testBase.DriverManager;
import testBase.TestBase;

public class TestClass1 extends TestBase {
	
	@Test
	public void testMethod1() throws InterruptedException {
		Thread.sleep(10000);
		WebDriver testDriver = DriverManager.getDriver();
		Thread.sleep(10000);
		testDriver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
		Thread.sleep(10000);
		testDriver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("mobiles"+Keys.ENTER);
		Thread.sleep(10000);

		
		
	}
	//@Test
	public void testMethod2() throws InterruptedException {
		WebDriver testDriver = DriverManager.getDriver();
		Thread.sleep(5000);
		testDriver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
		testDriver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("mobiles"+Keys.ENTER);
		
		
	}
	

}
