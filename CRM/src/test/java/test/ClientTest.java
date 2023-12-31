package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.ClientPage;
import page.LoginPage;
import page.NotesPage;
import utility.ExcelRead;
import utility.FakerUtility;

public class ClientTest extends BaseTest {
	

	  @Test(priority=1,groups= {"sanity","regression"},retryAnalyzer=generaltests.Retry.class)
	     public void verifyAddNote() {
		  LoginPage lp=new LoginPage(driver);
		  lp.doLogin(ExcelRead.getString(1, 0, "logindata"),ExcelRead.getNumeric(1, 1, "logindata" ));
		  ClientPage cp=new ClientPage(driver);
		  cp.clickClientLink();
		  cp.addClientLink();
		  cp.fillAddCompanyName(ExcelRead.getString(5, 0, "logindata"));
		  
		  cp.fillAddAddress(ExcelRead.getString(5, 1, "logindata"));
		  
		  cp.fillAddCity(ExcelRead.getString(5, 2, "logindata"));
		  
		  cp.fillAddState(FakerUtility.state());
		  
		  cp.fillAddZip(ExcelRead.getNumeric(5, 4, "logindata" ));
		  
		  cp.fillAddCountry(ExcelRead.getString(5, 5, "logindata"));
		  
		  cp.fillAddPhone(FakerUtility.phoneNumber());
		  
		  cp.fillAddvatNo(ExcelRead.getNumeric(5, 7, "logindata" ));
		  
		  cp.clickCurrencyDropDown();
		  cp.selectCurrency();
		  cp.checkBox();
		  cp.save();
		  
		  String expected ="tcs";
		  String actualtitle=cp.enterSearchValue(ExcelRead.getString(5, 0, "logindata"));
		  Assert.assertEquals(actualtitle, expected, "Add is not successful");
		  }
  
	 @Test(priority=2,groups= {"regression"},retryAnalyzer=generaltests.Retry.class)
	 public void verifySearchNote() {
		  LoginPage lp=new LoginPage(driver);
		  lp.doLogin(ExcelRead.getString(1, 0, "logindata"),ExcelRead.getNumeric(1, 1, "logindata" ));
		  ClientPage cp=new ClientPage(driver);
		  cp.clickClientLink();
		 
		  String expected ="tcs";
		  String actualtitle=cp.enterSearchValue(ExcelRead.getString(5, 0, "logindata"));
		  Assert.assertEquals(actualtitle, expected, "Search is not successful");
		  }
	  
	  @Test(priority=3,groups= {"regression"},retryAnalyzer=generaltests.Retry.class)
	  public void verifyEditNote() {
		  LoginPage lp=new LoginPage(driver);
		  lp.doLogin(ExcelRead.getString(1, 0, "logindata"),ExcelRead.getNumeric(1, 1, "logindata" ));
		  ClientPage cp=new ClientPage(driver);
		  cp.clickClientLink();
		 
		  String expected ="img";
		  String actulaTitle=cp.doEdit(ExcelRead.getString(5, 8, "logindata"));
		  Assert.assertEquals(actulaTitle, expected, "edit is not  successful");
		  
	  }
	  @Test(priority=4,groups= {"regression"},retryAnalyzer=generaltests.Retry.class)
	  public void verifyDeleteEditNote() {
		  LoginPage lp=new LoginPage(driver);
		  lp.doLogin(ExcelRead.getString(1, 0, "logindata"),ExcelRead.getNumeric(1, 1, "logindata" ));
		  ClientPage cp=new ClientPage(driver);
		  cp.clickClientLink();
		 
		  String expected="No record found.";
		  String actulaTitle=cp.dodeleteClient(ExcelRead.getString(5, 8, "logindata"));
		  Assert.assertEquals(actulaTitle, expected, "delete is not  successful");
		   
		  }
	  
	 
	  
	}


