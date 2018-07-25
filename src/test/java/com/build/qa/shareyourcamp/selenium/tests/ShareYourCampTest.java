package com.build.qa.shareyourcamp.selenium.tests;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;

import org.testng.AssertJUnit;

import org.testng.annotations.Test;


import com.build.qa.shareyourcamp.selenium.framework.BaseFramework;
import com.build.qa.shareyourcamp.selenium.pageobjects.landingpage.LandingPage;






public class ShareYourCampTest extends BaseFramework{
	//ExtentReports report = new ExtentReports();
	//ExtentTest extentlogger;
	
	WebElement element = null; 
	//Opens Browser and navigates to Landing Page
	@Test
	public void navigateToLandingPage() throws Exception{
		 
		//extentlogger= report.createTest("Test");
		
		driver.get(getConfiguration("HOMEPAGE"));
		
		LandingPage lp = new LandingPage(driver, wait);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		lp.onLandingPageButton().click();
		//extentlogger.log(LogStatus.INFO,"Landing Page opened");
		
		//report.removeTest(extentlogger);
		//report.flush();
		tearDownAfter();
	}
	//opens browser, navigates to Landing Page, navigates to Home Page and verifies the title
	@Test
	public void verifyTitle() throws Exception{
		//extentlogger =report.startTest("Verfiy Title Test");
		driver.get(getConfiguration("HOMEPAGE"));
		
		LandingPage lp = new LandingPage(driver, wait);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		//extentlogger.log(LogStatus.INFO,"Landing Page opened");
		
		lp.onLandingPageButton().click();
		//extentlogger.log(LogStatus.INFO,"Landing Page Button Clicked");
		
		String text = lp.onTitle().getText();
		String expectedText = "ShareYourCamp";		
		AssertJUnit.assertEquals(text,expectedText);
		//extentlogger.log(LogStatus.INFO,text);
		//extentlogger.log(LogStatus.INFO,expectedText);		
		//report.endTest(extentlogger);
		//report.flush();
		tearDownAfter();
	}
	//opens browser, navigates to Landing Page, navigates to Home Page and verifies the dropdown works 
	@Test
	public void verifyDropDown() throws Exception{
		//extentlogger =report.startTest("Verfiy Drop Down Test");
		driver.get(getConfiguration("HOMEPAGE"));
		
		LandingPage lp = new LandingPage(driver, wait);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		//extentlogger.log(LogStatus.INFO,"Landing Page opened");
		
		lp.onLandingPageButton().click();
		//extentlogger.log(LogStatus.INFO,"Landing Page Button Clicked");
		
		lp.onCampgroundsDropDown().click();
		//extentlogger.log(LogStatus.INFO,"Downdown Menu clicked");
		
		lp.onCampgroundsDropDown2nd().click();
		//extentlogger.log(LogStatus.INFO,"2nd Item clicked");
		
		
		
		
		//report.endTest(extentlogger);
		//report.flush();
		tearDownAfter();
		
	}
}
	
	
	


