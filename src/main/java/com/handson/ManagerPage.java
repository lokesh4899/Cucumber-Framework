package com.handson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManagerPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@class='center']/button[1]")
	WebElement add_customer;
	@FindBy(xpath="//*[@class='center']/button[2]")
	WebElement open_account;
	@FindBy(xpath="//*[@class='center']/button[3]")
	WebElement customers;
	@FindBy(xpath="//*[@class='marTop']/form/div[1]/input")
	WebElement first_name;
	@FindBy(xpath="//*[@class='marTop']/form/div[2]/input")
	WebElement last_name;
	@FindBy(xpath="//*[@class='marTop']/form/div[3]/input")
	WebElement postcode;
	@FindBy(xpath="//*[@name='myForm']/button")
	WebElement submit;
	@FindBy(id="userSelect")
	WebElement customer_name;
	@FindBy(id="currency")
	WebElement currency;
	@FindBy(xpath="//*[@class='marTop']/form/button")
	WebElement process;
	@FindBy(xpath="//*[@class='input-group']/input")
	WebElement search_box;
	@FindBy(xpath="//*[@class='table table-bordered table-striped']/tbody/tr")
	WebElement count;
	@FindBy(xpath="//*[@class='table table-bordered table-striped']/tbody/tr/td[5]/button")
	WebElement delete;
	
	public ManagerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void addCustomer() {
		add_customer.click();
	}
	
	public void openAccount() {
		open_account.click();
	}
	
	public void Customers() {
		customers.click();
	}
	
	public void firstName(String fname) {
		first_name.sendKeys(fname);
	}
	
	public void lastName(String lname) {
		last_name.sendKeys(lname);
	}
	
	public void postCode(String code) {
		postcode.sendKeys(code);
	}
	
	public void Submit() {
		submit.click();
	}
	
	public void customerName(String customer) {
		Select name=new Select(customer_name);
		name.selectByVisibleText(customer);
	}
	
	public void Currency(String curr_type) {
		Select currency_type=new Select(currency);
		currency_type.selectByVisibleText(curr_type);
	}
	
	public void Process() {
		process.click();
	}
	
	public void Search(String fname) {
		search_box.sendKeys(fname);
	}
	
	public void Delete() {
		delete.click();
	}

}
