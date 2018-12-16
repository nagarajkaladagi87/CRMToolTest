package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	// Page Factory - OR

	@FindBy(xpath = "//td[contains(text(),'User: Nagaraj Kaladagi')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	// Initializing Objects

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyCorrectUsername() {
		return userNameLabel.isDisplayed();

	}

	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		System.out.println("testtest");
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {
		dealsLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContact() {
		Actions actions = new Actions(driver);
		actions.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}

}
