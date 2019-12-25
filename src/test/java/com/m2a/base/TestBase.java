package com.m2a.base;

import org.testng.annotations.BeforeMethod;

import com.m2a.utilities.ExcelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.jmx.LoggerDynamicMBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class TestBase {
	public static WebDriver driver;
	public static Properties config=new Properties();
	public static Properties or=new Properties();
	public static FileInputStream fis;
	public static Logger log= Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	
	@BeforeSuite
	public void setUp() {
		
		if (driver == null) {
			try {
				fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\or.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       try {
			or.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	    if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
	    	System.setProperty("webdriver.chrome.driver", "D:\\BackUp\\Java_Programs\\DataDrivenFramework\\src\\test\\resources\\Executables\\chromedriver.exe");
	    	driver=new ChromeDriver();
	    }
	    if (config.getProperty("browser").equalsIgnoreCase("Firefox")) {
	    	driver=new FirefoxDriver();
	    }
	    	if (config.getProperty("browser").equalsIgnoreCase("IE")) {
	    	driver=new ChromeDriver();
	    }
	    	driver.get(config.getProperty("testsiteurl"));
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	wait=new WebDriverWait(driver, 5);
	    	log.debug("open bank site");
		
	}
			
}
