package com.inetBanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageobjects.LoginPageObjects;

public class Tc_001_LoginTest extends BaseClass{
	

	@Test
	public void LoginTest() throws IOException {
		driver.get(baseURL);
		logger.info("Guru99 home page is opened");
		LoginPageObjects lp= new LoginPageObjects(driver);
		lp.enterUserId(username);
		logger.info("Entered user name");
		lp.enterPassword(password);
		logger.info("Entered user password");
		lp.clickLoginButton();
		logger.info("Clicked on login button");
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
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
