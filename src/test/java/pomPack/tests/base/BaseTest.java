package pomPack.tests.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pomPack.util.Constants;
import pomPack.util.ExtentManager;

public class BaseTest {
	public ExtentReports eReport=ExtentManager.getInstance();;
	public ExtentTest eTest=null;

	//generic reusable methods need to be created which are not related to application.like opening the browser
public WebDriver driver=null;
	
	public void openBrowser(String browserType) {
		
		if(browserType.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();		
			
		}else if(browserType.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",Constants.CHROME_DRIVER_EXE);
			driver = new ChromeDriver();
			
		}else if(browserType.equalsIgnoreCase("ie")) {
			
			System.setProperty("webdriver.ie.driver", Constants.IE_DRIVER_EXE);
			driver = new InternetExplorerDriver();
		
		}
		
		eTest.log(LogStatus.INFO, "Successfully opened the browser of "+browserType);
		driver.manage().window().maximize();
		eTest.log(LogStatus.INFO, "Browser got maximised");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
public void reportPass(String message)	
{
	eTest.log(LogStatus.PASS, message);
}
public void reportFail(String message) throws IOException	
{
	eTest.log(LogStatus.FAIL, message);

	takeScreenshot();
	/*fail the testng test*/
	Assert.fail(message);
	
}
	
	//take screenshot
public void takeScreenshot() throws IOException
{
			Date d=new Date();
				
				String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
				File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(srcFile, new File("\\screenshots\\screenshotFile"));
				
				
				//put screenshots into report
				eTest.log(LogStatus.INFO, "Screenshot -> "+eTest.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
			}
	
}

