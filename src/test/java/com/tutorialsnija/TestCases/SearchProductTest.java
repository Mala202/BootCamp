package com.tutorialsnija.TestCases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.aq.HomePage.HomePage;
import com.tutorialninja.aq.HomePage.ProductPage;
import com.tutorialsninja.qa.TestBase.TestBase;

public class SearchProductTest extends TestBase{
	
    public SearchProductTest() throws Exception {
		super();
		
	}

public WebDriver driver;
public HomePage homepage;
public ProductPage productpage;

	
	@BeforeMethod
	public void loginSetup() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
	}	
		@Test(priority = 1) 
		public void validateSearchWithValidProduct() {
			
			HomePage homepage = new HomePage(driver);
			productpage = homepage.navigateToProductPage(dataprop.getProperty("validProduct"));
			Assert.assertTrue(productpage.verifyInvalidProduct());
	
	}
		@Test(priority = 2) 
		public void validateSearchWithInValidProduct() {
			
			HomePage homepage = new HomePage(driver);
			productpage = homepage.navigateToProductPage(dataprop.getProperty("invalidProduct"));
			Assert.assertFalse(productpage.verifyValidProduct());
	
					
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
