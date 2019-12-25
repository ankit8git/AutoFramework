package com.m2a.TestCases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.m2a.base.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void loginAsBankManager() throws InterruptedException {
		driver.findElement(By.cssSelector(or.getProperty("bankmanagerlocator"))).click();
		Thread.sleep(300);		
		log.debug("click on bank manager");
		Reporter.log("Bank manager click is successful");
	}
	
	@AfterSuite
	public void tearDown() {
		if (driver!=null) {
			driver.close();
		}
	}
	
}
