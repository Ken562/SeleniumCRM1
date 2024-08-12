package com.comcast.crm.Objectrepositoryutlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	public Homepage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
@FindBy(linkText="Organizations")
private WebElement orgLink;

@FindBy(linkText="Contacts")
private WebElement contactLink;

@FindBy(xpath="//a[text()='Products']")
private WebElement ProductLink;

@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement administrationLink;
@FindBy(xpath="//a[@href='index.php?module=Users&action=Logout']")
private WebElement signOutLink;






public WebElement getProductLink() {
	return ProductLink;
}

public WebElement getContactLink() {
	return contactLink;
}
public WebElement getOrgLink() 
{
	return orgLink;
}
public WebElement getAdministrationLink() 
{
	return administrationLink;
}
public WebElement getSignOutLink()
{
	return signOutLink;
}


public void logOutfromApp() 
{
	administrationLink.click();
	signOutLink.click();	
}
public void navigateToOrg() {
	orgLink.click();
}
	
}
