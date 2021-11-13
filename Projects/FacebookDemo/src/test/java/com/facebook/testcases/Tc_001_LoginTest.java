package com.facebook.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.facebook.pageobjects.LoginPageObjects;

public class Tc_001_LoginTest extends BaseClass{
	

	@Test
	public void LoginTest() throws IOException {
		driver.get(baseURL);
		logger.info("Guru99 home page is opened");
		LoginPageObjects lp= new LoginPageObjects(driver);
		lp.enterEmail(username);
		logger.info("Given email id");
		lp.enterPassword(password);
		logger.info("Entered user password");
		lp.clickLoginButton();
		logger.info("Clicked on login button");
		if(driver.getTitle().contains("Facebook"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreenshot(driver,"LoginTest");
			Assert.assertTrue(false);
			
		}
		
		
		}

}
