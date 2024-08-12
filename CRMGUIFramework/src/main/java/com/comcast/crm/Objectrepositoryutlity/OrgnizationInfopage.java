package com.comcast.crm.Objectrepositoryutlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgnizationInfopage  {
	public OrgnizationInfopage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="mouseArea_Organization Name")//dtlview_Organization Name
	private WebElement OrgNameEdit;
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement HeaderOrgName;
	@FindBy(id="dtlview_Industry")
	private WebElement IndustryEdt;
	
	
	public WebElement getIndustryEdt() {
		return IndustryEdt;
	}
	
	public WebElement getActOrgName() {
		return OrgNameEdit;
	}
	public WebElement getHeaderOrgName() {
		return HeaderOrgName;
	}
	
	
			
		
		
	}
	
