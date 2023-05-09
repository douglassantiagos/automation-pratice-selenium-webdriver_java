package dev.douglas.automation.pratice.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class LoginTest {
	private WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.http.factory", "jdk-http-client"); 	
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe"); // Browser driver exe
        driver = new ChromeDriver(); // Create chrome instance - Open browser
        driver.manage().window().maximize(); // Maximize browser
        driver.get("http://automationpractice.pl/index.php?controller=authentication&back=my-account");  // Access url
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void test() {
		WebElement emailAddressElement = driver.findElement(By.id("email"));
		emailAddressElement.sendKeys("douglassanti@hotmail.com");
		
		WebElement passwordElement = driver.findElement(By.id("passwd"));
		passwordElement.sendKeys("123456@ds");
		
		WebElement submitBtnElement = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]"));
		submitBtnElement.click();
		
		WebElement tagMyAccount = driver.findElement(By.tagName("h1"));
		String textTagH1 = tagMyAccount.getText();
		
		Assertions.assertTrue(textTagH1.equals("MY ACCOUNT"));
	}
}
