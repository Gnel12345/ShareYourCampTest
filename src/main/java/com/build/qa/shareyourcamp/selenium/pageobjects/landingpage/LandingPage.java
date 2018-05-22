package com.build.qa.shareyourcamp.selenium.pageobjects.landingpage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.Wait;


import com.build.qa.shareyourcamp.selenium.pageobjects.BasePage;

import com.build.qa.shareyourcamp.selenium.pageobjects.landingpage.LandingPage;
import com.relevantcodes.extentreports.LogStatus;

public class LandingPage extends BasePage {
	public By LandingPageButton;
	public By Title;
	
	
	public LandingPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait, report, extentlogger);
		LandingPageButton=By.cssSelector("#landing-header > a");
		Title = By.cssSelector("body > nav > div > div.navbar-header > a");
	}

		
	
	
	public WebElement onLandingPageButton() throws Exception {
		try{
		return driver.findElement(LandingPageButton); 
		}catch(Exception e ){
			extentlogger.log(LogStatus.FAIL,"Landing Page Button error");
			
			throw e;
		}
	}
	
	public WebElement onTitle() throws Exception{
		try 
		{
			return driver.findElement(Title);
		}
		catch(Exception e){
			extentlogger.log(LogStatus.FAIL,"Title error");
			
			throw e;
		}
		}
		
	}
	

	
	

