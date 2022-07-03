package MainTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Methods.ContactUs_POM;
import ReusableComponents.Constants;
import ReusableComponents.ExcelUtils;

public class Main extends Constants {
	
	WebDriver driver;
	
	@BeforeTest
	public void Setup() throws Exception {
		
		System.setProperty(Constants.browser, Constants.browserlocation);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constants.link);
		
		Thread.sleep(1000);
		
	}
	
	@Test
	public void ContactUsPage() throws Exception {
		
		ExcelUtils.setExcelFile(Constants.excelLocation + Constants.excelFilename,Constants.ExcelSheetname);
		
		
		ContactUs_POM contactUs = new ContactUs_POM(driver);
		
		driver.switchTo().frame(0);
		
		int totalrows = ExcelUtils.getNumberRows();
		  for(int i=1; i <= totalrows; i++) {
		
			  
		
		//Thread.sleep(10000);
		contactUs.setNameClear();
		contactUs.setNametxt(ExcelUtils.getCellData(i, 0));
		contactUs.setEmailClear();
		contactUs.setEmailtxt(ExcelUtils.getCellData(i, 1));
		contactUs.setContactNumberClear();
		contactUs.setContactNumber(ExcelUtils.getCellData(i, 2));
		//contactUs.setCompanySizeClear();
		contactUs.setCompanySize(ExcelUtils.getCellData(i, 3));
		//contactUs.setServicesClear();
		contactUs.setServices(ExcelUtils.getCellData(i, 4));
		contactUs.setMessageClear();
		contactUs.setMessage(ExcelUtils.getCellData(i, 5));
		contactUs.setConsentbtn();
		captureScreenShot(driver, "Contact Page - form");
		contactUs.setSubmitbtn();
		
		
		captureScreenShot(driver, "Contact Page - Positive Results");
		//driver.switchTo().frame(0);
		
		
		
		/*
		 * String ActualResults = contactUs.getSuccesstxt(); String ExpectedResults =
		 * ExcelUtils.getCellData(i, 6);
		 * 
		 * if(ActualResults.equalsIgnoreCase(ExpectedResults)) {
		 * ExcelUtils.setCellData(ActualResults, i, 7); ExcelUtils.setCellData("Pass",
		 * i, 8); }else { ExcelUtils.setCellData(ActualResults, i, 7);
		 * ExcelUtils.setCellData("Fail", i, 8); }
		 */
		  
		  //driver.switchTo().frame(0);
		  //contactUs.clickUsingJavaScriptExecutor();
		
		 // driver.switchTo().parentFrame();
		  driver.get(Constants.link);
		  
		  
		 // Setup();
		  
		  }
	}
	
	@Test 
	public void NegativeScenario() throws Exception {
		
		ExcelUtils.setExcelFile(Constants.excelLocation + Constants.excelFilename,Constants.excelSheetname2);
		
		ContactUs_POM contactUs = new ContactUs_POM(driver);
		int totalrows = ExcelUtils.getNumberRows();
		  for(int i=1; i <= totalrows; i++) {
		
			  driver.switchTo().frame(0);
			  
		Thread.sleep(10000);
		contactUs.setNameClear();
		contactUs.setNametxt(ExcelUtils.getCellData(i, 0));
		contactUs.setEmailClear();
		contactUs.setEmailtxt(ExcelUtils.getCellData(i, 1));
		contactUs.setContactNumberClear();
		contactUs.setContactNumber(ExcelUtils.getCellData(i, 2));
		//contactUs.setCompanySizeClear();
		contactUs.setCompanySize(ExcelUtils.getCellData(i, 3));
		//contactUs.setServicesClear();
		contactUs.setServices(ExcelUtils.getCellData(i, 4));
		contactUs.setMessageClear();
		contactUs.setMessage(ExcelUtils.getCellData(i, 5));
		contactUs.setConsentbtn();
		captureScreenShot(driver, "Contact Page - Positive Results");
		contactUs.setSubmitbtn();
		
		//driver.switchTo().frame(0);
		
		 String ActualResults2 = contactUs.getFailtxt();
		  String ExpectedResults2 = ExcelUtils.getCellData(i, 6);
		  
		  if(ActualResults2.equalsIgnoreCase(ExpectedResults2)) {
			  ExcelUtils.setCellData(ActualResults2, i, 7);
			  ExcelUtils.setCellData("Pass", i, 8);
		  }else {
			  ExcelUtils.setCellData(ActualResults2, i, 7);
			  ExcelUtils.setCellData("Fail", i, 8);
		  
	
		  }	
		  captureScreenShot(driver, "Contact Page - Positive Results");
		
		contactUs.clickUsingJavaScriptExecutor();
		  }
	}
	
	@AfterSuite(enabled = false)
	public void Close() {
		driver.quit();
	}
	



public void captureScreenShot(WebDriver driver, String Name) throws IOException {
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dest = new File("./"+"/Screenshots/"+ Name +".png");
	FileUtils.copyFile(src, dest);
	
	
	
}}
