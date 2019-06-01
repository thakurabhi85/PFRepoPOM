package pomPack.tests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.LogStatus;

import pomPack.pages.LaunchPage;
import pomPack.tests.base.BaseTest;
import pomPack.util.Constants;
//this is a test
public class LoginTest extends BaseTest {
	
public void testLogin() throws IOException {
		
		
		 eTest = eReport.startTest("Login Test");
		eTest.log(LogStatus.INFO,"Stating Login Test");
		openBrowser(Constants.BROWSER_TYPE);
		LaunchPage launchPage=new LaunchPage(driver,eTest);
		PageFactory.initElements(driver, launchPage);
		boolean loginStatus=launchPage.goToLoginPage();
		if(loginStatus)
		{
			//pass the test case
			reportPass("LoginTest testcase passed");
		}
		
		else
		{
			//fail the test case
			reportFail("LoginTest testcase failed");
		}
		
}
		@AfterMethod
		public void testClosure() {
			if(eReport!=null)
			{
				eReport.endTest(eTest);
				eReport.flush();
			}
			
			if(driver!=null)
			{
				driver.quit();
			}
		}
		
	}

