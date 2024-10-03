package com.qa.waf.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.waf.basetest.BaseTest;

public class RegisterTest extends BaseTest {

	@BeforeClass
	public void preReq() {

		rep = lp.goToRegisterPage();

	}

	@Test(priority = 18)
	public void doRegisterTest() {

		rep.doRegister();

	}

}
