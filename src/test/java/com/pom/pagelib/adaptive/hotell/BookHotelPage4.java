package com.pom.pagelib.adaptive.hotell;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class BookHotelPage4 extends BaseClass {
	public BookHotelPage4() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[text()='Book A Hotel ']")
	private WebElement verifyPage; // Book A Hotel --(4)

	@FindBy(id = "first_name")
	private WebElement txtFirstName;

	@FindBy(id = "last_name")
	private WebElement txtLastName;

	@FindBy(id = "address")
	private WebElement address;

	@FindBy(id = "cc_num")
	private WebElement txtCreditCardNum;

	@FindBy(id = "cc_type")
	private WebElement drpCreditCardType;

	@FindBy(id = "cc_exp_month")
	private WebElement drpExpMonth;

	@FindBy(id = "cc_exp_year")
	private WebElement drpCreditYear;

	@FindBy(id = "cc_cvv")
	private WebElement txtCvvNum;

	@FindBy(id = "book_now")
	private WebElement btnBookNow;

	@FindBy(id = "cancel")
	private WebElement btnCancel;

	public WebElement getVerifyPage() {
		return verifyPage;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getTxtCreditCardNum() {
		return txtCreditCardNum;
	}

	public WebElement getDrpCreditCardType() {
		return drpCreditCardType;
	}

	public WebElement getDrpExpMonth() {
		return drpExpMonth;
	}

	public WebElement getDrpCreditYear() {
		return drpCreditYear;
	}

	public WebElement getTxtCvvNum() {
		return txtCvvNum;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	public void bookHotelData(String firstName,String lastName,String billAddress,String cCardNum,String cCardType,String month,String year,
			String cvv) {
		
		sendTo(getTxtFirstName(), firstName);
		sendTo(getTxtLastName(), lastName);
		sendTo(getAddress(), billAddress);
		sendTo(getTxtCreditCardNum(), cCardNum);
		sendTo(getDrpCreditCardType(), cCardType);
		sendTo( getDrpExpMonth(),month);
		sendTo(getDrpCreditYear(),year);
		sendTo(getTxtCvvNum(),cvv);
	
	}
	
	

	
	
	
	
	
	
	
	
	
	
	

}
