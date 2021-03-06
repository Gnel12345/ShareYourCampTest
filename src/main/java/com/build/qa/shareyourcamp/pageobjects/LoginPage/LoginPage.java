package com.build.qa.shareyourcamp.pageobjects.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.shareyourcamp.selenium.pageobjects.BasePage;

public class LoginPage extends BasePage {
	public By UserNameTextBox;
	public By PasswordTextBox;
	public By LoginButton;
	public By SignUp;
	
	

	public LoginPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		UserNameTextBox = By.cssSelector(utilities.ObjectRepositiory.LoginUser);
		PasswordTextBox = By.cssSelector(utilities.ObjectRepositiory.LoginPass);
		LoginButton = By.cssSelector(utilities.ObjectRepositiory.LoginButton);
		SignUp = By.id(utilities.ObjectRepositiory.SignUp);
	}
	
	public WebElement onUserNameTextBox() throws Exception{
		try{
			return driver.findElement(UserNameTextBox);
		}catch(Exception e){
			failedScreenshot();
			throw e;
		}
	}
	
	public WebElement onPasswordTextBox() throws Exception{
		try{
			return driver.findElement(PasswordTextBox);
		}catch(Exception e){
			failedScreenshot();
			throw e;
		}
	}
	public WebElement onLoginButton() throws Exception{
		try{
			return driver.findElement(LoginButton);
			
	}catch (Exception e){
		failedScreenshot();
		throw e;
	}
	}
	
	public WebElement onSignUp() throws Exception{
		try{
			return driver.findElement(SignUp);
		}catch(Exception e){
			failedScreenshot();
			throw e;
		}
	}	

}
