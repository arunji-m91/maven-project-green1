package com.pom.pagelib.adaptive.hotell;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class SelectHotelPage3 extends BaseClass{
	public SelectHotelPage3(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//td[text()='Select Hotel ']")
	private WebElement verifyPage;  //Select Hotel  (3)
	
	@FindBy(id="radiobutton_0")
	private WebElement rBtnSelect;
	
	@FindBy(id="continue")
	private WebElement btnContinue;
	
	@FindBy(id="cancel")
	private WebElement btnCancel;

	public WebElement getVerifyPage() {
		return verifyPage;
	}

	public WebElement getrBtnSelect() {
		return rBtnSelect;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
