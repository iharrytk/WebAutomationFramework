package com.qa.waf.pojos;

public class ProductPagePOJO {

	private String productSearch;
	private String productSelect;
	private int productImagesCount;
	private String brand;
	private String productCode;
	private String rewardPoints;
	private String availability;
	private String price;
	private String exTax;

	public ProductPagePOJO(String productSearch) {

		this.productSearch = productSearch;

	}

	public ProductPagePOJO(String productSearch, String productSelect) {
		super();
		this.productSearch = productSearch;
		this.productSelect = productSelect;
	}
	
	public ProductPagePOJO(String productSearch, String productSelect,int productImagesCount) {
		super();
		this.productSearch = productSearch;
		this.productSelect = productSelect;
		this.productImagesCount=productImagesCount;
	}
	
	

	public ProductPagePOJO(String productSearch, String productSelect, String brand, String productCode,
			String rewardPoints, String availability) {
		super();
		this.productSearch = productSearch;
		this.productSelect = productSelect;
		this.brand = brand;
		this.productCode = productCode;
		this.rewardPoints = rewardPoints;
		this.availability = availability;
	}
	
	

	public ProductPagePOJO(String productSearch, String productSelect, String brand,
			String productCode, String rewardPoints, String availability, String price, String exTax) {
		super();
		this.productSearch = productSearch;
		this.productSelect = productSelect;
		this.brand = brand;
		this.productCode = productCode;
		this.rewardPoints = rewardPoints;
		this.availability = availability;
		this.price = price;
		this.exTax = exTax;
	}
	

	

	public String getProductSearch() {
		return productSearch;
	}

	public void setProductSearch(String productSearch) {
		this.productSearch = productSearch;
	}


	public String getProductSelect() {
		return productSelect;
	}

	public void setProductSelect(String productSelect) {
		this.productSelect = productSelect;
	}
	
	

	public int getProductImagesCount() {
		return productImagesCount;
	}

	public void setProductImagesCount(int productImagesCount) {
		this.productImagesCount = productImagesCount;
	}
	
	

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(String rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}
	

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getExTax() {
		return exTax;
	}

	public void setExTax(String exTax) {
		this.exTax = exTax;
	}

	@Override
	public String toString() {
		return "ProductPagePOJO [productSearch=" + productSearch + ", productSelect=" + productSelect
				+ ", productImagesCount=" + productImagesCount + ", brand=" + brand + ", productCode=" + productCode
				+ ", rewardPoints=" + rewardPoints + ", availability=" + availability + ", price=" + price + ", exTax="
				+ exTax + "]";
	}

	
	
	

	

	
	
}
