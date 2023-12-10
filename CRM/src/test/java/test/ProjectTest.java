package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.ClientPage;
import page.LoginPage;
import page.NotesPage;
import page.ProjectPage;
import utility.ExcelRead;
import utility.FakerUtility;

public class ProjectTest extends BaseTest {
	
	@Test(priority=1,groups= {"sanity","regression"},retryAnalyzer=generaltests.Retry.class)
    public void verifyAddNote() {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin(ExcelRead.getString(1, 0, "logindata"),ExcelRead.getNumeric(1, 1, "logindata" ));
	  ProjectPage pg=new ProjectPage(driver);
	  pg.clickProjectLink();
	  pg.clickAddProjectButton();
	  
	  pg.addClientTitle(ExcelRead.getString(8, 0, "logindata"));
	  
	  pg.addClientDescription(ExcelRead.getString(8, 1, "logindata"));
	  
	  pg.addStartDate(ExcelRead.getNumeric(8, 2, "logindata" ));
	 
	  pg.addEndtDate(ExcelRead.getNumeric(8, 3, "logindata" ));
	  
	  pg.addPrice(ExcelRead.getNumeric(8, 4, "logindata" ));
	  pg.save();
	  
	  String expected ="obsqura";
	  String actualtitle=pg.enterSearchValue(ExcelRead.getString(8, 0, "projecttestdata"));
	  Assert.assertEquals(actualtitle, expected, "Add is not successful");
	}
	
	 @Test(priority=2,groups= {"regression"},retryAnalyzer=generaltests.Retry.class)
	 public void verifySearchNote() {
		  LoginPage lp=new LoginPage(driver);
		  lp.doLogin(ExcelRead.getString(1, 0, "logindata"),ExcelRead.getNumeric(1, 1, "logindata" ));
		  ProjectPage pg=new ProjectPage(driver);
		  pg.clickProjectLink();
		  
		  String expected ="obsqura";
		  String actualtitle=pg.enterSearchValue(ExcelRead.getString(8, 0, "logindata"));
		  Assert.assertEquals(actualtitle, expected, "Search is not successful");
		  }
	
	
}
	 
	  
	  
	  

