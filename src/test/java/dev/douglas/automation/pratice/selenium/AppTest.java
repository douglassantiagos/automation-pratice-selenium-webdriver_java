package dev.douglas.automation.pratice.selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {
	private WebDriver driver;

    @Test
    public void helloSelenium() {   
    	System.setProperty("webdriver.http.factory", "jdk-http-client"); 	
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe"); // Browser driver exe
        driver = new ChromeDriver(); // Create chrome instance - Open browser
        driver.manage().window().maximize(); // Maximize browser
        driver.get("http://automationpractice.pl/index.php");  // Access url
        
        String currentUrl = driver.getCurrentUrl();
        String expected = "http://automationpractice.pl/index.php";

        Assertions.assertEquals(expected, currentUrl);
        
        //driver.quit();
    }
}
