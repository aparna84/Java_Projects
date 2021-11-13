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
	@FindBy (name="uid")
	WebElement textUserId;

	@FindBy (name="password")
	WebElement textPassword;

	@FindBy (name="btnLogin")
	WebElement loginButton;
	
	@FindBy (xpath="//a[@href='Logout.php']")
	WebElement Logout;
	
	
	public void enterUserId(String uid) {
		textUserId.sendKeys(uid);
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
