package com.sms.genericutility;

import java.sql.SQLException; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import sms.pomrepository.HomePage;
import sms.pomrepository.LoginPage;

public class BaseClass 
{
	public static WebDriver sdriver;
	public WebDriver driver;
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public DataBaseUtility dLib=new DataBaseUtility();
	public String ENV_FILE_PATH;
	public String TEST_SCRIPT_EXCEL_FILE_PATH;

	@BeforeSuite
	public void connectDB() throws SQLException
	{
		dLib.connectDB();
		System.out.println("dataBase is connected");
	}
	@Parameters("browser")
	@BeforeClass
	public void launchBrowser(String BROWSER) throws Throwable
	{
		
		ENV_FILE_PATH=fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
	//	String BROWSER=fLib.getDataFromProperties(ENV_FILE_PATH,"browser");
		String URL=fLib.getDataFromProperties(ENV_FILE_PATH,"url");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
					}else if(BROWSER.equalsIgnoreCase("firefox")) {
						driver = new FirefoxDriver();
					}else if(BROWSER.equalsIgnoreCase("edge")) {
						WebDriverManager.edgedriver().setup();
						driver = new EdgeDriver();
					}else {
					    driver = new ChromeDriver();
					}	
		sdriver=driver;
		wLib.waitForElementInDOM(driver);
		wLib.maximize(driver);
		driver.get(URL);
		System.out.println("Browser is launched");
	}
	
	@BeforeMethod
	public void login() throws Throwable
	{
		TEST_SCRIPT_EXCEL_FILE_PATH=fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");
	//	wlib.waitForElement(driver, usernameTxt);
		String USERNAME=fLib.getDataFromProperties(ENV_FILE_PATH,"user3");
		String PASSWORD=fLib.getDataFromProperties(ENV_FILE_PATH,"password");
		LoginPage Login=new LoginPage(driver);
		Login.loginToApp(USERNAME, PASSWORD);
//		wlib.implicitlyWait(driver);
		System.out.println("successfully logged into application");
		
	}
	
	@AfterMethod
	public void logout()
	{
		HomePage home=new HomePage(driver);
		home.getSignOutImg();
		home.logoutToApp();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("Browser is closed");
	}
	
	@AfterSuite
	public void closeDB() throws SQLException
	{
		dLib.closeDB();
		System.out.println("dataBase is closed");
	}
}
