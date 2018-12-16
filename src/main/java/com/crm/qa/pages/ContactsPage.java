package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	// Page Factory - OR

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactsLabel;

	@FindBy(id = "first_name")
	@CacheLookup
	WebElement firstName;

	@FindBy(id = "surname")
	WebElement lastName;

	@FindBy(name = "client_lookup")
	WebElement company;

	@FindBy(xpath = "//tr[1]/td//input[@type='submit' and @value='Save']")
	WebElement saveBtn;

	// Initialization of the objects
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public void selectContactsByName(String contactName) {
		driver.findElement(By.xpath("//a[text()='" + contactName
				+ "']/parent::td[@class='datalistrow']//preceding-sibling::td/input[@name='contact_id']")).click();
	}

	public void createNewContact(String title, String fName, String lName, String comp) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(comp);
		saveBtn.click();

	}

}
