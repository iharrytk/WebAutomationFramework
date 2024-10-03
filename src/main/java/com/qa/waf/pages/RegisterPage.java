package com.qa.waf.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.waf.utilities.AppConstants;
import com.qa.waf.utilities.ElementUtil;

public class RegisterPage {

	private WebDriver driver;
	private ElementUtil ele;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		ele = new ElementUtil(this.driver);

	}

	private By registerLink = By.xpath("//a[text()='Register' and @class='list-group-item']");
	private By firstNameLocator = By.id("input-firstname");
	private By lastNameLocator = By.id("input-lastname");
	private By emailLocator = By.id("input-email");
	private By telephoneLocator = By.id("input-telephone");
	private By passwordLocator = By.id("input-password");
	private By passwordconfirmLocator = By.id("input-confirm");
	private By yesSubscribeLocator = By.xpath("(//label[@class='radio-inline'])[1]");
	private By noSubscribeLocator = By.xpath("(//label[@class='radio-inline'])[2]");
	private By agreeLocator = By.xpath("//input[@type='checkbox' and @name='agree']");
	private By continueLocator = By.xpath("//input[@type='submit' and @value='Continue']");
	private By furtherContinueLocator=By.xpath("//a[text()='Continue']");
	private By furtherLogout=By.xpath("(//a[text()='Logout'])[2]");
	

	public void doRegister() {

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(AppConstants.MEDIUM_DEFAULT_TIMEOUT));
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameLocator)).sendKeys("john");
		driver.findElement(lastNameLocator).sendKeys("spurlin");
		driver.findElement(emailLocator).sendKeys("johnspirulinaa@gmail.com");
		driver.findElement(telephoneLocator).sendKeys("4125877896");
		driver.findElement(passwordLocator).sendKeys("john@2024");
		driver.findElement(passwordconfirmLocator).sendKeys("john@2024");
		driver.findElement(yesSubscribeLocator).click();
		driver.findElement(agreeLocator).click();
		driver.findElement(continueLocator).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(furtherContinueLocator)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(furtherLogout)).click();
		driver.findElement(registerLink).click();

	}

}
