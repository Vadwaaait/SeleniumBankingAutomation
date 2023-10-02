package com.banking.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.utils.FileUtil;
import com.banking.utilities.ReadConfig;
import com.beust.jcommander.Parameter;

import freemarker.log.Logger;

public class BaseClass {
	
	
	ReadConfig rc=new ReadConfig();
	
	public String baseUrl=rc.getApplicationURL();
	public String username=rc.getUserName();
	public String password=rc.getPassword();
	public static WebDriver driver;
	
	
	

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", rc.getChromePath());
			driver=new ChromeDriver();
			
		}
		
		if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", rc.getFireFoxPath());
			driver=new FirefoxDriver();
			
		}
		
		
		
		
		}
	
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
	
	
	public void captureScreen(WebDriver driver,String testname) {
		
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+testname+".png");
		
		try {
			FileUtils.copyFile(source, target);
			System.out.println("ScreenShot Taken Successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
