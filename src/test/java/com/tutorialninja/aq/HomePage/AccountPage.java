package com.tutorialninja.aq.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	public WebDriver driver;
	
	@FindBy (linkText = "Edit your information")
	private WebElement editAccountInforlinl;

	private static WebElement editAccountInfoLink;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static boolean editAccountInfoLinkDisplayStatus() {
		boolean display = editAccountInfoLink.isDisplayed();
		return display;
		
	}
	
	

}
