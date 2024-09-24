package com.qa.waf.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	private By usernamelocator = By.id("input-email");
	private By passwordlocator = By.id("input-password");
	private By loginbtnlocator = By.xpath("//input[@type='submit']");
	private By forgotpassword = By.xpath("//a[text()='Forgotten Password' and @class='list-group-item']");
	private By footerlist = By.xpath("//div[@class='row']//ul//a");

	public AccountsPage dologin(String username,String password) {

		driver.findElement(usernamelocator).sendKeys(username);
		driver.findElement(passwordlocator).sendKeys(password);
		driver.findElement(loginbtnlocator).click();
		return new AccountsPage(driver);
	}

	public boolean forgotPassworddisplayed() {
		return driver.findElement(forgotpassword).isDisplayed();
	}

	public List<WebElement> footerlist() {
		return driver.findElements(footerlist);
	}

	public String getTitle() {

		return driver.getTitle();
	}

	public String getURL() {

		return driver.getCurrentUrl();
	}

}
