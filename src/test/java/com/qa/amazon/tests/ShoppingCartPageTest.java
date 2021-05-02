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
import com.qa.amazon.pages.ShoppingCartPage;

public class ShoppingCartPageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	MobilePhonePage mobilePhonePage;
	HomePageTest homePageTest;
	ApplePhonePage applePhonePage;
	ShoppingCartPage shoppingCartPage;

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
		shoppingCartPage = applePhonePage.doAddToCart();

	}

	@Test(priority = 1)
	public void verifyShoppingCartPageTitleTest() {

		String title = shoppingCartPage.getShoppingCartPageTitle();
		System.out.println("Title of Shopping Cart page is " + title);
		Assert.assertEquals(title, AppConstant.SHOPPING_CART_PAGE_TITLE);

	}
	
	@Test(priority = 2)
	public void verifyClickOnCart()
	{
		shoppingCartPage.doClickOnCart();
	}

	@AfterTest()
	public void tearDown() {
		driver.quit();
	}
}
