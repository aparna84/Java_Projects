package com.facebook.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePost {

	WebDriver ldriver;
	JavascriptExecutor jsx;

	public CreatePost(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	@FindBy (xpath="//*[@class='m9osqain a5q79mjw gy2v8mqq jm1wdb64 k4urcfbm qv66sw1b']")
	WebElement ClickCreatePost;

	@FindBy( xpath="//*[@class='taijpn5t pq6dq46d bp9cbjyn cgat1ltu']")
	WebElement ClickFriendDrodown;

	@FindBy (xpath="//*[@class='rq0escxv datstx6m k4urcfbm a8c37x1j']/div/div[2]/div")
	WebElement composePost;

	@FindBy (xpath="//*[@class='rq0escxv l9j0dhe7 du4w35lb j83agx80 pfnyh3mw taijpn5t bp9cbjyn owycx6da btwxx1t3 kt9q3ron ak7q8e6j isp2s0ed ri5dt5u2 rt8b4zig n8ej3o3l agehan2d sk4xxmp2 d1544ag0 tw6a2znq s1i5eluu tv7at329']")
	WebElement clickPostButton;
	
	public void clickCreatePost() 
	{
		ClickCreatePost.click();
	}

	public void ClickFriendDrodownMenu()
	{
		ClickFriendDrodown.click();
		List<WebElement> FriendsList=ldriver.findElements(By.xpath("//*[@class='lzcic4wl b20td4e0 muag1w35']/div"));
		for(WebElement element:FriendsList)
		{
			String items=element.getText();
			System.out.println("All dropdown items are-->"+items);
			if(items.contains("Only me"))
			{
				element.click();
			}
		}
	}
	
	public void composePost() {
		composePost.sendKeys("This is Selenium Test");
	}
	
	public void clickPostButton()
	{
		clickPostButton.click();
	}
	
	//Check all posts
	public void AllPostsDetails() throws InterruptedException
	{
		
		JavascriptExecutor jsx = (JavascriptExecutor)ldriver;
		int i=1;
		do
		{
			
		
		jsx.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(10000);
		
		i++;
		}
		while(i<2);
		
		
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
		
	String posterName="";
		int i=1;
		do
		{
			
		jsx=(JavascriptExecutor)ldriver;
		jsx.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(10000);
		List<WebElement> name=ldriver.findElements(By.xpath("//*[@class='gmql0nx0 l94mrbxd p1ri9a11 lzcic4wl aahdfvyu hzawbc8m']/span/a/strong/span"));
		//jsx.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(10000);
		
		System.out.println("Posts -->"+name.size());
		for(WebElement element: name)
		{
			 posterName=element.getText();
			System.out.println("This is posted by-->"+posterName);
		}
		i++;
		}
		while(i< 5 && posterName.contains("Aparna Guttula"));
		
		
		}
	
}