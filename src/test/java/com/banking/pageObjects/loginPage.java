package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	
	WebDriver driver;
	
	public loginPage(WebDriver wdriver) {
		
		driver=wdriver;
		PageFactory.initElements(wdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement userpass;
	
	@FindBy(name="btnLogin")
	WebElement loginbtn;
	
	
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
	WebElement lnklogout;
	
	
	public void setUsername(String name)
	{
		username.sendKeys(name);
		
	}
	

	public void setPassword(String pass)
	{
		userpass.sendKeys(pass);
		
	}
	
	public void clickloginbtn() {
		loginbtn.click();
		
	}
	
	public void clicklogout() {
		
		lnklogout.click();
	}
	
	
	
}
