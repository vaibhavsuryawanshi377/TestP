package testLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import testBase.DriverManager;
import testBase.TestBase;

public class TestClass4 extends TestBase {
	
	@Test
	public void testMethod7() throws InterruptedException {
		Thread.sleep(3000);
		WebDriver testDriver = DriverManager.getDriver();
		testDriver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
		testDriver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("mobiles"+Keys.ENTER);

		
		
	}
	@Test
	public void testMethod8() throws InterruptedException {
		WebDriver testDriver = DriverManager.getDriver();
		Thread.sleep(3000);
		testDriver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
		testDriver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("mobiles"+Keys.ENTER);
		
		
	}
	

}
