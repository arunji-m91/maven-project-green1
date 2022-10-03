package com.pom.pagelib.adaptive.hotell;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class LoginPage1 extends BaseClass {

	public LoginPage1() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement txtUserName;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(id = "login")
	private WebElement btnLogin;

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassWord() {
		return txtPassword;
	}

	public WebElement getLogin() {
		return btnLogin;
	}

	public void login(String userName, String password) {

		sendTo(getTxtUserName(), userName);
		sendTo(getTxtPassWord(), password);
		elementClick(getLogin());

	}

}
