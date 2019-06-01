package pomPack.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

public class basePage {
	public WebDriver driver=null;
	public ExtentTest eTest=null;

	//reusable methods across pages will be kept here

public boolean isElementPresent(WebElement element)
{
boolean displayedStatus=element.isDisplayed();	
if(displayedStatus)
{
	return true;
}
else
{
	return false;
}
}
}