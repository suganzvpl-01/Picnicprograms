package com.question2.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.beust.jcommander.JCommander.Builder;

public class wordPress {
	public static WebDriver driver;

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		connection("https://wordpress.com/?aff=58022&cid=8348279");
		
		/*
		 * File fs = new File("Excel\\excel1.xlsx"); FileInputStream fis=new
		 * FileInputStream(fs); //WorkBook Access Workbook wb= new XSSFWorkbook(fis);
		 * Sheet sheetName = wb.getSheet("Sheet1");
		 *///Row Create Cell Access <TR>
		
		//fetch all possible links
		clickMainMenu("Products");

		WebElement findbloElement = driver.findElement(By.xpath("//a[contains(text(),'Blogs')]"));
		findbloElement.click();
		Thread.sleep(5000);
		List<WebElement> findLinkElements = driver.findElements(By.tagName("a"));
		System.out.println(findLinkElements.size());
		for(WebElement item: findLinkElements) {
			System.out.println(item.getAttribute("href"));
		}
		List<WebElement> findimgElements = driver.findElements(By.tagName("img"));
		System.out.println(findimgElements.size());
		for(WebElement item: findimgElements) {
			System.out.println(item.getAttribute("src"));
		}
		
		
		clickMainMenu("Products");
		//act_try.moveToElement(findProElement).build().perform();
		WebElement findwebElement = driver.findElement(By.xpath("//a[contains(text(),'Websites')]"));
		findwebElement.click();
		Thread.sleep(5000);
		List<WebElement> findwebLinkElements = driver.findElements(By.tagName("a"));
		System.out.println(findwebLinkElements.size());
		for(WebElement item: findwebLinkElements) {
			System.out.println(item.getAttribute("href"));
		}
		List<WebElement> findwebimgElements = driver.findElements(By.tagName("img"));
		System.out.println(findwebimgElements.size());
		for(WebElement item: findwebimgElements) {
			System.out.println(item.getAttribute("src"));
		}
		
		clickMainMenu("Products");
		//act_try.moveToElement(findProElement).build().perform();
		WebElement finddomElement = driver.findElement(By.xpath("//a[contains(text(),'Domains')]"));
		finddomElement.click();
		Thread.sleep(5000);
		List<WebElement> finddomLinkElements = driver.findElements(By.tagName("a"));
		System.out.println(finddomLinkElements.size());
		for(WebElement item: finddomLinkElements) {
			System.out.println(item.getAttribute("href"));
		}
		
		List<WebElement> finddomimgElements = driver.findElements(By.tagName("img"));
		System.out.println(finddomimgElements.size());
		for(WebElement item: finddomimgElements) {
			System.out.println(item.getAttribute("src"));
		}
		
		WebElement findhomeLink = driver.findElement(By.xpath("//a[text()='WordPress.com']"));
		findhomeLink.click();
		Thread.sleep(3000);
		
		clickMainMenu("Products");
		//act_try.moveToElement(findProElement).build().perform();
		WebElement findeElement = driver.findElement(By.xpath("//a[contains(text(),'eCommerce')]"));
		findeElement.click();
		Thread.sleep(5000);
		List<WebElement> findeLinkElements = driver.findElements(By.tagName("a"));
		System.out.println(findeLinkElements.size());
		for(WebElement item: findeLinkElements) {
			System.out.println(item.getAttribute("href"));
		}

		List<WebElement> findeimgElements = driver.findElements(By.tagName("img"));
		System.out.println(findeimgElements.size());
		for(WebElement item: findeimgElements) {
			System.out.println(item.getAttribute("src"));
		}
		
		Thread.sleep(3000);
		
		
		clickMainMenu("Products");
		//act_try.moveToElement(findProElement).build().perform();
		WebElement findssElement = driver.findElement(By.xpath("//a[contains(text(),'Self')]"));
		findssElement.click();
		Thread.sleep(5000);
		List<WebElement> findssLinkElements = driver.findElements(By.tagName("a"));
		System.out.println(findssLinkElements.size());
		
		for(WebElement item: findssLinkElements) {
			System.out.println(item.getAttribute("href"));
		}
		List<WebElement> findssimgElements = driver.findElements(By.tagName("img"));
		System.out.println(findssimgElements.size());
		int i=1;
		File fs = new File("Excel\\excel1.xlsx");
		FileInputStream fis=new FileInputStream(fs);
		//WorkBook Access
		Workbook wb= new XSSFWorkbook(fis);
		Sheet sheetName = wb.getSheet("Sheet1");
		//Row Create Cell Access <TR>
		
		Row createRow = sheetName.createRow(0);
		
		for(WebElement item: findssimgElements) {
			System.out.println(item.getAttribute("src"));
			System.out.println(i);
				Cell createCell = createRow.createCell(i);
				createCell.setCellValue(item.getAttribute("src"));
				
				i=i+1;			
		}
		fis.close();
		FileOutputStream fos=new FileOutputStream(fs);
		wb.write(fos);
		fos.close();	
		
		
		//excel steps
		
		//Row createRow = sheetName.createRow(0);
		/*
		 * Cell createCell = createRow.createCell(0);
		 * createCell.setCellValue("I am Writing the Excel");
		 */
		//File Close
		
        		
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
	public static void clickMainMenu(String value) throws Throwable {
		Actions act_try=new Actions(driver);
		WebElement findProElement = driver.findElement(By.xpath("//button[contains(text(),'"+value+"')]"));
		act_try.moveToElement(findProElement).build().perform();
		Thread.sleep(3000);

	}


}
