package dev.douglas.automation.pratice.selenium.pages;

import org.openqa.selenium.By;

public class DressesPage extends BasePage {
	// Locators
	private By menuDressesLocator = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
	private By submenuDressesLocator = By.cssSelector("#block_top_menu > ul > li:nth-child(2) > ul > li:nth-child(1) > a");
	private By titlePageCasualDressesLocator = By.className("cat-name");
	
	public void viewCasualDressesPage() {
		if (super.isDisplayed(menuDressesLocator)) {
			super.actionMoveToElementPerform(menuDressesLocator);
			super.actionMoveToElementClickPerform(submenuDressesLocator);
		} else {
			System.out.println("menu dresses wasn't found");
		}
	}
	
	public String getTitlePage() {
		return super.getText(titlePageCasualDressesLocator);
	}
}
