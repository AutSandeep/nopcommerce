package com.nopcommerce.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageobjects.LoginPage;
import com.nopcommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user, String Pwd) throws InterruptedException {
		
		driver.get(baseURL);
		Thread.sleep(3000);
		logger.info("url is launched");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		LoginPage loginpage= new LoginPage(driver);
		loginpage.setEmailID(user);
		logger.info("Email Id is entered ");
		loginpage.setPassword(Pwd);
		logger.info("Password  is entered ");
		loginpage.clickLogin();
		logger.info("clicked on login button ");
		if(driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			
			Assert.assertTrue(true);
			loginpage.clickLogout();
			
		}else {
			//captureScreen(driver,"logintest");
			Assert.assertTrue(false);
		}
		
		
	}
	
	@DataProvider(name="LoginData")
	public String[][] getdata() throws IOException {
		
		//String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\nopcommerce\\testdata\\LoginData.xlsx";
		//String path=System.getProperty("user.dir")+"/src/test/java/com/nopcommerce/testData/LoginData.xlsx";
		
		String path=System.getProperty("user.dir")+"\\configuration\\LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]= new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount; j++) {
				
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
			
		}
		return logindata;
		
		
	}
	

}
