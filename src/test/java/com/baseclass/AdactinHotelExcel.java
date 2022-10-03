package com.baseclass;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class AdactinHotelExcel {
//test
	public static void main(String[] args) throws IOException, InterruptedException {
		BaseClass b = new BaseClass();
		b.getDriver("chrome", "http://adactinhotelapp.com/");
		//b.sendUrl("http://adactinhotelapp.com/");
		WebElement txtUserName = b.findLocatorById("username");
		String userName = b.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 0);
		b.sendTo(txtUserName, userName);
		String passWord = b.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 1);
		WebElement txtPass = b.findLocatorById("password");
		b.sendTo(txtPass, passWord);
		b.findLocatorById("login").click();

		WebElement drpLocation = b.findLocatorById("location");
		String location = b.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 2);
		b.dropDownSelect(location, drpLocation);

		String selectHotel = b.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 3);
		WebElement drpSelectHotel = b.findLocatorById("hotels");
		b.sendTo(drpSelectHotel, selectHotel);

		WebElement drpRoom = b.findLocatorById("room_type");
		String room = b.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 4);
		b.sendTo(drpRoom, room);

		WebElement drpNoOfRoom = b.findLocatorById("room_nos");
		String noOfRoom = b.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 5);
		b.sendTo(drpNoOfRoom, noOfRoom);

		WebElement drpCheckInDate = b.findLocatorById("datepick_in");
		String checkInDate = b.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 6);
		b.sendTo(drpCheckInDate, checkInDate);

		WebElement drpCheckOutDate = b.findLocatorById("datepick_out");
		String checkOutDate = b.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 7);
		b.sendTo(drpCheckOutDate, checkOutDate);

		WebElement drpAdultRoom = b.findLocatorById("adult_room");
		String adultRoom = b.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 8);
		b.sendTo(drpAdultRoom, adultRoom);

		WebElement drpChildRoom = b.findLocatorById("child_room");
		String childRoom = b.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 9);
		b.sendTo(drpChildRoom, childRoom);

		WebElement btnSearch = b.findLocatorById("Submit");
		btnSearch.click();

		WebElement radioClick = b.findLocatorById("radiobutton_0");
		radioClick.click();

		WebElement btnContinue = b.findLocatorById("continue");
		btnContinue.click();

		WebElement txtFirstName = b.findLocatorById("first_name");
		String firstName = b.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 10);
		b.sendTo(txtFirstName, firstName);

		WebElement txtLastName = b.findLocatorById("last_name");
		String lastName = b.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 11);
		b.sendTo(txtLastName, lastName);

		WebElement txtAddress = b.findLocatorById("address");
		String address = b.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 12);
		b.sendTo(txtAddress, address);

		WebElement txtCreditCard = b.findLocatorById("cc_num");
		String creditId = b.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 13);
		b.sendTo(txtCreditCard, creditId);

		WebElement drpCeditCardType = b.findLocatorById("cc_type");
		String creditCard = b.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 14);
		b.sendTo(drpCeditCardType, creditCard);

		WebElement drpMonth = b.findLocatorById("cc_exp_month");
		String month = b.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 15);
		b.sendTo(drpMonth, month);

		WebElement drpSelectYear = b.findLocatorById("cc_exp_year");
		String selectYear = b.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 16);
		b.sendTo(drpSelectYear, selectYear);

		WebElement cvv = b.findLocatorById("cc_cvv");
		String cvv1 = b.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 17);
		b.sendTo(cvv, cvv1);

		WebElement btnBookNow = b.findLocatorById("book_now");
		btnBookNow.click();

		Thread.sleep(7000);
		WebElement orderId = b.findLocatorById("order_no");

		String orderid = b.getAttributeValueFromElement(orderId);

		String old = b.compareXCellWriteDir("AdaptinOrderTask", "AdaptinTestData", 1, 18, orderid);
		System.out.println("The old order Id is : "+old);
		b.toCloseAllWindow();

	}

}
