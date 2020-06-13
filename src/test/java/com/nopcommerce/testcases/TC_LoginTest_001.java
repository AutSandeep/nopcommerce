package com.nopcommerce.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageobjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	
	
	
	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		
		driver.get(baseURL);
		Thread.sleep(3000);
		logger.info("url is launched");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		LoginPage loginpage= new LoginPage(driver);
		loginpage.setEmailID(username);
		logger.info("Email Id is entered ");
		loginpage.setPassword(password);
		logger.info("Password  is entered ");
		loginpage.clickLogin();
		logger.info("clicked on login button ");
		if(driver.getTitle().equals("Dashboard / nopCommerce administration1")) {
			
			Assert.assertTrue(true);
			loginpage.clickLogout();
			
		}else {
			captureScreen(driver,"logintest");
			Assert.assertTrue(false);
		}
		
		
	}
	
	

	

}
