package com.build.qa.shareyourcamp.selenium.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.build.qa.shareyourcamp.selenium.framework.BaseFramework;
import com.build.qa.shareyourcamp.selenium.pageobjects.landingpage.LandingPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ShareYourCampTest extends BaseFramework{
	
	
	WebElement element = null;
	
	@Test
	public void navigateToLandingPage() throws Exception{
		 
		 report.startTest("navigateToLandingPage");
		
		driver.get(getConfiguration("HOMEPAGE"));
		
		LandingPage lp = new LandingPage(driver, wait);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		lp.onLandingPageButton().click();
		extentlogger.log(LogStatus.INFO,"Landing Page opened");
		
		
		
	}
	
	@Test
	public void verifyTitle() throws Exception{
		report.startTest("Verfiy Title Test");
		driver.get(getConfiguration("HOMEPAGE"));
		
		LandingPage lp = new LandingPage(driver, wait);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		extentlogger.log(LogStatus.INFO,"Landing Page opened");
		
		lp.onLandingPageButton().click();
		extentlogger.log(LogStatus.INFO,"Landing Page Button Clicked");
		
		String text = lp.onTitle().getText();
		String expectedText = "ShareYourCamp";		
		AssertJUnit.assertEquals(text,expectedText);
		extentlogger.log(LogStatus.INFO,text);
		extentlogger.log(LogStatus.INFO,expectedText);
		
		
		
	}
	
	
	
	
	
	
	
	

}
