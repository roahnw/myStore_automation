package com.myStore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.Driver.Base;
import com.myStore.Driver.constants;

public class ContactUs_page extends BasePage
{
	public ContactUs_page()
	{
		PageFactory.initElements(Base.getDriver(constants.browser), this);
	}
	
	@FindBy(linkText = "Contact us")
	WebElement contactUs_link1;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailaddress_txtbox;
	
	@FindBy(xpath = "//input[@id='id_order']")
	WebElement refNo;
	
	public void enterEmailaddress(String value)
	{
		enterText(emailaddress_txtbox, value);
	}
	
	public void enterRefNo(String value)
	{
		enterText(refNo, value);
	}
	
	public void clickonContactUs1()
	{
		click(contactUs_link1);
	}
}
