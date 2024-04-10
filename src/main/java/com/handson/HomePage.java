package com.handson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	@FindBy(xpath="//*[@class='borderM box padT20']/div[1]/button")
	WebElement customer_login;
	@FindBy(xpath="//*[@class='borderM box padT20']/div[2]/button")
	WebElement manager_login;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void customerLogin() {
		customer_login.click();
	}
	
	public void managerLogin() {
		manager_login.click();
	}

}
