package student;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sms.genericutility.BaseClass;
import sms.pomrepository.HomePage;
@Listeners(com.sms.genericutility.ListenerImplementation.class)
public class StudentExamMarks_SMSTest extends BaseClass//Marks Graphical Representation
{//(groups={"Integration"})
	@Test(retryAnalyzer=com.sms.genericutility.RetryImplementation.class,alwaysRun = true)
	public void ExamMarksGraph() throws Throwable 
	{
		TEST_SCRIPT_EXCEL_FILE_PATH=fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");
		HomePage home=new HomePage(driver);
		home.Exam();
		home.ExamMarks();
		WebElement exam=driver.findElement(By.id("exam"));
		wLib.select(exam,eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH,"Sheet3", "TC_12", "Exam_Names"));
		driver.findElement(By.id("btnSubmit")).click();
		driver.findElement(By.xpath("//input[@value='Pie Chart']")).click();
//		WebElement element = home.getSignOutImg();
//		wlib.waitForElement(driver, element);
	}
}
