package com.qa.amazon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aq.amazon.utils.AppConstant;
import com.qa.amazon.basePage.BasePage;
import com.qa.amazon.pages.HomePage;
import com.qa.amazon.pages.MobilePhonePage;


public class MobilePhonePageTest{
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	MobilePhonePage mobilePhonePage;
	HomePageTest homePageTest;
	
	
	@BeforeTest
	public void init_Setup()
	{
		basePage= new BasePage();
		prop = basePage.init_prop();	
		String browserName = prop.getProperty("browser");
		driver = basePage.init_Driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
		homePage.doEnterText();
		mobilePhonePage = homePage.doClickSearchButton();
		
	}
	
	@Test(priority = 1)
	public void verifyMobilePhonePageTitleTest()
	{
		
		String title = mobilePhonePage.getMobilePhonePageTitle();
		System.out.println("Title of Mobile page is " +title);
		Assert.assertEquals(title, AppConstant.MOBILE_PAGE_TITLE);
		
		
//		String title = mobilePhonePage.getMobilePhonePageTitle();
//		Assert.assertEquals(title, "Amazon.com : MobilePhones");
	}
	
	@Test(priority = 2)
	public void verifyAppleCheckBoxTest()
	{
		mobilePhonePage.doClickAppleCheckBox();
	}
	
	@Test(priority = 3)
	public void verifyApplePhoneClick()
	{
		mobilePhonePage.doClickOnApplePhoneLink();
		
	}
	
	@AfterTest()
	public void tearDown() {
		driver.quit();
	}
}
