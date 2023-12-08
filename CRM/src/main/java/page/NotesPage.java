package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtility;
import utility.WaitUtility;

public class NotesPage
{
	
	WebDriver driver;
	ElementUtility elmentutility;
	WaitUtility waitutility;
	
	@FindBy(xpath="//span[text()='Notes']")
	WebElement notes;
	
	@FindBy(xpath="//a[@class='btn btn-default']")
	WebElement add;
	
	@FindBy(id="title")
	WebElement title;
	
	@FindBy(id="description")
	WebElement description;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement save;
	
    @FindBy(xpath="//input[@type='search']")
	WebElement search;
	
	@FindBy(xpath="//table[@id='note-table']//tbody//tr[1]//td[2]//a")
	WebElement titlecolumndata;
	
	@FindBy(xpath="//table[@id='note-table']//tbody//tr[1]//td[4]//a[@class='edit']")
	WebElement editData;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement editTitle;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement editSave;
	
	@FindBy(xpath="//button[@class='close']")
	WebElement closeButton;
	
	@FindBy(xpath="//table[@id='note-table']//tbody//tr[1]//td[4]//a[2]")
	WebElement clickDeleteButton;
	
	@FindBy(xpath="//button[@id='confirmDeleteButton']")
	WebElement deleteButtonConfirm;
	
	@FindBy(xpath="//button[@id='confirmDeleteButton']")
	WebElement deleteCheck;
	
	
	@FindBy(xpath="//table[@id='note-table']//tbody//tr[1]//td")
	WebElement deleteText;
	
	
	
	public NotesPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elmentutility=new ElementUtility(driver);
		waitutility=new WaitUtility(driver);
	}

	public void clickNoteLink()
	{
		waitutility.waitForClick(notes);
		elmentutility.doClick(notes);
	}
	public void addClickButton()
	{
		waitutility.waitForClick(add);
		elmentutility.doClick(add);
	}
	public void fillAddNoteForm(String value)
	{
		waitutility.waitForVisiblity(title);
		elmentutility.doSendKeys(title, value);	
	}
	public void fillAddDescription(String value)
	{
		
		elmentutility.doSendKeys(description, value);
	}
	public void save()
	{
		waitutility.waitForClick(save);
		elmentutility.doClick(save);
	}
	public void close()
	{
		waitutility.waitForClick(closeButton);
		elmentutility.doClick(closeButton);
	}
	public String enterSearchValue(String value)
	{
		elmentutility.doClick(search);
		waitutility.waitForVisiblity(search);
		elmentutility.doSendKeys(search, value);
		
		By locator=By.xpath("//table[@id='note-table']//tbody//tr//td//a[contains(text(),'"+value+"')]");
		waitutility.waitForVisiblity(locator);
		List<WebElement> notetable=driver.findElements(By.xpath("//table[@id='note-table']//tbody//tr//td//a[contains(text(),'"+value+"')]"));
		waitutility.waitForVisiblity(notetable);
		int row=elmentutility.getTableDataRowCount(notetable, value);

		String actualmsg="";
        if(row!=0) 
		{
			WebElement tableRow=driver.findElement(By.xpath("//table[@id='note-table']//tbody//tr["+row+"]//td[2]"));
			actualmsg=tableRow.getText();
			System.out.println("Searched Element : " +actualmsg);
		}
		return actualmsg;
	}
	public String doEdit(String value)
	{
		
		elmentutility.doClick(editData);
		waitutility.waitForVisiblity(title);
		elmentutility.doClearData(title);
		elmentutility.doSendKeys(editTitle, value);
		elmentutility.doClick(editSave);
		String editTitle=elmentutility.getText(titlecolumndata);
		return editTitle; 
		
	}
	
	public String dodeleteNote(String value)

	{
		waitutility.waitForVisiblity(search);
		elmentutility.doSendKeys(search, value);
		
		elmentutility.doClick(clickDeleteButton);
		waitutility.waitForClick(clickDeleteButton);
		
		waitutility.waitForVisiblity(deleteButtonConfirm);
		elmentutility.doClick(deleteButtonConfirm);
		
		
		waitutility.waitForVisiblity(search);
		elmentutility.doSendKeys(search, value);
		
		waitutility.waitForVisiblity(deleteText);
		String deleteTextData=elmentutility.getText(deleteText);
		return  deleteTextData; 
		
		}


	
	

}
