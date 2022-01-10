package com.myStore.pages;

import org.openqa.selenium.support.PageFactory;

import com.myStore.Driver.Base;
import com.myStore.Driver.constants;

public class Home_page 
{
	public Home_page()
	{
		PageFactory.initElements(Base.getDriver(constants.browser), this);
	}

}
