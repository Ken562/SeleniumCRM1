package com.comcast.crm.Objectrepositoryutlity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CreateNewcontactPage {
	WebDriver driver;
	public CreateNewcontactPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement CreateNewcontactEdt;
@FindBy(name="lastname")
private WebElement nameEdt;
@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")
private WebElement OrglookupLink;
@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement Save;
@FindBy(id="search_txt")
private WebElement search;
@FindBy(name="search")
private WebElement searchbtn ;
@FindBy(name="support_start_date")
private WebElement start_date ;
@FindBy(name="support_end_date")
private WebElement end_date ;




public WebElement getStart_date() {
	return start_date;
}
public WebElement getEnd_date() {
	return end_date;
}
public WebElement getSearch() {
	return search;
}
public WebElement getSearchbtn() {
	return searchbtn;
}
public WebElement getCreateNewcontactEdt() {
	return CreateNewcontactEdt;
}
public WebElement getSave() {
	return Save;
}
public WebElement getNameEdt() {
	return nameEdt;
}
public WebElement getOrglookupLink() {
	return OrglookupLink;
}

public void getCreatecontactPage(String name) {
	CreateNewcontactEdt.click();
	nameEdt.sendKeys(name);
	
}
public void selectOrg(String orgname) {
	driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
}

	
	
}

//public void contactwithOrg(String name,String orgname,WebdriverUtility Wu,String text) {
//	CreateNewcontactEdt.click();
//	nameEdt.sendKeys(name);
//	OrglookupLink.click();
//	Wu.switchToWindow_PartialUrl(text);
//	search.sendKeys(orgname);
//	searchbtn.click();
//	
//	
//	Save.click();
	

