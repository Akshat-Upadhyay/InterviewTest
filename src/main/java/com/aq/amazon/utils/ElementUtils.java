package com.aq.amazon.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);

		} catch (Exception e) {
			System.out.println("Some exception got occurred with this locator: " + locator);
		}
		return element;
	}

	public void doSendKeys(By locator, String value) {
		waitForElementPresent(locator, 10);
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		waitForElementPresent(locator, 10);
		getElement(locator).click();
	}

	public String doGetText(By locator) {
		waitForElementPresent(locator, 10);
		return getElement(locator).getText();
	}

	public WebElement waitForElementPresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
	}

	// clickWhenReady:
	public void clickWhenReady(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	public String waitForTitleToBePresent(String title, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	// ---------------------------------------------------------------------------------------------------------

//	WebDriver driver;
//	WebDriverWait wait;
//	
//	
//	public ElementUtils(WebDriver driver)
//	{
//		this.driver=driver;
//		wait = new WebDriverWait(driver, AppConstant.DEFAULT_TIMEOUT);
//	
//	}
//	
//	
//	public boolean doWaitForElementPresent(By locator)
//	{
//		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//		return true;
//	}
//	
//	public boolean doWaitForElementVisible(By locator)
//	{
//		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//		return true;
//	}
//	
//	public boolean doWaitForTitlePresent(String value)
//	{
//		wait.until(ExpectedConditions.titleIs(value));
//		return true;
//	}
//	
//	
//	
//	public String doGetPageTitle()
//	{
//		try
//		{
//		 return driver.getTitle();
//		}
//		catch(Exception e)
//		{
//			System.out.println("Some issue while trying to retrieve the page title");
//		}
//		return null;
//	}
//	
//	
//
//	public WebElement doGetElement(By locator)
//	{
//		WebElement element = null;
//		try
//		{
//		if(doWaitForElementPresent(locator))
//		{
//		element = driver.findElement(locator);
//		}
//		}
//		catch(Exception e)
//		{
//			System.out.println("Some issue while creating the WebElement.Please check...");
//		}
//		return element;
//		}
//
//	
//	
//	public void doSendKeys(By locator, String value)
//	{
//		try
//		{
//		WebElement ele = doGetElement(locator);
//		ele.clear();
//		ele.sendKeys(value);
//		}
//		catch(Exception e)
//		{
//			System.out.println("Some issue occured while entering value. Please check...");
//		}
//	}
//	
//	public void doClick(By locator)
//	{
//		try
//		{
//		doGetElement(locator).click();
//		}
//		catch(Exception e)
//		{
//			System.out.println("Some issue occured while trying to click on the element. Please check...");
//		}
//	}
//	
//	
//	public String doGetText(By locator)
//	{
//		try
//		{
//		return doGetElement(locator).getText();
//		}
//		catch(Exception e)
//		{
//			System.out.println("Some error occurred while trying to fetch the text. Please check...");
//		}
//		return null;
//	}

}
