package com.build.qa.shareyourcamp.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.shareyourcamp.selenium.framework.BaseFramework;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public abstract class BasePage extends BaseFramework {
	
	public BasePage(WebDriver driver, Wait<WebDriver> wait, ExtentReports report, ExtentTest extentlogger ) { 
		this.driver = driver;
		this.wait = wait;
		this.report = report;
		this.extentlogger = extentlogger;
		
		PageFactory.initElements(driver, this);
	}
}
