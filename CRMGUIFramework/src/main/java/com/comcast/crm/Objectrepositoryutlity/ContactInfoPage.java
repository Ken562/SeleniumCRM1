package com.comcast.crm.Objectrepositoryutlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ContactInfoPage {
	public ContactInfoPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[(@class='dvHeaderText')]")
	private WebElement header;
@FindBy(id="mouseArea_Last Name")
private WebElement Name;

@FindBy(id="dtlview_Last Name")
private WebElement LastName ;
@FindBy(xpath="//td[@id='mouseArea_Organization Name']/a")
private WebElement orgName ;
@FindBy(id="dtlview_Support Start Date")
private WebElement StartDate  ;
@FindBy(id="dtlview_Support End Date")
private WebElement EndDate  ;



public WebElement getHeader() {
	return header;
}
public WebElement getStartDate() {
	return StartDate;
}
public WebElement getEndDate() {
	return EndDate;
}
//"dtlview_Support Start Date"
public WebElement getLastName() {
	return LastName;
}
public WebElement getOrgName() {
	return orgName;
}
public WebElement getName() {
	return Name;
}

//@FindBy(id="dtlview_Last Name")
//private WebElement Name;

public void infoPge(String confrm)
{
	String actul = header.getText();
	SoftAssert s = new SoftAssert();
	s.assertEquals(actul, confrm);
	System.out.println(actul);
	s.assertAll();
}
}
