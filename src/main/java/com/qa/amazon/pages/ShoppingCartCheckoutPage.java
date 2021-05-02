package com.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aq.amazon.utils.AppConstant;
import com.aq.amazon.utils.ElementUtils;
import com.qa.amazon.basePage.BasePage;

public class ShoppingCartCheckoutPage extends BasePage {
	
	WebDriver driver;
	ElementUtils elementUtils;

	private By cartItem = By.xpath("(//span[contains(text(),'Apple iPhone SE')])[2]");

	public ShoppingCartCheckoutPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	
	public String getShoppingCartCheckoutPageTitle() {
		
		return elementUtils.waitForTitleToBePresent(AppConstant.SHOPPING_CART_CHECKOUT_PAGE_TITLE, AppConstant.DEFAULT_TIMEOUT);
//		elementUtils.doWaitForTitlePresent(AppConstant.SHOPPING_CART_CHECKOUT_PAGE_TITLE);
//		return elementUtils.doGetPageTitle();
	}
	
	public String getItemText()
	{
		return elementUtils.doGetText(cartItem);
	}
	
}
