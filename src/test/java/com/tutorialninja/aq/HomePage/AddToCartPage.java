package com.tutorialninja.aq.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//h2[test() = '$100.00']" )
	private WebElement priceofLaptop;
	
	public AddToCartPage() {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	public boolean displayStatusOfLaptopPrice() {
		boolean display = priceofLaptop.isDisplayed();
		return display;
	}

}
