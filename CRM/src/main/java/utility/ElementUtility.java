package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;

public class ElementUtility {
	WebDriver driver;
	public ElementUtility(WebDriver driver)
	{
	this.driver=driver;
	
	}
	public static String getPropertyValue(String key) 
	{

		File src=new File(Constants.propertyConfig_File);
		Properties pro=new Properties();
		try {
			FileInputStream fis = new FileInputStream (src);
			
			pro.load(fis);
		} catch (Exception e) {

			e.printStackTrace();
		}
		String value=pro.get(key).toString();
		return value;
	}
	
	public void doSendKeys(WebElement element,String value)
	{
		element.sendKeys(value);
	}
	public void doClick(WebElement element)
	{
		element.click();	
	}
	public void radioButtonClick(List<WebElement> elements,String value)
	{
		for (WebElement element : elements) {
			if(element.getText().equals(value))
			{
				element.click();
			}
		}
		
	}
	
	public void selectDropDown(WebElement element,String value)
	{
		Select m=new Select(element);
		m.deselectByValue(value);
	}
	public String getText(WebElement element)
	{
		String value=element.getText();
		return value;
	}
	
	public void doClearData(WebElement element)
	{
		element.clear();
	}
	
	public void scrollIntoView(WebElement element)

    {

    	JavascriptExecutor js=(JavascriptExecutor)driver;

		js.executeScript("arguments[0].scrollIntoView();", element);
    }
	
		public void verticalScrollDown()
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;//typecast driver to javascriptexecutor
		 js.executeScript("window.scrollBy(0,500)");//vertical down to 500 pixel
	}
		public int getTableDataRowCount(List<WebElement> tableRowData ,String expectedValue)
		{
			int counter=0;
			for(int i=0;i<tableRowData.size();i++)
			{
				String value=tableRowData.get(i).getText();
				if(expectedValue.equalsIgnoreCase(value))
				{
					counter=i+1;
					break;
				}
			}
			return counter;
		}
	

}
