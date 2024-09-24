package com.qa.waf.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	private WebDriver driver;
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	private By accountpagefeaturelocator=By.xpath("//div[@id='content']//h2");
	private By logoutlocator=By.xpath("//a[@class='list-group-item' and text()='Logout']");
	private By searchtextboxLocator=By.xpath("//input[@type='text' and @name='search']");
	private By searchBtnLocator=By.xpath("//button[@type='button' and @class='btn btn-default btn-lg']");
	
	
	public List<String> accountPageHeaders() {
		
		List<WebElement> headersList= driver.findElements(accountpagefeaturelocator);
		List<String> headers=new ArrayList<String>();
		for(WebElement ele:headersList) {
			String text=ele.getText();
			headers.add(text);
		}
		return headers;
		
	}
	
	
	public boolean logoutlinkdisplayed() {
		return driver.findElement(logoutlocator).isDisplayed();
	} 
	
	public ResultsPage doSearch(String searchtext) {
		
		driver.findElement(searchtextboxLocator).sendKeys(searchtext);
		driver.findElement(searchBtnLocator).click();
		return new ResultsPage(driver);
		
		
	}
	
	public String getTitle() {

		return driver.getTitle();
	}

	public String getURL() {

		return driver.getCurrentUrl();
	}

}
