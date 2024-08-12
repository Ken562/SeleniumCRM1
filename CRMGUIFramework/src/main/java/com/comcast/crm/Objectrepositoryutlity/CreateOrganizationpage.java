package com.comcast.crm.Objectrepositoryutlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.WebDriverUtility.WebdriverUtility;

public class CreateOrganizationpage {
	public CreateOrganizationpage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="accountname")
	private WebElement OrgEdt;
	@FindBy(name="button")
	private WebElement saveBtn;
	@FindBy(name="industry")
	private WebElement IndustryDd;
	@FindBy(name="accounttype")
	private WebElement typeDd;
	
	public WebElement getTypeDd() {
		return typeDd;
	}
	public WebElement getOrgEdt() 
	{
		return OrgEdt;
	}
	public WebElement getSaveBtn() 
	{
		return saveBtn;
	}
	public WebElement getIndustryDd() 
	{
		return IndustryDd;
	}
	public void CreateOrgPageWithInd(String orgname,String Indu, String type, WebdriverUtility Wu) {
		OrgEdt.sendKeys(orgname);
		Wu.HandleDropdownbyText(IndustryDd, Indu);
		Wu.HandleDropdownbyText(typeDd, type);
		saveBtn.click();
		
		
	}
	public void CreateOrgPage(String orgname) {
		OrgEdt.sendKeys(orgname);
		saveBtn.click();
	}

	

	
	
	
}
