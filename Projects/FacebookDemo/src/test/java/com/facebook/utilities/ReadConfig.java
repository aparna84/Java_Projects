package com.facebook.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties prop;
	public ReadConfig(){
		File file= new File("./Configurations/config.properties");
	
		try {
			FileInputStream fis= new FileInputStream(file);
			prop= new Properties();
			prop.load(fis);
			
		}
		catch(Exception e)
		{
			System.out.println("Expcetion is"+e.getMessage());
		}
	}
	
	public String getBaseURL()
	{
		String URL= prop.getProperty("baseURL");
		return URL;
	}
	
	public String getUserID()
	{
		String uname= prop.getProperty("username");
		return uname;
	}
	public String getpassword()
	{
		String pwd= prop.getProperty("password");
		return pwd;
	}
	public String getchromepath()
	{
		String cpath= prop.getProperty("chromepath");
		return cpath;
	}
}
