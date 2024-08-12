package com.comcast.crm.contacttest;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.WebdriverUtility;
import com.comcast.crm.genericUtility.ExcelUtility;
import com.comcast.crm.genericUtility.FileUtility;

public class CreateContacttest {


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
	
	//Read the data from excel file
	String LastName = Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx","contact", 1, 2)+Ju.getRandomNumber();
	


	driver=Wu.launchTheBrowser("chrome");
	Wu.MaximizeWindow();
	Wu.waitForPagetoLoad();

	 
	//step1:login to app
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(UN);
	driver.findElement(By.name("user_password")).sendKeys(PWD);
	driver.findElement(By.id("submitButton")).submit();
	
	//Navigate to contactModule
	driver.findElement(By.linkText("Contacts")).click();
	//Navigate to contactcreate
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys(LastName);
	
	//step3: click on save button
		driver.findElement(By.name("button")).click();
	
	//verify lastname and contact info ExpectedREsult
			String Actlastname = driver.findElement(By.id("dtlview_Last Name")).getText();
			System.out.println(Actlastname);
			if(Actlastname.equals(LastName)) {
				System.out.println(Actlastname+ "verfied=pass");
			}
			else {
				System.out.println(Actlastname+ "verfied=Fail");
			}
			
		Wu.postcondtion(driver);
	
}
}
