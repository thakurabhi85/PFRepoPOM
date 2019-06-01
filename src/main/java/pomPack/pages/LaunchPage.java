package pomPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pomPack.base.basePage;
import pomPack.util.Constants;

public class LaunchPage extends basePage {

	
	//WEBELEMENTS
	@FindBy(className="zh-customers")
	public WebElement Customers;
	
	@FindBy(className="zh-support")
	public WebElement Support;
	
	@FindBy(className="zh-login")
	public WebElement Login;
	
	
	@FindBy(className="zh-signup")
	public WebElement Signup;
	
	//creating a constructor
	public LaunchPage(WebDriver driver,ExtentTest eTest	)
	{
		this.driver=driver;
		this.eTest=eTest;
		
	}
	
	//Reusable methods of launch page
	public boolean goToLoginPage()
	{
		driver.get(Constants.APP_URL);
		eTest.log(LogStatus.INFO, "Application URL "+Constants.APP_URL+" got opened");
		Login.click();
		eTest.log(LogStatus.INFO, "Login option got clicked");
		
		LoginPage loginPage=new LoginPage(driver,eTest);
		PageFactory.initElements(driver, loginPage);
		boolean loginStatus=loginPage.doLogin();
		return loginStatus;
		
		
	}
	
}
