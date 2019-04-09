package com.nopcommerce.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	
	@FindBy(xpath="//input[@id='Email']")
	public WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	public WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Log in']")
	public WebElement btnlogin;
	
	@FindBy(xpath="//a[@href='/logout']")
	public WebElement btnlogout;
	
	
	public void setEmailID(String email) {
		txtEmail.sendKeys(email);
		
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
		
	}
	
	public void clickLogin() {
		btnlogin.click();
		
	}
	
	public void clickLogout() {
		Actions act= new Actions(ldriver);
		act.moveToElement(btnlogout).click().build().perform();
		
		
	}
	
	


}
