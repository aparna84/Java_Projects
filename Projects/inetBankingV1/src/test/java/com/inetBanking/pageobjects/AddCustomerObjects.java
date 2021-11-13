package com.inetBanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerObjects {

	WebDriver ldriver;
	
	public AddCustomerObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
}
	@FindBy (xpath="//a[@href='addcustomerpage.php']")
	WebElement AddCustomer;
	
	@FindBy (name="name")
	WebElement customerName;

	@FindBy (name="rad1")
	WebElement Gender;

	@FindBy (name="dob")
	WebElement dob;

	@FindBy (name="addr")
	WebElement addr;


	@FindBy (name="city")
	WebElement city;


	@FindBy (name="state")
	WebElement state;

	@FindBy (name="pinno")
	WebElement pinno;


	@FindBy (name="telephoneno")
	WebElement telephoneno;


	@FindBy (name="emailid")
	WebElement emailid;

	@FindBy (name="password")
	WebElement password;

	@FindBy (name="sub")
	WebElement submit;

	public void clickAddCustomerLink() {
		AddCustomer.click();
	}

	public void enterCustomerName(String custName)
	{
		customerName.sendKeys(custName);
	}

	public void selectGender(String gender)
	{
		Gender.click();
	}
	
	public void enterDOB(String mm, String dd, String yyyy)
	{
		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yyyy);
	}
	
	public void enterAddress(String address)
	{
		addr.sendKeys(address);
	}
	public void enterCity(String City)
	{
		city.sendKeys(City);
	}
	
	public void enterState(String State)
	{
		state.sendKeys(State);
	}
	public void enterPinNo(String Pin)
	{
		pinno.sendKeys(String.valueOf(Pin));
	}
	
	public void enterPhone(String Phone)
	{
		telephoneno.sendKeys(Phone);
	}
	public void enterEmail(String Email)
	{
		emailid.sendKeys(Email);
	}
	
	public void enterPassword(String Password)
	{
		password.sendKeys(Password);
	}
	
	public void clickSubmit() {
		submit.click();
	}
	
}