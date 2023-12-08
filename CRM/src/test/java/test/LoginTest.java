package test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import page.LoginPage;
import utility.ExcelRead;

public class LoginTest extends BaseTest {
	
	
	  @Test(groups= {"sanity","regression"},dataProvider = "dp",retryAnalyzer=generaltests.Retry.class)
	  public void f(String username,String password) {
		  LoginPage lp=new LoginPage(driver);
		  lp.doLogin(username, password);
		  
	  }
	  @DataProvider
	  public Object[][] dp() throws InvalidFormatException, IOException {
		  Object[][] excelvalue=ExcelRead.getDataFromExcel(Constants.testData, "logindata");
	      return  excelvalue;
	  }
	 

	}
