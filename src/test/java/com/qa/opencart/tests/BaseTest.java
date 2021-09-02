package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistrationsPage;
import com.qa.opencart.pages.ResultsPage;

public class BaseTest {

	WebDriver driver;
	Properties prop;
	DriverFactory df;
	
	SoftAssert softAssert;
	

	LoginPage loginPage;
	AccountsPage accPage;
	ResultsPage resultsPage;
	ProductInfoPage productInfoPage;
	RegistrationsPage regPage;

	@BeforeTest
	public void setUp() {
		
		softAssert = new SoftAssert();
		df = new DriverFactory();
		prop = df.initProperties();
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
