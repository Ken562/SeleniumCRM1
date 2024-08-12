package com.comcast.crm.generic.baseUtility;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.Objectrepositoryutlity.Homepage;
import com.comcast.crm.Objectrepositoryutlity.Login;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.ObjectUtility;
import com.comcast.crm.generic.WebDriverUtility.WebdriverUtility;
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.genericUtility.ExcelUtility;
import com.comcast.crm.genericUtility.FileUtility;

public class Baseclass {
	
	
	public DatabaseUtility Du=new DatabaseUtility();
	public FileUtility Fu=new FileUtility();
	public ExcelUtility Eu=new ExcelUtility();
	public JavaUtility Ju=new JavaUtility();
	public WebdriverUtility Wu=new WebdriverUtility();



	public WebDriver driver=null;
	public static WebDriver sdriver=null;//We re creating another driver bcz static driver can't take part in parallel execution.
	@BeforeSuite(groups={"smokeTest","regressionTest"})
public void configbs() throws Throwable {
	System.out.println("connect to DB,Report Confgi");	
	Du.getDatabaseConeection();
	}
	
//@Parameters("BROWSER")

@BeforeClass(groups={"smokeTest","regressionTest"})
public void configBC() throws Throwable {
	System.out.println("launch the browser");
	String URL = Fu.getdatafrompropertiesfile("url");
	String Browser=Fu.getdatafrompropertiesfile("browser");
			//browser;
			
	driver=Wu.launchTheBrowser(Browser);
	sdriver=driver;
	// To pass browser session ID to EventFiringWebDriver(), driver is main driver and sdriver is temporary driver.here we are storing session id to sdriver.
	ObjectUtility.setDriver(driver);
	Wu.MaximizeWindow();
	Wu.waitForPagetoLoad();
	Wu.getUrl(URL);
}

	@BeforeMethod(groups={"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		System.out.println("login");
		Login lu=new Login(driver);
		String UN = Fu.getdatafrompropertiesfile("username");
		String PWD = Fu.getdatafrompropertiesfile("password");
		lu.loginToapp(UN, PWD);
		
	}

	@AfterMethod(groups={"smokeTest","regressionTest"})
public void configAM() {
	System.out.println("logout");
	Homepage page=new Homepage(driver);
	page.logOutfromApp();
	
	

}
	@AfterClass(groups={"smokeTest","regressionTest"})
public void configAC() {
	System.out.println("close the browser");
	driver.quit();
}
	@AfterSuite(groups={"smokeTest","regressionTest"})
public void configAS() throws Throwable {
	System.out.println("close DB, report backup");
	Du.closeConnection();
	
}
}
