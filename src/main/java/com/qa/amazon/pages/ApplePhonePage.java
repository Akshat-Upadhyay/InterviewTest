package com.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aq.amazon.utils.AppConstant;
import com.aq.amazon.utils.ElementUtils;
import com.qa.amazon.basePage.BasePage;

public class ApplePhonePage extends BasePage {

	private By addToCart = By.xpath("//input[@id='add-to-cart-button']");

	WebDriver driver;
	ElementUtils elementUtils;

	public ApplePhonePage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public String getApplePageTitle() {
		
		return elementUtils.waitForTitleToBePresent(AppConstant.APPLE_PAGE_TITLE, AppConstant.DEFAULT_TIMEOUT);
//		elementUtils.doWaitForTitlePresent(AppConstant.APPLE_PAGE_TITLE);
//		return elementUtils.doGetPageTitle();
	}

	public ShoppingCartPage doAddToCart() {
		elementUtils.doClick(addToCart);

		return new ShoppingCartPage(driver);
	}
}
