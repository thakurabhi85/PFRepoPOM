package pomPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

import pomPack.base.basePage;

public class HomePage extends basePage {
	
	@FindBy(css="[class^='zicon-apps-chat']")
	public WebElement cliqOption;
	
	@FindBy(css="[class^='zicon-apps-crm']")
	public WebElement crm;
	
	@FindBy(css="[class^='zicon-apps-salesiq']")
	public WebElement salesIQOption;
	
	@FindBy(css="[class^='zicon-apps-calender']")
	public WebElement Calender;
	
	@FindBy(css="[class^='zicon-apps-mail']")
	public WebElement Mail;
	//Reusable method to verify the presence of CRM option
	
	//Reusable method for navigating to CRM option
	
	//Reusable method for navigating to SalesIQ option
	
	//Reusable method for navigating to Cliq option
	
	//constructor code
	public HomePage(WebDriver driver,ExtentTest eTest)
	{
		this.driver=driver;
		this.eTest=eTest;
	}
	
	
	//reusable method for verify whether user got successfully logged in or not
	public boolean verifyDisplayOfHomePage()
	{
		return(isElementPresent(crm));
		
	}
}
