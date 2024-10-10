package com.qa.waf.dataproviders;

import org.testng.annotations.DataProvider;

import com.qa.waf.pojos.ProductPagePOJO;

public class ProductPageData {
	
	@DataProvider(name="productSearchDataMethod")
	public Object[][] productSearch(){
		
		return new Object[][] {
			
			{new ProductPagePOJO("MacBook")},
			{new ProductPagePOJO("Samsung")}
			
		};
		
		
		
	}
	
	@DataProvider(name="productSelectDataMethod")
	public Object[][] productSelect(){
		
		return new Object[][] {
			
			{new ProductPagePOJO("MacBook","MacBook Air")},
			{new ProductPagePOJO("Samsung","Samsung Galaxy Tab 10.1")}
			
		};
		
		
		
	}
	
	@DataProvider(name="productImagesDataMethod")
	public Object[][] productImages(){
		
		return new Object[][] {
			
			{new ProductPagePOJO("MacBook","MacBook Air",4)},
			{new ProductPagePOJO("Samsung","Samsung Galaxy Tab 10.1",7)}
			
		};
		
		
		
	}
	
	
	@DataProvider(name="productMetaDataMethod")
	public Object[][] productMetaData(){
		
		return new Object[][] {
			
			{new ProductPagePOJO("MacBook","MacBook Air","Apple","Product 17","700","Out Of Stock")}
			//{new ProductPagePOJO("Samsung","Samsung Galaxy Tab 10.1","","SAM1","1000","Pre-Order")}
			
		};
		
		
		
	}
	
	@DataProvider(name="productCompleteDataMethod")
	public Object[][] productCompleteData(){
		
		return new Object[][] {
			
			{new ProductPagePOJO("MacBook","MacBook Air","Apple","Product 17","700","Out Of Stock","$1,202.00","$1,000.00")}
			//{new ProductPagePOJO("Samsung","Samsung Galaxy Tab 10.1","","SAM1","1000","Pre-Order")}
			
		};
		
		
		
	}

}
