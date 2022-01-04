package testCases;


import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//import com.myStore.Driver.Reporting;
import com.myStore.pages.ContactUs_page;

import extentReports.ExtentTestManager;

public class Validate_ContactUs extends ExtentTestManager
{
	public static SoftAssert sa = new SoftAssert();
	ContactUs_page cp = new ContactUs_page();
	@BeforeClass(alwaysRun = true)
	public void gotoContactUsPage()
	{
		cp.clickonContactUs1();
	}
	
	@Test(priority = 2,groups = {"quick"} )
	public void TC02(Method method)
	{
		startTest(method.getName(),"this is test 002");
		cp.enterEmailaddress("test@test.com");
		sa.fail();
	}
	
	@Test(priority = 3, groups = {"quick"})
	public void TC03(Method method)
	{ 
		startTest(method.getName(),"this is test 003");
		cp.enterRefNo("1234567");
		sa.assertTrue(true);
		sa.assertAll();
	}
}
