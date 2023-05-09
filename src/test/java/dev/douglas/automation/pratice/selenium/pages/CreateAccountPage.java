package dev.douglas.automation.pratice.selenium.pages;

import org.openqa.selenium.By;

public class CreateAccountPage extends BasePage {
	// Locators
	private By emailAddressLocator = By.id("email_create");	
	private By emailLocator = By.id("email");	
	private By submitBtnCreateAccountLocator = By.xpath("//*[@id=\"SubmitCreate\"]");
	private By alertAdditionalInformationLocator = By.xpath("//*[@id=\"account-creation_form\"]/div[2]/p/span");
	private By genderMaleLocator = By.id("id_gender1");
	private By firstNameLocator = By.xpath("//*[@id=\"customer_firstname\"]");
	private By lastNameLocator = By.xpath("//*[@id=\"customer_lastname\"]");
	private By passwordLocator = By.xpath("//*[@id=\"passwd\"]");
	private By daysLocator = By.xpath("//*[@id=\"days\"]");
	private By monthsLocator = By.xpath("//*[@id=\"months\"]");
	private By yearsLocator = By.xpath("//*[@id=\"years\"]");
	private By newsletterLocator = By.xpath("//*[@id=\"newsletter\"]");
	private By optionLocator = By.xpath("//*[@id=\"optin\"]");
	private By submitRegisterBtnLocator = By.xpath("//*[@id=\"submitAccount\"]");
	private By confirmationRegisterMessageLocator = By.xpath("//*[@id=\"center_column\"]/p[1]");
	private By messageEmailErrorLocator = By.xpath("//*[@id=\"create_account_error\"]/ol/li");
	private By messageFormErrorLocator = By.xpath("//*[@id=\"center_column\"]/div/ol/li");
	private By messageTitleFormErrorLocator = By.xpath("//*[@id=\"center_column\"]/div/p");
	
	public void insertEmailToRegister() {
		if (super.isDisplayed(emailAddressLocator)) {
			super.type("douglastest099@gmail.com", emailAddressLocator);			
			super.click(submitBtnCreateAccountLocator);			
		} else {
			System.out.println("email textbox wasn't present");
		}
	}
	
	public String getEmailNewAccount() {
		super.waitVisibilityOfElementLocated(alertAdditionalInformationLocator);
		return super.getTextByAttribute(this.emailLocator, "value");
	}	
	
	public void fillOutForm() {
		this.insertEmailToRegister();
		super.waitVisibilityOfElementLocated(alertAdditionalInformationLocator);
		
		if (super.isDisplayed(genderMaleLocator)) {
			super.click(genderMaleLocator);
			super.type("Douglas", firstNameLocator);
			super.type("Santiago", lastNameLocator);
			super.type("123456", passwordLocator);
			super.selectByValue(daysLocator, "20");
			super.selectByValue(monthsLocator, "4");
			super.selectByValue(yearsLocator, "1990");
			super.click(newsletterLocator);
			super.click(optionLocator);
			super.click(submitRegisterBtnLocator);
		} else {
			System.out.println("gender radio button wasn't found");
		}
	}
	
	public String getConfirmationRegisterAccountMessage() {
		return super.getText(confirmationRegisterMessageLocator);
	}
	
	public void createAccountWithoutEmailAddress() {
		if(super.isDisplayed(emailAddressLocator)) {
			super.click(submitBtnCreateAccountLocator);
		} else {
			System.out.println("email textbox wasn't present");
		}
	}
	
	public void createAccountInvalidEmailAddress() {
		if(super.isDisplayed(emailAddressLocator)) {
			super.type("douglassantos", emailAddressLocator);
			super.click(submitBtnCreateAccountLocator);
		} else {
			System.out.println("email textbox wasn't present");
		}
	}
	
	public String getMessageEmailError() {
		super.waitVisibilityOfElementLocated(messageEmailErrorLocator);
		return super.getText(messageEmailErrorLocator);
	}
	
