package com.qa.waf.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.waf.basetest.BaseTest;
import com.qa.waf.dataproviders.ProductPageData;
import com.qa.waf.pojos.ProductPagePOJO;

public class ProductInfoPageTest extends BaseTest {
	Map<String, String> metadata = new HashMap<String, String>();

	@BeforeClass
	public void prereq() {

		ap = lp.dologin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 13,dataProvider = "productSelectDataMethod",dataProviderClass =ProductPageData.class)
	public void productHeaderNameTest(ProductPagePOJO pp) {
		rp = ap.doSearch(pp.getProductSearch());
		pi = rp.selectProduct(pp.getProductSelect());
		String actualname = pi.getProductNameHeader();
		System.out.println("The actual product headername is:" + actualname);
		Assert.assertEquals(actualname, pp.getProductSelect());

	}

	@Test(priority = 14,dataProvider = "productImagesDataMethod",dataProviderClass =ProductPageData.class)
	public void productImagesCountTest(ProductPagePOJO pp) {

		rp = ap.doSearch(pp.getProductSearch());
		pi = rp.selectProduct(pp.getProductSelect());
		int actualimages = pi.getProductImagesCount();
		System.out.println("The actual product images count is:" + actualimages);
		Assert.assertEquals(actualimages, pp.getProductImagesCount());
	}

	@Test(priority = 15,dataProvider = "productMetaDataMethod",dataProviderClass =ProductPageData.class)
	public void productMetaDataTest(ProductPagePOJO pp) {

		rp = ap.doSearch(pp.getProductSearch());
		pi = rp.selectProduct(pp.getProductSelect());
		metadata = pi.getProductMetaData();
		System.out.println("The product metadata is:" + metadata);
		sa.assertEquals(metadata.get("Brand").trim(), pp.getBrand());
		sa.assertEquals(metadata.get("Product Code").trim(), pp.getProductCode());
		sa.assertEquals(metadata.get("Reward Points").trim(), pp.getRewardPoints());
		sa.assertEquals(metadata.get("Availability").trim(), pp.getAvailability());
		sa.assertAll();

	}
	
	@Test(priority = 16,dataProvider = "productCompleteDataMethod",dataProviderClass =ProductPageData.class)
	public void productPriceTest(ProductPagePOJO pp) {

		rp = ap.doSearch(pp.getProductSearch());
		pi = rp.selectProduct(pp.getProductSelect());
		metadata = pi.getProductPrice();
		System.out.println("The product pricing is:" + metadata);
		sa.assertEquals(metadata.get("price").trim(), pp.getPrice());
		sa.assertEquals(metadata.get("Ex Tax").trim(), pp.getExTax());
		sa.assertAll();

	}
	
	@Test(priority = 17,dataProvider = "productCompleteDataMethod",dataProviderClass =ProductPageData.class)
	public void productDetailsTest(ProductPagePOJO pp) {

		rp = ap.doSearch(pp.getProductSearch());
		pi = rp.selectProduct(pp.getProductSelect());
		metadata = pi.getProductCompleteInfo();
		System.out.println("The product complete details is:" + metadata);
		sa.assertEquals(metadata.get("Product Name").trim(), pp.getProductSelect());
		sa.assertEquals(metadata.get("Brand").trim(), pp.getBrand());
		sa.assertEquals(metadata.get("Product Code").trim(), pp.getProductCode());
		sa.assertEquals(metadata.get("Reward Points").trim(), pp.getRewardPoints());
		sa.assertEquals(metadata.get("Availability").trim(), pp.getAvailability());
		sa.assertEquals(metadata.get("price").trim(), pp.getPrice());
		sa.assertEquals(metadata.get("Ex Tax").trim(), pp.getExTax());
		sa.assertAll();

	}
	
	

}
