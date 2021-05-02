package com.qa.amazon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aq.amazon.utils.AppConstant;
import com.qa.amazon.basePage.BasePage;
import com.qa.amazon.pages.ApplePhonePage;
import com.qa.amazon.pages.HomePage;
import com.qa.amazon.pages.MobilePhonePage;

public class ApplePhonePageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	MobilePhonePage mobilePhonePage;
	HomePageTest homePageTest;
	ApplePhonePage applePhonePage;

	@BeforeTest
	public void init_Setup() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_Driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
		homePage.doEnterText();
		mobilePhonePage = homePage.doClickSearchButton();
		mobilePhonePage.doClickAppleCheckBox();
		applePhonePage = mobilePhonePage.doClickOnApplePhoneLink();

	}

	@Test(priority = 1)
	public void verifyApplePhonePageTitleTest() {

		String title = applePhonePage.getApplePageTitle();
		System.out.println("Title of Apple page is " + title);
		Assert.assertEquals(title, AppConstant.APPLE_PAGE_TITLE);

	}

	@Test(priority = 2)
	public void verifyAddToCart() {
		applePhonePage.doAddToCart();

	}

	@AfterTest()
	public void tearDown() {
		driver.quit();
	}

}
