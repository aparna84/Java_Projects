package com.inetBanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageobjects.LoginPageObjects;

public class Tc_001_LoginTest extends BaseClass{
	

	@Test
	public void LoginTest() throws IOException, InterruptedException {
		driver.get(baseURL);
		logger.info("Travel PHP login page is opened");
		LoginPageObjects lp= new LoginPageObjects(driver);
		lp.enterUserId(username);
		logger.info("Entered user name");
		lp.enterPassword(password);
		logger.info("Entered user password");
		lp.clickLoginButton();
		Thread.sleep(10000);
		logger.info("Clicked on login button");
		if(driver.getTitle().equals("My Account"))
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
