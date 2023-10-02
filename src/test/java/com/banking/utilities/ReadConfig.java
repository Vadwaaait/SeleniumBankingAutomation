package com.banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	
	public ReadConfig() {
		
		File src= new File("./Configurations/config.properties");
		
		try {
			
			FileInputStream fis=new FileInputStream(src);
			prop =new Properties();
			prop.load(fis);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	
	
	public String getApplicationURL() {
		
		String url=prop.getProperty("baseUrl");
		
		return url;
		
			}
	
		public String getUserName() {
		
		String url=prop.getProperty("username");
		
		return url;
			}

		
		
	 public String getPassword() {
	
		 	String url=prop.getProperty("password");
	
		 		return url;
				}
	 
	 public String getChromePath() {
			
		 	String url=prop.getProperty("chromepath");
	
		 		return url;
				}
	 
	 public String getFireFoxPath() {
			
		 	String url=prop.getProperty("firefoxpath");
	
		 		return url;
				}


}
