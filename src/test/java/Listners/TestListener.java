package Listners;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.Objects;
import com.myStore.Driver.Base;
import com.myStore.Driver.Logs;

import extentReports.ExtentManager;
import extentReports.ExtentTestManager;


public class TestListener extends ExtentTestManager implements ITestListener {
	private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    
	@Override
    public void onStart(ITestContext iTestContext) {
        Logs.info("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", Base.driver);
    }
	
	@Override
    public void onFinish(ITestContext iTestContext) {
        Logs.info("I am in onFinish method " + iTestContext.getName());
        //Logs.info("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for ExtentReports reporting!
        ExtentManager.extentReports.flush();
    }
	
	@Override
    public void onTestStart(ITestResult iTestResult) {
        Logs.info(getTestMethodName(iTestResult) + " test is starting.");
    }
	
	@Override
    public void onTestSuccess(ITestResult iTestResult) {
        Logs.info(getTestMethodName(iTestResult) + " test is succeed.");
        //ExtentReports log operation for passed tests.
        getTest().log(Status.PASS, "Test passed");
    }
	
	@Override
    public void onTestFailure(ITestResult iTestResult) {
        Logs.info(getTestMethodName(iTestResult) + " test is failed.");
        //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
        WebDriver driver = Base.driver;
        //Take base64Screenshot screenshot for extent reports
        String base64Screenshot =
            "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
        //ExtentReports log and screenshot operations for failed tests.
        
        getTest().log(Status.FAIL, "Test Failed",
            getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
    }
	
	@Override
    public void onTestSkipped(ITestResult iTestResult) {
        Logs.info(getTestMethodName(iTestResult) + " test is skipped.");
        //ExtentReports log operation for skipped tests.
        getTest().log(Status.SKIP, "Test Skipped");
    }
	
	@Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Logs.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}