package com.inetBanking.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.inetBanking.pageobjects.LoginPageObjects;
import com.inetBanking.pageobjects.SearchFlightsPageObjects;

public class Tc_002_SearchFlights extends BaseClass

{
	@Test
	public void clickHomeMenu() throws InterruptedException
	{
		driver.get(baseURL);
		/*
		 * logger.info("Travel PHP login page is opened"); LoginPageObjects lp= new
		 * LoginPageObjects(driver); lp.enterUserId(username);
		 * logger.info("Entered user name"); lp.enterPassword(password);
		 * logger.info("Entered user password"); lp.clickLoginButton();
		 * Thread.sleep(10000); logger.info("Clicked on login button");
		 * Thread.sleep(10000);
		 */
		SearchFlightsPageObjects sp= new SearchFlightsPageObjects(driver);
		sp.clickLanaguage();
		sp.clickHomelink();
		Thread.sleep(3000);


		List<WebElement> list=sp.CurrecnyRadioDropdown1();
		/*
		 * for(int i=0;i<list.size();i++) { System.out.println(list.get(i).toString());
		 * }
		 */


		//sp.SelectCurrecny("INR");
		//Thread.sleep(3000);
		sp.clickFlightButton();
		sp.OnewayRadio();
		//Thread.sleep(5000);

		sp.selectFromCountry("Bang");
		Thread.sleep(3000);
		sp.selectToCountry();
		Thread.sleep(10000);
		sp.FlightStartDate1("30-12-2021");
		Thread.sleep(5000);
		sp.clickAdultsButton();
		sp.clickChildButton();
		sp.clickInfantButton();
		Thread.sleep(5000);
		sp.clickSearchButton();
		Thread.sleep(5000);
		
		driver.quit();
	}

}
