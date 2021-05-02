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
import com.qa.amazon.pages.ShoppingCartCheckoutPage;
import com.qa.amazon.pages.ShoppingCartPage;

public class ShoppingCartCheckoutPageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	MobilePhonePage mobilePhonePage;
	HomePageTest homePageTest;
	ApplePhonePage applePhonePage;
	ShoppingCartPage shoppingCartPage;
	ShoppingCartCheckoutPage shoppingCartCheckoutPage;

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

		shoppingCartCheckoutPage = shoppingCartPage.doClickOnCart();

	}

	@Test(priority = 1)
	public void verifyShoppingCartCheckoutPagePageTitleTest() {

		String title = shoppingCartCheckoutPage.getShoppingCartCheckoutPageTitle();
		System.out.println("Title of Shopping Cart Checkout page is " + title);
		Assert.assertEquals(title, AppConstant.SHOPPING_CART_CHECKOUT_PAGE_TITLE);

	}

	@Test(priority = 2)
	public void verifyCartItem() {
		String item = shoppingCartCheckoutPage.getItemText();
		System.out.println("Item value is :" + item);
		Assert.assertEquals(item, AppConstant.CART_VALUE);
	}

	@AfterTest()
	public void tearDown() {
		driver.quit();
	}

}
