package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtility;
import utility.WaitUtility;

public class ProjectPage {
	WebDriver driver;
	ElementUtility elmentutility;
	WaitUtility waitutility;
	
	@FindBy(xpath="//span[text()='Projects']")
	WebElement projectsClick;
	

	@FindBy(xpath="//span[text()='All Projects']")
	WebElement subProjectsClick;
	
	@FindBy(xpath="//a[@title='Add project']")
	WebElement addProject;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement title;
	
	@FindBy(xpath="//input[@id='s2id_autogen6_search']")
	WebElement clickClient;
	
	@FindBy(xpath="//div[@id='select2-result-label-202']")
	WebElement selectClient;
	
	@FindBy(xpath="//textarea[@id='description']")
	WebElement clientDescription;
	
	@FindBy(xpath="//input[@id='start_date']")
	WebElement startDate;
	
	@FindBy(xpath="//input[@id='deadline']")
	WebElement deadLine;
	
	@FindBy(xpath="//input[@id='price']")
	WebElement price;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement save;
	

	@FindBy(xpath="//input[@type='search']")
	WebElement search;
	
	@FindBy(xpath="//table[@id='project-table']//tbody//tr[1]//td[2]")
	WebElement projectData;
	
	
	
	public ProjectPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elmentutility=new ElementUtility(driver);
		waitutility=new WaitUtility(driver);
		
	}

	public void clickProjectLink()
	{
		waitutility.waitForClick(projectsClick);
		elmentutility.doClick(projectsClick);
		
		waitutility.waitForClick(subProjectsClick);
		elmentutility.doClick(subProjectsClick);
		
	}
	
	public void clickAddProjectButton()
	{
		waitutility.waitForClick(addProject);
		elmentutility.doClick(addProject);
	}
	
	public void addClientTitle(String value)
	{
		waitutility.waitForVisiblity(title);
		elmentutility.doSendKeys(title, value);	
	}
	
	
	public void addClientDescription(String value)
	{
		waitutility.waitForVisiblity(clientDescription);
		elmentutility.doSendKeys(clientDescription, value);	
	}
	
	public void addStartDate(String value)
	{
		waitutility.waitForVisiblity( startDate);
		elmentutility.doSendKeys(startDate, value);	
	}
	
	public void addEndtDate(String value)
	{
		waitutility.waitForVisiblity(deadLine);
		elmentutility.doSendKeys(deadLine, value);	
	}
	
	public void addPrice(String value)
	{
		waitutility.waitForVisiblity(price);
		elmentutility.doSendKeys(price, value);	
	}
	
	public void save()
	{
		waitutility.waitForClick(save);
		elmentutility.doClick(save);
	}
	
	public String enterSearchValue(String value)
	{
		
		waitutility.waitForVisiblity(search);
		elmentutility.doClick(search);
		elmentutility.doSendKeys(search, value);
		
		String project=elmentutility.getText(projectData);
		return project;
	
}
}
