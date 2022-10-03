package com.pom.pagelib.adaptive.hotell;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class BookedItenary6 extends BaseClass{

	public BookedItenary6() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//td[text()='Booked Itinerary']")
	private WebElement verifyPage;
	
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement bookIternary;
	
	@FindBy(id="order_id_text")
	private WebElement txtSearchOrderId;
	
	@FindBy(id="search_hotel_id")
	private WebElement btnGo;

	
	@FindBy(xpath="//input[@type='button']")
	private WebElement idCancel;
	
	@FindBy(id="search_result_error")
	private WebElement idCancelMsg;
	
	
	
	
	
	public WebElement getIdCancelMsg() {
		return idCancelMsg;
	}

	public List<WebElement> getIdCancel() {
		return (List<WebElement>) idCancel;
	}

	public WebElement getVerifyPage() {
		return verifyPage;
	}

	public WebElement getBookIternary() {
		return bookIternary;
	}

	public WebElement getTxtSearchOrderId() {
		return txtSearchOrderId;
	}

	public WebElement getBtnGo() {
		return btnGo;
	}

	
	
	
	
}
