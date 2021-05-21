package com.cigna.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cigna.commons.Commons;

public class HomePage extends Commons
{
	WebDriver driver;
	

	@FindBy(xpath="(//ul[@data-ct-component='nav-universal-links'])[1]/li[1]/a")
	WebElement menu_CignaInternational;
	
	@FindBy(xpath="(//ul[@data-ct-component='nav-universal-links'])[1]/li[2]/a")
	WebElement menu_headerContactUs;
	
	@FindBy(xpath="(//ul[@data-ct-component='nav-universal-links'])[1]/li[3]/a")
	WebElement menu_headerEspanol;
	
	
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void headerMenuValidation(String ExpectedcignaInt, String ExpectedContactUs, String ExpectedEspanol)
	{
		String contactus = menu_headerContactUs.getText();
		Assert.assertEquals(contactus, ExpectedContactUs);
		String cignaInt = menu_CignaInternational.getText();
		Assert.assertEquals(cignaInt, ExpectedcignaInt);
		String espanol = menu_headerEspanol.getText();
		Assert.assertEquals(espanol, ExpectedEspanol);
	}
	
}
