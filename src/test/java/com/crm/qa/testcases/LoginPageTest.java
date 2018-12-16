package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homepage;
	Logger log = Logger.getLogger(LoginPageTest.class);

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		log.info("Launching browser and URL");
/*		log.warn("May be this is warning message");
		log.fatal("May be this is fatal error message");
		log.debug("May be this is debug message");*/
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		log.info("****************************** Starting Test *************************************");
		log.info("******************************* loginPageTitleTest *******************************");
		String loginPageTitle = loginPage.validateLoginPageTitle();
		System.out.println(loginPageTitle);
		Assert.assertEquals(loginPageTitle, "Free CRM software in the cloud powers sales and customer service");
		log.info("****************************** Ending Test *************************************");
	}

	@Test(priority = 2)
	public void loginPageCRMLogoTest() {
		boolean flag = loginPage.validateCRMLogo();
		System.out.println(flag);
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() throws InterruptedException {
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {		
		log.info("****************************** Closing driver*************************************");
		driver.quit();

	}

}
