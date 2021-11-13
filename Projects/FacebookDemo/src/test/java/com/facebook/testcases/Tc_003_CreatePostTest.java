package com.facebook.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.facebook.pageobjects.CreatePost;
import com.facebook.pageobjects.LoginPageObjects;

public class Tc_003_CreatePostTest extends BaseClass  {
	
	@Test
public void CreatePostTest() throws InterruptedException, IOException {
		
		//Login to facebook application
		driver.get(baseURL);
		logger.info("FaceBook portal is opened");
		LoginPageObjects lp= new LoginPageObjects(driver);
		lp.enterEmail(username);
		logger.info("Entered user name");
		lp.enterPassword(password);
		logger.info("Entered user password");
		lp.clickLoginButton();
		logger.info("Clicked on login button");
	
		//Create Post
		CreatePost cp= new CreatePost(driver);
		cp.clickCreatePost();
		Thread.sleep(3000);
		cp.ClickFriendDrodownMenu();
		Thread.sleep(3000);
		cp.composePost();
		Thread.sleep(3000);
		cp.clickPostButton();
		Thread.sleep(10000);
		//cp.AllPostsDetails();
		cp.ReadSenderName();
		Thread.sleep(10000);
		
		

}
}
