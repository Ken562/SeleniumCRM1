package com.comcast.crm.contacttest;


import org.openqa.selenium.WebDriver;

import com.comcast.crm.Objectrepositoryutlity.ContactInfoPage;
import com.comcast.crm.Objectrepositoryutlity.CreateNewcontactPage;
import com.comcast.crm.Objectrepositoryutlity.CreateOrganizationpage;
import com.comcast.crm.Objectrepositoryutlity.CreatecontactPage;
import com.comcast.crm.Objectrepositoryutlity.Homepage;
import com.comcast.crm.Objectrepositoryutlity.Login;
import com.comcast.crm.Objectrepositoryutlity.Organizationpage;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.WebdriverUtility;
import com.comcast.crm.genericUtility.ExcelUtility;
import com.comcast.crm.genericUtility.FileUtility;

public class CreateContactwithOrgwithpom {
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

	String orgname = Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx","org", 4, 2)+Ju.getRandomNumber();
	String LastName = Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx", "contact", 1, 2)+Ju.getRandomNumber();

	driver=Wu.launchTheBrowser("chrome");
	Login lu=new Login(driver);

	Wu.MaximizeWindow();
	Wu.waitForPagetoLoad();
	Wu.getUrl(URL);
	//step1:login to app
	lu.loginToapp(UN,PWD);
	Homepage Hp=new Homepage(driver);
	Hp.navigateToOrg();
	//step3: Navigate to Create Organisation page
		Organizationpage Op=new Organizationpage(driver);
		Op.navigateToCreateNewOrg();
	//step4:Enter the Orgname
		CreateOrganizationpage Op1=new CreateOrganizationpage(driver);
		Op1.CreateOrgPage(orgname);
		Thread.sleep(2000);
		Hp.getContactLink().click();
	CreatecontactPage Cc=new CreatecontactPage(driver);
	Cc.getCreatecontactLink().click();
	CreateNewcontactPage Ccp=new CreateNewcontactPage(driver);
	Ccp.getNameEdt().sendKeys(LastName);
	Ccp.getOrglookupLink().click();
	Wu.switchToWindow_PartialUrl("Accounts&action");
	Ccp.getSearch().sendKeys(orgname);
	Ccp.getSearchbtn().click();
	Ccp.selectOrg(orgname);
	Wu.switchToWindow_PartialUrl("Contacts&action");
Ccp.getSave().click();
ContactInfoPage Cip = new ContactInfoPage (driver);
String actLastName = Cip.getLastName().getText();

if(actLastName.equals(LastName))
{
	System.out.println(LastName+ "verfied=pass");
}
else 
{
	System.out.println(LastName+ "verfied=Fail");
}

//verify Org name info
String actOrgName = Cip.getOrgName().getText();
if(actOrgName.equals(orgname)) {
	System.out.println(orgname+ "verfied=pass");
}
else {
	System.out.println(orgname+ "verfied=Fail");
}

	
}
}
