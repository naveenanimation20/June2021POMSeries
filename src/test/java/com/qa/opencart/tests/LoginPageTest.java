package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.listeners.TestAllureListener;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.Errors;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("EPIC 100: Design Login page for open cart application....")
@Story("US 101: Login page with differnet features.....")
@Listeners(TestAllureListener.class)
public class LoginPageTest extends BaseTest {

	@Description("login page title test.....")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("lp title is: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, Errors.TITLE_ERROR_MESSG);
	}

	@Description("login page header test.....")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void loginPageHeaderTest() {
		String header = loginPage.getPageHeaderText();
		System.out.println("lp header is: " + header);
		Assert.assertEquals(header, Constants.PAGE_HEADER, Errors.HEADER_ERROR_MESSG);
	}

	@Description("forgot pwd link test.....")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 3)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@Description("login page test with username and password.....")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 4)
	public void loginTest() {
		AccountsPage accPage = loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		//AccountsPage accPage = loginPage.doLogin(System.getProperty("username"), System.getProperty("password"));
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	
	

}
