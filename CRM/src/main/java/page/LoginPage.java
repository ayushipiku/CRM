package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtility;

public class LoginPage {
WebDriver driver;
	
	ElementUtility elementutil;
	
	@FindBy(name="email")
	WebElement usernamefield;
	
	@FindBy(name="password")
	WebElement passwordfield;
	
	@FindBy(xpath="//button[text()='Sign in']")
	WebElement submit;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		elementutil=new ElementUtility(driver);
		PageFactory.initElements(driver,this );
		
	}
	

	public void doLogin(String username,String password) {
	
	    
		 elementutil.doSendKeys(usernamefield, username);
		
         elementutil.doSendKeys(passwordfield, password);
		
		 elementutil.doClick(submit);
		 submit.click();
	}

}
