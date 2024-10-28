package com.qa.waf.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.waf.utilities.ElementUtil;

import io.qameta.allure.Step;

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
	private By registerLink = By.xpath("//a[text()='Register' and @class='list-group-item']");

	@Step("login with username {0} and password {1}")
	public AccountsPage dologin(String username, String password) {

		ele.waitForElementVisible(usernamelocator, 10).sendKeys(username);
		ele.doSendKeys(passwordlocator, password);
		ele.doClick(loginbtnlocator);
		return new AccountsPage(driver);
	}

	@Step("checking if forgotpasswork link is displayed in login page")
	public boolean forgotPassworddisplayed() {
		return ele.checkElementIsDisplayed(forgotpassword);
	}

	@Step("getting all the footer links..")
	public List<WebElement> footerlist() {

		return ele.getElements(footerlist);

	}

	@Step("getting the login page title")
	public String getTitle() {

		return ele.waitForTitleIsAndCapture("Account Login", 5);

	}

	@Step("getting the login page URL")
	public String getURL() {

		return ele.waitForURLContainsAndCapture("route=account/login", 5);

	}

	@Step("Clicking on Register link and navigating to Registerpage")
	public RegisterPage goToRegisterPage() {

		ele.waitForElementVisible(registerLink, 5).click();
		return new RegisterPage(driver);

	}

}
