package com.comcast.crm.orgtest;

import org.openqa.selenium.WebDriver;

import com.comcast.crm.Objectrepositoryutlity.CreateOrganizationpage;
import com.comcast.crm.Objectrepositoryutlity.Homepage;
import com.comcast.crm.Objectrepositoryutlity.Login;
import com.comcast.crm.Objectrepositoryutlity.Organizationpage;
import com.comcast.crm.Objectrepositoryutlity.OrgnizationInfopage;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.WebdriverUtility;
import com.comcast.crm.genericUtility.ExcelUtility;
import com.comcast.crm.genericUtility.FileUtility;

public class CreateorgwithPom {
	public static void main(String[] args) throws Throwable {
		WebDriver driver;
	FileUtility Fu=new FileUtility();
	ExcelUtility Eu=new ExcelUtility();
	JavaUtility Ju=new JavaUtility();
	WebdriverUtility Wu=new WebdriverUtility();
	
	

	String URL = Fu.getdatafrompropertiesfile("url");
//	String BROWSER = Fu.getdatafrompropertiesfile("browser");
	String UN = Fu.getdatafrompropertiesfile("username");
	String PWD = Fu.getdatafrompropertiesfile("password");
	
	//Read the test script data from excel file
	
	String orgname = Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx","org", 1, 2)+Ju.getRandomNumber();


  driver=Wu.launchTheBrowser("chrome");
    Login lu=new Login(driver);

    Wu.MaximizeWindow();
	Wu.waitForPagetoLoad();
	Wu.getUrl(URL);
	//step1:login to app
	lu.loginToapp(UN,PWD);
	//another way
//	Login Lp = PageFactory.initElements(driver, Login.class);
//	Lp.getUsernameEdt().sendKeys("admin");
//	Lp.getPasswordedt().sendKeys("admin");
//	Lp.getLoginBtn().click();
//step2: Navigate to Organisation module
	Homepage page=new Homepage(driver);
	page.navigateToOrg();
//step3: Navigate to Create Organisation page
	Organizationpage Op=new Organizationpage(driver);
	Op.navigateToCreateNewOrg();
//step4:Enter the Orgname
	CreateOrganizationpage Op1=new CreateOrganizationpage(driver);
	Op1.CreateOrgPage(orgname);
//Step5:verify  Headermsg ExpectedREsult
	OrgnizationInfopage Ci=new OrgnizationInfopage(driver);
	String ExOrgName = Ci.getActOrgName().getText();
	
	if( ExOrgName.equals(orgname)) {
		System.out.println(orgname+ "verfied=pass");
	}
	else {
		System.out.println(orgname+ "verfied=Fail");
	}
//	//Step5:logout From App
	page.logOutfromApp();
	
	
	
	
	
	


	
}
}

