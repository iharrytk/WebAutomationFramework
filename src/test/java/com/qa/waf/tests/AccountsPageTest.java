package com.qa.waf.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.waf.basetest.BaseTest;
import com.qa.waf.utilities.AppConstants;

public class AccountsPageTest extends BaseTest {
	@BeforeClass
	public void preCondition() {
		ap = lp.dologin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 5)
	public void aplogoutLinkTest() {
		boolean actual = ap.logoutlinkdisplayed();
		Assert.assertTrue(actual);

	}

	@Test(priority = 6)
	public void accountHeadersTest() {
		List<String> actualHeaders = ap.accountPageHeaders();
		List<String> expectedHeaders = Arrays.asList("My Account", "My Orders", "My Affiliate Account", "Newsletter");
		Assert.assertEquals(actualHeaders, expectedHeaders);

	}

	@Test(priority = 7)
	public void aptitleTest() {
		Assert.assertEquals(ap.getTitle(), AppConstants.ACCOUNT_TITLE);
	}

	@Test(priority = 8)
	public void apgeturlTest() {

		Assert.assertTrue(ap.getURL().contains(AppConstants.ACCOUNT_URL));
	}

	@Test(priority = 9)
	public void apdoSearchTest() {

		rp = ap.doSearch("mac");
	}

}
