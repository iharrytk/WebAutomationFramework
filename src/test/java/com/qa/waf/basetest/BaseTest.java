package com.qa.waf.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.waf.pages.AccountsPage;
import com.qa.waf.pages.LoginPage;
import com.qa.waf.pages.ResultsPage;

public class BaseTest {
	
	WebDriver driver;
	protected LoginPage lp;
	protected AccountsPage ap;
	protected ResultsPage rp;

	@BeforeTest
	public void setUp() {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		lp = new LoginPage(driver);
		
		

	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
