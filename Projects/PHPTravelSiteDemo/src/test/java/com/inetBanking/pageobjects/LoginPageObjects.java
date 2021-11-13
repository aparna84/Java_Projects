package com.inetBanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	WebDriver ldriver;
	public LoginPageObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);

	}
	@FindBy (name="username")
	WebElement textemail;

	@FindBy (name="password")
	WebElement textPassword;

	@FindBy (xpath="//*[@id='loginfrm']/button")
	WebElement loginButton;
	
	@FindBy (xpath="//a[@href='https://www.phptravels.net/account/logout/']")
	WebElement Logout;
	
	
	public void enterUserId(String uid) {
		textemail.sendKeys(uid);
	}

	public void enterPassword(String pwd) {
		textPassword.sendKeys(pwd);
	}

	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void clickLogoutLink() {
		Logout.click();
	}
}
