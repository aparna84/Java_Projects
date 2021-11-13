package com.inetBanking.testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.inetBanking.pageobjects.AddCustomerObjects;
import com.inetBanking.pageobjects.LoginPageObjects;

import junit.framework.Assert;

public class Tc_003_AddCustomer extends BaseClass 
{
	@Test
	public void AddnewCustomer() throws InterruptedException, IOException {
		
		
		driver.get(baseURL);
		logger.info("Guru99 home page is opened");
		LoginPageObjects lp= new LoginPageObjects(driver);
		lp.enterUserId(username);
		logger.info("Entered user name");
		lp.enterPassword(password);
		logger.info("Entered user password");
		lp.clickLoginButton();
		logger.info("Clicked on login button");
		logger.info("Clicked on login button");
		Thread.sleep(3000);

		
		AddCustomerObjects addCust= new AddCustomerObjects(driver);
		logger.info("Providing new Customer Details");
		addCust.clickAddCustomerLink();
		addCust.enterCustomerName("Suresh");
		addCust.selectGender("male");
		addCust.enterDOB("23", "12","2001");
		Thread.sleep(5000);
		addCust.enterAddress("H no 12 Manikonda  Hyderabad");
		addCust.enterCity("Hyderabad");
		addCust.enterState("Telangana");
		addCust.enterPinNo("500089");
		addCust.enterPhone("9866487955");
		String email=generateRandomString()+"@gmail.com";
		addCust.enterEmail(email);
		addCust.enterPassword("abcdef");
		Thread.sleep(3000);
		addCust.clickSubmit();
		Thread.sleep(5000);
		logger.info("Validation started");

		boolean res= driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("New Customer Added");
		}
		else
		{
			logger.info("Adding New Customer failed");
			Assert.assertTrue(false);
			captureScreenshot(driver,"Tc_003_AddCustomer");
			
		}
			
	}
	
	

}
