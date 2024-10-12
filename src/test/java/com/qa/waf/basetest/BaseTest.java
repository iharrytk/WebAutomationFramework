package com.qa.waf.basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.waf.factory.DriverFactory;
import com.qa.waf.pages.AccountsPage;
import com.qa.waf.pages.LoginPage;
import com.qa.waf.pages.ProductInfoPage;
import com.qa.waf.pages.RegisterPage;
import com.qa.waf.pages.ResultsPage;

public class BaseTest {

	WebDriver driver;

	protected LoginPage lp;
	protected AccountsPage ap;
	protected ResultsPage rp;
	protected ProductInfoPage pi;
	protected RegisterPage rep;
	protected DriverFactory df;
	protected Properties prop;
	protected SoftAssert sa;

	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browservalue) {

		df = new DriverFactory(driver);
		prop = df.init_prop();
		
		if(browservalue!=null) {
			prop.setProperty("browser", browservalue);
		}
		driver = df.init_driver(prop);
		sa=new SoftAssert();
		lp = new LoginPage(driver);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
