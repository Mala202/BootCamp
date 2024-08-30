package com.tutorialninja.aq.HomePage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage<Private> {
	public WebDriver driver;
		
	
	
	@FindBy(linkText = "My Account")
	private WebElement myAccoutDropdown;
	
	@FindBy(linkText = "Register")
	private WebElement RegisterOption;
	
	@FindBy(linkText = "Login")
	private WebElement LoginOption;
	
	@FindBy(name= "search")
	private WebElement searchTextbox;
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	


	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, HomePage.class);
	}
	
	public LoginPage combiningTwoActionsToNavigateTologinPage1() {
		myAccoutDropdown.click();
		LoginOption.click();
		return new LoginPage(driver);
		
	}
	
	public RegisterPage combiningTwoActionsToNavigateTologinPage() {
		myAccoutDropdown.click();
		RegisterOption.click();
		return new RegisterPage(driver);
	}
	public void enterProductName(String validProductText) {
		searchTextbox.sendKeys(validProductText);
	}
	
	public ProductPage clickOnSearchButton() {
		searchButton.click();
		return new ProductPage(driver);
	}
	
	public ProductPage navigateToProductPage(String validProductText) {
		searchTextbox.sendKeys(validProductText);
		searchButton.click();
		return new ProductPage(driver);
	}


	
		
	}

		
	
	
	
	
	

