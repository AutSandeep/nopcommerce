package com.nopcommerce.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.commons.io.FileUtils;

import com.nopcommerce.utilities.ReadConfig;




public class BaseClass {
	
	ReadConfig readconfig= new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {

		logger= Logger.getLogger("nopcommerce");
		PropertyConfigurator.configure("log4j.properties");
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readconfig.getchromePath() );
			driver= new ChromeDriver();
		}else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getfirefoxPath() );
			driver= new FirefoxDriver();
			
		}
		
		

	}
	
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname ) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshot/"+tname+".png");
		FileUtils.copyFile(src,target);
		
	}
	

}
