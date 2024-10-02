package com.qa.waf.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.waf.basetest.BaseTest;

public class ResultsTest extends BaseTest {

	@BeforeClass
	public void prereq() {

		ap = lp.dologin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 10)
	public void searchResultTitleTest() {
		rp = ap.doSearch("MacBook");
		String title = rp.searchResultsTitle();
		Assert.assertEquals(title, "Search - MacBook");

	}

	@Test(priority = 11)
	public void searchResultsProductCount() {
		rp = ap.doSearch("MacBook");
		int searchcount = rp.searchResultsProductCount();
		Assert.assertTrue(searchcount > 0);

	}

	@Test(priority = 12)
	public void selectProductTest() {
		rp = ap.doSearch("MacBook");
		pi = rp.selectProduct("MacBook Air");

	}

}
