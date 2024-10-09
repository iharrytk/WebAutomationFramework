package com.qa.waf.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.waf.basetest.BaseTest;
import com.qa.waf.dataproviders.RegisterPageData;
import com.qa.waf.pojos.RegisterPagePOJO;
import com.qa.waf.utilities.AppConstants;

public class RegisterTest extends BaseTest {

	@BeforeClass
	public void preReq() {

		rep = lp.goToRegisterPage();

	}

	@Test(priority = 18,dataProvider = "RegisterPageDataMethod",dataProviderClass = RegisterPageData.class)
	public void doRegisterTest(RegisterPagePOJO rpj) {

		String actualRegisterMessage=rep.doRegister(rpj.getFirstName(),rpj.getLastName(),rpj.getEmail(),rpj.getTelephone(),rpj.getPassword());
		Assert.assertEquals(actualRegisterMessage, AppConstants.REGISTER_SUCESS_MESSAGE);
	}

}
