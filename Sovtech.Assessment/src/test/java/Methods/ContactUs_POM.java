package Methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUs_POM {
	
WebDriver driver;

	
	By Nametxt = By.id("your_name-c2e387f9-4bd8-496f-ab2a-81fbbc31712a");
	By Emailtxt = By.id("email-c2e387f9-4bd8-496f-ab2a-81fbbc31712a");
	By ContactNumbertxt = By.id("mobilephone-c2e387f9-4bd8-496f-ab2a-81fbbc31712a");
	By CompanySizedrop = By.id("numemployees-c2e387f9-4bd8-496f-ab2a-81fbbc31712a");
	By Services = By.id("what_kind_of_problem_is_your_business_currently_facing_-c2e387f9-4bd8-496f-ab2a-81fbbc31712a");
	By Messagetxt = By.id("message-c2e387f9-4bd8-496f-ab2a-81fbbc31712a");
	By Consentbtn = By.id("LEGAL_CONSENT.subscription_type_10841063-c2e387f9-4bd8-496f-ab2a-81fbbc31712a");
	By Submitbtn = By.xpath("/html[1]/body[1]/div[1]/form[1]/div[1]/div[2]/input[1]");
	By ContactUsMenubtn = By.cssSelector("ul#menu-main-menu li:nth-child(5) > a > span");
	By getSuccessfultxt = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h2[1]");
	By getFailReultstxt = By.xpath("/html[1]/body[1]/div[1]/form[1]/div[1]/ul[1]/li[1]/label[1]");
	
	public ContactUs_POM(WebDriver driver) {
		this.driver=driver;
		
	}
	
	
	
	public void setNameClear() {
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30000));
		
		WebElement nametxtt = wait.until(ExpectedConditions.visibilityOfElementLocated(Nametxt));
		
		driver.findElement(Nametxt).clear();
		}
	
	public void setNametxt(String name) {
		driver.findElement(Nametxt).sendKeys(name);
	}
	public void setEmailClear() {
		driver.findElement(Emailtxt).clear();
		}
	public void setEmailtxt(String email) {
		driver.findElement(Emailtxt).sendKeys(email);
	}
	public void setContactNumberClear() {
		driver.findElement(ContactNumbertxt).clear();
		}
	public void setContactNumber(String Cnumber) {
		driver.findElement(ContactNumbertxt).sendKeys(Cnumber);
	}
	
	public void setCompanySize(String companysize) {
		new Select (driver.findElement(CompanySizedrop)).selectByValue(companysize); 
	}
	
	public void setServices(String service) {
		new Select (driver.findElement(Services)).selectByValue(service);
	}
	public void setMessageClear() {
		driver.findElement(Messagetxt).clear();
		}
	public void setMessage(String message) {
		driver.findElement(Messagetxt).sendKeys(message);
	}
	public void setConsentbtn() {
		driver.findElement(Consentbtn).click();
	}
	public void setSubmitbtn() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		WebElement submitbttn = wait.until(ExpectedConditions.visibilityOfElementLocated(Submitbtn));
		driver.findElement(Submitbtn).click();
	}
	public void setContactUsbtn() {
		driver.findElement(ContactUsMenubtn).click();
	}
	public void setContactMenu() {
		driver.findElement(ContactUsMenubtn).click();
	}
	
	public void clickUsingJavaScriptExecutor() {
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		WebElement contactus = wait.until(ExpectedConditions.visibilityOfElementLocated(ContactUsMenubtn));
		
		//create javascript executor
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		WebElement pc = driver.findElement(ContactUsMenubtn);
		executor.executeScript("arguments[0].click();", pc);
	}
	
	public String getSuccesstxt() 
	{
		return driver.findElement(getSuccessfultxt).getText();
	}
	public String getFailtxt() 
	{
		return driver.findElement(getFailReultstxt).getText();
	}

}
