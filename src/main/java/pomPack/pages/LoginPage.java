package pomPack.pages;

import java.util.Base64;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pomPack.base.basePage;
import pomPack.util.Constants;

public class LoginPage extends basePage {

	@FindBy(id="lid")
	public WebElement EmailField;
	
	@FindBy(id="pwd")
	public WebElement PasswordField;

	@FindBy(id="signin_submit")
	public WebElement SignInButton;
	
	
	public LoginPage(WebDriver driver,ExtentTest eTest)
	{
		this.driver=driver;
		this.eTest=eTest;
	}
	//reusable methods of login page
	
	public boolean doLogin()
	{
		EmailField.sendKeys(Constants.USERNAME);
		eTest.log(LogStatus.INFO, "Username got entered into email field on login page");
		PasswordField.sendKeys(Constants.PASSWORD);
		eTest.log(LogStatus.INFO, "Password got enetered succesfully");
		SignInButton.click();
		eTest.log(LogStatus.INFO, "Sign in button got clicked");
		
		HomePage homepage=new HomePage(driver,eTest);
		PageFactory.initElements(driver, homepage);
		boolean loginStatus=homepage.verifyDisplayOfHomePage();
		return loginStatus;
		
	}
}
