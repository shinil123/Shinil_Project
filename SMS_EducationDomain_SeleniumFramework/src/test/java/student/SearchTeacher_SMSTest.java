package student;
//System Test case
import java.io.FileInputStream;


import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.sms.genericutility.BaseClass;
import com.sms.genericutility.ExcelUtility;
import com.sms.genericutility.FileUtility;
import com.sms.genericutility.WebDriverUtility;
import sms.pomrepository.HomePage;
import sms.pomrepository.LoginPage;
@Listeners(com.sms.genericutility.ListenerImplementation.class)
public class SearchTeacher_SMSTest extends BaseClass
{//(groups={"System"})
	@Test(retryAnalyzer=com.sms.genericutility.RetryImplementation.class,alwaysRun = true)
	public void searchTeacher() throws Throwable 
	{
		TEST_SCRIPT_EXCEL_FILE_PATH=fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");
		String value=eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH,"Sheet1", "TC_04", "Teacher_Name");
		HomePage home=new HomePage(driver);
		home.Teacher();
		home.AllTeacher();
		driver.findElement(By.xpath("//div[@id='example1_filter']/label/input")).sendKeys(value,Keys.ENTER);
   
	}
}
