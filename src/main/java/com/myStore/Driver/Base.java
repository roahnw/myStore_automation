package com.myStore.Driver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static WebDriver driver;
	public static Properties p = null;

	public static Properties loadProperties() {
		try {
			FileReader reader = new FileReader(
					System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\config.properties");
			p = new Properties();
			p.load(reader);
		} catch (IOException e) {
			System.err.println("config.properties file not found");
		}
		return p;
	}

	public static WebDriver getDriver(String browser) {
		if (driver == null) {
			if (browser == "chrome") {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + loadProperties().getProperty("chromedriver"));

				driver = new ChromeDriver();
			} else if (browser == "gecko") {

			} else if (browser == "IE") {

			} else
				System.err.println("Unknown browser!!!");
		}
		return driver;
	}

	public static void openApplication(String url) {
		driver.navigate().to(url);
	}

	public static String capture(WebDriver driver) 
	{ 
		File scrFile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
		File Dest = new File("H:\\DemoAutomation\\commons-myStore\\ScreenShots\\" +System.currentTimeMillis() + ".png"); 
		String errflpath =Dest.getAbsolutePath(); 
		try 
		{ 
			FileUtils.copyFile(scrFile, Dest); 
		} catch (IOException e) 
		{ // TODO Auto-generated catch block e.printStackTrace(); 
		  
		}
		return errflpath;
	}
}

