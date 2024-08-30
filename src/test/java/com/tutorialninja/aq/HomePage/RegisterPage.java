package com.tutorialninja.aq.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	public WebDriver driver;
	
	
	@FindBy (id = "input-firstname")
	private WebElement firstnamefield;
	
	@FindBy (id = "input-lastname")
	private WebElement lastnamefield;
	
	@FindBy (id = "input-email")
	private WebElement emailfield;
	
	@FindBy (id = "input-telephone")
	private WebElement telephonefield;
	
	@FindBy (id = "input-password")
	private WebElement passwordfield;
	
	@FindBy (id = "input-confirm")
	private WebElement confirmpasswordfield;
	
	@FindBy (xpath = "//input[@name = 'agree']")
	private WebElement PrivacyPolicyCheckbox;
	
	@FindBy (css = "input.btn.btn-primary")
	private WebElement continuebutton;
	
	@FindBy (xpath = "//input[@name = 'newsletter' and @value = '1']")
	private WebElement yesSubscribeRadioButton;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void  enterFirstnameText(String firstnameText) {
		firstnamefield.sendKeys(firstnameText);
		
	}
	public void enterlastnameText(String lastnameText) {
		lastnamefield.sendKeys(lastnameText);
	}
	public void enteremailText(String emailText) {
		emailfield.sendKeys(emailText);
	}
	public void entertelephoneText(String telephoneText) {
		telephonefield.sendKeys(telephoneText);
	}
	public void enterpasswordText(String passwordText) {
		passwordfield.sendKeys(passwordText);
	}
	public void enterconfirmpasswordText(String confirmpasswordText) {
		confirmpasswordfield.sendKeys(confirmpasswordText);
	}
	public void clickOnPrivacyPolicy() {
		PrivacyPolicyCheckbox.click();
	}
	public void clickOncontinuebutton() {
		continuebutton.click();
	}
	
	public void clickYesSubscribeRadioButton() {
		yesSubscribeRadioButton.click();
	}
}
