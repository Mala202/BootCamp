package com.tutorialsnija.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import com.tutorialninja.aq.HomePage.AccountPage;
import com.tutorialninja.aq.HomePage.HomePage;
import com.tutorialninja.aq.HomePage.LoginPage;
import com.tutorialsninja.qa.TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;



@Test
public class LoginTest extends TestBase{
	
	public LoginTest() throws Exception{
		super();
	}
	public WebDriver driver;
	public LoginPage loginpage;
	public HomePage homepage;
	public AccountPage accountpage;


	@BeforeMethod
	public void loginSetup() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.combiningTwoActionsToNavigateTologinPage();
		homepage.combiningTwoActionsToNavigateTologinPage1();
	} 
	
	@Test
	public void verifyLoginWithValidCredentials() {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailInEmailTextBox(prop.getProperty("validEmail"));
		loginpage.enterPasswordInPasswordTextBox(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
		System.out.println("verifyLoginWithValidCredentials is under : " + Thread.currentThread().getId());
		AssertJUnit.assertTrue(AccountPage.editAccountInfoLinkDisplayStatus());
		
		  
	}
	
	public void verifyLoginWithinValidCredentials() {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailInEmailTextBox(prop.getProperty("invalidEmail"));
		loginpage.enterPasswordInPasswordTextBox(prop.getProperty("invalidPassword"));
		loginpage.clickOnLoginButton();
		String actualWarningMessage = loginpage.retrieveWarningEmialPasswordMismatchText();
		String expectedWarningMessage = dataprop.getProperty("invalidEmailPasswordMismatchWarningMessage");
		System.out.println("verifyLoginWithinValidCredentials is under : " + Thread.currentThread().getId());
		AssertJUnit.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
