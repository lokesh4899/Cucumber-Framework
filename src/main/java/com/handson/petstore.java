package com.handson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class petstore {
	
	WebDriver driver;
	
	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name="signon")
	WebElement signon;
	
	public petstore(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void Login(String uname,String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
	}
	public void Submit() {
		signon.click();
	}

}
