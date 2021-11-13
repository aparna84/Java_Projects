package com.facebook.pageobjects;

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
	@FindBy (id="email")
	WebElement email;

	@FindBy (name="pass")
	WebElement password;

	@FindBy (name="login")
	WebElement loginButton;
	
	@FindBy (xpath="//a[@href='Logout.php']")
	WebElement Logout;
	
	
	public void enterEmail(String uid) {
		email.sendKeys(uid);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void clickLogoutLink() {
		Logout.click();
	}
}
