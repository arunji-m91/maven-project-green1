package com.junit.intro;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeclareAnnotationAdaptinTask {

	/*
	 * this order is important
	 * 1 @BeforeClass
	 * 2 @Before-->basically it execute before every @Test
	 * 3 @Test
	 * 4 @After-->execute after every @Test
	 * 5 @AfterClass  -->after all test cases
	 */
	
	
	static WebDriver driver;
@BeforeClass
public static void launchBrowser() {
	//basically before class is a setup
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("http://adactinhotelapp.com/");
	driver.manage().window().maximize();
}


@AfterClass
public static void quitBrowser() {
	driver.quit();
}


@Before
public void beforeTest() {
	long beforeLoginTime = System.currentTimeMillis();
	System.out.println(beforeLoginTime);

}

@Test
public void adaptinLogInTest() {
	WebElement txtUserName = driver.findElement(By.id("username"));
	txtUserName.sendKeys("greens");
	
	WebElement txtPassWord = driver.findElement(By.id("password"));
	
	txtPassWord.sendKeys("green1234");
	WebElement btnLogin = driver.findElement(By.id("login"));
	btnLogin.click();
}

@After
public void afterTest() {
	long afterLoginTime = System.currentTimeMillis();
	System.out.println(afterLoginTime);

}
	
	
	
}
	
	

