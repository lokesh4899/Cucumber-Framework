package com.handson;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions(features = {"src/test/java/Features"}, glue = {"com.stepdefinition"},
                 plugin = {"html:target/cucumber-reports.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
    
public class Runner extends AbstractTestNGCucumberTests {
    
}