package com.comcast.crm.contact.anotation;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.Objectrepositoryutlity.ContactInfoPage;
import com.comcast.crm.Objectrepositoryutlity.CreateNewcontactPage;
import com.comcast.crm.Objectrepositoryutlity.CreateOrganizationpage;
import com.comcast.crm.Objectrepositoryutlity.CreatecontactPage;
import com.comcast.crm.Objectrepositoryutlity.Homepage;
import com.comcast.crm.Objectrepositoryutlity.Organizationpage;
import com.comcast.crm.generic.WebDriverUtility.ObjectUtility;
import com.comcast.crm.generic.baseUtility.Baseclass;

@Listeners(com.comcast.crm.generic.listnerUtility.ListImpClass.class)
public class CreatecontactTest extends Baseclass {
	
//public static void main(String[] args) throws Throwable {
	@Test(groups="smokeTest")
	public void CreatecontactPageWithpomTest() throws Throwable {

//	FileUtility Fu=new FileUtility();
//	ExcelUtility Eu=new ExcelUtility();
//	JavaUtility Ju=new JavaUtility();
//	WebdriverUtility Wu=new WebdriverUtility();



//	String URL = Fu.getdatafrompropertiesfile("url");
//	//String BROWSER = Fu.getdatafrompropertiesfile("browser");
//	String UN = Fu.getdatafrompropertiesfile("username");
//	String PWD = Fu.getdatafrompropertiesfile("password");

	//Read the test script data from excel file

//	String orgname = Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx","org", 4, 2)+Ju.getRandomNumber();
	

//	driver=Wu.launchTheBrowser("chrome");
//	Login lu=new Login(driver);
//
//	Wu.MaximizeWindow();
//	Wu.waitForPagetoLoad();
//	Wu.getUrl(URL);
	//step1:login to app
//	lu.loginToapp(UN,PWD);
		ObjectUtility.getTest().log(Status.INFO, "Read data from excel");
		String LastName =Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx", "contact", 1, 2)+Ju.getRandomNumber();
	Homepage page=new Homepage(driver);
	//navigate to Contact module
	ObjectUtility.getTest().log(Status.INFO, "navigate to Contact module");
	page.getContactLink().click();
	//click on create Contact link
	ObjectUtility.getTest().log(Status.INFO, "click on create Contact link");
	CreatecontactPage Cc=new CreatecontactPage(driver);
	Cc.getCreatecontactLink().click();
	//Enter the detail
	CreateNewcontactPage Ccp=new CreateNewcontactPage(driver);
	ObjectUtility.getTest().log(Status.INFO, "  create new Contact");
	Ccp.getCreatecontactPage(LastName);
	Ccp.getSave().click();
	ObjectUtility.getTest().log(Status.INFO, "Contact is created");
	
	//Verify Contact
	SoftAssert objass=new SoftAssert();
	ContactInfoPage Cip=new ContactInfoPage(driver);
	String actHeader = Cip.getHeader().getText();
	boolean status = actHeader.contains(LastName);
	Assert.assertEquals(status, false);
	String actlastName = Cip.getLastName().getText();
	objass.assertEquals(actlastName, LastName);
    objass.assertAll();
	
	
	}
	@Test
	public void CreateContactwithSupportDatewithpom() throws Throwable {
		String LastName =Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx", "contact", 1, 2)+Ju.getRandomNumber();
		Homepage page=new Homepage(driver);
		//navigate to Contact module
		page.getContactLink().click();
		//click on create Contact link
		CreatecontactPage Cc=new CreatecontactPage(driver);
		//Enter the detail
		Cc.getCreatecontactLink();
		//Verify Contact name
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
	@Test(groups="regressionTest")
	public void CreateContactwithorg() throws Throwable {
		String orgname = Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx","org", 4, 2)+Ju.getRandomNumber();
		String LastName =Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx", "contact", 1, 2)+Ju.getRandomNumber();
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
	@Test(groups="regressionTest")
	public void  CreateContactwithphonenum() {
		System.out.println("phone number");
		
	}
}
