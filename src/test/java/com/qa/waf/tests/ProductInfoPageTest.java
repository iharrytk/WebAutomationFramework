package com.qa.waf.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.waf.basetest.BaseTest;

public class ProductInfoPageTest extends BaseTest {
	Map<String, String> metadata = new HashMap<String, String>();

	@BeforeClass
	public void prereq() {

		ap = lp.dologin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 13)
	public void productHeaderNameTest() {
		rp = ap.doSearch("MacBook");
		pi = rp.selectProduct("MacBook Air");
		String actualname = pi.getProductNameHeader();
		System.out.println("The actual product headername is:" + actualname);
		Assert.assertEquals(actualname, "MacBook Air");

	}

	@Test(priority = 14)
	public void productImagesCountTest() {

		rp = ap.doSearch("MacBook");
		pi = rp.selectProduct("MacBook Air");
		int actualimages = pi.getProductImagesCount();
		System.out.println("The actual product images count is:" + actualimages);
		Assert.assertEquals(actualimages, 4);
	}

	@Test(priority = 15)
	public void productMetaDataTest() {

		rp = ap.doSearch("MacBook");
		pi = rp.selectProduct("MacBook Air");
		metadata = pi.getProductMetaData();
		System.out.println("The product metadata is:" + metadata);
		sa.assertEquals(metadata.get("Brand").trim(), "Apple");
		sa.assertEquals(metadata.get("Product Code").trim(), "Product 17");
		sa.assertEquals(metadata.get("Reward Points").trim(), "700");
		sa.assertEquals(metadata.get("Availability").trim(), "Out Of Stock");
		sa.assertAll();

	}
	
	@Test(priority = 16)
	public void productPriceTest() {

		rp = ap.doSearch("MacBook");
		pi = rp.selectProduct("MacBook Air");
		metadata = pi.getProductPrice();
		System.out.println("The product pricing is:" + metadata);
		sa.assertEquals(metadata.get("price").trim(), "$1,202.00");
		sa.assertEquals(metadata.get("Ex Tax").trim(), "$1,000.00");
		sa.assertAll();

	}
	
	@Test(priority = 17)
	public void productDetailsTest() {

		rp = ap.doSearch("MacBook");
		pi = rp.selectProduct("MacBook Air");
		metadata = pi.getProductCompleteInfo();
		System.out.println("The product complete details is:" + metadata);
		sa.assertEquals(metadata.get("Product Name").trim(), "MacBook Air");
		sa.assertEquals(metadata.get("Brand").trim(), "Apple");
		sa.assertEquals(metadata.get("Product Code").trim(), "Product 17");
		sa.assertEquals(metadata.get("Reward Points").trim(), "700");
		sa.assertEquals(metadata.get("Availability").trim(), "Out Of Stock");
		sa.assertEquals(metadata.get("price").trim(), "$1,202.00");
		sa.assertEquals(metadata.get("Ex Tax").trim(), "$1,000.00");
		sa.assertAll();

	}
	
	

}
