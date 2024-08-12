package com.comcast.crm.contacttest;



import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.WebdriverUtility;
import com.comcast.crm.genericUtility.ExcelUtility;
import com.comcast.crm.genericUtility.FileUtility;

public class CreateContactwithSupportDatetest {

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
		String LastName = Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx","org", 4, 2)+Ju.getRandomNumber();
	


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
	
	//Navigate to contactModule
	driver.findElement(By.linkText("Contacts")).click();
	//Navigate to contactcreate
	String Startdate = Ju.getSystemDateYYYYDDMM();
	String Enddate=Ju.getrequiredDateYYYYDDMM(30);
	
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	
	
	
	

	driver.findElement(By.name("lastname")).sendKeys(LastName);
	driver.findElement(By.name("support_start_date")).clear();
	driver.findElement(By.name("support_start_date")).sendKeys(Startdate);
	
	driver.findElement(By.name("support_end_date")).clear();
	driver.findElement(By.name("support_end_date")).sendKeys(Enddate);
	
	//step3: click on save button
		driver.findElement(By.name("button")).click();
		
		
//Verify Start date and end date
		String ActStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(ActStartDate.equals(Startdate)) {
			System.out.println(ActStartDate+ "verfied=pass");
		}
		else {
			System.out.println(ActStartDate+ "verfied=Fail");
		}
		
		
		String ActEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(ActEndDate.equals(Enddate)) {
			System.out.println(ActEndDate+ "verfied=pass");
		}
		else {
			System.out.println(ActEndDate+ "verfied=Fail");
		}
		
		
	Wu.postcondtion(driver);
}
}
