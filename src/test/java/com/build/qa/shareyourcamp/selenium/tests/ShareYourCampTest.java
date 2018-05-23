package com.build.qa.shareyourcamp.selenium.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.build.qa.shareyourcamp.pageobjects.LoginPage.LoginPage;
import com.build.qa.shareyourcamp.pageobjects.SignUpPage.SignUpPage;
import com.build.qa.shareyourcamp.selenium.framework.BaseFramework;
import com.build.qa.shareyourcamp.selenium.pageobjects.landingpage.LandingPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ShareYourCampTest extends BaseFramework{
	ExtentReports report = new ExtentReports("../ShareYourCampTest/Reports/reports.html");
	ExtentTest extentlogger;
	
	WebElement element = null;
	
	@Test
	public void navigateToLandingPage() throws Exception{
		 
		extentlogger= report.startTest("navigateToLandingPage");
		
		driver.get(getConfiguration("HOMEPAGE"));
		
		LandingPage lp = new LandingPage(driver, wait);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		lp.onLandingPageButton().click();
		extentlogger.log(LogStatus.INFO,"Landing Page opened");
		
		report.endTest(extentlogger);
		report.flush();
		driver.quit();
	}
	
	@Test
	public void verifyTitle() throws Exception{
		extentlogger =report.startTest("Verfiy Title Test");
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
		extentlogger.log(LogStatus.INFO,"L Page opened");
		report.endTest(extentlogger);
		report.flush();
		driver.quit();
	}
	
	@Test(dataProvider="getData")
	public void setData(String username, String password) throws Exception
	{
		extentlogger =report.startTest("Login Test");
		driver.get(getConfiguration("HOMEPAGE"));
		
		LandingPage lp = new LandingPage(driver, wait);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		extentlogger.log(LogStatus.INFO,"Landing Page opened");
		
		lp.onLandingPageButton().click();
		extentlogger.log(LogStatus.INFO,"Landing Page Button Clicked");
		lp.onNavBarSignUp().click();
		extentlogger.log(LogStatus.INFO,"Landing Page Sign Up Button Clicked");
		SignUpPage signup = new SignUpPage(driver, wait);
		signup.onUserNameTextBox().sendKeys("George");
		extentlogger.log(LogStatus.INFO,"UserName SignUp Entered");
		signup.onPasswordTextbox().sendKeys("bobby");
		extentlogger.log(LogStatus.INFO,"Password SignUp Entered");
		signup.onSignUpButton().click();		
		extentlogger.log(LogStatus.INFO,"Sign Up Button Clicked");
		lp.onNavBarLogin().click();
		extentlogger.log(LogStatus.INFO,"Landing Page Login Button Clicked");
		LoginPage login = new LoginPage(driver, wait);
		login.onUserNameTextBox().sendKeys(username);
		login.onPasswordTextBox().sendKeys(password);
		login.onLoginButton().click();
		String expectedText = "Signed in as George";
		String text = lp.onVerifyLoginText().getText();
		AssertJUnit.assertEquals(expectedText, text);
		if(expectedText == text){
			extentlogger.log(LogStatus.PASS,"Signed in message passed");
		}else{
			extentlogger.log(LogStatus.FAIL,"Signed in message failed");
		}
		
		report.endTest(extentlogger);
		report.flush();
		driver.quit();
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
	//Rows - Number of times test has to be repeated.
	//Columns - Number of parameters in test data.
	Object[][] data = new Object[4][2];

	// 1st row
	data[0][0] ="George";
	data[0][1] = "";

	// 2nd row
	data[1][0] ="";
	data[1][1] = "bobby";
	
	// 3rd row
	data[2][0] ="";
	data[2][1] = "";
	
	data[3][0] = "George";
	data[3][1] = "bobby";

	return data;
	
	}
	
	
	

}
