package dev.douglas.automation.pratice.selenium.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.douglas.automation.pratice.selenium.pages.DressesPage;

class DressesPageTest {
	private DressesPage dressesPage;
	private final String BASE_URL = "http://automationpractice.pl/index.php";

	@BeforeEach
	void setUp() throws Exception {
		this.dressesPage = new DressesPage();
		this.dressesPage.visit("http://automationpractice.pl/index.php");
	}

	@AfterEach
	void tearDown() throws Exception {
		this.dressesPage.quitWebDriver();
	}

	@Test
	void successAccessNavbarDressesTest() {
		// when
		this.dressesPage.viewCasualDressesPage();
		
		// then
		Assertions.assertEquals("CASUAL DRESSES ", this.dressesPage.getTitlePage());;
		Assertions.assertFalse(this.dressesPage.getCurrentUrl().equals(this.BASE_URL));
	}

}
