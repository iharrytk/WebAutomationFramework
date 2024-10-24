package com.qa.waf.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.waf.utilities.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil ele;

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		ele = new ElementUtil(this.driver);
	}

	private By accountpagefeaturelocator = By.xpath("//div[@id='content']//h2");
	private By logoutlocator = By.xpath("//a[@class='list-group-item' and text()='Logout']");
	private By searchtextboxLocator = By.xpath("//input[@type='text' and @name='search']");
	private By searchBtnLocator = By.xpath("//button[@type='button' and @class='btn btn-default btn-lg']");

	public List<String> accountPageHeaders() {

		List<WebElement> headersList = ele.getElements(accountpagefeaturelocator);
		List<String> headers = new ArrayList<String>();
		for (WebElement ele : headersList) {
			String text = ele.getText();
			headers.add(text);
		}
		return headers;

	}

	public boolean logoutlinkdisplayed() {
		return ele.checkElementIsDisplayed(logoutlocator);
	}

	public ResultsPage doSearch(String searchtext) {

		ele.doSendKeys(searchtextboxLocator, searchtext);
		ele.doClick(searchBtnLocator);
		return new ResultsPage(driver);

	}

	public String getTitle() {

		return ele.waitForTitleIsAndCapture("My Account", 5);
	}

	public String getURL() {

		return ele.waitForURLContainsAndCapture("route=account/account", 5);
	}

}
