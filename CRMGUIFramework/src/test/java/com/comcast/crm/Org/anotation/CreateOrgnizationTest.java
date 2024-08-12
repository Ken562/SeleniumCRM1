package com.comcast.crm.Org.anotation;


import org.testng.annotations.Test;

import com.comcast.crm.Objectrepositoryutlity.CreateOrganizationpage;
import com.comcast.crm.Objectrepositoryutlity.Homepage;

import com.comcast.crm.Objectrepositoryutlity.Organizationpage;
import com.comcast.crm.Objectrepositoryutlity.OrgnizationInfopage;

import com.comcast.crm.generic.baseUtility.Baseclass;


public class CreateOrgnizationTest extends Baseclass{
	

	@Test(groups="smokeTest")
	public void createOrg() throws Throwable {

//step2: Navigate to Organisation module
Homepage page=new Homepage(driver);
page.navigateToOrg();
//step3: Navigate to Create Organisation page
Organizationpage Op=new Organizationpage(driver);
Op.navigateToCreateNewOrg();
//step4:Enter the Orgname
String orgname = Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx","org", 1, 2)+Ju.getRandomNumber();
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
	}
	
	@Test(groups="regressionTest")
	public void CreateOrgTestwithIndustry() throws Throwable {
		
		Homepage page=new Homepage(driver);
		page.navigateToOrg();
		//step3: Navigate to Create Organisation page
		Organizationpage Op=new Organizationpage(driver);
		Op.navigateToCreateNewOrg();
		//step4:Enter the Orgname
		String orgname = Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx","org", 1, 2)+Ju.getRandomNumber();
		String Indu=Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx","org", 4, 3);
		String type = Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx", "org", 4, 4);
		CreateOrganizationpage Cop=new CreateOrganizationpage(driver);
		Cop.CreateOrgPageWithInd(orgname, Indu, type, Wu);
		//Step5:verify  Headermsg ExpectedREsult
		OrgnizationInfopage Ci=new OrgnizationInfopage(driver);
		String ExOrgName = Ci.getActOrgName().getText();

		if( ExOrgName.equals(orgname)) {
			System.out.println(orgname+ "verfied=pass");
		}
		else {
			System.out.println(orgname+ "verfied=Fail");
		}
		
		
	}
	@Test(groups="regressionTest")
	public void CreateOrgTestwithphonenum() {
		System.out.println("phonenumber");
	}
	
	

}

