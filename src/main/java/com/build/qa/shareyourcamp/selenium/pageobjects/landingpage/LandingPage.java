package com.build.qa.shareyourcamp.selenium.pageobjects.landingpage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;


import com.build.qa.shareyourcamp.selenium.pageobjects.BasePage;

import com.build.qa.shareyourcamp.selenium.pageobjects.landingpage.LandingPage;

import utilities.ObjectRepositiory;


public class LandingPage extends BasePage {
	public By LandingPageButton;
	public By Title;
	public By SignUp;
	public By Login;
	public By LoginText;
	public By addCampground;
	public By Campgroundsbtn;
	public By Campgrounds2nd;
	
	
	public LandingPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		LandingPageButton=By.cssSelector(utilities.ObjectRepositiory.LandingPageButton);
		Title = By.cssSelector(utilities.ObjectRepositiory.LandingPageTitle);
		SignUp = By.cssSelector(utilities.ObjectRepositiory.LandingPageSignUpButton);
		Login = By.cssSelector(utilities.ObjectRepositiory.LandingPageLoginButton);
		LoginText = By.cssSelector(utilities.ObjectRepositiory.LandingPageLoginText);
		addCampground = By.id(utilities.ObjectRepositiory.LandingPageAddCampground);
		Campgroundsbtn = By.cssSelector(utilities.ObjectRepositiory.LandingPageCampgroundsbtn);
		Campgrounds2nd = By.cssSelector(utilities.ObjectRepositiory.LandingPageCampgroundsbtn2nd);
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
	
	public WebElement onAddCampground() throws Exception{
		try{
			return driver.findElement(addCampground);
		}catch(Exception e){
			throw e;
		} 
		
	}
	public WebElement onCampgroundsDropDown() throws Exception{
		try{
			return driver.findElement(Campgroundsbtn);
		}catch(Exception e){
			throw e;
		}
	}
	public WebElement onCampgroundsDropDown2nd() throws Exception{
		try{
		
		return driver.findElement(Campgrounds2nd);
		}catch(Exception e){
			
			throw e;
		}
		
	}
		
	}
	

	
	

