package com.qa.waf.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductInfoPage {

	private WebDriver driver;

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;

	}

	By productNameHeader = By.xpath("//div[@class='col-sm-4']//h1");
	By productImages = By.xpath("//div[@class='col-sm-8']//img");
	By productMetaData=By.xpath("(//div[@class='col-sm-4']//ul)[1]/li");
	By productprice=By.xpath("(//div[@class='col-sm-4']//ul)[2]/li");
	
	public String getProductNameHeader() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(productNameHeader));
		return ele.getText();

	}

	public int getProductImagesCount() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		List<WebElement> ele = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productImages));
		return ele.size();

	}

	public Map<String, String> getProductMetaData() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		List<WebElement> ele = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productMetaData));
		Map<String, String> hm=new HashMap<String, String>();
		for (WebElement webElement : ele) {
			
			String listitem=webElement.getText();
			String[] str=listitem.split(":");
			String metadataheader=str[0];
			String metadatavalue=str[1];
			hm.put(metadataheader, metadatavalue);
		}
		
		return hm;
		
	}

	public Map<String, String> getProductPrice() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		List<WebElement> ele = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productprice));
		Map<String, String> hm=new HashMap<String, String>();
		List<String> ls=new ArrayList<String>();
		for (WebElement webElement : ele) {
			String listitem=webElement.getText();
			ls.add(listitem);
			
		}
		String price=ls.get(0);
		hm.put("price", price);
		String[] extaxprice=ls.get(1).split(":");
		hm.put(extaxprice[0], extaxprice[1]);
		
		return hm;
		
	}

	public Map<String, String> getProductCompleteInfo() {
		Map<String, String> productdetails=new HashMap<String, String>();
		
		productdetails.putAll(getProductMetaData());
		productdetails.putAll(getProductPrice());
		productdetails.put("Product Name", getProductNameHeader());
		return productdetails;
		
		
	}

	public void productAddToCart() {
	}

}