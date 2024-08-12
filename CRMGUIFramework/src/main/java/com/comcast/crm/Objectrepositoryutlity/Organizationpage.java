package com.comcast.crm.Objectrepositoryutlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationpage {
	
	public Organizationpage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement orgcreateLink;

	public WebElement getOrgcreateLink() {
		return orgcreateLink;
	}
	
	public void navigateToCreateNewOrg() {
		orgcreateLink.click();
	}
}
