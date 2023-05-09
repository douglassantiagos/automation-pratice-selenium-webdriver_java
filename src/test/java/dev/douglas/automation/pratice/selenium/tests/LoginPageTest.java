package dev.douglas.automation.pratice.selenium.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.douglas.automation.pratice.selenium.pages.LoginPage;

class LoginPageTest {
	private LoginPage loginPage;
	private final String BASE_URL = "http://automationpractice.pl/index.php?controller=authentication&back=my-account";

	@BeforeEach
	void setUp() throws Exception {
		this.loginPage = new LoginPage();
		this.loginPage.visit(this.BASE_URL);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.loginPage.quitWebDriver();
	}

	@Test
	void successSigninTest() {
		// When
		this.loginPage.signin();
		
		// Then
		Assertions.assertTrue(this.loginPage.getMyAccountMessage().equals("MY ACCOUNT"));
		Assertions.assertFalse(this.loginPage.getCurrentUrl().equals(this.BASE_URL));
	}
	
	@Test
	void errorSigninWithoutEmailAndPasswordTest() {
		// When
		this.loginPage.signinWithoutEmailAndPassword();
		
		// Then
		Assertions.assertTrue(this.loginPage.getMessageError().equals("An email address required."));
	}
	
	@Test
	void errorSigninWithoutPasswordTest() {
		// When
		this.loginPage.signinWithoutPassword();
		
		// Then
		Assertions.assertTrue(this.loginPage.getMessageError().equals("Password is required."));
	}
	
	@Test
	void errorSigninWithoutEmailTest() {
		// When
		this.loginPage.signinWithoutEmail();
		
		// Then
		Assertions.assertTrue(this.loginPage.getMessageError().equals("An email address required."));
	}
	
	@Test
	void errorSigninInvalidEmailAddressTest() {
		// When
		this.loginPage.signinInvalidEmailAddress();
		
		// Then
		Assertions.assertTrue(this.loginPage.getMessageError().equals("Invalid email address."));
	}
	
	@Test
	void errorSigninErrorPasswordTest() {
		// When
		this.loginPage.signinErrorPassword();
		
		// Then
		Assertions.assertTrue(this.loginPage.getMessageError().equals("Authentication failed."));
	}
}