	public void fillOutFormWithoutFirstName() {
		this.insertEmailToRegister();
		super.waitVisibilityOfElementLocated(alertAdditionalInformationLocator);
		
		if (super.isDisplayed(genderMaleLocator)) {
			super.click(genderMaleLocator);
			super.type("Santiago", lastNameLocator);
			super.type("123456", passwordLocator);
			super.selectByValue(daysLocator, "20");
			super.selectByValue(monthsLocator, "4");
			super.selectByValue(yearsLocator, "1990");
			super.click(newsletterLocator);
			super.click(optionLocator);
			super.click(submitRegisterBtnLocator);
		} else {
			System.out.println("gender radio button wasn't found");
		}
	}
	
	public void fillOutFormWithoutLastName() {
		this.insertEmailToRegister();
		super.waitVisibilityOfElementLocated(alertAdditionalInformationLocator);
		
		if (super.isDisplayed(genderMaleLocator)) {
			super.click(genderMaleLocator);
			super.type("Douglas", firstNameLocator);
			super.type("123456", passwordLocator);
			super.selectByValue(daysLocator, "20");
			super.selectByValue(monthsLocator, "4");
			super.selectByValue(yearsLocator, "1990");
			super.click(newsletterLocator);
			super.click(optionLocator);
			super.click(submitRegisterBtnLocator);
		} else {
			System.out.println("gender radio button wasn't found");
		}
	}
	
	public void fillOutFormWithoutPassword() {
		this.insertEmailToRegister();
		super.waitVisibilityOfElementLocated(alertAdditionalInformationLocator);
		
		if (super.isDisplayed(genderMaleLocator)) {
			super.click(genderMaleLocator);
			super.type("Douglas", firstNameLocator);
			super.type("Santiago", lastNameLocator);
			super.selectByValue(daysLocator, "20");
			super.selectByValue(monthsLocator, "4");
			super.selectByValue(yearsLocator, "1990");
			super.click(newsletterLocator);
			super.click(optionLocator);
			super.click(submitRegisterBtnLocator);
		} else {
			System.out.println("gender radio button wasn't found");
		}
	}
	
	public void fillOutFormWithoutFirstNameAndLastNameAndPassword() {
		this.insertEmailToRegister();
		super.waitVisibilityOfElementLocated(alertAdditionalInformationLocator);
		
		if (super.isDisplayed(genderMaleLocator)) {
			super.click(genderMaleLocator);
			super.selectByValue(daysLocator, "20");
			super.selectByValue(monthsLocator, "4");
			super.selectByValue(yearsLocator, "1990");
			super.click(newsletterLocator);
			super.click(optionLocator);
			super.click(submitRegisterBtnLocator);
		} else {
			System.out.println("gender radio button wasn't found");
		}
	}
	
	public void fillOutFormWithoutLastNameAndPassword() {
		this.insertEmailToRegister();
		super.waitVisibilityOfElementLocated(alertAdditionalInformationLocator);
		
		if (super.isDisplayed(genderMaleLocator)) {
			super.click(genderMaleLocator);
			super.type("Douglas", firstNameLocator);
			super.selectByValue(daysLocator, "20");
			super.selectByValue(monthsLocator, "4");
			super.selectByValue(yearsLocator, "1990");
			super.click(newsletterLocator);
			super.click(optionLocator);
			super.click(submitRegisterBtnLocator);
		} else {
			System.out.println("gender radio button wasn't found");
		}
	}
	
	public String getMessageTitleFormError() {
		super.waitVisibilityOfElementLocated(messageTitleFormErrorLocator);
		return super.getText(messageTitleFormErrorLocator);
	}
	
	public String getMessageFormError() {
		super.waitVisibilityOfElementLocated(messageFormErrorLocator);
		return super.getText(messageFormErrorLocator);
	}
}
