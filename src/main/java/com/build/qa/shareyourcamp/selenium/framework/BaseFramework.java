package com.build.qa.shareyourcamp.selenium.framework;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;





public abstract class BaseFramework {
	protected WebDriver driver;
	protected Wait<WebDriver> wait;
	protected static Robot rb;
	protected static Rectangle rec;
	protected static BufferedImage screenshot;
	protected static ImageIO passScreenshot;
	
	
	
	
	private static final String CONFIG_FILE = "./conf/automation.properties";
	
	private static final String Android = "android";
	
	private static Properties configuration;

	
	


	@Rule
	public final   JUnitSoftAssertions softly = new JUnitSoftAssertions();
	
	
	@BeforeClass
	public static void beforeClass() throws IOException, AWTException {
		configuration = new Properties();
		FileInputStream input;

	
		input = new FileInputStream(new File(CONFIG_FILE));
		configuration.loadFromXML(input);
		input.close();
		
        rb = new Robot();
		
		rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		
		
		
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	@SuppressWarnings({ "deprecation", "rawtypes" })	
	public void setUpBefore(@Optional("chrome")String browser) throws MalformedURLException  {
		DesiredCapabilities capabilities;
		// Which driver to use? 
		if (browser.equalsIgnoreCase("chrome")){
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			File file = new File("driver/chromedriver.exe");
			 System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
			driver = new ChromeDriver(options);
		} if  (browser.equalsIgnoreCase("firefox")) {
			capabilities = DesiredCapabilities.firefox();
			File file = new File("driver/geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());

			File pathToBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			//firefoxProfile.setPreference("dom.webnotifications.enabled", false);
		 	driver = new FirefoxDriver(ffBinary);
			
		}if (browser.equalsIgnoreCase("ie")){
			File file = new File("driver/IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			
			driver = new InternetExplorerDriver();
		}if (browser.equalsIgnoreCase("opera")){
			OperaOptions op= new OperaOptions();
		    op.setBinary("C:\\Program Files\\Opera\\launcher.exe"); 
		    op.addArguments("--disable-notifications");
			File file = new File("driver/operadriver.exe");
			System.setProperty("webdriver.opera.driver", file.getAbsolutePath());
						
			driver = new OperaDriver(op);
			
		}if(browser.equalsIgnoreCase("unitbrowser")){
			driver = new HtmlUnitDriver();
		}
		
		if (Android.equalsIgnoreCase(configuration.getProperty("BROWSER"))){
			// Create object of  DesiredCapabilities class and specify android platform
			DesiredCapabilities androidCapabilities=DesiredCapabilities.android();
			 
			File file = new File("driver/chromedriver.exe");
			 System.setProperty("webdriver.chrome.driver", file.getAbsolutePath()); 
			// set the capability to execute test in chrome browser
			androidCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserType.CHROME);
			 
			// set the capability to execute our test in Android Platform
			androidCapabilities.setCapability(MobileCapabilityType.PLATFORM,Platform.ANDROID);
			 
			// we need to define platform name
			androidCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			 
			// Set the device name as well (you can give any name)
			androidCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Motorola Moto X");
			 
			 // set the android version as well 
			androidCapabilities.setCapability(MobileCapabilityType.VERSION,"4.4.4");
			 
			 // Create object of URL class and specify the appium server address
			 URL url= new URL("http://127.0.0.1:4723/wd/hub");
			 
			// Create object of  AndroidDriver class and pass the url and capability that we created
			 driver = new AndroidDriver(url, androidCapabilities);
			
		}
		
		
		
		
		// Define fluent wait
		wait = new FluentWait<WebDriver>(driver).withTimeout(15, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
	}
	
	protected WebDriver getDriver() {
		
		return driver;
	}
	
	protected String getConfiguration(String config) { 
		return configuration.getProperty(config);
	}
	
	protected void PassedScreenShot() throws IOException {
		screenshot = rb.createScreenCapture(rec); 
		passScreenshot.write(screenshot, "JPEG", new File(utilities.ObjectRepositiory.Pass +timestamp()+ utilities.ObjectRepositiory.Format));	
		
	}
	
	public void failedScreenshot() throws IOException {
		screenshot = rb.createScreenCapture(rec); 
		passScreenshot.write(screenshot, "JPEG", new File(utilities.ObjectRepositiory.Fail+timestamp()+utilities.ObjectRepositiory.Format));
		
	}
	
	public static  String timestamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	
	
		
	
	

	/*@AfterMethod
	public void tearDownAfter() throws Exception {
		try{
		driver.quit();	
		Runtime.getRuntime().exec("taskkill /f /im opera.exe");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
	}*/
	
	
	
	
}
