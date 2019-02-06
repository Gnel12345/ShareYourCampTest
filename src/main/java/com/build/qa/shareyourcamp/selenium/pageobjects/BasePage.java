package com.build.qa.shareyourcamp.selenium.pageobjects;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.shareyourcamp.selenium.framework.BaseFramework;


public abstract class BasePage extends BaseFramework {
	
	public BasePage(WebDriver driver, Wait<WebDriver> wait) { 
		this.driver = driver;
		this.wait = wait;
		
		
		
		PageFactory.initElements(driver, this);
	}
}
