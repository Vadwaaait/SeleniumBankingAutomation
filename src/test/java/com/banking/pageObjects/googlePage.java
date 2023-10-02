package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class googlePage {
	
	
	WebDriver driver;
	
	public googlePage(WebDriver wdriver) {
		System.out.println("Constructor google");
		driver=wdriver;
		PageFactory.initElements(wdriver, this);
	}

	
	@FindBy(id="APjFqb")
	public WebElement search;
	
	@FindBy(name="btnK")
	public WebElement gsear;
	
	public void clicksearchbox()
	{
		search.click();
		
		search.sendKeys("Hello");
	}
	
	public void sear()
	{
		gsear.click();
	}
	
	
}
