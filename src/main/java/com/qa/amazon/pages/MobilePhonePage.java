package com.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.aq.amazon.utils.AppConstant;
import com.aq.amazon.utils.ElementUtils;
import com.qa.amazon.basePage.BasePage;


public class MobilePhonePage extends BasePage{
	
	WebDriver driver;
	ElementUtils elementUtils;
	
	private By seeMoreLink = By.xpath("//div[@id='brandsRefinements']//span[@class='a-expander-prompt']");
	private By appleCheckBox = By.xpath("//span[text()='Apple']");
	private By applePhone= By.xpath("//span[contains(text(),'Apple iPhone SE, 128GB, Red')]");
	
	
	public MobilePhonePage(WebDriver driver)
	{
		this.driver=driver;
		elementUtils= new ElementUtils(driver);
	}
	
	public String getMobilePhonePageTitle()
	{
		//return driver.getTitle();
		
		return elementUtils.waitForTitleToBePresent(AppConstant.MOBILE_PAGE_TITLE, AppConstant.DEFAULT_TIMEOUT);
//		elementUtils.doWaitForTitlePresent(AppConstant.MOBILE_PAGE_TITLE);
//		return elementUtils.doGetPageTitle();
	}
	
	public void doClickAppleCheckBox()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		elementUtils.clickWhenReady(seeMoreLink, AppConstant.DEFAULT_TIMEOUT);
		
		elementUtils.clickWhenReady(appleCheckBox, AppConstant.DEFAULT_TIMEOUT);
		
//		elementUtils.doWaitForElementPresent(seeMoreLink);
//		elementUtils.doClick(seeMoreLink);
		
		
//		elementUtils.doWaitForElementPresent(appleCheckBox);
//		elementUtils.doClick(appleCheckBox);
		
	}
	
	
	public ApplePhonePage doClickOnApplePhoneLink()

	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		elementUtils.clickWhenReady(applePhone, AppConstant.DEFAULT_TIMEOUT);
		//elementUtils.doClick(applePhone);
		
		return new ApplePhonePage(driver);
		
	}
}
