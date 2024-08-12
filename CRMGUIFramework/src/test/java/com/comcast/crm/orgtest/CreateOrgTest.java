package com.comcast.crm.orgtest;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.WebdriverUtility;
import com.comcast.crm.genericUtility.ExcelUtility;
import com.comcast.crm.genericUtility.FileUtility;

public class CreateOrgTest {
public static void main(String[] args) throws Throwable {
	
	
	

	FileUtility Fu=new FileUtility();
	ExcelUtility Eu=new ExcelUtility();
	JavaUtility Ju=new JavaUtility();
	WebdriverUtility Wu=new WebdriverUtility();

	String URL = Fu.getdatafrompropertiesfile("url");
	String BROWSER = Fu.getdatafrompropertiesfile("browser");
	String UN = Fu.getdatafrompropertiesfile("username");
	String PWD = Fu.getdatafrompropertiesfile("password");
	
	//Read the test script data from excel file
	String orgname = Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx","org", 1, 2)+Ju.getRandomNumber();
	


	WebDriver driver=null;
	
	if(BROWSER.equals("chrome")) 
	{
		driver=new ChromeDriver();
	}
	else if(BROWSER.equals("edge"))
	{
		driver=new EdgeDriver();
		
	}
	Wu.MaximizeWindow();
	Wu.waitForPagetoLoad();
	
	 
//step1:login to app
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(UN);
	driver.findElement(By.name("user_password")).sendKeys(PWD);
	driver.findElement(By.id("submitButton")).submit();
	Wu.screenshot_Webpage( "Loginpage");
	
	//step2: Navigate to Organisation module 
	driver.findElement(By.linkText("Organizations")).click();
	
	//step3: click on Create Organisation button
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	//step3: Enter the values to the Organisation name textfield
	
	driver.findElement(By.name("accountname")).sendKeys(orgname);
	//step3: click on save button
	driver.findElement(By.name("button")).click();
	
	//verify  Headermsg ExpectedREsult
	
	String headerinfo =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(headerinfo.contains(orgname)) {
		System.out.println(orgname+ "verfied=pass");
	}
	else {
		System.out.println(orgname+ "verfied=Fail");
	}
	//verify  Header orgName info ExpectedREsult
	String HeaderorgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
	if(HeaderorgName.equals(orgname)) {
		System.out.println(orgname+ "verfied=pass");
	}
	else {
		System.out.println(orgname+ "verfied=Fail");
	}
	Wu.postcondtion(driver);
}
}
