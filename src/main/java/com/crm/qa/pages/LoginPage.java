package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase {

	// Page Factory - OR:

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit' and @value='Login']")
	WebElement loginBtn;

	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;

	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;

	// Initializing the Objects

	public LoginPage() {

		PageFactory.initElements(driver, LoginPage.this);
	}

	// Actions:

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, TestUtil.EXPLICIT_WAIT1);
		WebElement usr = wait.until(ExpectedConditions.elementToBeClickable(username));
		usr.sendKeys(un);
		WebElement password1 = wait.until(ExpectedConditions.elementToBeClickable(password));
		password1.sendKeys(pwd);

		/*
		 * WebElement loginBtn1 =
		 * wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		 * loginBtn1.click();
		 */

		Thread.sleep(3000);
		loginBtn.click();
		Thread.sleep(3000);
		String homePageTitle = driver.getTitle();
		System.out.println(homePageTitle);
		return new HomePage();

	}

}
