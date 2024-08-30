package com.tutorialninja.aq.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	
	@FindBy(id = "input-email")
	private WebElement emailTextBox;
	
	@FindBy(id = "input-password")
	private WebElement passwordTextBox;
	
	@FindBy (css = "input.btn.btn-primary")
	private WebElement loginbutton;
	
	@FindBy (xpath = "//div[contains(@class, 'alert-dimissible')]")
	private WebElement inValidEmailPasswordWarning;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailInEmailTextBox(String emailText) {
		emailTextBox.sendKeys(emailText);
	}
	
	public void enterPasswordInPasswordTextBox(String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	
	public void clickOnLoginButton() {
		loginbutton.click();
	}
	
	public String retrieveWarningEmialPasswordMismatchText() {
		String warningMessage = inValidEmailPasswordWarning.getText();
		return warningMessage ;
		
	}

		
	}

	

