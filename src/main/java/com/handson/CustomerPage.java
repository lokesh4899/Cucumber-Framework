package com.handson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage {
	
	WebDriver driver;
	@FindBy(xpath="//*[@class='box mainhdr']/button[1]")
	WebElement home;
	@FindBy(id="userSelect")
	WebElement user_name;
	@FindBy(xpath="//*[@name='myForm']/button")
	WebElement submit;
	@FindBy(xpath="//*[@class='borderM box padT20 ng-scope']/div[1]/strong")
	WebElement welcome_msg;
	@FindBy(xpath="//*[@class='borderM box padT20 ng-scope']/div[2]")
	WebElement account_details;
	@FindBy(xpath="//*[@class='borderM box padT20 ng-scope']/div[3]/button[1]")
	WebElement transaction;
	@FindBy(xpath="//*[@class='borderM box padT20 ng-scope']/div[3]/button[2]")
	WebElement deposit;
	@FindBy(xpath="//*[@class='borderM box padT20 ng-scope']/div[3]/button[3]")
	WebElement withdraw;
	@FindBy(xpath="//input[@type='number']")
	WebElement amount;
	@FindBy(xpath="//*[@class='borderM box padT20 ng-scope']/div[4]/div/span")
	WebElement success_msg;
	@FindBy(xpath="//*[@class='box mainhdr']/button[2]")
	WebElement logout;
	
	public CustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void Home() {
		home.click();
	}
	
	public void Name(String customer_name) {
		Select name=new Select(user_name);
		name.selectByVisibleText(customer_name);		
	}
	
	public String welcomeMsg() {
		return welcome_msg.getText();
	}
	
	public String accountDetails() {
		return account_details.getText();
	}
	
	public void Transaction() {
		transaction.click();
	}
	
	public void Deposit() {
		deposit.click();
	}
	
	public void Withdraw() {
		withdraw.click();
	}
	
	public void amount(String money) {
		amount.sendKeys(money);
	}
	
	public String successMsg() {
		return success_msg.getText();
	}
	
	public void Submit() {
		submit.click();
	}
	
	public void Logout() {
		logout.click();
	}

}
