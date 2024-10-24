package com.qa.waf.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {

	private WebDriver driver;
	
	public ResultsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By searchedProductsLocator=By.cssSelector("div.product-layout.product-grid.col-lg-3.col-md-3.col-sm-6.col-xs-12");

	
	public String searchResultsTitle() {
		String title=driver.getTitle();
		return title;
		
	}
	
	
	public int searchResultsProductCount() {
		
		int productCount;
		WebDriverWait  wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		List<WebElement> ele=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchedProductsLocator));
		productCount=ele.size();
		return productCount;
		
	}
	
	public ProductInfoPage selectProduct(String productName) {
		
		By selectProductLocator=By.linkText(productName);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(selectProductLocator));
		ele.click();
		return new ProductInfoPage(driver);
		
	}

}
