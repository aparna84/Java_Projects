package com.facebook.testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.facebook.pageobjects.HomePageDetailsObjects;
import com.facebook.pageobjects.LoginPageObjects;

import junit.framework.Assert;

public class Tc_002_HomePageDetails extends BaseClass 
{
	@Test
	public void AddnewCustomer() throws InterruptedException, IOException {
		
		
		driver.get(baseURL);
		logger.info("FaceBook portal is opened");
		LoginPageObjects lp= new LoginPageObjects(driver);
		lp.enterEmail(username);
		logger.info("Entered user name");
		lp.enterPassword(password);
		logger.info("Entered user password");
		lp.clickLoginButton();
		logger.info("Clicked on login button");
		
		Thread.sleep(3000);

		
		HomePageDetailsObjects Homepage= new HomePageDetailsObjects(driver);
		//Homepage.AllPostsDetails();
		
		//Homepage.ReadSenderName();
		//Homepage.ReadGroupPostedByDetails();
		Homepage.clickAllComments();
		Thread.sleep(10000);
		
		/*boolean res= driver.getPageSource().contains("Customer Registered Successfully!!!");
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
			
	}*/
	
	}

}
