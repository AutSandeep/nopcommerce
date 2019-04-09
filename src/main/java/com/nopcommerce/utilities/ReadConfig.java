package com.nopcommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties pro;
	
	public ReadConfig() {
		
		File src = new File("./configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		} catch (Exception e) {
			
			System.out.println("Exception is "+ e.getMessage());
		}
		
	}
	
	
	public String getApplicationURL() {
		return pro.getProperty("baseURL");
		
		
		
		
	}
	
	public String getUserName() {
		String username=pro.getProperty("username");
		return username;
		
	}
	
	public String getPassword() {
		String password=pro.getProperty("password");
		return password;
		
	}
	
	public String getchromePath() {
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
		
	}
	
	public String getfirefoxPath() {
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
		
	}
	
	
	

}
