package com.comcast.crm.generic.WebDriverUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class ObjectUtility {
	public static ThreadLocal<ExtentTest>test=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver>driver=new ThreadLocal<WebDriver>();
	
	public static void setTest(ExtentTest acttest) {
		test.set(acttest);
	}
	public static void setDriver(WebDriver actdriver) {
		driver.set(actdriver);
	}
	public static ExtentTest getTest() {
		return test.get();
	}
	public static WebDriver getdriver() {
		return driver.get();
	}
	

}
