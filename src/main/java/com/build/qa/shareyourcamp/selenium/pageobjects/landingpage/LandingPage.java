package com.build.qa.shareyourcamp.selenium.pageobjects.landingpage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.Wait;


import com.build.qa.shareyourcamp.selenium.pageobjects.BasePage;

import com.build.qa.shareyourcamp.selenium.pageobjects.landingpage.LandingPage;


public class LandingPage extends BasePage {
	public By LandingPageButton;
	public By Title;
	public By SignUp;
	public By Login;
	public By LoginText;
	
	
	public LandingPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		LandingPageButton=By.cssSelector("#landing-header > a");
		Title = By.cssSelector("body > nav > div > div.navbar-header > a");
		SignUp = By.cssSelector("body > nav > div > div.collapse.navbar-collapse > ul > li:nth-child(2) > a");
		Login = By.cssSelector("body > nav > div > div.collapse.navbar-collapse > ul > li:nth-child(1) > a");
		LoginText = By.cssSelector("body > nav > div > div.collapse.navbar-collapse > ul > li:nth-child(1) > a");
	}

		
	
	
	public WebElement onLandingPageButton() throws Exception {
		
		try{
		return driver.findElement(LandingPageButton); 
		}catch(Exception e ){
			
			
			throw e;
		}
	}
	
	public WebElement onTitle() throws Exception{
		try 
		{
			return driver.findElement(Title);
		}
		catch(Exception e){
			
			
			throw e;
		}
		}
	
	public WebElement onNavBarSignUp() throws Exception{
		try{
			return driver.findElement(SignUp);
		}catch(Exception e){
			throw e;
		}
		
	}
	
	public WebElement onNavBarLogin() throws Exception{
		try{
			return driver.findElement(Login);
		}catch(Exception e){
			throw e;
		}
		
	}
	
	public WebElement onVerifyLoginText() throws Exception{
		try{
			return driver.findElement(LoginText);
		}catch(Exception e){
			throw e;
		}
	}
		
	}
	

	
	

