package com.pom.pagelib.adaptive.hotell;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class BookingConfirmation5 extends BaseClass {
	
	public BookingConfirmation5() {
		PageFactory.initElements(driver,this);
	}
	
	
	
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	private WebElement verifyPage;  //booking confirmation page (5)
	
	@FindBy(id="order_no")
	private WebElement orderNum;
	
	@FindBy(id="search_hotel")
	private WebElement btnSearchHotel;
	
	@FindBy(id="my_itinerary")
	private WebElement btnItenary;
	
	@FindBy(id="logout")
	private WebElement btnLogout;	
	
	public WebElement getVerifyPage() {
		return verifyPage;
	}

	public void setVerifyPage(WebElement verifyPage) {
		this.verifyPage = verifyPage;
	}

	public WebElement getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(WebElement orderNum) {
		this.orderNum = orderNum;
	}

	public WebElement getBtnSearchHotel() {
		return btnSearchHotel;
	}

	public void setBtnSearchHotel(WebElement btnSearchHotel) {
		this.btnSearchHotel = btnSearchHotel;
	}
	
	public WebElement getBtnItenary() {
		return btnItenary;
	}

	public void setBtnItenary(WebElement btnItenary) {
		this.btnItenary = btnItenary;
	}

	public WebElement getBtnLogout() {
		return btnLogout;
	}

	public void setBtnLogout(WebElement btnLogout) {
		this.btnLogout = btnLogout;
	}
}
