package student;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sms.genericutility.BaseClass;
import sms.pomrepository.HomePage;
@Listeners(com.sms.genericutility.ListenerImplementation.class)
public class Student_attendanceHistory_SMSTest extends BaseClass
{//(groups={"System"})
		@Test(retryAnalyzer=com.sms.genericutility.RetryImplementation.class,alwaysRun = true)
		public void AttHistoryTest() throws Throwable 
		{
			TEST_SCRIPT_EXCEL_FILE_PATH=fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");
			HomePage home=new HomePage(driver);
			home.Attendance();
			home.AttHistory();
			WebElement year=driver.findElement(By.id("year"));
			wLib.select(year, 0);
			WebElement month=driver.findElement(By.id("month"));
			wLib.select(month, eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Sheet2","TC_07","Exam_Month"));
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			WebElement element = home.getSignOutImg();
			wLib.waitForElement(driver, element);
		}
}
