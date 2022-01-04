package testCases;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//import com.myStore.Driver.Reporting;

import extentReports.ExtentTestManager;

public class Validate_HomePage extends ExtentTestManager
{
	public static SoftAssert sa = new SoftAssert();
	//Home_page h = new Home_page();
	
	@Test(priority = 1, groups = { "quick" }, description = "this is test 001")
	public void TC01(Method method)
	{
		startTest(method.getName(),"this is test 001");
		assertTrue(true);
	}	
}
