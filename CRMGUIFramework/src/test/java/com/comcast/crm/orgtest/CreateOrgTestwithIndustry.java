package com.comcast.crm.orgtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.WebdriverUtility;
import com.comcast.crm.genericUtility.ExcelUtility;
import com.comcast.crm.genericUtility.FileUtility;

public class CreateOrgTestwithIndustry {

	public static void main(String[] args) throws Throwable {
		
	
	
		WebDriver driver;

		FileUtility Fu=new FileUtility();
		ExcelUtility Eu=new ExcelUtility();
		JavaUtility Ju=new JavaUtility();
		WebdriverUtility Wu=new WebdriverUtility();
		

		String URL = Fu.getdatafrompropertiesfile("url");
		String BROWSER = Fu.getdatafrompropertiesfile("browser");
		String UN = Fu.getdatafrompropertiesfile("username");
		String PWD = Fu.getdatafrompropertiesfile("password");
		
		//Read the test script data from excel file
		String orgname = Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx","org", 4, 2)+Ju.getRandomNumber();
		String Industry=Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx","org", 4, 3);
		String Type=Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx","org", 4, 4);
	


		driver=Wu.launchTheBrowser("chrome");
	Wu.MaximizeWindow();
	Wu.waitForPagetoLoad();
	 
	//step1:login to app
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(UN);
	driver.findElement(By.name("user_password")).sendKeys(PWD);
	driver.findElement(By.id("submitButton")).submit();
	//step2: Navigate to Organisation module 
	driver.findElement(By.linkText("Organizations")).click();
	//step3: click on Create Organisation button
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	//step3: Enter the values to the Organisation name textfield
	
	driver.findElement(By.name("accountname")).sendKeys(orgname);
//	WebElement IndusrtyDd = driver.findElement(By.name("industry"));
//	IndusrtyDd.click();
       Wu.HandleDropdownbyText(driver.findElement(By.name("industry")),Industry );
	
	WebElement TypeDd = driver.findElement(By.name("accounttype"));
	Wu.HandleDropdownbyText(TypeDd, Type);
	
	//step3: click on save button
	driver.findElement(By.name("button")).click();
	
	//verify  and Type info ExpectedREsult
		String IndustryName = driver.findElement(By.id("dtlview_Industry")).getText();
		if(IndustryName.equals(Industry)) {
			System.out.println(IndustryName+ "verfied=pass");
		}
		else {
			System.out.println(IndustryName+ "verfied=Fail");
		}
		
		String typeName = driver.findElement(By.id("dtlview_Type")).getText();
		if(typeName.equals(Type)) {
			System.out.println(typeName+ "verfied=pass");
		}
		else {
			System.out.println(typeName+ "verfied=Fail");
		}
	
		Wu.postcondtion(driver);
	
	

	
	
	
}
}

	


