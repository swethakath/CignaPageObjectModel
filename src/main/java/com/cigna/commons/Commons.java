package com.cigna.commons;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

public class Commons 
{
	public FileInputStream fis;
	public Properties prop;
	
	
	public String headerCignaInternational = "(//ul[@data-ct-component='nav-universal-links'])[1]/li[1]/a";
	public String headerContactUs = "(//ul[@data-ct-component='nav-universal-links'])[1]/li[2]/a";
	public String headerEspanol = "(//ul[@data-ct-component='nav-universal-links'])[1]/li[3]/a";
	
	public void click(WebDriver driver,String xpathvalue,String text) throws Exception
	{
		try
		{
		driver.findElement(By.xpath(xpathvalue)).click();	
		Reporter.log(text + " is clicked");
		System.out.println(text+ " is clicked");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			Reporter.log(text + " is not clicked " + e.getMessage());
		//	Assert.fail(text + " is not clicked");
		}
	}
	
	
	public void navigateUrl(WebDriver driver,String url)
	{
		try
		{
			driver.get(url);
			Reporter.log(url + " is entered");
		}catch(Exception e)
		{
			
			Reporter.log(url + " is not entered");
			System.out.println("Navigate URL method is not working "+e.getMessage());
			Assert.fail("URL is not entered");
		}
	}
	
	public void verifyTitle(WebDriver driver,String expectedTitle)
	{
		try
		{
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
			Reporter.log(actualTitle + " is matched with " + expectedTitle); 
			
		}catch(Exception e)
		{
			Reporter.log(expectedTitle + "Title is not matched");
			System.out.println(e.getMessage());
		}
	}
	
	public void verifyText(WebDriver driver,WebElement xpathvalue,String expectedText)
	{
		try
		{
			String actualtext = xpathvalue.getText();
			System.out.println(actualtext);
			Assert.assertEquals(actualtext, expectedText);
			Reporter.log(actualtext + " is matched with " + expectedText); 
			
		}catch(Exception e)
		{
			Reporter.log(expectedText + "Title is not matched");
			System.out.println(e.getMessage());
		}
	}
	
	public void currentURLValidation(WebDriver driver,String expectedURL) throws Exception
	{
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
		Reporter.log(actualURL + " is matched with " + expectedURL); 		
	}
	
	public Properties propertiesRead(String filePath)
	{
		try
		{
			 fis = new FileInputStream(filePath);
			 prop = new Properties();
			prop.load(fis);
			
			return prop;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

}
