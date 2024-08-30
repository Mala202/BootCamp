package com.tutorialsnija.TestCases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tutorialninja.aq.HomePage.AddToCartPage;
import com.tutorialninja.aq.HomePage.HomePage;
import com.tutorialninja.aq.HomePage.ProductPage;
import com.tutorialsninja.qa.TestBase.TestBase;

@Test
public class CompleteCheckoutTest  extends TestBase{
	
	public CompleteCheckoutTest() throws Exception {
		super();
	}
	public WebDriver driver;
	public HomePage homepage;
	private ProductPage productpage;
	private AddToCartPage addtocartpage;
	
	
	@BeforeMethod
	public void completeCheckOutSetup() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
	    homepage = new HomePage(driver);
	    productpage = homepage.navigateToProductPage(dataprop.getProperty("valid[rodcut"));
	}
	@Test(priority = 1)
	public void validatingValidProduct() {
		Assert.assertTrue(productpage.verifyInvalidProduct());
		
	}
	@Test(priority = 2)
	public void clickOnAddtoCartForValidProduct() {
		
		addtocartpage = productpage.cliclOnAddToCartButton();
		Assert.assertTrue(addtocartpage.displayStatusOfLaptopPrice());
		driver.findElement(By.id("button-cart")).click();
		
		String actualSuccessMessage = driver.findElement(By.xpath("//div[conatins(@class, 'alert-dismissible')]")).getText();
	    String expectedSuccessMessage = "Success: You have added";
	    Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage));
		
		 
	}
	@Test(priority = 3)
	public void clickOnAddToCartButtonOnAddToCartPage() {
		
		addtocartpage = productpage.cliclOnAddToCartButton();
	    Assert.assertTrue(addtocartpage.displayStatusOfLaptopPrice());
		driver.findElement(By.id("button-cart")).click();
		
		String actualSuccessMessage = driver.findElement(By.xpath("//div[conatins(@class, 'alert-dismissible')]")).getText();
	    String expectedSuccessMessage = "Success: You have added";
	    Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage));
	    
		Assert.assertTrue(driver.findElement(By.xpath(" //span[@id = ' cart-total'][text() = '1 item(s) - $100.00']")).isDisplayed());
		driver.findElement(By.id("cart")).click();
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
