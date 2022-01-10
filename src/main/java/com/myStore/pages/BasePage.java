package com.myStore.pages;

import org.openqa.selenium.WebElement;

public class BasePage 
{
	public void enterText(WebElement element, String val)
	{
		element.clear();
		element.sendKeys(val);
	}
	
	public void click(WebElement element)
	{
		element.click();
	}
}
