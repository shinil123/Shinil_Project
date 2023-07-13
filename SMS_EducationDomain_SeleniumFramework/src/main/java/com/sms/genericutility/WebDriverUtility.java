package com.sms.genericutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebDriverUtility {
	FileUtility fLib = new FileUtility();
	int TIMEOUT;
	
	public WebDriverUtility()  {
	try {	
		String filepath = fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String STIMEOUT = fLib.getDataFromProperties(filepath, "TimeOut");
		 TIMEOUT = Integer.parseInt(STIMEOUT);
	}
	catch(Throwable e)
	{
		
	}
	}

	
	public void waitForElementInDOM(WebDriver driver) throws Throwable {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
	}
	

	public void waitForPage(WebDriver driver , String partailPageURL) throws Throwable {
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
		wait.until(ExpectedConditions.urlContains(partailPageURL));
	}
	

	public void waitForElement(WebDriver driver , WebElement element) throws Throwable {
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	   public void waitAndClick(WebElement element) throws Throwable
	   {

		   int count = 0;
	       while(count<TIMEOUT) {
		    	   try {
		    	       element.click();
		    	       break;
		    	   }catch(Throwable e){
		    		   Thread.sleep(1000);
		    		   count++;
		    	   }
	       }
	   }
	   
	   public void waitAndType(WebElement element, String data) throws InterruptedException
	   {
		   int count = 0;
	       while(count<20) {
		    	   try {
		    	       element.sendKeys(data);
		    	       break;
		    	   }catch(Throwable e){
		    		   Thread.sleep(1000);
		    		   count++;
		    	   }
	       }
	   }
	
	public void swithToWindow(WebDriver driver , String partialWindowTitle) {
	       Set<String> set = driver.getWindowHandles();
	         Iterator<String> it = set.iterator();

	          while (it.hasNext()) {
			          String wID = it.next();
			          driver.switchTo().window(wID);
			          String currentWindowTitle = driver.getTitle();
			          if(currentWindowTitle.contains(partialWindowTitle)) {
			        	  System.out.println(partialWindowTitle + "Switch to Window is passed--!");
			        	  break;
			          }
		    	}
	}

	public void swithToWindowBasedOnURL(WebDriver driver , String partialWindowURL) {
	       Set<String> set = driver.getWindowHandles();
	         Iterator<String> it = set.iterator();

	          while (it.hasNext()) {
			          String wID = it.next();
			          driver.switchTo().window(wID);
			          String currentWindowTitle = driver.getCurrentUrl();
			          if(currentWindowTitle.contains(partialWindowURL)) {
			        	  System.out.println(partialWindowURL + "Switch to Window is passed--!");
			        	  break;
			          }
		    	}
	}

	public void swithToAlertWindowAndAccpect(WebDriver driver ,String expectedMsg) {
		Alert alt = driver.switchTo().alert();
		 if(alt.getText().trim().equalsIgnoreCase(expectedMsg.trim())) {
			 System.out.println("Alert Message is verified");
		 }else {
			 System.out.println("Alert Message is not verified");
		 }
		alt.accept();
	}
	
	public void swithToAlertWindowAndCancel(WebDriver driver, String expectedMsg) {
		Alert alt = driver.switchTo().alert();
		 if(alt.getText().equals(expectedMsg)) {
			 System.out.println("Alert Message is verified");
		 }else {
			 System.out.println("Alert Message is not verified");
		 }
		 alt.dismiss();
	}
	public void swithToFrame(WebDriver driver , int index) {
		driver.switchTo().frame(index);
	}
	
	public void swithToFrame(WebDriver driver , String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	
	public void select(WebElement element , int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void select(WebElement element , String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public void mouseOverOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
	}
	
	
	public void rightClickOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
	}
	
	public void executeJavaScript(WebDriver driver , String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript(javaScript, null);
	}

	   

	   
	   public void passEnterKey(WebDriver driver) {
		   Actions act = new Actions(driver);
		   act.sendKeys(Keys.ENTER).perform();
	   } 
	   
	   public void maximize(WebDriver driver)
		{
			driver.manage().window().maximize();
		}
}
