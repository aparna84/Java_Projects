package com.facebook.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageDetailsObjects {

	WebDriver ldriver;
	JavascriptExecutor jsx;
	
	public HomePageDetailsObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
}
	@FindBy (xpath="//*[@class='rq0escxv l9j0dhe7 du4w35lb hybvsw6c io0zqebd m5lcvass fbipl8qg nwvqtn77 k4urcfbm ni8dbmo4 stjgntxs sbcfpzgs']")
	WebElement AllPosts;
	
	public void AllPostsDetails() throws InterruptedException
	{
		/*
		 * Actions actions = new Actions(ldriver);
		 * 
		 * // Scroll Down using Actions class
		 * actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		 */
		
		JavascriptExecutor jsx = (JavascriptExecutor)ldriver;
		int i=1;
		do
		{
			
		
		jsx.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(10000);
		
		i++;
		}
		while(i<2);
		
		
	//List<WebElement> TotalPosts=ldriver.findElements(By.xpath("//*[@class='tr9rh885 k4urcfbm']/div[3]/div/div[4]/div/div/div/div/div/div/div/div/div"));
		List<WebElement> TotalPosts=ldriver.findElements(By.xpath("//*[@class='du4w35lb k4urcfbm l9j0dhe7 sjgh65i0']"));
	
		for(WebElement element:TotalPosts)
		{
			String postDesciption=element.getText();
			System.out.println("This is post details-->"+postDesciption);
		}
	
	
	
	Thread.sleep(10000);
	
	
	System.out.println("Total posts="+TotalPosts.size());
	
	
	}
	public void ReadSenderName() throws InterruptedException {
		
		
		int i=1;
		do
		{
			
		jsx=(JavascriptExecutor)ldriver;
		jsx.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(10000);
		
		i++;
		}
		while(i<2);
		
		List<WebElement> name=ldriver.findElements(By.xpath("//*[@class='oajrlxb2 g5ia77u1 qu0x051f esr5mh6w e9989ue4 r7d6kgcz rq0escxv nhd2j8a9 nc684nl6 p7hjln8o kvgmc6g5 cxmmr5t8 oygrvhab hcukyx3x jb3vyjys rz4wbd8a qt6c0cv9 a8nywdso i1ao9s8h esuyzwwr f1sip0of lzcic4wl oo9gr5id gpro0wi8 lrazzd5p']/span"));
		//jsx.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(10000);
		
		System.out.println("Posts -->"+name.size());
		for(WebElement element: name)
		{
			String posterName=element.getText();
			System.out.println("This is posted by-->"+posterName);
		}
		}
	public void ReadGroupPostedByDetails() throws InterruptedException
	{
		
		
		
		int i=1;
		do
		{
			
		jsx=(JavascriptExecutor)ldriver;
		jsx.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(10000);
		
		i++;
		}
		while(i<5);
		
		List<WebElement> name=ldriver.findElements(By.xpath("//*[@class='d2edcug0 hpfvmrgz qv66sw1b c1et5uql lr9zc1uh a8c37x1j keod5gw0 nxhoafnm aigsh9s9 d9wwppkn fe6kdd0r mau55g9w c8b282yb mdeji52x e9vueds3 j5wam9gi knj5qynh m9osqain hzawbc8m']/span[1]/span/span/span/a"));
		//jsx.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(10000);
		
		System.out.println("GroupPosted Details total Size-->"+name.size());
		for(WebElement element: name)
		{
			String posterName=element.getText();
			System.out.println("This is Group posted by details-->"+posterName);
		}
		}
	
	
	public void clickAllComments() {
		WebElement allComments=ldriver.findElement(By.xpath("//*[@class='j83agx80 bkfpd7mw jb3vyjys hv4rvrfc qt6c0cv9 dati1w0a l9j0dhe7']/div[2]/div/span"));
		allComments.click();
	}
}

		