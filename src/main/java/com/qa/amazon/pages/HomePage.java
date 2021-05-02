package com.qa.amazon.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aq.amazon.utils.AppConstant;
import com.aq.amazon.utils.ElementUtils;
import com.qa.amazon.basePage.BasePage;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtils elementUtils;
	Properties prop;

	private By textBox = By.id("twotabsearchtextbox");
	private By searchButton = By.id("nav-search-submit-button");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public String getHomePageTitle() {
		return elementUtils.waitForTitleToBePresent(AppConstant.HOME_PAGE_TITLE, AppConstant.DEFAULT_TIMEOUT);
		// elementUtils.doWaitForTitlePresent(AppConstant.HOME_PAGE_TITLE);

	}

	public void doEnterText() {
		elementUtils.doSendKeys(textBox, "Mobile Phones");
	}

	public MobilePhonePage doClickSearchButton() {

		elementUtils.doClick(searchButton);

		return new MobilePhonePage(driver);

	}
}
