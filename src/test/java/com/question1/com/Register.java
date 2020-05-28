package com.question1.com;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;


public class Register {
	
	public static WebDriver driver;

	@Test(groups="high")
	// public static List<Map<String, String>> listOfMaps;
	public static void main(String[] args) throws Throwable {

		// TODO Auto-generated method stub
		connection("http://demo.guru99.com/test/newtours/register.php");
		// excelvaluesGet();
		// object creation
		// printing all the Country VAlues in console
		RegisterwithPOM reg = new RegisterwithPOM();

		List<WebElement> countryOptions = reg.getCountry().getOptions();
		System.out.println("The Country List is below: ");
		for (WebElement item:countryOptions) {
			System.out.println(item.getText());
		}
		
		registerUser();
		
			
		//Date date=java.util.Calendar.getInstance().getTime();
		
		//assert
		String assertionVal =  reg.getPostSignin().getText();
		if (assertionVal.equals("sign-in")) {
			System.out.println("Case is passed");
			takeScreenshot("Passed");
		}
		else System.out.println("Case is Failed");
		
		/*
		 * for (WebElement options : countryOptions) {
		 * System.out.println(options.getText()); }
		 */
	}
	
	public static void takeScreenshot(String result) throws Throwable {
		 TakesScreenshot ts = (TakesScreenshot)driver;
	        File temp = ts.getScreenshotAs(OutputType.FILE);
	        //String changeOver= (parseString)instant;
	        
	        File des = new File("Screenshot/"+result+"_Register_"+timestamp()+".png");
	        FileUtils.copyFile(temp, des);

	}
	public static String timestamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	public static void connection(String url) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		// Thread.sleep(5000);
		/*
		 * WebElement tryEle=driver.findElement(By.name("firstName"));
		 * tryEle.sendKeys("Hi");
		 */
	}

	public static String getTheData(String ColNameParm) throws Throwable {
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection("Excel/data.xlsx");
		String strQuery = "Select * from Sheet1";
		Recordset recordset = connection.executeQuery(strQuery);
		//System.out.println(recordset.getField(ColNameParm).toString());
		String result = null;
		//System.out.println(recordset.getCount());
		while(recordset.next()) { 	 	
				 result=recordset.getField(ColNameParm).toString();
				 break;
				 
		}
		 	 // System.out.println(listOfMaps.get(0));
		
		recordset.close();
		connection.close();
		return result;
	
	}
	public static void registerUser() throws Throwable{
		RegisterwithPOM reg = new RegisterwithPOM();

		reg.getFirstName().sendKeys(getTheData("FirstName"));
		reg.getLastName().sendKeys(getTheData("LastName"));
		reg.getPhone().sendKeys(getTheData("Phone"));
		reg.getEmail().sendKeys(getTheData("Email"));
		reg.getAddress().sendKeys(getTheData("Address"));
		reg.getCity().sendKeys(getTheData("City"));
		reg.getState().sendKeys(getTheData("State"));
		reg.getPostalCode().sendKeys(getTheData("PostCode"));
		reg.getCountry().selectByValue(getTheData("Country"));
		reg.getUserName().sendKeys(getTheData("UserName"));
		reg.getPassword().sendKeys(getTheData("Pwd"));
		reg.getConfirmPassword().sendKeys(getTheData("ConfirmPwd"));
		
		//submit
		reg.getSubmit().click();
		
		
	
	}

}
