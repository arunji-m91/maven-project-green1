package com.junit.intro;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DeclareAnnotationFaceBookJuniTest {
static WebDriver driver;
	@BeforeClass
	public static void launchBrowser(){
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}
	
	@Before
	public void expResult() {
		System.out.println("is login success");
	}
	
	@Test
	public void fbLogin() {
		WebElement txtUserName = driver.findElement(By.id("email"));
		txtUserName.sendKeys("arunji");
		String attribute = txtUserName.getAttribute("value");
		Assert.assertEquals("teat","Greens",attribute);
		WebElement txtPassWord = driver.findElement(By.id("pass"));
		txtPassWord.sendKeys("arun1234");
		
		WebElement btnLogin = driver.findElement(By.name("login"));
		btnLogin.click();

	}
	@After
	public void actResult() {
		System.out.println("yes log in success");
	}
	
	
	
	
	
}
