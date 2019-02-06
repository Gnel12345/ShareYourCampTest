package com.build.qa.shareyourcamp.selenium.tests;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebElement;

import org.testng.AssertJUnit;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.build.qa.shareyourcamp.pageobjects.SignUpPage.SignUpPage;
import com.build.qa.shareyourcamp.selenium.framework.BaseFramework;

import com.build.qa.shareyourcamp.selenium.pageobjects.landingpage.LandingPage;












public class ShareYourCampTest extends BaseFramework{
	
	 
	
	WebElement element = null; 
	//Opens Browser and navigates to Landing Page
	@Test
	public void navigateToLandingPage() throws Exception{
		
		
		
	    
		
		driver.get(getConfiguration("HOMEPAGE"));
		
        
		LandingPage lp = new LandingPage(driver, wait);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		PassedScreenShot();
		lp.onLandingPageButton().click(); 
		PassedScreenShot();
		
		
		
	}
	//opens browser, navigates to Landing Page, navigates to Home Page and verifies the title
	@Test
	public void verifyTitle() throws Exception{
		
		driver.get(getConfiguration("HOMEPAGE"));
		
		LandingPage lp = new LandingPage(driver, wait);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		PassedScreenShot();
		
		
		lp.onLandingPageButton().click();
		PassedScreenShot();
		
		
		String text = lp.onTitle().getText();
		String expectedText = "ShareYourCamp";		
		AssertJUnit.assertEquals(text,expectedText);
		PassedScreenShot();
		
		
	}
	//opens browser, navigates to Landing Page, navigates to Home Page and verifies the dropdown works 
	@Test
	public void verifyDropDown() throws Exception{
		
		driver.get(getConfiguration("HOMEPAGE"));
		
		LandingPage lp = new LandingPage(driver, wait);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		PassedScreenShot();
		
		
		lp.onLandingPageButton().click();
		PassedScreenShot();
		
		
		lp.onCampgroundsDropDown().click();
		PassedScreenShot();
		
		
		lp.onCampgroundsDropDown2nd().click();
		PassedScreenShot();
		
		
		
		
		
		
		
		
		
	}
     //opens browser, navigates to Landing Page, navigates to Home Page, Signs up
	//trys to Login with correct username, incorrect password, verifies unable to login message
	//trys to Login with incorrect username, correct password, verifies unable to login message
	//trys to Login with incorrect username, incorrect password, verifies unable to login message
	//trys to Login with correct username, correct password, verifies login successful message
	/*@Test
	public void verifyLogin() throws Exception{
		driver.get(getConfiguration("HOMEPAGE"));
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		LandingPage lp = new LandingPage(driver, wait);
		
		lp.onLandingPageButton().click();
		lp.onSignUpPageButton().click();
		SignUpPage sup = new SignUpPage(driver,wait);
		
		sup.onUserNameTextBox().click();
		
		DataDriven dp = new DataDriven();
		ArrayList<String> data = dp.getData("Profile");
		
		sup.onUserNameTextBox().sendKeys(data.get(1));
		
		
				
		
		
	}*/
}
	
	
	


