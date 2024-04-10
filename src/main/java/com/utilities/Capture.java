package com.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Capture {
	
	public static void ScreenShot(WebDriver driver, String filename) {
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source,new File(System.getProperty("user,dir")+"\\screenshots\\"+filename+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
