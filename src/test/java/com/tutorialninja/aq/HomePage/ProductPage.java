package com.tutorialninja.aq.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	
	public WebDriver driver;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validProduct;
	
	@FindBy (xpath = "//p[test() = 'There is no product that matches the search criteria.']")
	private WebElement invalidProductWarningMessage;
	
	@FindBy(css = "div.button-group>button:nth-child(1)")
	private WebElement addToCartButton;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyValidProduct() {
		boolean status = validProduct.isDisplayed();
		return status;
	}
	public boolean verifyInvalidProduct() {
		boolean status = invalidProductWarningMessage.isDisplayed();
		return status;
		
	}
	
	public AddToCartPage cliclOnAddToCartButton() {
		addToCartButton.click();
		return new AddToCartPage();
	}

}
