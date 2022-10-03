package com.pom.pagelib.adaptive.hotell;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class SearchHotelPage2 extends BaseClass {

	public SearchHotelPage2() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username_show")
	private WebElement welcomeMsg;  //verify login
	
	
	@FindBy(xpath = "//td[@class='login_title']")
	private WebElement verifyPage;  //Search Hotel page (2)

	@FindBy(id = "location")
	private WebElement drpLocation;

	@FindBy(id = "hotels")
	private WebElement drpHotels;

	@FindBy(id = "room_type")
	private WebElement drpRoomType;

	@FindBy(id = "room_nos")
	private WebElement drpNumOfRoom;

	@FindBy(id = "datepick_in")
	private WebElement drpCheckIn;

	@FindBy(id = "datepick_out")
	private WebElement drpCheckOut;

	@FindBy(id = "adult_room")
	private WebElement drpAdultPerRoom;

	@FindBy(id = "child_room")
	private WebElement drpChildrenPerRoom;

	@FindBy(id = "Submit")
	private WebElement btnSearch;

	@FindBy(id = "Reset")
	private WebElement btnReset;

	@FindBy(id = "radiobutton_0")
	private WebElement btnBooking;

	public WebElement getVerifyPage() {
		return verifyPage;
	}

	public WebElement getWelcomeMsg() {
		return welcomeMsg;
	}

	public WebElement getDrpLocation() {
		return drpLocation;
	}

	public WebElement getDrpHotels() {
		return drpHotels;
	}

	public WebElement getDrpRoomType() {
		return drpRoomType;
	}

	public WebElement getDrpNumOfRoom() {
		return drpNumOfRoom;
	}

	public WebElement getDrpCheckIn() {
		return drpCheckIn;
	}

	public WebElement getDrpCheckOut() {
		return drpCheckOut;
	}

	public WebElement getDrpAdultPerRoom() {
		return drpAdultPerRoom;
	}

	public WebElement getDrpChildrenPerRoom() {
		return drpChildrenPerRoom;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public WebElement getBtnReset() {
		return btnReset;
	}

	public WebElement getBtnBooking() {
		return btnBooking;
	}

	public void hotelPage(String location, String hotel, String roomType, String noOfRoom, String dateCheckIn,
			String dateCheckOut, String adultsPerRoom, String childrednPerRoom) {
		//getDrpLocation().clear();
		sendTo(getDrpLocation(), location);
		//getDrpHotels().clear();
		sendTo(getDrpHotels(), hotel);
		//getDrpRoomType().clear();
		sendTo(getDrpRoomType(), roomType);
		//getDrpNumOfRoom().clear();
		sendTo(getDrpNumOfRoom(), noOfRoom);
		//getDrpCheckIn().clear();
		sendTo(getDrpCheckIn(), dateCheckIn);
		getDrpCheckOut().clear();
		sendTo(getDrpCheckOut(), dateCheckOut);
		//getDrpAdultPerRoom().clear();
		sendTo(getDrpAdultPerRoom(), adultsPerRoom);
		//getDrpChildrenPerRoom().clear();
		sendTo(getDrpChildrenPerRoom(), childrednPerRoom);
		elementClick(getBtnSearch());

	}

}
