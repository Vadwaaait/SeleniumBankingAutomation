package com.banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException
	{
		
		fis=new FileInputStream("D:\\Eclipse ws\\SeleniumBanking\\TestData\\TestData.xlsx");
		
		wb=new XSSFWorkbook(fis);
		System.out.println("ky");
		
		ws=wb.getSheet(xlsheet);
		
		int rowCount = ws.getLastRowNum();
		
		
		fis.close();
		
		return rowCount;
		
	
	}
	
	
	public static int getCellCount(String xlFIle, String xlsheet,int rownumber) throws IOException
	{
		
		
		fis=new FileInputStream(xlFIle);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlsheet);
		
		row=ws.getRow(rownumber);
		
		int cellCOunt=row.getLastCellNum();
	
		fis.close();
		
		
		
		return cellCOunt;
	}
	
	
	
	public static String getCellData(String xlFile, String xlSheet, int rownum, int colnum) throws IOException
	{
		
		fis=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlSheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		
		try {
			DataFormatter df= new DataFormatter();
			String celldata=df.formatCellValue(cell);
			return celldata;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			data="";
		}
		
		fis.close();
		return data;
	
	}
	
	
	
	public static void setCellData(String xlFile, String xlSheet, int rownum, int colnum,String data) throws IOException
	{
		
		fis=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlSheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		cell.setCellValue(data);
		fos=new FileOutputStream(xlFile);
		wb.write(fos);
		
	
		fis.close();
		
	

	}	

}