package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	// private By locators:
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']");
	private By header = By.cssSelector("div#logo h1 a");
	private By registerLink = By.linkText("Register");

	// constructor:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// page actions/ page methods/ functionality/behavior of the page/ no assertion

	@Step("getting login page title....")
	public String getLoginPageTitle() {
		return elementUtil.waitForTitleIs(Constants.LOGIN_PAGE_TITLE, 5);
	}

	@Step("getting login page header text....")
	public String getPageHeaderText() {
		return elementUtil.doGetText(header);
	}

	@Step("checking forgot pwd link is displayed on login page....")
	public boolean isForgotPwdLinkExist() {
		return elementUtil.doIsDisplayed(forgotPwdLink);
	}

	@Step("login to application with username {0} and password {1}")
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("============"+un + ":"+ pwd + "=================");
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		return new AccountsPage(driver);
	}
	
	@Step("navigating to reg page....")
	public RegistrationsPage nagigateToRegisterPage() {
		elementUtil.doClick(registerLink);
		return new RegistrationsPage(driver);
	}

}
