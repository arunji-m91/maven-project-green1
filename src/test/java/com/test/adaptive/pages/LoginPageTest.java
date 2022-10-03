package com.test.adaptive.pages;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
import com.pom.pagelib.adaptive.hotell.BookHotelPage4;
import com.pom.pagelib.adaptive.hotell.BookedItenary6;
import com.pom.pagelib.adaptive.hotell.BookingConfirmation5;
import com.pom.pagelib.adaptive.hotell.LoginPage1;
import com.pom.pagelib.adaptive.hotell.SearchHotelPage2;
import com.pom.pagelib.adaptive.hotell.SelectHotelPage3;

public class LoginPageTest extends BaseClass {

	public LoginPageTest(){
		PageFactory.initElements(driver, this);
	}

	@BeforeClass
	public static void browserLaunch1() {
		getDriver("chrome", "http://adactinhotelapp.com/");
	}
	//
	// @AfterClass
	// public static void close() {
	//
	// toCloseWindow();
	// }

	@Test
	public void loginTest() throws IOException, InterruptedException {
		LoginPage1 l = new LoginPage1();
		String userNameX = readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 0);
		String passWordX = readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 1);
		l.login(userNameX, passWordX);

		//login success or not test
		SearchHotelPage2 searchHotelPage = new SearchHotelPage2();
		//String text = searchHotelPage.getWelcomeMsg().getAttribute("value");
		//Assert.assertEquals("login page test", "Hello Greens8767!",text);
		boolean contains = searchHotelPage.getVerifyPage().getText().contains("Search Hotel");
		Assert.assertTrue("Login page test", contains);
		String locationX = searchHotelPage.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 2);
		String hotelX = searchHotelPage.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 3);
		String roomTypeX = searchHotelPage.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 4);
		String noOfRoomX = searchHotelPage.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 5);
		String dateCheckInX = searchHotelPage.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 6);
		String dateCheckOutX = searchHotelPage.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 7);
		String adultsPerRoomX = searchHotelPage.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 8);
		String childrensPerRoomX = searchHotelPage.readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 9);
		searchHotelPage.hotelPage(locationX, hotelX, roomTypeX, noOfRoomX, dateCheckInX, dateCheckOutX, adultsPerRoomX,
				childrensPerRoomX);

		SelectHotelPage3 s3 = new SelectHotelPage3();
		boolean contains2 = s3.getVerifyPage().getText().contains("Select Hotel");
		Assert.assertTrue(contains2);
		elementClick(s3.getrBtnSelect());
		elementClick(s3.getBtnContinue());

		BookHotelPage4 b4 = new BookHotelPage4();
		boolean contains3 = b4.getVerifyPage().getText().contains("Book A Hotel");
		Assert.assertTrue("select hotel page test", contains3);
		String firstName = readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 10);
		String lastName = readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 11);
		String billAddress = readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 12);
		String cCardNum = readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 13);
		String cCardType = readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 14);
		String month = readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 15);
		String year = readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 16);
		String cvv = readFromXl("AdaptinOrderTask", "AdaptinTestData", 1, 17);
		b4.bookHotelData(firstName, lastName, billAddress, cCardNum, cCardType, month, year, cvv);
		elementClick(b4.getBtnBookNow());

		Thread.sleep(7000);

		BookingConfirmation5 b5 = new BookingConfirmation5();
		boolean contains4 = b5.getVerifyPage().getText().contains("Booking Confirmation");
		Assert.assertTrue("Booking hotel page test", contains4);
		WebElement orderNum = b5.getOrderNum();
		String orderID = orderNum.getAttribute("value");
		System.out.println(orderID);
		compareXCellWriteDir("AdaptinOrderTask", "AdaptinTestData", 2, 0, orderID);

		
		BookedItenary6 b6 = new BookedItenary6();
		WebElement searchBox = b6.getTxtSearchOrderId();
		searchBox.sendKeys(orderID,Keys.ENTER);
		Thread.sleep(8000);
		elementClick(b6.getBookIternary());
		boolean contains5 = b6.getVerifyPage().getText().contains("Booked Itinerary");
		Assert.assertTrue(contains5);
		
		//`Thread.sleep(180000);
		//WebElement txtSearchOrderId = b6.getTxtSearchOrderId();
//		List<WebElement> idCancel = b6.getIdCancel();
//		String orderIdX = readFromXl("AdaptinOrderTask", "AdaptinTestData", 2, 0);
//		WebDriverWait wait = new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.visibilityOfAllElements(idCancel));
//		
    	
    	//sendToTextBoxAndEnter(txtSearchOrderId, orderIdX);
		//Thread.sleep(200000);
    	
//		
    	
    	//b6.sendToTextboxByJs(idCancel,"Cancel "+orderIdX);
//    		for (WebElement webElement : idCancel) {
//				String attribute = webElement.getAttribute("value");
//				if(attribute.contains(orderIdX)) {
//					webElement.click();
//					break;
//				}
//			}
    		
    		acceptPopUp();
    		String text = b6.getIdCancelMsg().getText();
    		compareXCellWriteDir("AdaptinOrderTask","AdaptinTestData",3,0,text);

	}

}
