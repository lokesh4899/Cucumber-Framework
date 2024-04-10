package com.baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeSuite;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop = new Properties();;
	public static WebDriver driver;
	
	
	
	public void setup() throws IOException {
		FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "/config/config.properties");
		prop.load(input);
		
		if(prop.getProperty("browser").equals("edge")) {
		WebDriverManager.edgedriver().setup();
		EdgeOptions options=new EdgeOptions();
		options.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		driver=new EdgeDriver(options);
		driver.manage().window().maximize();
		//driver.get(prop.getProperty("url"));
		}
		else if(prop.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
			driver=new ChromeDriver(options);
			driver.manage().window().maximize();
			//driver.get(prop.getProperty("url"));
		}
		
		
	}
	

}
