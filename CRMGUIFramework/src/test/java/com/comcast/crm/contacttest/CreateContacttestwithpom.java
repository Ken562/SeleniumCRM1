package com.comcast.crm.contacttest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.Objectrepositoryutlity.ContactInfoPage;
import com.comcast.crm.Objectrepositoryutlity.CreateNewcontactPage;
import com.comcast.crm.Objectrepositoryutlity.CreatecontactPage;
import com.comcast.crm.Objectrepositoryutlity.Homepage;
import com.comcast.crm.generic.baseUtility.Baseclass;

public class CreateContacttestwithpom extends Baseclass {
	@Test
	public void CreatecontactPageWithpomTest() throws Throwable {


		String LastName =Eu.getdatafromExcelfile("./resource/Tek3 - Copy.xlsx", "contact", 1, 2)+Ju.getRandomNumber();
		Homepage page=new Homepage(driver);
		//navigate to Contact module
		page.getContactLink().click();
		//click on create Contact link
		CreatecontactPage Cc=new CreatecontactPage(driver);
		Cc.getCreatecontactLink();
		//Enter the detail
		CreateNewcontactPage Ccp=new CreateNewcontactPage(driver);
		Ccp.getCreatecontactPage(LastName);
		Ccp.getSave().click();
		//Verify Contact
	SoftAssert objass=new SoftAssert();
		ContactInfoPage Cip=new ContactInfoPage(driver);
		String actHeader = Cip.getHeader().getText();
	
		System.out.println(actHeader);
		
		String actlastName = Cip.getLastName().getText();
		objass.assertEquals(actlastName, "bnn");
		objass.assertAll();
		
		
}
}
