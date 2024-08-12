package com.comcast.crm.generic.listnerUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.ObjectUtility;
import com.comcast.crm.generic.baseUtility.Baseclass;

//JavaUtility Ju=newJavaUtility();
public class ListImpClass implements ITestListener,ISuiteListener {
	JavaUtility Ju=new JavaUtility();
	public static ExtentSparkReporter spark;
	public ExtentTest test;
	public static ExtentReports report;//making static to use in other class instead of making object of listImp class
	public void onStart(ISuite suite) {
		System.out.println("ReportConfiguration");
		//spark report configu.
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report"+Ju.getLocalDateandTime()+".html");
		spark.config().setDocumentTitle("CRM etst suite results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add environment info and create test
		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-10");
		report.setSystemInfo("browser", "chrome-1.01");
}
		
	
public void onFinish(ISuite suite) {
	System.out.println("Report Backup");
    //to save the report
	report.flush();
		
	}
	public void onTestStart(ITestResult result) {
		System.out.println("===="+result.getMethod().getMethodName()+"==START==");
		 test=report.createTest(result.getMethod().getMethodName());
		 ObjectUtility.setTest(test);
		 test.log(Status.INFO, result.getMethod().getMethodName()+"==Start==");
		
	}
public void onTestSuccess(ITestResult result) {
	System.out.println("===="+result.getMethod().getMethodName()+"==END==");
	 test.log(Status.PASS, result.getMethod().getMethodName()+"==completed==");	
	}
public void onTestFailure(ITestResult result) {
	
	String testname = result.getMethod().getMethodName();
	TakesScreenshot tss= (TakesScreenshot)Baseclass.sdriver;
	String tempfile = tss.getScreenshotAs(OutputType.BASE64);
	test.addScreenCaptureFromBase64String(tempfile, testname+Ju.getLocalDateandTime());
	test.log(Status.FAIL, result.getMethod().getMethodName()+"==failed==");
	test.log(Status.FAIL, result.getThrowable()+"==failed==");
	
	
}

	

}
