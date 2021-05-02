package com.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aq.amazon.utils.AppConstant;
import com.aq.amazon.utils.ElementUtils;
import com.qa.amazon.basePage.BasePage;

public class ShoppingCartPage extends BasePage {

	WebDriver driver;
	ElementUtils elementUtils;

	private By clickOnCart = By.xpath("//a[@id='hlb-view-cart-announce']");

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public String getShoppingCartPageTitle() {
		return elementUtils.waitForTitleToBePresent(AppConstant.SHOPPING_CART_PAGE_TITLE, AppConstant.DEFAULT_TIMEOUT);
//		elementUtils.doWaitForTitlePresent(AppConstant.SHOPPING_CART_PAGE_TITLE);
//		return elementUtils.doGetPageTitle();
	}

	public ShoppingCartCheckoutPage doClickOnCart()

	{
		elementUtils.doClick(clickOnCart);	
		return new ShoppingCartCheckoutPage(driver);
	}
}
