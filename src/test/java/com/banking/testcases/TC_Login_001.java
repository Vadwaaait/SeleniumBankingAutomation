package com.banking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.banking.pageObjects.loginPage;

public class TC_Login_001 extends BaseClass{

	
	@Test
	public void loginTest() {
		
			
		driver.get(baseUrl);
		
		
		
		
		loginPage lp=new loginPage(driver);
	
		
		lp.setUsername(username);
	
		
		lp.setPassword(password);
		
		
		
		lp.clickloginbtn();
	
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			
				Assert.assertTrue(true);
			
				
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertFalse(true);
			
		}
	}
	
}
