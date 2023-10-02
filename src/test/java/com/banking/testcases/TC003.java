package com.banking.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.pageObjects.googlePage;
import com.banking.pageObjects.loginPage;

public class TC003 extends BaseClass{
	
	@Test(dataProvider  = "data-provider")
	public void gandu(String a,String b) {
		
	
		
		System.out.println("EmailId - "+a +"   "+"Password - "+b );
	
		
		
	
		
	
	}
	
	
	@DataProvider (name = "data-provider")
    public String[][] dpMethod(){
		
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
