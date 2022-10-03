package com.intromaven;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchFbUsingWebDriverManager {

	public static void main(String[] args) {
		//WebDriverManager.chromedriver().setup();
	 //WebDriverManager.firefoxdriver().setup();
		//WebDriverManager.edgedriver().setup();
		WebDriverManager.iedriver().setup();
//		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new InternetExplorerDriver();
		driver.get("https://www.facebook.com/");

	}

}
