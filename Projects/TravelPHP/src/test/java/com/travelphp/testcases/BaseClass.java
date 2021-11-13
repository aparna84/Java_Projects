package com.travelphp.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig= new ReadConfig();
	public String baseURL=readconfig.getBaseURL();
	public String username =readconfig.getUserID();
	public String  password =readconfig.getpassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		logger= Logger.getLogger("inetBankingV1");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+readconfig.getchromepath());
			driver= new ChromeDriver();
		}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+readconfig.getchromepath());
			driver= new InternetExplorerDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.ssdriver", System.getProperty("user.dir")+readconfig.getchromepath());
			driver= new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		
		 	
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}
	public String generateRandomString() {
		String generatedString= RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	
	public String generateRandomNumber() {
		String generatedNumber= RandomStringUtils.randomNumeric(6);
		return generatedNumber;
		
	}
}
