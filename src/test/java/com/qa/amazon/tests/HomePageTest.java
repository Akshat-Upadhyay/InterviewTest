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

public class HomePageTest{

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	MobilePhonePage mobilePhonePage;

	@BeforeTest 
	public void init_Setup() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_Driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);

	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {

		String title = homePage.getHomePageTitle();
		System.out.println("Title of Home page is " + title);
		Assert.assertEquals(title, AppConstant.HOME_PAGE_TITLE);

	}

	@Test(priority = 2)
	public void verifySearchButtonTest() {
		
		homePage.doEnterText();

		mobilePhonePage = homePage.doClickSearchButton();
		String title = mobilePhonePage.getMobilePhonePageTitle();
		Assert.assertEquals(title, AppConstant.MOBILE_PAGE_TITLE);

	}

	@AfterTest()
	public void tearDown() {
		driver.quit();
	}

}
