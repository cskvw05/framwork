package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;

import Base.baseDriver;


public class T002_Login extends baseDriver {
	
	


	@Test
	public void login_Test(){

		driver.get(baseURL);
		logger.info("URL is open");

		LoginPage lp = new LoginPage(driver);
		lp.setUserame(username);
		logger.info("Username is given");
		lp.setPassword(password);
		logger.info("Password is given");
		lp.loginBtn();
		logger.info("Login Button is clicked");

		if(driver.getTitle().equals("Dashboard - PHPTRAVELS")) {

			Assert.assertTrue(true);
			lp.logoutBtn();
			logger.info("Logout button is cliecked");
			logger.info("assert is passed");

		}


	}

}


