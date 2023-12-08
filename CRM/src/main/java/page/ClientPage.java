package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtility;
import utility.WaitUtility;

public class ClientPage {

	WebDriver driver;
	ElementUtility elmentutility;
	WaitUtility waitutility;
	
	@FindBy(xpath="//span[text()='Clients']")
	WebElement clients;
	
	@FindBy(xpath="//a[@class='btn btn-default']")
	WebElement add;
	
	@FindBy(xpath="//input[@id='company_name']")
	WebElement companyName;
	
	@FindBy(id="address")
	WebElement address;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(xpath="//input[@id='state']")
	WebElement state;
	
	@FindBy(xpath="//input[@id='zip']")
	WebElement zip;
	
	@FindBy(xpath="//input[@id='country']")
	WebElement country;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement phoneNo;
	
	@FindBy(xpath="//input[@id='website']")
	WebElement website;
	
	@FindBy(xpath="//input[@id='vat_number']")
	WebElement vatNo;
	
	@FindBy(xpath="//div[@id='s2id_currency']")
	WebElement currenyField;
	
	@FindBy(xpath="//div[text()='AED']")
	WebElement selectCurreny;
	
	@FindBy(xpath="//input[@id='disable_online_payment']")
	WebElement disableOnlineCheckBox;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement save;
	
	
	@FindBy(xpath="//input[@type='search']")
	WebElement search;
	
	
	@FindBy(xpath="//table[@id='client-table']//tbody//tr[1]//td[2]")
	WebElement clientData;
	
	@FindBy(xpath="//table[@id='client-table']//tbody//tr[1]//td[9]//a[@class='edit']")
	WebElement editLink;
	
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement editSave;
	
	@FindBy(xpath="//button[@class='close']")
	WebElement closeButton;
	
	@FindBy(xpath="//table[@id='client-table']//tbody//tr[1]//td[9]//a[2]")
	WebElement clickDeleteButton;
	
	@FindBy(xpath="//button[@id='confirmDeleteButton']")
	WebElement deleteButtonConfirm;
	
	@FindBy(xpath="//button[@id='confirmDeleteButton']")
	WebElement deleteCheck;
	
	
	@FindBy(xpath="//table[@id='client-table']//tbody//tr[1]//td")
	WebElement deleteText;


	public  ClientPage (WebDriver driver) 
	{
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
	elmentutility=new ElementUtility(driver);
	waitutility=new WaitUtility(driver);
	
	}

public void clickClientLink()
{
	waitutility.waitForClick( clients);
	elmentutility.doClick( clients);
}
public void addClientLink()
{
	waitutility.waitForClick(add);
	elmentutility.doClick(add);
}
public void fillAddCompanyName(String value)
{
	waitutility.waitForVisiblity(companyName);
	elmentutility.doSendKeys(companyName, value);	
}

public void fillAddAddress(String value)
{
	waitutility.waitForVisiblity(address);
	elmentutility.doSendKeys(address, value);
}

public void fillAddCity(String value)
{
	waitutility.waitForVisiblity(city);
	elmentutility.doSendKeys(city, value);	
}

public void fillAddState(String value)
{
	waitutility.waitForVisiblity(state);
	elmentutility.doSendKeys(state, value);	
}

public void fillAddZip(String value)
{
	waitutility.waitForVisiblity(zip);
	elmentutility.doSendKeys(zip, value);	
}

public void fillAddCountry(String value)
{
	waitutility.waitForVisiblity(country);
	elmentutility.doSendKeys(country, value);	
}
public void fillAddPhone(String value)
{
	waitutility.waitForVisiblity(phoneNo);
	elmentutility.doSendKeys(phoneNo, value);	
	elmentutility.scrollIntoView(phoneNo);
}

public void fillAddvatNo(String value)
{
	waitutility.waitForVisiblity(vatNo);
	elmentutility.doSendKeys(vatNo, value);	
}

public void clickCurrencyDropDown()
{
	
    waitutility.waitForClick(currenyField);
    elmentutility.doClick(currenyField);
	 
}

public void selectCurrency()
{
	waitutility.waitForClick(selectCurreny);
	elmentutility.doClick(selectCurreny);

}

public void checkBox()
{
	
	waitutility.waitForVisiblity(disableOnlineCheckBox);
	elmentutility.doClick(disableOnlineCheckBox);
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
	
	String client=elmentutility.getText(clientData);
	return client;
}
public String doEdit(String value)
{
	elmentutility.doClick(editLink);
	waitutility.waitForVisiblity(companyName);
	
	elmentutility.doClearData(companyName);
	elmentutility.doSendKeys(companyName, value);
	elmentutility.doClick(editSave);
	
	waitutility.waitForPrsenceOfElement(By.xpath("//input[@type='search']"));
	
	elmentutility.doClick(search);
	elmentutility.doSendKeys(search, value);
	
	
	String editCompanyName=elmentutility.getText(clientData);
	return editCompanyName; 
	
	
}
public String dodeleteClient(String value)

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
