package com.qa.waf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.waf.basetest.BaseTest;
import com.qa.waf.utilities.AppConstants;

public class LoginPageTest extends BaseTest {

	@Test(priority = 0)
	public void lpTitleTest() {

		String actualtitle = lp.getTitle();
		Assert.assertEquals(actualtitle, AppConstants.LOGIN_TITLE);

	}

	@Test(priority = 1)
	public void lpUrlTest() {
		String actualurl = lp.getURL();
		Assert.assertTrue(actualurl.contains(AppConstants.LOGIN_URL));

	}

	@Test(priority = 2)
	public void forgotpasswordTest() {

		boolean actual = lp.forgotPassworddisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 3)
	public void lpfooterlinksSizeTest() {
		int footerlist = lp.footerlist().size();
		Assert.assertEquals(footerlist, 15);

	}

	@Test(priority = 4)
	public void doLoginTest() {

		ap=lp.dologin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(ap.getTitle(), "My Account");
		System.out.println("Able to login successfully using valid credentials");
	}
	
	
	

}
