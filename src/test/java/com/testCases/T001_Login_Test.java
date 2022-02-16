package com.testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page.CaptureScreenshotFormat;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;

import Base.baseDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class T001_Login_Test extends baseDriver  {


	
	
	@Test
	public void login_Test() throws IOException{
		
		driver.get(baseURL);
		logger.info("URL is open");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserame(username);
		logger.info("Username is given");
		lp.setPassword(password);
		logger.info("Password is given");
		lp.loginBtn();
		logger.info("Login Button is clicked");
		
		if(driver.getTitle().equals("Dashboard - PHPTRAVELS"))
		{
			//captureScreen(driver,"logintest");
			Assert.assertTrue(true);
			lp.logoutBtn();
			logger.info("Logout button is cliecked");
			logger.info("assert is passed");
		}
		else 
		{
			captureScreen(driver,"logintest");
			Assert.assertTrue(false);
			logger.info("Test Failed");	
		}
		
	}
	
}
