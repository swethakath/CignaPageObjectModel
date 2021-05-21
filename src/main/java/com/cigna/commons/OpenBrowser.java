package com.cigna.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.session.FirefoxFilter;
import org.testng.Reporter;

public class OpenBrowser 
{
	
	
	public WebDriver browserOpen(WebDriver driver, String browsername)
	{
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			 driver = new ChromeDriver();
			 Reporter.log(browsername + " is opened");
		}else if(browsername.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
			 Reporter.log(browsername + " is opened");
		}else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			 driver = new ChromeDriver();
			 Reporter.log(browsername + " is opened");
		}else
		{
			System.out.println(browsername + " is invalid");
			Reporter.log(browsername + " is not opened");
		}
		
		return driver;
		
	}

}
