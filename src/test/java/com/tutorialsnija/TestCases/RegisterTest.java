package com.tutorialsnija.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.aq.HomePage.AccountSuccessPage;
import com.tutorialninja.aq.HomePage.RegisterPage;
import com.tutorialsninja.qa.TestBase.TestBase;
import com.tutorialsninja.qa.Utilities.Utils;

public class RegisterTest extends TestBase{
	
	public RegisterTest() throws Exception{
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void registerSetup() {
		driver = initializeBrowserAndOpenApplication("Chrome");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		
	}
	@Test(priority = 1)
	public void registerwithmandatorydetails() {
		
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.enterFirstnameText(dataprop.getProperty("firstnames"));
		registerpage.enterlastnameText(dataprop.getProperty("lastname"));
		registerpage.enteremailText(Utils.emailWithDateTimeStamp());
		registerpage.entertelephoneText(dataprop.getProperty("telephone"));
		registerpage.enterpasswordText(dataprop.getProperty("password"));
		registerpage.enterconfirmpasswordText(dataprop.getProperty("confirm"));
		registerpage.clickOnPrivacyPolicy();
		registerpage.clickOncontinuebutton();
		AccountSuccessPage accountsuccesspage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountsuccesspage.displayStatusOfAccountSuccessMessage());

	}
	
	@Test(priority = 2)
	public void registerwithalldetails() {
		
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.enterFirstnameText(dataprop.getProperty("firstnames"));
		registerpage.enterlastnameText(dataprop.getProperty("lastname"));
		registerpage.enteremailText(Utils.emailWithDateTimeStamp());
		registerpage.entertelephoneText(dataprop.getProperty("telephone"));
		registerpage.enterpasswordText(dataprop.getProperty("password"));
		registerpage.enterconfirmpasswordText(dataprop.getProperty("confirm"));
		registerpage.clickYesSubscribeRadioButton();
		registerpage.clickOnPrivacyPolicy();
		registerpage.clickOncontinuebutton();
		AccountSuccessPage accountsuccesspage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountsuccesspage.displayStatusOfAccountSuccessMessage());
	}		

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
