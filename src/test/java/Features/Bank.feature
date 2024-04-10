Feature: XYZ Bank

Background:
		Given Open the url
		
		@ignore
Scenario: Customer Login
    Given Click on Customer Login
    When Select the name "<username>" in login page and click on login
    Then Validate the welcome message,account number and balance
    When click on deposit and enter the amount to deposit "<depositamount>" and clicck on deposit
    Then validate the result message of depost
    When click on withdraw button and enter the amount to withdraw "<withdrawamount>" and click on withdraw button
    Then validate the result messageof withdraw
    When Click on Transactions button in homepage to see the transaction page
    And Click on logout button on top right corner
    Then Validate the logon page url
    When Click on home button on top left corner to go back to landing page

Examples:
| username | depositamount | withdrawamount |
| Ron Weasly | 100 | 100 |

 Scenario: Manager Login
    Given Click on Manager Login button to go to anager Page
    Then validate the url
    When click on add customer and fil the required details from "<firstname>" and "<lastname>" and "<postcode>"
    Then validate the customer id shown in alert box along with success message
    When click on Open account in manager page by filling up customer name and currency from dropdown list from "<customer>" and "<currency>"
    Then Validate the account number shown in alert box along with success message
    When Click on Customers button in manager page
    Then Validate data table with customer details and validate search input box functionality "<searchname>"
    When Click on delete button in data table to remove newly added customer


 Examples: 
| firstname  | lastname | postcode  | customer | currency | searchname |
| john | snow | 1011 | john snow | Dollar | john |
