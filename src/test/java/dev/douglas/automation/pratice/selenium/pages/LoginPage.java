package dev.douglas.automation.pratice.selenium.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
	// Locators
	private By emailAddressLocator = By.id("email");
	private By passwordLocator = By.id("passwd");
	private By submitBtnLocator = By.xpath("//*[@id=\"SubmitLogin\"]");
	private By tagMyAccountLocator = By.tagName("h1");
	private By messageErrorLocator = By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li");
	
	public void signin() {
		if (super.isDisplayed(emailAddressLocator)) {
			super.type("douglassanti@hotmail.com", emailAddressLocator);
			super.type("123456@ds", passwordLocator);
			super.click(submitBtnLocator);
		} else {
			System.out.println("email textbox wasn't present");
		}
	}
	
	public void signinWithoutEmailAndPassword() {
		if(super.isDisplayed(emailAddressLocator)) {
			super.click(submitBtnLocator);
		} else {
			System.out.println("email textbox wasn't present");
		}
	}
	
	public void signinWithoutPassword() {
		if(super.isDisplayed(emailAddressLocator)) {
			super.type("douglassanti@hotmail.com", emailAddressLocator);
			super.click(submitBtnLocator);
		} else {
			System.out.println("email textbox wasn't present");
		}
	}
	
	public void signinWithoutEmail() {
		if(super.isDisplayed(emailAddressLocator)) {
			super.type("123456@ds", passwordLocator);
			super.click(submitBtnLocator);
		} else {
			System.out.println("email textbox wasn't present");
		}
	}
	
	public void signinInvalidEmailAddress() {
		if(super.isDisplayed(emailAddressLocator)) {
			super.type("douglassanti", emailAddressLocator);
			super.type("123456@ds", passwordLocator);
			super.click(submitBtnLocator);
		} else {
			System.out.println("email textbox wasn't present");
		}
	}
	
	public void signinErrorPassword() {
		if(super.isDisplayed(emailAddressLocator)) {
			super.type("douglassanti@hotmail.com", emailAddressLocator);
			super.type("123456@", passwordLocator);
			super.click(submitBtnLocator);
		} else {
			System.out.println("email textbox wasn't present");
		}
	}
	
	public String getMyAccountMessage() {
		return super.getText(tagMyAccountLocator);
	}
	
	public String getMessageError() {
		return super.getText(messageErrorLocator);
	}
}
