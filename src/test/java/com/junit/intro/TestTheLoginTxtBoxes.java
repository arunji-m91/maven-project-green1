package com.junit.intro;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTheLoginTxtBoxes {
	static WebDriver driver;

	@BeforeClass
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

	}

	@Before
	public void sintax() {
		System.out.println("fb login test");
	}

	@Test
	public void loginTest() {
		WebElement txtUserName = driver.findElement(By.id("email"));
		txtUserName.sendKeys("Greens");
		String userName = txtUserName.getAttribute("value");
		Assert.assertEquals("username test", "Greens", userName);

	}
	
	@Test
	public void test() {
		System.out.println("start");
		//here any one of the assertion is failed it does not run any assertion in that test
		Assert.assertTrue("verify username ",true);
		Assert.assertTrue("verify password",false);
		//Assert.assertTrue("verify useenaem",true);
		System.out.println("end");
		//in this commenmt out condition it runs this test after remove commment out it wont run
	}
	
	@Test
	public void tesingTwo() {
		System.out.println("this is execute it having no error only");
	}

}
