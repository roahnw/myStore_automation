package testCases;

import java.lang.reflect.Method;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.myStore.Driver.Base;
import com.myStore.Driver.Logs;
import com.myStore.pages.Home_page;

import extentReports.ExtentTestManager;

public class KickOFF extends ExtentTestManager {
	
	@BeforeSuite(alwaysRun = true) 
	public void initDriver()
	{
		new Home_page();
		//new Reporting();
		Base.openApplication(Base.loadProperties().getProperty("url"));
	}
	
	
	@AfterSuite(alwaysRun = true) 
	public void destroy() 
	{
		Base.driver.quit(); 
		//Reporting.flushReport(); 
	}
	 
	
}
