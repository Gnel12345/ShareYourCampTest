package com.build.qa.shareyourcamp.pageobjects.SignUpPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.shareyourcamp.selenium.pageobjects.BasePage;

public class SignUpPage extends BasePage{
	public By UserNameTextBox;
	public By PasswordTextBox;
	public By SignUpButton;
	
	

	public SignUpPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		UserNameTextBox = By.cssSelector("body > form > input[type=text]:nth-child(1)");
		PasswordTextBox = By.cssSelector("body > form > input[type=password]:nth-child(2)");
		SignUpButton = By.cssSelector("body > form > button");
	}
	public WebElement onUserNameTextBox() throws Exception{
		try{
			return driver.findElement(UserNameTextBox);
		}catch(Exception e){
			throw e;
			
		}
	}
	public WebElement onPasswordTextbox() throws Exception{
		try{
			return driver.findElement(PasswordTextBox);
		}catch(Exception e){
			throw e;
		}
	}
	public WebElement onSignUpButton() throws Exception{
		try{
			return driver.findElement(SignUpButton);
		}catch(Exception e){
			throw e;
		}
	}

}
