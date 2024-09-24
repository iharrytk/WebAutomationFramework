package com.qa.waf.basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.waf.factory.DriverFactory;
import com.qa.waf.pages.AccountsPage;
import com.qa.waf.pages.LoginPage;
import com.qa.waf.pages.ResultsPage;

public class BaseTest {

	WebDriver driver;

	protected LoginPage lp;
	protected AccountsPage ap;
	protected ResultsPage rp;
	protected DriverFactory df;
	protected Properties prop;

	@BeforeTest
	public void setUp() {

		df = new DriverFactory(driver);
		prop = df.init_prop();
		driver = df.init_driver(prop);
		lp = new LoginPage(driver);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
