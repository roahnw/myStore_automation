package extentReports;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	public static final ExtentReports extentReports = new ExtentReports();
	
	public synchronized static ExtentReports createExtentReports() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\CustomeReports\\Report"+timeStamp+".html");
		reporter.config().setReportName("Test automation report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Blog Name", "LearingAutomation");
        extentReports.setSystemInfo("Author", "Rohanw");
        return extentReports;
	}
	
}