package com.qa.waf.dataproviders;

import org.testng.annotations.DataProvider;

import com.qa.waf.pojos.RegisterPagePOJO;

public class RegisterPageData {

	// method with return type Object[][]
	@DataProvider(name = "RegisterPageDataMethod")
	public Object[][] registerPageTestData() {

		return new Object[][] {
				{ new RegisterPagePOJO("john", "spurlin", "johnspirulinaaa" + System.currentTimeMillis() + "@gmail.com",
						"4125877896", "john@2024") },
				{ new RegisterPagePOJO("diego", "sebastian",
						"diegosebastian" + System.currentTimeMillis() + "@gmail.com", "1478523698", "diego@2024") }

		};

	}

}
