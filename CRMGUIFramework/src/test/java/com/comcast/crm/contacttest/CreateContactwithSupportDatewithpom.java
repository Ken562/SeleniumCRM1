package com.comcast.crm.contacttest;

import org.openqa.selenium.WebDriver;

import com.comcast.crm.Objectrepositoryutlity.ContactInfoPage;
import com.comcast.crm.Objectrepositoryutlity.CreateNewcontactPage;
import com.comcast.crm.Objectrepositoryutlity.CreatecontactPage;
import com.comcast.crm.Objectrepositoryutlity.Homepage;
import com.comcast.crm.Objectrepositoryutlity.Login;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.WebdriverUtility;
import com.comcast.crm.genericUtility.ExcelUtility;
import com.comcast.crm.genericUtility.FileUtility;

public class CreateContactwithSupportDatewithpom {
public static void main(String[] args) throws Throwable {
	WebDriver driver;
	FileUtility Fu=new FileUtility();
	ExcelUtility Eu=new ExcelUtility();
	JavaUtility Ju=new JavaUtility();
	WebdriverUtility Wu=new WebdriverUtility();



	String URL = Fu.getdatafrompropertiesfile("url");
	//String BROWSER = Fu.getdatafrompropertiesfile("browser");
	String UN = Fu.getdatafrompropertiesfile("username");
	String PWD = Fu.getdatafrompropertiesfile("password");

	//Read the test script data from excel file

//	String orgname = Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx","org", 4, 2)+Ju.getRandomNumber();
	String LastName = Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx", "contact", 1, 2)+Ju.getRandomNumber();

	driver=Wu.launchTheBrowser("chrome");
	Login lu=new Login(driver);

	Wu.MaximizeWindow();
	Wu.waitForPagetoLoad();
	Wu.getUrl(URL);
	//step1:login to app
	lu.loginToapp(UN,PWD);
	Homepage page=new Homepage(driver);
	page.getContactLink().click();
	CreatecontactPage Cc=new CreatecontactPage(driver);
	Cc.getCreatecontactLink();
	CreateNewcontactPage Ccp=new CreateNewcontactPage(driver);
	Ccp.getCreatecontactPage(LastName);
	Ccp.getStart_date().clear();
	String Startdate = Ju.getSystemDateYYYYDDMM();
	String Enddate = Ju.getrequiredDateYYYYDDMM(30);
	Ccp.getStart_date().clear();
    Ccp.getStart_date().sendKeys(Startdate);
    Ccp.getEnd_date().clear();
    Ccp.getEnd_date().sendKeys(Enddate);
    Ccp.getSave().click();

	ContactInfoPage Cip=new ContactInfoPage(driver);
	String ExName = Cip.getName().getText();
	if(ExName.equals(LastName)) {
		System.out.println(ExName+ "verfied=pass");
	}
	else {
		System.out.println(ExName+ "verfied=Fail");
	}
	String ActStartDate = Cip.getStartDate().getText();
	if(ActStartDate.equals(Startdate)) {
		System.out.println(ActStartDate+ "verfied=pass");
	}
	else {
		System.out.println(ActStartDate+ "verfied=Fail");
	}
	String ActEndDate = Cip.getEndDate().getText();
	if(ActEndDate.equals(Enddate)) {
		System.out.println(ActEndDate+ "verfied=pass");
	}
	else {
		System.out.println(ActEndDate+ "verfied=Fail");
	}
}

}
