package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	
	public WebDriver ldriver;

	public LoginPage (WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath="//input[@placeholder='Email']")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(xpath="//input[@placeholder='Password']")
	@CacheLookup
	WebElement txtpassword;

	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
	WebElement btnLogin;


	@FindBy(xpath="(//a[@href='https://www.phptravels.net/account/logout'])[2]")
	@CacheLookup
	WebElement btnLogout;


	public void setUserame(String uname) {

		txtEmail.sendKeys(uname);
	}

	public void setPassword(String pwd) {

		txtpassword.sendKeys(pwd);
	}

	public void loginBtn() {

		btnLogin.click();;
	}

	public void logoutBtn() {

		btnLogout.click();
	}

}
