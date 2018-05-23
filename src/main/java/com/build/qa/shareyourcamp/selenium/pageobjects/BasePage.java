package com.build.qa.shareyourcamp.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.shareyourcamp.selenium.framework.BaseFramework;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public abstract class BasePage extends BaseFramework {
	
	public BasePage(WebDriver driver, Wait<WebDriver> wait ) { 
		this.driver = driver;
		this.wait = wait;
		
		
		PageFactory.initElements(driver, this);
	}
}
