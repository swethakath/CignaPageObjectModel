package com.cigna.homepage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cigna.commons.Commons;
import com.cigna.commons.OpenBrowser;
import com.cigna.pages.HomePage;

public class HomePageHeaderValidation extends Commons
{
	
	WebDriver driver;
	OpenBrowser openBrowser = new OpenBrowser();
	
	@Parameters({"browsername","url"})
	@BeforeMethod
	public void setup(String browsername,String url)
	{
	 driver=openBrowser.browserOpen(driver, browsername);
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	 navigateUrl(driver, url);
	}
	
	
	
	@Test
	public void homePageHeaderValidation()
	{
		HomePage homePage = new HomePage(driver);
		homePage.headerMenuValidation("Cigna International", "Contact Us", "Español");
		
	}

}
