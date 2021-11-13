package com.inetBanking.pageobjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchFlightsPageObjects {

	WebDriver ldriver;
	Map<String, Integer> objMap = new HashMap<String, Integer>();
	WebDriverWait element;
	Actions actions;
	//String dateval="";
	
	
	public SearchFlightsPageObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);

	}
	@FindBy (xpath="//*[@title='home']")
	WebElement clickHome;

	@FindBy (xpath="//*[@href='#flights']")
	WebElement ClickFlightButton;


	@FindBy (xpath="//*[@id='flightSearchRadio-2']")
	WebElement OnewayRadio;

	@FindBy (xpath="//*[@id='//header-waypoint-sticky']/div[1]/div/div/div[2]/div/ul/li[1]/div/div/div/a")
	List<WebElement> CurrencyDropdown;

	@FindBy (xpath="//*[@id='//header-waypoint-sticky']/div/div/div/div[2]/div/ul/li[1]/div/a")
	WebElement selectCurrency;

	@FindBy (xpath="//*[@id='flights']/div/div/form/div/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/span/button[1]")
	WebElement ClickAdults;

	@FindBy (xpath="//*[@id='flights']/div/div/form/div/div/div[3]/div[3]/div/div/div[2]/div/div[2]/div/span/button[1]")
	WebElement ClickChild;

	@FindBy (xpath="//*[@id='flights']/div/div/form/div/div/div[3]/div[3]/div/div/div[3]/div/div[2]/div/span/button[1]")
	WebElement ClickInfant;
	
	@FindBy (xpath="//*[@id='s2id_location_from']/a")
	WebElement selectFrom;
	
	@FindBy (xpath="//*[@id='s2id_location_to']/a")
	WebElement selectTo;
	
	@FindBy (xpath="//*[@id='select2-drop']/ul/li")
	List<WebElement> FromDropdown;
	
	@FindBy (xpath="//*[@id='dropdownLangauge']")
	WebElement Language;
	
	@FindBy (xpath="//*[@id='FlightsDateStart']")
	WebElement FlightStartDate;
	
	@FindBy (xpath="//*[@id='flights']/div/div/form/div/div/div[3]/div[4]/button")
	WebElement clickSearchButton;
	

	public void clickHomelink() 
	{
		clickHome.click();
	}
	
	public void clickLanaguage()
	{
		Language.click();
		List<WebElement> engLang=ldriver.findElements(By.xpath("//*[@class='dropdown-item']"));
		System.out.println("Total languages are "+engLang.size());

		for (WebElement element:engLang)
			
		{
			String LanguageItems=element.getText();
			System.out.println("LanguageItems are-->"+LanguageItems);
			if(LanguageItems.contains("English"))
			{
				element.click();
				break;
				
			}
		}
		
	}

	public void clickFlightButton() 
	{
		ClickFlightButton.click();
	}
	public void OnewayRadio() 
	{

		boolean OneWaySelected= OnewayRadio.isSelected();
		Assert.assertEquals(OneWaySelected, true, "One way is not auto selected");
	}
	public void SelectCurrecny(String Currency) 
	{
		System.out.println("This is map number"+objMap.get("INR"));
		WebElement INR= ldriver.findElement(By.xpath("//*[@id='//header-waypoint-sticky']/div/div/div/div[2]/div/ul/li[1]/div/div/div[1]/a["+objMap.get(Currency)+"]"));

		 actions = new Actions(ldriver); 
		// Call moveToElement() method of actions class to move mouse cursor to a WebElement A. 
		actions.moveToElement(selectCurrency); 
		actions.click();
		//actions.clickAndHold(); 
		actions.moveToElement(INR).click(); 
		actions.release().perform(); 
	} 



	public List<WebElement> CurrecnyRadioDropdown1() {


		List<WebElement> dropdownList= ldriver.findElements(By.xpath("//*[@id='//header-waypoint-sticky']/div[1]/div/div/div[2]/div/ul/li[1]/div/div/div/a"));

		System.out.println(dropdownList.size());

		int i=1;

		for (WebElement element : dropdownList) {

			String text=element.getAttribute("text");

			System.out.println("This is text attr"+text);

			System.out.println(element.getTagName() + "=" + text +", "+ element.getText());


			objMap.put(text, i);
			i++;


		}
		System.out.println(objMap);
		return CurrencyDropdown;

	}
	public void clickAdultsButton()
	{
		int i=1;
		while(i<5)
		{
			ClickAdults.click();
			i++;
		}
		

	}
	public void clickChildButton()
	{
		int i=1;
		while(i<3)
		{
			ClickChild.click();
			i++;
		}
		
	}
	public void clickInfantButton()
	{
		int i=1;
		while(i<2)
		{
			ClickInfant.click();
			i++;
		}

	}
	
	public void selectFromCountry(String fromCountry) throws InterruptedException 
	{
		//selectFrom.click();
		//selectFrom.sendKeys(fromCountry);
		Actions actions = new Actions(ldriver); 
		// Call moveToElement() method of actions class to move mouse cursor to a WebElement A. 
		actions.moveToElement(selectFrom).click(); 
		actions.click();
		//actions.clickAndHold(); 
		//actions.moveToElement(INR).click(); 
		actions.release().perform(); 
		selectFrom.sendKeys(fromCountry);
		Thread.sleep(5000);
		
		try {
			
		
		List<WebElement> FromdropdownList=ldriver.findElements(By.xpath("//*[@class='select2-results-dept-0 select2-result select2-result-selectable']"));
		
		System.out.println("This is from dropdown size="+FromdropdownList.size());
		for (WebElement element:FromdropdownList)
		{
			String counntryItem=element.getText();
			System.out.println("counntryItem-->"+counntryItem);
			if(counntryItem.contains("Bangalore"))
			{
				element.click();
				break;
				
			}
			
		}
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
		public void selectToCountry() throws InterruptedException 
		{
			selectTo.click();
			selectTo.sendKeys("Kera");
			Thread.sleep(5000);
			
			List<WebElement> toDropdownList=ldriver.findElements(By.xpath("//*[@class='select2-result-label']"));
			System.out.println("This is To dropdown size"+toDropdownList.size());
			
			for(WebElement element:toDropdownList)
			{
				String ToCityList=element.getText();
				System.out.println("Cities starts with ker are==>"+ToCityList);
				if(ToCityList.contains("Kerama"))
				{
					element.click();
					break;
				}
			}
			
			
		}
		public void FlightStartDate()
		{
			FlightStartDate.click();
				
			List<WebElement> dates=ldriver.findElements(By.xpath("//*[@class='datepicker--cell datepicker--cell-day -other-month- -disabled-']"));
			System.out.println("All dates are-->"+dates.size());
			for(WebElement element:dates)
			{
				String allDatesDetails=element.getText();
				System.out.println("All dates and month details are -->"+allDatesDetails);
			}
			
			
		
			
		}
		
		public void FlightStartDate1(String dateval)
		{
			//FlightStartDate.click();
			
			JavascriptExecutor js=(JavascriptExecutor)ldriver;
			//js.executeScript("document[0].setAttribute('value','"+dateval+"');", FlightStartDate);
			js.executeScript("document.getElementById('FlightsDateStart').setAttribute('value','"+dateval+"');");
			System.out.print("value: "+ldriver.findElement(By.id("FlightsDateStart")).getAttribute("value"));
			
		}
		
		public void clickSearchButton() {
			clickSearchButton.click();
		}
}