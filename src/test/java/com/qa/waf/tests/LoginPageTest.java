package com.qa.waf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.waf.basetest.BaseTest;
import com.qa.waf.utilities.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Epic("Epic 100:Login Page Design")
@Story("UserStory 101:Design Login Page for Opencart with title,url,forgot password link,user is able to login")
public class LoginPageTest extends BaseTest {
	@Severity(SeverityLevel.MINOR)
	@Description("Checking Login Page title test")
	@Feature("title test")
	@Test(priority = 0)
	public void lpTitleTest() {

		String actualtitle = lp.getTitle();
		Assert.assertEquals(actualtitle, AppConstants.LOGIN_TITLE);

	}
	@Severity(SeverityLevel.NORMAL)
	@Description("Checking login page URL test")
	@Feature("url test")
	@Test(priority = 1)
	public void lpUrlTest() {
		String actualurl = lp.getURL();
		Assert.assertTrue(actualurl.contains(AppConstants.LOGIN_URL));

	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Checking login page -forgot password link")
	@Feature("forgot password link in login page test")
	@Test(priority = 2)
	public void forgotpasswordTest() {

		boolean actual = lp.forgotPassworddisplayed();
		Assert.assertTrue(actual);

	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Checking login page - footer links ")
	@Feature("footer links  in login page test")
	@Test(priority = 3)
	public void lpfooterlinksSizeTest() {
		int footerlist = lp.footerlist().size();
		Assert.assertEquals(footerlist, 15);

	}

	@Severity(SeverityLevel.BLOCKER)
	@Description("Checking login page -login functionality")
	@Feature("login functionality in login page test")
	@Test(priority = 4)
	public void doLoginTest() {

		ap=lp.dologin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(ap.getTitle(), "My Account");
		System.out.println("Able to login successfully using valid credentials");
	}
	
	
	

}
