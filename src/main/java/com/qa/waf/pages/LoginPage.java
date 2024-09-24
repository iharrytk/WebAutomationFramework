package com.qa.waf.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.waf.utilities.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil ele;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		ele = new ElementUtil(this.driver);
	}

	private By usernamelocator = By.id("input-email");
	private By passwordlocator = By.id("input-password");
	private By loginbtnlocator = By.xpath("//input[@type='submit']");
	private By forgotpassword = By.xpath("//a[text()='Forgotten Password' and @class='list-group-item']");
	private By footerlist = By.xpath("//div[@class='row']//ul//a");

	public AccountsPage dologin(String username, String password) {

		ele.waitForElementVisible(usernamelocator, 10).sendKeys(username);
		ele.doSendKeys(passwordlocator, password);
		ele.doClick(loginbtnlocator);
		return new AccountsPage(driver);
	}

	public boolean forgotPassworddisplayed() {
		return ele.checkElementIsDisplayed(forgotpassword);
	}

	public List<WebElement> footerlist() {

		return ele.getElements(footerlist);

	}

	public String getTitle() {

		return ele.waitForTitleIsAndCapture("Account Login", 5);

	}

	public String getURL() {

	return  ele.waitForURLContainsAndCapture("route=account/login", 5);
		
	}

}
