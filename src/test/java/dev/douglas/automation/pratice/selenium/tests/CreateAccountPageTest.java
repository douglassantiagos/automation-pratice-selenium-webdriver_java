package dev.douglas.automation.pratice.selenium.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.douglas.automation.pratice.selenium.pages.CreateAccountPage;

class CreateAccountPageTest {
	private CreateAccountPage createAccountpage;
	private final String BASE_URL = "http://automationpractice.pl/index.php?controller=authentication&back=my-account";

	@BeforeEach
	void setUp() throws Exception {
		this.createAccountpage = new CreateAccountPage();
		this.createAccountpage.visit(this.BASE_URL);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.createAccountpage.quitWebDriver();
	}

	@Test
	void test01_successEmailAddressToCreateAccountTest() {
		// when
		this.createAccountpage.insertEmailToRegister();
		
		//then
		String expected = "douglastest099@gmail.com";
		String actual = this.createAccountpage.getEmailNewAccount();
		
		Assertions.assertEquals(expected, actual);		
	}
	
	@Test
	void test02_successFillFormAndCreateAccountTest() {
		// when
		this.createAccountpage.fillOutForm();
		
		// then
		String expected = "Your account has been created.";
		String actual = this.createAccountpage.getConfirmationRegisterAccountMessage();
		String actualUrl = this.createAccountpage.getCurrentUrl();
		
		Assertions.assertEquals(expected, actual);
		Assertions.assertFalse(this.BASE_URL.equals(actualUrl));
	}
	
	@Test
	void errorEmptyEmailAddressToCreateAccountTest() {
		// When
		this.createAccountpage.createAccountWithoutEmailAddress();
		
		// Then
		Assertions.assertTrue(this.createAccountpage.getMessageEmailError().equals("Invalid email address."));
	}
	
	@Test
	void errorInvalidEmailAddressToCreateAccountTest() {
		// When
		this.createAccountpage.createAccountInvalidEmailAddress();
		
		// Then
		Assertions.assertTrue(this.createAccountpage.getMessageEmailError().equals("Invalid email address."));
	}
	
	@Test
	void errorFillOutFormWithoutFirstNameTest() {
		// When
		this.createAccountpage.fillOutFormWithoutFirstName();
		
		// Then
		Assertions.assertTrue(this.createAccountpage.getMessageFormError().equals("firstname is required."));
	}
	
	@Test
	void errorFillOutFormWithoutLastNameTest() {
		// When
		this.createAccountpage.fillOutFormWithoutLastName();
		
		// Then
		Assertions.assertTrue(this.createAccountpage.getMessageFormError().equals("lastname is required."));
	}
	
	@Test
	void errorFillOutFormWithoutPasswordTest() {
		// When
		this.createAccountpage.fillOutFormWithoutPassword();
		
		// Then
		Assertions.assertTrue(this.createAccountpage.getMessageFormError().equals("passwd is required."));
	}
	
	@Test
	void errorFillOutFormWithoutFirstNameAndPasswordTest() {
		// When
		this.createAccountpage.fillOutFormWithoutFirstNameAndLastNameAndPassword();
		
		// Then
		Assertions.assertTrue(this.createAccountpage.getMessageTitleFormError().equals("There are 3 errors"));
	}
	
	@Test
	void errorFillOutFormWithoutLastNameAndPasswordTest() {
		// When
		this.createAccountpage.fillOutFormWithoutLastNameAndPassword();
		
		// Then
		Assertions.assertTrue(this.createAccountpage.getMessageTitleFormError().equals("There are 2 errors"));
	}
}
