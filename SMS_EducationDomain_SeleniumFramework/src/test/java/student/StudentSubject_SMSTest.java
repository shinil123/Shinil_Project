package student;
//System test case
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sms.genericutility.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.sms.genericutility.FileUtility;
import com.sms.genericutility.WebDriverUtility;
import sms.pomrepository.HomePage;
import sms.pomrepository.LoginPage;
@Listeners(com.sms.genericutility.ListenerImplementation.class)
public class StudentSubject_SMSTest extends BaseClass
{//(groups={"System"})
	@Test(retryAnalyzer=com.sms.genericutility.RetryImplementation.class,alwaysRun = true)
	public void Subject() throws Throwable  
	{	
		HomePage home=new HomePage(driver);
		home.Subjects();
		home.StudentSubject();
	}
}
