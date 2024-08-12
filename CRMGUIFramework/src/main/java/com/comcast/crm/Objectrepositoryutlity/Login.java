package com.comcast.crm.Objectrepositoryutlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Login  {

	public Login(WebDriver driver) {

		PageFactory.initElements(driver, this);// here this refers to current object means the class
	}
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordedt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//object encapsulation

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordedt() {
		return passwordedt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

//provide action
public void loginToapp(String username, String password) {
	usernameEdt.sendKeys(username);
	passwordedt.sendKeys(password);
	loginBtn.click();
}
}



