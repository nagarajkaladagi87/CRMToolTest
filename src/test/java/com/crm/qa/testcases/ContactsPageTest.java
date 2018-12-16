package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;

	String sheetName = "contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		contactsPage = new ContactsPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		homePage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts label is missing in page");
	}

	@Test(priority = 2)
	public void selectSingleContactByNameTest() {
		contactsPage.selectContactsByName("Shravan K");
	}

	@Test(priority = 3)
	public void selectmultipleContactByNameTest() {
		contactsPage.selectContactsByName("Shravan K");
		contactsPage.selectContactsByName("Test Test1 LastTest");
	}

	@SuppressWarnings("static-access")
	@DataProvider
	public Object[][] getCRMTestData() throws IOException {

		Object data[][] = testUtil.getTestData(sheetName);
		return data;

	}

	@Test(priority = 1, dataProvider = "getCRMTestData")
	public void createNewContactTest(String title, String firstName, String lastName, String company) {
		homePage.clickOnNewContact();
		// contactsPage.createNewContact("Dr.", "Nate", "Bryer", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
