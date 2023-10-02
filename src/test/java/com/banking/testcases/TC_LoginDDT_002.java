package com.banking.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.pageObjects.loginPage;
import com.banking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	
	@Test(dataProvider = "TestData")
	public void loginddt(String uname, String pass) {
		driver.get(baseUrl);
		System.out.println(uname);
		System.out.println(pass);
		loginPage lp= new loginPage(driver);
	
		lp.setUsername(uname);
		lp.setPassword(pass);
		lp.clickloginbtn();
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			
		}
		else {
			
			Assert.assertTrue(true);
			lp.clicklogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
		
	}
	
	
	public boolean isAlertPresent() {
		
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e){
			return false;
		}
		}
	
	
	
	@DataProvider(name="TestData")
		public String[][] getData() throws Exception
	{
String[][] ans = null;
		
		File file=new File("D:\\Eclipse ws\\SeleniumBanking\\TestData\\TestData.xlsx");
		try {
			FileInputStream fis=new FileInputStream(file);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet ws=wb.getSheet("Sheet1");
			XSSFRow row=ws.getRow(1);
			XSSFCell cell=row.getCell(0);
			
			int rowcount=ws.getLastRowNum();
			int cols=row.getLastCellNum();
			ans=new String[rowcount][cols];
			
			for(int i=1;i<=rowcount;i++)
			{
				
				int j=0;
				while(j<cols)
				{
					row=ws.getRow(i);
					cell=row.getCell(j);
					
					ans[i-1][j]=cell.getStringCellValue();
					
					
					j++;
				}
				
			}
		
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	 return ans;
		
	}

}
