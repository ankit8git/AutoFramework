package com.m2a.TestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.m2a.base.TestBase;


public class AddCustomerData extends TestBase {

	@Test(dataProvider="getData")
	public void addCustomer(String FirstName,String lastName, String postalCode,String AlertMsg) throws InterruptedException {
	driver.findElement(By.cssSelector(or.getProperty("addcust"))).click();
	driver.findElement(By.cssSelector(or.getProperty("firstname"))).sendKeys(FirstName);
	driver.findElement(By.cssSelector(or.getProperty("lastname"))).sendKeys(lastName);
	driver.findElement(By.cssSelector(or.getProperty("postcode"))).sendKeys(postalCode);
	driver.findElement(By.cssSelector(or.getProperty("addbtn"))).click();
	Thread.sleep(10000);
	
	Alert alert=wait.until(ExpectedConditions.alertIsPresent());
	Assert.assertTrue(alert.getText().contains(AlertMsg));
		alert.accept();
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
	String sheetName="AddCustomerData";
		int rows=excel.getRowCount(sheetName);
		int columns=excel.getColumnCount(sheetName);
		Object [][] data=new Object[rows-1][columns];
		
		for (int rowNum=2;rowNum<=rows;rowNum++) {
			for (int colNum=0;colNum<columns;colNum++) {
			data[rowNum-2][colNum]=excel.getCellData(sheetName,colNum,rowNum); 
		}
		}
		return data;
	}
}
