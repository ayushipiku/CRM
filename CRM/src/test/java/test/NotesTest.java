package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import page.LoginPage;
import page.NotesPage;
import utility.ElementUtility;
import utility.ExcelRead;


public class NotesTest extends BaseTest {
  @Test(priority=1,groups= {"sanity","regression"},retryAnalyzer=generaltests.Retry.class)
  public void verifyAddNote() {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin(ExcelRead.getString(1, 0, "logindata"),ExcelRead.getNumeric(1, 1, "logindata" ));
	  NotesPage np=new NotesPage(driver);
	  np.clickNoteLink();
	  np.addClickButton();
	 
	  np.fillAddNoteForm(ExcelRead.getString(12, 0, "logindata"));
	 
	  np.fillAddDescription(ExcelRead.getString(12, 1, "logindata"));
	  np.save();
	  np.close();
	  np.clickNoteLink();
	  
	 
	  String expected ="veegaland";
	  String actualtitle=np.enterSearchValue(ExcelRead.getString(12, 0, "logindata"));
	  Assert.assertEquals(actualtitle, expected, "Search is not successful");
	  
	  
  }
  @Test(priority=2,groups= {"regression"},retryAnalyzer=generaltests.Retry.class)
  public void verifySearchNote() {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin(ExcelRead.getString(1, 0, "logindata"),ExcelRead.getNumeric(1, 1, "logindata" ));
	  NotesPage np=new NotesPage(driver);
	  np.clickNoteLink();
	 
	  String expected ="veegaland";
	  String actualtitle=np.enterSearchValue(ExcelRead.getString(12, 0, "logindata"));
	  Assert.assertEquals(actualtitle, expected, "Search is not successful");
	  }
  
  @Test(priority=3,groups= {"regression"},retryAnalyzer=generaltests.Retry.class)
  public void verifyEditNote() {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin(ExcelRead.getString(1, 0, "logindata"),ExcelRead.getNumeric(1, 1, "logindata" ));
	  NotesPage np=new NotesPage(driver);
	  np.clickNoteLink();
	 
	  String expected ="wonderland";
	  String actulaTitle=np.doEdit(ExcelRead.getString(12, 2, "logindata"));
	  Assert.assertEquals(actulaTitle, expected, "edit is not  successful");
	  
  }
  
  @Test(priority=4,groups= {"regression"},retryAnalyzer=generaltests.Retry.class)
  public void verifyDeleteEditNote() {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin(ExcelRead.getString(1, 0, "logindata"),ExcelRead.getNumeric(1, 1, "logindata" ));
	  NotesPage np=new NotesPage(driver);
	  np.clickNoteLink();
	 
	  String expected="No record found.";
	  String actulaTitle=np.dodeleteNote(ExcelRead.getString(12, 2, "logindata"));
	  Assert.assertEquals(actulaTitle, expected, "delete is not  successful");
	   
	  }
  
}
