package com.qa.waf.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.waf.basetest.BaseTest;
import com.qa.waf.dataproviders.ProductPageData;
import com.qa.waf.pojos.ProductPagePOJO;

public class ResultsTest extends BaseTest {

	@BeforeClass
	public void prereq() {

		ap = lp.dologin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 10,dataProvider = "productSearchDataMethod",dataProviderClass =ProductPageData.class )
	public void searchResultTitleTest(ProductPagePOJO pp) {
		rp = ap.doSearch(pp.getProductSearch());
		String title = rp.searchResultsTitle();
		System.out.println("The actual page title is:"+title);
		Assert.assertEquals(title, "Search -"+" "+pp.getProductSearch());

	}

	@Test(priority = 11,dataProvider = "productSearchDataMethod",dataProviderClass =ProductPageData.class)
	public void searchResultsProductCount(ProductPagePOJO pp) {
		rp = ap.doSearch(pp.getProductSearch());
		int searchcount = rp.searchResultsProductCount();
		Assert.assertTrue(searchcount > 0);

	}

	@Test(priority = 12,dataProvider = "productSelectDataMethod",dataProviderClass =ProductPageData.class)
	public void selectProductTest(ProductPagePOJO pp) {
		rp = ap.doSearch(pp.getProductSearch());
		pi = rp.selectProduct(pp.getProductSelect());

	}

}
