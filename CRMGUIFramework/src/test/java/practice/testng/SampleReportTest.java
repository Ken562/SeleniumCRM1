package practice.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	ExtentReports report;
	
	@BeforeSuite
	public void configBS() {
		//spark report configu.
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM etst suite results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add environment info and create test
		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-10");
		report.setSystemInfo("browser", "chrome-1.01");
	}
	
	
	@AfterSuite
	public void configAS() {
		report.flush();
	}
	
@Test
public void createContact() {
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888");
	
	TakesScreenshot tss= (TakesScreenshot)driver;
	String tempfile = tss.getScreenshotAs(OutputType.BASE64);
	
	ExtentTest test=report.createTest("createContact");
	
	test.log(Status.INFO, "login to app");
	test.log(Status.INFO, "navigate to contact page");
	test.log(Status.INFO, "createContact");
	if("HDFC".equals("HD")) {
		test.log(Status.PASS, "Contact is created");
	}
	else {
		test.addScreenCaptureFromBase64String(tempfile, "errorfile");
	}
	
}
//@Test
//public void createContactwithorg() {
//	
//	ExtentTest test=report.createTest("createContactwithorg");
//	
//	test.log(Status.INFO, "login to app");
//	test.log(Status.INFO, "navigate to contact page");
//	test.log(Status.INFO, "createContactwithorg");
//	
//	if("HDFC".equals("HDFC")) {
//		test.log(Status.PASS, "createContactwithorg is created");
//	}
//	else {
//		test.log(Status.FAIL, "createContactwithorg is not created");
//		//test.log(Status.FAIL, );
//	}
//}
//@Test
//public void createContactwithphonenumber() {
//	
//	ExtentTest test=report.createTest("createContactwithphonenumber");
//	
//	test.log(Status.INFO, "login to app");
//	test.log(Status.INFO, "navigate to contact page");
//	test.log(Status.INFO, "createContact");
//	if("HDFC".equals("HDFC")) {
//		test.log(Status.PASS, "createContactwithphonenumber is created");
//	}
//	else {
//		test.log(Status.FAIL, "createContactwithphonenumber is not created");
//	}
//}
}
