package com.stepdefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.BaseClass;
import com.handson.CustomerPage;
import com.handson.HomePage;
import com.handson.ManagerPage;
import com.handson.petstore;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class StepDefinition extends BaseClass{	
	
	HomePage obj1;
	CustomerPage obj2;
	ManagerPage obj3;
	
		
	@Given("Open the url")
	public void open_the_url() throws IOException {
		setup();
	    driver.get(prop.getProperty("url"));	
	}

	@Given("Click on Customer Login")
	public void click_on_customer_login() {
	   obj1=new HomePage(driver);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   obj1.customerLogin();
	}

	@When("Select the name {string} in login page and click on login")
	public void select_the_name_in_login_page_and_click_on_login(String username) {
	    obj2=new CustomerPage(driver);
	    obj2.Name(username);
	    obj2.Submit();
	}

	@Then("Validate the welcome message,account number and balance")
	public void validate_the_welcome_message_account_number_and_balance() {
	    String message=obj2.welcomeMsg();
	    String account=obj2.accountDetails();
	    Assert.assertEquals(message,"Welcome Ron Weasly !!");
	    Assert.assertEquals(account,"Account Number : 1007 , Balance : 0 , Currency : Dollar");
	    
	}

	
	@When("click on deposit and enter the amount to deposit {string} and clicck on deposit")
	public void click_on_deposit_and_enter_the_amount_to_deposit_and_clicck_on_deposit(String deposit_amount) {
		obj2.Deposit();
	    obj2.amount(deposit_amount);
	    obj2.Submit();
	}

	@Then("validate the result message of depost")
	public void validate_the_result_message_of_depost() {
	    String msg=obj2.successMsg();
	    Assert.assertEquals(msg,"Deposit Successful");
	}

	
	@When("click on withdraw button and enter the amount to withdraw {string} and click on withdraw button")
	public void click_on_withdraw_button_and_enter_the_amount_to_withdraw_and_click_on_withdraw_button(String amount) {
		obj2.Withdraw();
	    new WebDriverWait(driver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Amount to be Withdrawn :']")));
	    obj2.amount(amount);
	    obj2.Submit();
	}

	@Then("validate the result messageof withdraw")
	public void validate_the_result_messageof_withdraw() {
	    String msg=obj2.successMsg();
	    Assert.assertEquals(msg, "Transaction successful");
	}

	@When("Click on Transactions button in homepage to see the transaction page")
	public void click_on_transactions_button_in_homepage_to_see_the_transaction_page() {
	    obj2.Transaction();
	    new WebDriverWait(driver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Date-Time')]")));
	}


	@When("Click on logout button on top right corner")
	public void click_on_logout_button_on_top_right_corner() {
	    obj2.Logout();
	    
	}

	@Then("Validate the logon page url")
	public void validate_the_logon_page_url() {
	    Assert.assertEquals(driver.getCurrentUrl(), "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");}

	@When("Click on home button on top left corner to go back to landing page")
	public void click_on_home_button_on_top_left_corner_to_go_back_to_landing_page() {
	    obj2.Home();
	}

	@Given("Click on Manager Login button to go to anager Page")
	public void click_on_manager_login_button_to_go_to_anager_page() {
	    obj1=new HomePage(driver);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    obj1.managerLogin();
	}

	@Then("validate the url")
	public void validate_the_url() {
	    new WebDriverWait(driver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add Customer')]")));
	}

	@When("click on add customer and fil the required details from {string} and {string} and {string}")
	public void click_on_add_customer_and_fil_the_required_details_from_and_and(String fname, String lname, String postcode) {
	    obj3=new ManagerPage(driver);
	    obj3.addCustomer();
	    obj3.firstName(fname);
	    obj3.lastName(lname);
	    obj3.postCode(postcode);
	    obj3.Submit();
	}

	@Then("validate the customer id shown in alert box along with success message")
	public void validate_the_customer_id_shown_in_alert_box_along_with_success_message() {
	    String msg=driver.switchTo().alert().getText();
	    driver.switchTo().alert().accept();
	    Assert.assertEquals(msg,"Customer added successfully with customer id :6");
	}

	@When("click on Open account in manager page by filling up customer name and currency from dropdown list from {string} and {string}")
	public void click_on_open_account_in_manager_page_by_filling_up_customer_name_and_currency_from_dropdown_list_from_and(String customername, String dollar) {
	    obj3.openAccount();
	    obj3.customerName(customername);
	    obj3.Currency(dollar);
	    obj3.Process();
	}

	@Then("Validate the account number shown in alert box along with success message")
	public void validate_the_account_number_shown_in_alert_box_along_with_success_message() {
	    String msg=driver.switchTo().alert().getText();
	    driver.switchTo().alert().accept();
	    Assert.assertEquals(msg,"Account created successfully with account Number :1016");
	}

	@When("Click on Customers button in manager page")
	public void click_on_customers_button_in_manager_page() {
	   obj3.Customers();
	}

	@Then("Validate data table with customer details and validate search input box functionality {string}")
	public void validate_data_table_with_customer_details_and_validate_search_input_box_functionality(String string) {
	    obj3.Search(string);
	}

	@When("Click on delete button in data table to remove newly added customer")
	public void click_on_delete_button_in_data_table_to_remove_newly_added_customer() {
	    obj3.Delete();
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	

}
