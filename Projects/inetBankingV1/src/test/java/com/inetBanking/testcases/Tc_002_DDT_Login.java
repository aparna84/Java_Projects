package com.inetBanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageobjects.LoginPageObjects;
import com.inetBanking.utilities.XLUtils;

import junit.framework.Assert;

public class Tc_002_DDT_Login extends BaseClass{
	
	@Test(dataProvider="LoginData")
	
	public void loginDDT(String user, String password) throws InterruptedException {
		LoginPageObjects lp= new LoginPageObjects(driver);
		lp.enterUserId(user);
		logger.info("Entered user name");
		lp.enterPassword(password);
		logger.info("Entered password");
		lp.clickLoginButton();
		
		Thread.sleep(5000);
		logger.info("clicked on login button");
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.info("Login failed");
		}
		else
		{
			lp.clickLogoutLink();
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			logger.info("login passed");
		}
				
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert().accept();
			return true;
		}
		
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
		
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testdata/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		System.out.println("Total rows count-->"+rownum);
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		System.out.println("Total Columns count-->"+colcount);

		
		String LoginData [][] = new String[rownum][colcount];
		
		for(int i=1; i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				LoginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
				
			}
		}
		return LoginData;
		
	}
	
	

}
